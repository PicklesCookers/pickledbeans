package picklesjar.pickledbeans.ut.given;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import picklesjar.pickles.ut.core.IllegalMethodQueryException;
import picklesjar.pickles.ut.core.IllegalTestCodeStateException;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.core.PreparedTemporaryKey;
import picklesjar.pickles.ut.core.util.ClassFunctionTarget;
import picklesjar.pickles.ut.core.util.MethodQuery;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickles.ut.runtime.UnitTestTemporary;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class SetToTargetExecutionByMethodQuery {
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_OBJECT = 1;
	
	protected static final int CODE_OF_EMPTY_TARGET_METHOD_QUERY = 2;
	
	protected static final int CODE_OF_FAILED_TO_SEARCH_METHOD = 3;
	
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
				
				Class< ? > targetClass = null;
				try {
					targetClass = PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_OBJECT, exp );
				}
				
				MethodQuery methodQuery = null;
				try {
					methodQuery = PreparedTemporaryKey.TEST_TARGET_METHOD_QUERY.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_METHOD_QUERY, exp );
				}
				
				ClassFunctionTarget target = null;
				try {
					target = new ClassFunctionTarget( targetClass, methodQuery );
				} catch(
					IllegalTestCodeStateException | SecurityException exp ) {
					
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
				}
				
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_FUNCTION.name(), target );
				
			} );
		
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param className
	 */
	protected void execute( String methodQuery ) {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, String > )
			( temp, _methodQuery ) -> {
				
				Class< ? > targetClass = null;
				try {
					targetClass = PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_OBJECT, exp );
				}
				
				MethodQuery query = null;
				try {
					query = MethodQuery.newInstance( _methodQuery );
				} catch( IllegalMethodQueryException exp ) {
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
				}
				
				ClassFunctionTarget target = null;
				try {
					target = new ClassFunctionTarget( targetClass, query );
				} catch(
					IllegalTestCodeStateException | SecurityException exp ) {
					
					throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
				}
				
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_METHOD_QUERY.name(), query );
				temp.put(
					PreparedTemporaryKey.TEST_TARGET_CLASS_FUNCTION.name(), target );
				
			}, methodQuery );
		
	}
	
}
