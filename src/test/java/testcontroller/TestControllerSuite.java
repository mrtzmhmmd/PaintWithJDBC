package testcontroller;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestMD5.class, TestShapeEntityManager.class, TestUserEntityManager.class })
public class TestControllerSuite {

}
