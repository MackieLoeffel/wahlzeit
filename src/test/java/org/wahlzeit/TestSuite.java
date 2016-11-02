package org.wahlzeit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
		org.wahlzeit.handlers.TestSuite.class,
		org.wahlzeit.model.TestSuite.class,
		org.wahlzeit.services.TestSuite.class,
		org.wahlzeit.utils.TestSuite.class
})
public class TestSuite {
}
