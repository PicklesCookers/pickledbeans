package picklesjar.pickledbeans.ut.then.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.BiConsumer;

import picklesjar.pickledbeans.ut.then.AsserThatResultIs;
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
	 * @param key
	 */
	protected final < T > void execute( T expectedValue ) {
	
		UnitTestRuntimeFoundation.then(
			( BiConsumer< UnitTestResult, T > )
			( result, _expectedValue ) -> {
				
				Object resultValue = null;
				if( result.containsKey(
					AsserThatResultIs._ResultKey.SINGLE_FUNCTION_CALL.name() ) ) {
					
					resultValue = result.get(
						AsserThatResultIs._ResultKey.SINGLE_FUNCTION_CALL.name() );
					
				} else {
					
					throw new IllegalTestStateException( CODE_OF_EMPTY_ASSERT_TARGET_RESULT );
				}
				
				assertThat( resultValue, is( _expectedValue ) );
				
			}, expectedValue );
	}
	
}
