package picklesjar.pickledbeans.ut.jp.then;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.When;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public class StringResultChecker
	extends picklesjar.pickledbeans.ut.then.junit.StringResultChecker {
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Override
	@When( "^戻り値：\"(.*?)\"$" )
	public void checkStringValue( String expectedValue ) {
	
		try {
			super.checkStringValue( expectedValue );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "テスト結果が設定されていません。", exp );
		}
	}
	
}
