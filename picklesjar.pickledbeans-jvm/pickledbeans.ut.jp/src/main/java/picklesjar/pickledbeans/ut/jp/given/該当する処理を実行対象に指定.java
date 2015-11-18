package picklesjar.pickledbeans.ut.jp.given;

import picklesjar.pickledbeans.ut.given.SetToTargetExecutionByMethodQuery;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Given;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public class 該当する処理を実行対象に指定
	extends SetToTargetExecutionByMethodQuery {
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	@Override
	@Given( "^テスト対象の処理を実行対象に指定$" )
	public void execute() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_OBJECT :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスが指定されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_METHOD_QUERY :
					wrappedExp = new IllegalTestStateException(
						"対象処理の指定が事前にされていません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_SEARCH_METHOD :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				default :
					wrappedExp = new IllegalTestStateException(
						"処理に失敗しました。", exp );
					break;
			}
			throw wrappedExp;
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	@Override
	@Given( "^\"(.+?)\"を実行対象に指定$" )
	public void execute( String methodQuery ) {
	
		try {
			super.execute( methodQuery );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_OBJECT :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスが指定されていません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_SEARCH_METHOD :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				default :
					wrappedExp = new IllegalTestStateException(
						"処理に失敗しました。", exp );
					break;
			}
			throw wrappedExp;
		}
	}
	
}
