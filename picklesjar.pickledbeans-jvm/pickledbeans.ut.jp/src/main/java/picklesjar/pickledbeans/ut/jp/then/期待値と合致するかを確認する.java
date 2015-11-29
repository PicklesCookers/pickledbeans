package picklesjar.pickledbeans.ut.jp.then;

import java.util.function.BiConsumer;

import javax.annotation.Nonnull;

import picklesjar.pickledbeans.ut.then.junit.AssertThatResultIs;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Then;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public class 期待値と合致するかを確認する
	extends AssertThatResultIs {
	
	@Then( "^期待値（null）と合致するかを確認する$" )
	public void execute() {
	
		execute( super::executeWithAlias, DEFAULT_RESULT_KEY, null );
	}
	
	@Then( "^期待値（(true|True|TRUE|false|False|FALSE)）と合致するかを確認する$" )
	public void execute( boolean expectedValue ) {
	
		execute( super::executeWithAlias, DEFAULT_RESULT_KEY, expectedValue );
	}
	
	@Then( "^期待値（\"(.*?)\"）と合致するかを確認する$" )
	public void execute( String expectedValue ) {
	
		execute( super::executeWithAlias, DEFAULT_RESULT_KEY, expectedValue );
	}
	
	@Then( "^期待値（null）と合致するかを確認する（alias：\"(.+?)\"）$" )
	public void executeWithAlias( String alias ) {
	
		execute( super::executeWithAlias, alias, null );
	}
	
	@Then( "^期待値（(true|True|TRUE|false|False|FALSE)）と合致するかを確認する（alias：\"(.+?)\"）$" )
	public void executeWithAlias( boolean expectedValue, String alias ) {
	
		execute( super::executeWithAlias, alias, expectedValue );
	}
	
	@Then( "^期待値（\"(.*?)\"）と合致するかを確認する（alias：\"(.+?)\"）$" )
	public void executeWithAlias( String expectedValue, String alias ) {
	
		execute( super::executeWithAlias, alias, expectedValue );
	}
	
	protected < T > void execute( BiConsumer< String, T > function, String alias, T arg ) {
	
		try {
			function.accept( alias, arg );
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
		
			case 0 :
				result = new IllegalTestStateException(
					"テスト結果が設定されていません。", exp );
				break;
			
			default :
				result = new IllegalTestStateException(
					"処理に失敗しました。", exp );
				break;
		}
		
		return result;
	}
	
}
