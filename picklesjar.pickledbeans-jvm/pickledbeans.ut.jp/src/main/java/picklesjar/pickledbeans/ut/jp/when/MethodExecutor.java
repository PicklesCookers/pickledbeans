package picklesjar.pickledbeans.ut.jp.when;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.When;

public class MethodExecutor
	extends picklesjar.pickledbeans.ut.when.MethodExecutor {
	
	/**
	 * 
	 * 
	 * 
	 */
	@Override
	@When( "^メソッド実行（パラメータ：なし）$" )
	public void execute() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象のクラス・インスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_METHOD_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"メソッドを参照できませんでした。", exp );
					break;
				
				case CODE_OF_FAILED_TO_METHOD_EXECUTION :
					wrappedExp = new IllegalTestStateException(
						"メソッドの実行に失敗しました。", exp );
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
