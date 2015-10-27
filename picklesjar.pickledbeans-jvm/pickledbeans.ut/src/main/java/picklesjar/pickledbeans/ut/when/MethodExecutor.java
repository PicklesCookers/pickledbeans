package picklesjar.pickledbeans.ut.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import picklesjar.pickledbeans.ut.TemporaryKey;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickles.ut.runtime.UnitTestTemporary;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class MethodExecutor {
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_INSTANCE = 1;
	
	protected static final int CODE_OF_EMPTY_TARGET_METHOD_INSTANCE = 2;
	
	protected static final int CODE_OF_FAILED_TO_METHOD_EXECUTION = 3;
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	public void execute() {
	
		UnitTestRuntimeFoundation.when(
			( Function< UnitTestTemporary, Object > )
			( temp ) -> {
				
				Object clazz = temp.get( TemporaryKey.TEST_TARGET_CLASS_INSTANCE.name() );
				if( clazz == null ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_INSTANCE );
				}
				
				Object method = temp.get( TemporaryKey.TEST_TARGET_METHOD_INSTANCE.name() );
				if( !( method instanceof Method ) ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_METHOD_INSTANCE );
				}
				
				Object result = null;
				
				try {
					result = ( ( Method )method ).invoke( clazz );
				} catch(
					IllegalAccessException
					| IllegalArgumentException
					| InvocationTargetException exp ) {
					
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_METHOD_EXECUTION );
				}
				
				return result;
			} );
		
	}
	
}
