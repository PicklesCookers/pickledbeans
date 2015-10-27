package picklesjar.pickledbeans.ut.jp.given;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Given;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public class MethodReflector
	extends picklesjar.pickledbeans.ut.given.MethodReflector {
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	@Override
	@Given( "^\"(.+?)\"メソッドをテスト対象に指定$" )
	public void searchAndPut( String methodName ) {
	
		try {
			super.searchAndPut( methodName );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_OBJECT :
					wrappedExp = new IllegalTestStateException(
						"テスト対象のクラスが指定されていません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_SEARCH_METHOD :
					wrappedExp = new IllegalTestStateException(
						"メソッドを参照できませんでした。。", exp );
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
