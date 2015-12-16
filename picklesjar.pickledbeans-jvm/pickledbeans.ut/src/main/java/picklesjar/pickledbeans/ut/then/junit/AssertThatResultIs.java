package picklesjar.pickledbeans.ut.then.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.function.BiConsumer;

import picklesjar.pickle.ut.core.IllegalTestStateException;
import picklesjar.pickle.ut.runtime.UnitTestResult;
import picklesjar.pickle.ut.runtime.UnitTestRuntimeFoundation;

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
	public final < T > void executeWithAlias( String alias, T expectedValue ) {
	
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
