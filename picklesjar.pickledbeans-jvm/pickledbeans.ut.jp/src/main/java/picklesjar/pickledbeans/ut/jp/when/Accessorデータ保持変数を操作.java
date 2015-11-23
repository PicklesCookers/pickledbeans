package picklesjar.pickledbeans.ut.jp.when;

import java.util.function.Consumer;

import javax.annotation.Nonnull;

import picklesjar.pickledbeans.ut.then.AsserThatResultIs;
import picklesjar.pickledbeans.ut.when.OperateToAccessorDataBridgeVariable;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import cucumber.api.java.en.When;

public class Accessorデータ保持変数を操作
	extends OperateToAccessorDataBridgeVariable {
	
	@When( "^Accessorデータ保持変数の値を取得$" )
	public void executeGet() {
	
		execute( super::getAndPutTo, AsserThatResultIs.DEFAULT_RESULT_KEY );
	}
	
	@When( "^Accessorデータ保持変数の値を取得、保持（alias：\"(.+?)\"）$" )
	public void executeGetAndPutTo( String alias ) {
	
		execute( super::getAndPutTo, alias );
	}
	
	@When( "^Accessorデータ保持変数に値を設定（パラメータ：null）$" )
	public void executeSet() {
	
		execute( super::set, null );
	}
	
	@When( "^Accessorデータ保持変数に値を設定（パラメータ：(true|True|TRUE|false|False|FALSE)）$" )
	public void executeSet( boolean arg ) {
	
		execute( super::set, arg );
	}
	
	@When( "^Accessorデータ保持変数に値を設定（パラメータ：(\"(.*?)\")）$" )
	public void executeSet( String arg ) {
	
		execute( super::set, arg );
	}
	
	protected < T > void execute( Consumer< T > function, T arg ) {
	
		try {
			function.accept( arg );
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
		
			case CODE_OF_EMPTY_TARGET_CLASS_INSTANCE :
				result = new IllegalTestStateException(
					"テスト対象クラスのインスタンスが生成されていません。", exp );
				break;
			
			case CODE_OF_EMPTY_TARGET_CLASS_FUNCTION :
				result = new IllegalTestStateException(
					"処理を参照できませんでした。", exp );
				break;
			
			case CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN :
				result = new IllegalTestStateException(
					"処理対象のデザイン・タイプが設定されていないか、適切ではありません。", exp );
				break;
			
			case CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE :
				result = new IllegalTestStateException(
					"Accessorデータ保持変数を検知できませんでした。", exp );
				break;
			
			default :
				result = new IllegalTestStateException(
					"処理に失敗しました。", exp );
				break;
		}
		
		return result;
	}
	
}
