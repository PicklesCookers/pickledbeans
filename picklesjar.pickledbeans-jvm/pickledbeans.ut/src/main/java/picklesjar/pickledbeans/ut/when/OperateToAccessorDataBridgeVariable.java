package picklesjar.pickledbeans.ut.when;

import java.lang.reflect.Field;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.annotation.Nonnull;

import picklesjar.pickles.ut.core.IllegalMethodQueryException;
import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.core.PreparedTemporaryKey;
import picklesjar.pickles.ut.core.util.ClassFunctionTarget;
import picklesjar.pickles.ut.core.util.MethodQuery;
import picklesjar.pickles.ut.prepare.design.StereotypeDesign;
import picklesjar.pickles.ut.recipes.variable.AccessorDataBridgeVariable;
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
public abstract class OperateToAccessorDataBridgeVariable {
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_INSTANCE = 1;
	
	protected static final int CODE_OF_EMPTY_TARGET_CLASS_FUNCTION = 2;
	
	protected static final int CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN = 3;
	
	protected static final int CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE = 4;
	
	/**
	 * 
	 * 
	 * 
	 * @param alias
	 */
	protected final void getAndPutTo( String alias ) {
	
		UnitTestRuntimeFoundation.when(
			alias,
			
			( Function< UnitTestTemporary, Object > )
			( temp ) -> {
				
				return execute( temp,
					( field, instance ) -> {
						Object result = null;
						try {
							result = field.get( instance );
						} catch( IllegalAccessException exp ) {
							throw new IllegalTestStateException( CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE, exp );
						}
						return result;
					} );
			} );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param arg
	 */
	protected final void set( Object arg ) {
	
		UnitTestRuntimeFoundation.when(
			( BiConsumer< UnitTestResult, UnitTestTemporary > )
			( result, temp ) -> {
				
				execute( temp,
					( field, instance ) -> {
						try {
							field.set( instance, arg );
						} catch( IllegalAccessException exp ) {
							throw new IllegalTestStateException( CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE, exp );
						}
						return null;
					} );
			} );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param temp
	 * @param function
	 * @return
	 */
	private final Object execute(
		UnitTestTemporary temp,
		@Nonnull BiFunction< Field, Object, Object > function ) {
	
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
			throw new IllegalTestStateException( CODE_OF_EMPTY_TARGET_CLASS_FUNCTION, exp );
		}
		
		StereotypeDesign design = null;
		try {
			design = PreparedTemporaryKey.TEST_TARGET_METHOD_OF_STEREOTYPE_DESIGN.valueOf( temp );
		} catch( ClassCastException exp ) {
			throw new IllegalTestStateException( CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN, exp );
		}
		if( ( design == null )
			|| ( ( design != StereotypeDesign.ACCESSOR_GETTER )
			&& ( design != StereotypeDesign.ACCESSOR_SETTER ) ) ) {
			throw new IllegalTestStateException( CODE_OF_EMPTY_OR_ILLEGAL_TARGET_STEREOTYPE_DESIGN );
		}
		
		@Nonnull
		Field[] fields = target.getTargetClass().getDeclaredFields();
		if( ( fields == null ) || ( fields.length == 0 ) ) {
			throw new IllegalTestStateException( CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE );
		}
		
		Field targetField = null;
		String accessorName = null;
		for( @Nonnull
		Field field : fields ) {
			field.setAccessible( true );
			
			AccessorDataBridgeVariable annotation = field.getDeclaredAnnotation( AccessorDataBridgeVariable.class );
			if( annotation == null ) {
				continue;
			}
			
			if( design == StereotypeDesign.ACCESSOR_GETTER ) {
				
				accessorName = annotation.getter();
				
			} else if( design == StereotypeDesign.ACCESSOR_SETTER ) {
				
				accessorName = annotation.setter();
				
			}
			if( ( accessorName == null ) || ( accessorName.isEmpty() ) ) {
				
				continue;
			}
			
			MethodQuery accessorQuery = null;
			try {
				accessorQuery = MethodQuery.newInstance( accessorName );
			} catch( IllegalMethodQueryException exp ) {
				continue;
			}
			
			if( target.getTargetMethodQuery().equals( accessorQuery ) ) {
				targetField = field;
				break;
			}
		}
		
		if( targetField == null ) {
			throw new IllegalTestStateException( CODE_OF_FAILED_TO_LOOKUP_TARGET_VARIABLE );
		}
		
		return function.apply( targetField, instance );
	}
	
}
