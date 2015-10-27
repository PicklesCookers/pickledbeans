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
public abstract class StringResultChecker
	implements picklesjar.pickledbeans.ut.then.StringResultChecker {
	
	/**
	 * 
	 * 
	 * 
	 * @param key
	 */
	@Override
	public void checkStringValue( String expectedValue ) {
	
		UnitTestRuntimeFoundation.then(
			( BiConsumer< UnitTestResult, String > )
			( result, _expectedValue ) -> {
				
				Object resultValue = null;
				if( result.containsKey( "0" ) ) {
					
					resultValue = result.get( "0" );
					
				} else {
					
					throw new IllegalTestStateException( 1 );
				}
				
				if( resultValue instanceof String ) {
					
					assertThat( ( String )resultValue, is( _expectedValue ) );
					
				} else {
					
					throw new IllegalTestStateException( 2 );
				}
				
			}, expectedValue );
	}
}
