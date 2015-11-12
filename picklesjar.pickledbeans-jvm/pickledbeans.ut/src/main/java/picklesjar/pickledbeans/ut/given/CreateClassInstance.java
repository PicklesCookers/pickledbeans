package picklesjar.pickledbeans.ut.given;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.core.PreparedTemporaryKey;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickles.ut.runtime.UnitTestTemporary;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class CreateClassInstance {
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	protected void execute() {
	
		UnitTestRuntimeFoundation.given(
			( Consumer< UnitTestTemporary > )
			( temp ) -> {
				
				String className = null;
				try {
					className = PreparedTemporaryKey.TEST_TARGET_CLASS_FULLNAME.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( 1, exp );
				}
				
				Object result = null;
				
				try {
					result = Class.forName( className ).newInstance();
				} catch( ReflectiveOperationException exp ) {
					throw new IllegalTestStateException( exp );
				}
				
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.name(), result.getClass() );
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_INSTANCE.name(), result );
				
			} );
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	protected void execute( String className ) {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, String > )
			( temp, _className ) -> {
				
				Object result = null;
				
				try {
					result = Class.forName( _className ).newInstance();
				} catch( ReflectiveOperationException exp ) {
					throw new IllegalTestStateException( exp );
				}
				
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_FULLNAME.name(), _className );
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.name(), result.getClass() );
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_INSTANCE.name(), result );
				
			}, className );
		
	}
}
