package picklesjar.pickledbeans.ut.given;

import java.util.function.BiConsumer;
import java.util.function.Function;

import javax.annotation.Nonnull;

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
	 */
	protected final void execute() {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, Function< UnitTestTemporary, String > > )this::execute,
			( temp ) -> {
				String result = null;
				try {
					result = PreparedTemporaryKey.TEST_TARGET_CLASS_FULLNAME.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( 1, exp );
				}
				return result;
			} );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	protected final void execute( String className ) {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, String > )this::execute, className );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param function
	 */
	private final void execute(
		UnitTestTemporary temp, @Nonnull Function< UnitTestTemporary, String > function ) {
	
		execute( temp, function.apply( temp ) );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param className
	 */
	private final void execute( UnitTestTemporary temp, String className ) {
	
		Object result = null;
		try {
			result = Class.forName( className ).newInstance();
		} catch( ReflectiveOperationException exp ) {
			throw new IllegalTestStateException( exp );
		}
		
		temp.put(
			PreparedTemporaryKey.TEST_TARGET_CLASS_FULLNAME.name(), className );
		temp.put(
			PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.name(), result.getClass() );
		temp.put(
			PreparedTemporaryKey.TEST_TARGET_CLASS_INSTANCE.name(), result );
	}
	
}
