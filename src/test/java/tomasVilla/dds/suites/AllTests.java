package tomasVilla.dds.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tomasVilla.dds.cases.Tp0TestCase;

@RunWith(Suite.class)
@SuiteClasses({
	Tp0TestCase.class
})
public class AllTests {

}
