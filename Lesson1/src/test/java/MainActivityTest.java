import android.support.v7.appcompat.BuildConfig;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

/**
 * Created by DOu on 6/23/15.
 */
@RunWith(CustomRobolectricTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21, manifest="../AndroidManifest.xml")
public class MainActivityTest {

    @Before
    public void setUp() throws Exception {
        // setup
    }

    @Test
    public void testSomething() throws Exception {

    }
}
