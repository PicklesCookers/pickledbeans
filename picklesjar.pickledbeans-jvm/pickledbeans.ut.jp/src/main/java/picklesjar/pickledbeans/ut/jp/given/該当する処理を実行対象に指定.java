package picklesjar.pickledbeans.ut.jp.given;

import javax.annotation.Nonnull;

import picklesjar.pickle.ut.core.IllegalTestStateException;
import picklesjar.pickledbeans.ut.given.SetToTargetExecutionByMethodQuery;
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
	
	@Given( "^テスト対象の処理を実行対象に指定$" )
	public void executeDefault() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			throw distributeThrowcaseMessage( exp );
		}
	}
	
	@Given( "^\"(.+?)\"を実行対象に指定$" )
	public void executeWithMethodQuery( String methodQuery ) {
	
		try {
			super.execute( methodQuery );
		} catch( IllegalTestStateException exp ) {
			throw distributeThrowcaseMessage( exp );
		}
	}
	
	/**
	 * 例外発生時のメッセージ振り分け処理.
	 * 
	 * @param exp
	 *            振り分けの根拠となる情報を保持する例外
	 * @return メッセージを付与してそういつ例外でラップした新しい例外インスタンス
	 */
	protected IllegalTestStateException distributeThrowcaseMessage( @Nonnull IllegalTestStateException exp ) {
	
		IllegalTestStateException result = null;
		switch( exp.getCode() ) {
		
			case CODE_OF_EMPTY_TARGET_CLASS_OBJECT :
				result = new IllegalTestStateException(
					"テスト対象クラスが指定されていません。", exp );
				break;
			
			case CODE_OF_EMPTY_TARGET_METHOD_QUERY :
				result = new IllegalTestStateException(
					"対象処理の指定が事前にされていません。", exp );
				break;
			
			case CODE_OF_FAILED_TO_SEARCH_METHOD :
				result = new IllegalTestStateException(
					"処理を参照できませんでした。", exp );
				break;
			
			default :
				result = new IllegalTestStateException(
					"処理に失敗しました。", exp );
				break;
		}
		
		return result;
	}
	
}
