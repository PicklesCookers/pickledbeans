package picklesjar.pickledbeans.ut.jp.given;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Given;

public class InstanceFactory
	extends picklesjar.pickledbeans.ut.given.InstanceFactory {
	
	/**
	 * 
	 * 
	 * 
	 */
	@Override
	@Given( "^\"(.+?)\"インスタンス生成$" )
	public void newInstance( String className ) {
	
		try {
			super.newInstance( className );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "インスタンスの生成に失敗しました。", exp );
		}
		
	}
}
