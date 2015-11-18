package picklesjar.pickledbeans.ut.jp.when;

import picklesjar.pickledbeans.ut.when.OperateToAccessorDataBridgeVariable;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.When;

public class Accessorデータ保持変数を操作
	extends OperateToAccessorDataBridgeVariable {
	
	/**
	 * 
	 * 
	 * 
	 */
	@When( "^Accessorデータ保持変数の値を取得$" )
	public void execute() {
	
		try {
			super.get();
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_CLASS_FUNCTION :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN :
					wrappedExp = new IllegalTestStateException(
						"処理対象のデザイン・タイプが設定されていないか、適切ではありません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE :
					wrappedExp = new IllegalTestStateException(
						"Accessorデータ保持変数を検知できませんでした。", exp );
					break;
				
				default :
					wrappedExp = new IllegalTestStateException(
						"処理に失敗しました。", exp );
					break;
			}
			throw wrappedExp;
		}
	}
	
	@When( "^Accessorデータ保持変数の値を取得、保持（alias：\"(.+?)\"）$" )
	public void execute( String alias ) {
	
		try {
			super.getAndPutTo( alias );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_CLASS_FUNCTION :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN :
					wrappedExp = new IllegalTestStateException(
						"処理対象のデザイン・タイプが設定されていないか、適切ではありません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE :
					wrappedExp = new IllegalTestStateException(
						"Accessorデータ保持変数を検知できませんでした。", exp );
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
	@When( "^Accessorデータ保持変数に値を設定（パラメータ：(true|True|TRUE|false|False|FALSE)）$" )
	public void executeSet( boolean arg ) {
	
		try {
			super.set( arg );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_CLASS_FUNCTION :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN :
					wrappedExp = new IllegalTestStateException(
						"処理対象のデザイン・タイプが設定されていないか、適切ではありません。", exp );
					break;
				
				case CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE :
					wrappedExp = new IllegalTestStateException(
						"Accessorデータ保持変数を検知できませんでした。", exp );
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
	@When( "^Accessorデータ保持変数に値を設定（パラメータ：(\"(.*?)\")）$" )
	public void executeSet( String arg ) {
	
		try {
			super.set( arg );
		} catch( IllegalTestStateException exp ) {
			
			IllegalTestStateException wrappedExp = null;
			switch( exp.getCode() ) {
			
				case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
					wrappedExp = new IllegalTestStateException(
						"テスト対象クラスのインスタンスが生成されていません。", exp );
					break;
				
				case CODE_OF_EMPTY_TARGET_CLASS_FUNCTION :
					wrappedExp = new IllegalTestStateException(
						"処理を参照できませんでした。", exp );
					break;
				
				case CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE :
					wrappedExp = new IllegalTestStateException(
						"Accessorデータ保持変数を検知できませんでした。", exp );
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
