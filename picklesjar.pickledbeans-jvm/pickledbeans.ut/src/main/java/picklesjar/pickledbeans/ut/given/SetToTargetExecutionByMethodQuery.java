package picklesjar.pickledbeans.ut.given;

import java.util.function.BiConsumer;
import java.util.function.Function;

import javax.annotation.Nonnull;

import picklesjar.pickle.ut.core.IllegalMethodQueryException;
import picklesjar.pickle.ut.core.IllegalTestCodeStateException;
import picklesjar.pickle.ut.core.IllegalTestStateException;
import picklesjar.pickle.ut.core.PreparedTemporaryKey;
import picklesjar.pickle.ut.core.util.ClassFunctionTarget;
import picklesjar.pickle.ut.core.util.MethodQuery;
import picklesjar.pickle.ut.runtime.UnitTestRuntimeFoundation;
import picklesjar.pickle.ut.runtime.UnitTestTemporary;

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
	 */
	protected final void execute() {
	
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, Function< UnitTestTemporary, MethodQuery > > )this::execute,
			( temp ) -> {
				MethodQuery result = null;
				try {
					result = PreparedTemporaryKey.TEST_TARGET_METHOD_QUERY.valueOf( temp );
				} catch( ClassCastException exp ) {
					throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_METHOD_QUERY, exp );
				}
				return result;
			} );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param methodQuery
	 */
	protected final void execute( String methodQuery ) {
	
		MethodQuery query = null;
		try {
			query = MethodQuery.newInstance( methodQuery );
		} catch( IllegalMethodQueryException exp ) {
			throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
		}
		
		UnitTestRuntimeFoundation.given(
			( BiConsumer< UnitTestTemporary, MethodQuery > )this::execute, query );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param function
	 */
	private final void execute(
		UnitTestTemporary temp, @Nonnull Function< UnitTestTemporary, MethodQuery > function ) {
	
		execute( temp, function.apply( temp ) );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param methodQuery
	 */
	private final void execute( UnitTestTemporary temp, MethodQuery methodQuery ) {
	
		Class< ? > targetClass = null;
		try {
			targetClass = PreparedTemporaryKey.TEST_TARGET_CLASS_OBJECT.valueOf( temp );
		} catch( ClassCastException exp ) {
			throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_OBJECT, exp );
		}
		
		ClassFunctionTarget target = null;
		try {
			target = new ClassFunctionTarget( targetClass, methodQuery );
		} catch(
			IllegalTestCodeStateException | SecurityException exp ) {
			
			throw new IllegalTestStateException( CODE_OF_FAILED_TO_SEARCH_METHOD, exp );
		}
		
		temp.put(
			PreparedTemporaryKey.TEST_TARGET_METHOD_QUERY.name(), methodQuery );
		temp.put(
			PreparedTemporaryKey.TEST_TARGET_CLASS_FUNCTION.name(), target );
	}
	
}
