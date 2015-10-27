package picklesjar.pickledbeans.ut.given;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;

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
public abstract class MethodReflector {
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_OBJECT = 1;
	
	protected static final int CODE_OF_FAILED_TO_SEARCH_METHOD = 2;
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	public void searchAndPut( String methodName ) {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, String > )
			( temp, _methodName ) -> {
				
				Object clazz = temp.get( TemporaryKey.TEST_TARGET_CLASS_OBJECT.name() );
				if( !( clazz instanceof Class< ? > ) ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_OBJECT );
				}
				
				Method method = null;
				try {
					
					method = ( ( Class< ? > )clazz ).getDeclaredMethod( _methodName, ( Class< ? >[] )null );
					
				} catch( NoSuchMethodException | SecurityException exp ) {
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
				}
				
				temp.put(
					TemporaryKey.TEST_TARGET_METHOD_INSTANCE.name(), method );
				temp.put(
					TemporaryKey.TEST_TARGET_METHOD_NAME.name(), _methodName );
				
			}, methodName );
		
	}
}
