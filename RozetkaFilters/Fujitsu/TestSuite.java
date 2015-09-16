package Fujitsu;

import Fujitsu.TestCompateCountWithTitle;
import Fujitsu.TestContainsElement;
import Fujitsu.TestCountOfElements;
import Fujitsu.TitleContinsElement;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by user on 08.07.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        TitleContinsElement.class,
        TestCompateCountWithTitle.class,
        TestCountOfElements.class,
        TestContainsElement.class
})
public class TestSuite {
}
