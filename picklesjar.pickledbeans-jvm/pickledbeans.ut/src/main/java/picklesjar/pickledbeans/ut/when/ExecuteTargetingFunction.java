package picklesjar.pickledbeans.ut.when;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.core.PreparedTemporaryKey;
import picklesjar.pickles.ut.core.util.ClassFunctionTarget;
import picklesjar.pickles.ut.runtime.UnitTestResult;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickles.ut.runtime.UnitTestTemporary;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class ExecuteTargetingFunction {
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_INSTANCE = 1;
	
	protected static final int CODE_OF_EMPTY_TARGET_INSTANCE = 2;
	
	protected static final int CODE_OF_FAILED_TO_EXECUTE = 3;
	
	/**
	 * 
	 * 
	 * 
	 * @param args
	 */
	protected final void execute( Object... args ) {
	
		UnitTestRuntimeFoundation.when(
			
			( BiConsumer< UnitTestResult, UnitTestTemporary > )
			( result, temp ) -> {
				
				Object instance = null;
				try {
					instance = PreparedTemporaryKey.TEST_TARGET_CLASS_INSTANCE.getValueFrom( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_INSTANCE, exp );
				}
				
				ClassFunctionTarget target = null;
				try {
					target = PreparedTemporaryKey.TEST_TARGET_CLASS_FUNCTION.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_INSTANCE, exp );
				}
				
				try {
					target.execute( instance, args );
				} catch( Exception exp ) {
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_EXECUTE, exp );
				}
				
			} );
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param args
	 */
	protected final void executeAndPutToResult( Object... args ) {
	
		executeAndPutTo( "0", args );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param alias
	 * @param args
	 */
	protected final void executeAndPutTo( String alias, Object... args ) {
	
		UnitTestRuntimeFoundation.when(
			alias,
			
			( BiFunction< UnitTestTemporary, Object[], Object > )
			( temp, _args ) -> {
				
				Object instance = null;
				try {
					instance = PreparedTemporaryKey.TEST_TARGET_CLASS_INSTANCE.getValueFrom( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_INSTANCE, exp );
				}
				
				ClassFunctionTarget target = null;
				try {
					target = PreparedTemporaryKey.TEST_TARGET_CLASS_FUNCTION.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_INSTANCE, exp );
				}
				
				Object result = null;
				try {
					result = target.execute( instance, _args );
				} catch( Exception exp ) {
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_EXECUTE, exp );
				}
				
				return result;
			}, args );
		
	}
	
}
