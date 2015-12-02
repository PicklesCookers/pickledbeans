package picklesjar.pickledbeans.ut.when;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import picklesjar.pickle.ut.core.IllegalTestStateException;
import picklesjar.pickle.ut.core.PreparedTemporaryKey;
import picklesjar.pickle.ut.core.util.ClassFunctionTarget;
import picklesjar.pickle.ut.runtime.UnitTestResult;
import picklesjar.pickle.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickle.ut.runtime.UnitTestTemporary;
import picklesjar.pickledbeans.ut.then.AsserThatResultIs;

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
				result.put( AsserThatResultIs.DEFAULT_RESULT_KEY, execute( temp, args ) );
			} );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param alias
	 * @param args
	 */
	protected final void executeAndPutTo( String alias, Object... args ) {
	
		UnitTestRuntimeFoundation.when( alias,
			( BiFunction< UnitTestTemporary, Object[], Object > )this::execute, args );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param args
	 * @return
	 */
	private final Object execute( UnitTestTemporary temp, Object... args ) {
	
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
			result = target.execute( instance, args );
		} catch( Exception exp ) {
			throw new IllegalTestStateException( CODE_OF_FAILED_TO_EXECUTE, exp );
		}
		
		return result;
	}
	
}
