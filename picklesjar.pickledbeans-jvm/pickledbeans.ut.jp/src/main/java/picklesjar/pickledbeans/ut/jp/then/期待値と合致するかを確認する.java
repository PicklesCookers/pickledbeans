package picklesjar.pickledbeans.ut.jp.then;

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
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Then( "^期待値（(true|True|TRUE|false|False|FALSE)）と合致するかを確認する$" )
	public void execute( boolean expectedValue ) {
	
		try {
			super.execute( expectedValue );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "テスト結果が設定されていません。", exp );
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Then( "^期待値（(true|True|TRUE|false|False|FALSE)）と合致するかを確認する（alias：\"(.+?)\"）$" )
	public void execute( boolean expectedValue, String alias ) {
	
		try {
			super.execute( alias, expectedValue );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "テスト結果が設定されていません。", exp );
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Then( "^期待値（\"(.*?)\"）と合致するかを確認する$" )
	public void execute( String expectedValue ) {
	
		try {
			super.execute( expectedValue );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "テスト結果が設定されていません。", exp );
		}
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Then( "^期待値（\"(.*?)\"）と合致するかを確認する（alias：\"(.+?)\"）$" )
	public void execute( String expectedValue, String alias ) {
	
		try {
			super.execute( alias, expectedValue );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "テスト結果が設定されていません。", exp );
		}
	}
	
}
