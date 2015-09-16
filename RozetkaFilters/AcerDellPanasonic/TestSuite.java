package AcerDellPanasonic;

import AcerDellPanasonic.*;
import AcerDellPanasonic.TestCompateCountWithTitle;
import AcerDellPanasonic.TestContainsElement;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by user on 08.07.2015.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AcerDellPanasonic.TitleContinsElement.class,
        TestCompateCountWithTitle.class,
        TestContainsElement.class
})
public class TestSuite {
}
