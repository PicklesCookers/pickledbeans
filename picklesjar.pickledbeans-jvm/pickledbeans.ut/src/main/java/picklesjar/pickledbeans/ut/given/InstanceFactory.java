package picklesjar.pickledbeans.ut.given;

import java.util.function.BiConsumer;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.core.TemporaryPreparedKey;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickles.ut.runtime.UnitTestTemporary;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class InstanceFactory {
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	public void newInstance( String className ) {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, String > )
			( temp, _className ) -> {
				
				Object result = null;
				
				try {
					result = Class.forName( _className ).getConstructor( ( Class< ? >[] )null ).newInstance();
				} catch( ReflectiveOperationException exp ) {
					throw new IllegalTestStateException( exp );
				}
				
				temp.put(
					TemporaryPreparedKey.TEST_TARGET_CLASS_OBJECT.name(), result.getClass() );
				temp.put(
					TemporaryPreparedKey.TEST_TARGET_CLASS_INSTANCE.name(), result );
				
			}, className );
		
	}
	
}
