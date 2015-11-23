package picklesjar.pickledbeans.ut.jp.given;

import javax.annotation.Nonnull;

import picklesjar.pickledbeans.ut.given.CreateClassInstance;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.Given;

public class クラスのインスタンスを生成
	extends CreateClassInstance {
	
	@Given( "^テスト対象クラスのインスタンス生成$" )
	public void executeDefault() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			throw distributeThrowcaseMessage( exp );
		}
	}
	
	@Given( "^\"(.+?)\"クラスのインスタンス生成$" )
	public void executeWithClassName( String className ) {
	
		try {
			super.execute( className );
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
					"インスタンスの生成に失敗しました。", exp );
				break;
			
			default :
				result = new IllegalTestStateException(
					"処理に失敗しました。", exp );
				break;
		}
		
		return result;
	}
	
}
