package picklesjar.pickledbeans.ut.hooks.lock_only;

import picklesjar.pickles.ut.core.CucumberHook;
import picklesjar.pickles.ut.runtime.UnitTestRuntimeFoundation;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook
	implements CucumberHook {
	
	private static String lockKey = null;
	
	@Before
	public static void setUp() {
	
		// UnitTestRuntimeFoundation.switchMode( UnitTestRuntimeFoundation.MULTI_THREAD_MODE );
		lockKey = UnitTestRuntimeFoundation.lock();
	}
	
	@After
	public static void tearDown() {
	
		UnitTestRuntimeFoundation.unlock( lockKey );
	}
	
}
