package picklesjar.pickledbeans.ut.jp.given;

import picklesjar.pickledbeans.ut.given.CreateClassInstance;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Given;

public class クラスのインスタンスを生成
	extends CreateClassInstance {
	
	/**
	 * 
	 * 
	 * 
	 */
	@Override
	@Given( "^テスト対象クラスのインスタンス生成$" )
	public void execute() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "インスタンスの生成に失敗しました。", exp );
		}
		
	}
	
	/**
	 * 
	 * 
	 * 
	 */
	@Override
	@Given( "^\"(.+?)\"クラスのインスタンス生成$" )
	public void execute( String className ) {
	
		try {
			super.execute( className );
		} catch( IllegalTestStateException exp ) {
			throw new IllegalTestStateException( "インスタンスの生成に失敗しました。", exp );
		}
		
	}
	
}
