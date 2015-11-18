package picklesjar.pickledbeans.ut.then.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.BiConsumer;

import picklesjar.pickles.ut.core.IllegalTestStateException;
import picklesjar.pickles.ut.runtime.UnitTestResult;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;

/**
 * 
 * 
 * 
 * @author PicklesCooker
 *
 */
public abstract class AssertThatResultIs
	implements picklesjar.pickledbeans.ut.then.AsserThatResultIs {
	
	/**
	 * 
	 * 
	 * 
	 * @param expectedValue
	 */
	protected final < T > void execute( T expectedValue ) {
	
		executeWithAlias( "0", expectedValue );
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	protected final < T > void executeWithAlias( String alias, T expectedValue ) {
	
		UnitTestRuntimeFoundation.then(
			( BiConsumer< UnitTestResult, T > )
			( result, _expectedValue ) -> {
				
				Object resultValue = null;
				if( result.containsKey( alias ) ) {
					
					resultValue = result.get( alias );
					
				} else {
					
					throw new IllegalTestStateException( CODE_OF_EMPTY_ASSERT_TARGET_RESULT );
				}
				
				assertThat( resultValue, is( expectedValue ) );
				
			}, expectedValue );
	}
	
}
