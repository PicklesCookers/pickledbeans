package picklesjar.pickledbeans.ut.jp.when;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import picklesjar.pickle.ut.core.IllegalTestStateException;
import picklesjar.pickledbeans.ut.then.AsserThatResultIs;
import picklesjar.pickledbeans.ut.when.ExecuteTargetingFunction;
import cucumber.api.java.en.When;

public class 実行対象の処理を実行
	extends ExecuteTargetingFunction {
	
	@When( "^実行対象の処理を実行（パラメータ：なし）$" )
	public void execute() {
	
		execute( super::execute, ( Object[] )null );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：null）$" )
	public void executeWith1NullParam() {
	
		execute( super::execute, new Object[] { null } );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(true|True|TRUE|false|False|FALSE)）$" )
	public void execute( boolean arg ) {
	
		execute( super::execute, arg );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(\"(.*?)\")）$" )
	public void execute( String arg ) {
	
		execute( super::execute, arg );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：なし）、処理結果を保持$" )
	public void executeAndPutToResult() {
	
		execute( super::executeAndPutTo, AsserThatResultIs.DEFAULT_RESULT_KEY, ( Object[] )null );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：null）、処理結果を保持$" )
	public void executeWith1NullParamAndPutToResult() {
	
		execute( super::executeAndPutTo, AsserThatResultIs.DEFAULT_RESULT_KEY, new Object[] { null } );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(true|True|TRUE|false|False|FALSE)）、処理結果を保持$" )
	public void executeAndPutToResult( boolean arg ) {
	
		execute( super::executeAndPutTo, AsserThatResultIs.DEFAULT_RESULT_KEY, arg );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(\"(.*?)\")）、処理結果を保持$" )
	public void executeAndPutToResult( String arg ) {
	
		execute( super::executeAndPutTo, AsserThatResultIs.DEFAULT_RESULT_KEY, arg );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：なし）、処理結果を保持（alias：\"(.+?)\"）$" )
	public void executeAndPutTo( String alias ) {
	
		execute( super::executeAndPutTo, alias, ( Object[] )null );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：null）、処理結果を保持（alias：\"(.+?)\"）$" )
	public void executeWith1NullParamAndPutTo( String alias ) {
	
		execute( super::executeAndPutTo, alias, new Object[] { null } );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(true|True|TRUE|false|False|FALSE)）、処理結果を保持（alias：\"(.+?)\"）$" )
	public void executeAndPutTo( boolean arg, String alias ) {
	
		execute( super::executeAndPutTo, alias, arg );
	}
	
	@When( "^実行対象の処理を実行（パラメータ：(\"(.*?)\")）、処理結果を保持（alias：\"(.+?)\"）$" )
	public void executeAndPutTo( String arg, String alias ) {
	
		execute( super::executeAndPutTo, alias, arg );
	}
	
	protected < T > void execute( @Nonnull BiConsumer< String, T > function, String alias, T arg ) {
	
		try {
			function.accept( alias, arg );
		} catch( IllegalTestStateException exp ) {
			throw distributeThrowcaseMessage( exp );
		}
	}
	
	protected < T > void execute( @Nonnull Consumer< T > function, T arg ) {
	
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
			
			case CODE_OF_EMPTY_TARGET_INSTANCE :
				result = new IllegalTestStateException(
					"処理を参照できませんでした。", exp );
				break;
			
			case CODE_OF_FAILED_TO_EXECUTE :
				result = new IllegalTestStateException(
					"処理の実行に失敗しました。", exp );
				break;
			
			default :
				result = new IllegalTestStateException(
					"処理に失敗しました。", exp );
				break;
		}
		
		return result;
	}
	
}
