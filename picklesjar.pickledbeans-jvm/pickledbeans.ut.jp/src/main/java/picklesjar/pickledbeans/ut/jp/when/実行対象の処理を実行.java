package picklesjar.pickledbeans.ut.jp.when;

import picklesjar.pickledbeans.ut.when.ExecuteTargetingFunction;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.When;

public class 実行対象の処理を実行
	extends ExecuteTargetingFunction {
	
	/**
	 * 
	 * 
	 * 
	 */
	@When( "^実行対象の処理を実行（パラメータ：なし）$" )
	public void execute() {
	
		try {
			super.execute();
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_FAILED_TO_EXECUTE :
					wrappedExp = new IllegalTestStateException(
						"処理の実行に失敗しました。", exp );
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
	 */
	@When( "^実行対象の処理を実行（パラメータ：(true|True|TRUE|false|False|FALSE)）$" )
	public void execute( boolean arg ) {
	
		try {
			super.execute( arg );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_FAILED_TO_EXECUTE :
					wrappedExp = new IllegalTestStateException(
						"処理の実行に失敗しました。", exp );
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
	 */
	@When( "^実行対象の処理を実行（パラメータ：(\"(.*?)\")）$" )
	public void execute( String arg ) {
	
		try {
			super.execute( arg );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_FAILED_TO_EXECUTE :
					wrappedExp = new IllegalTestStateException(
						"処理の実行に失敗しました。", exp );
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
