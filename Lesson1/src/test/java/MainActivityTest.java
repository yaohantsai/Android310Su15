import android.support.v7.appcompat.BuildConfig;
import android.widget.TextView;

import com.uw.android310.lesson1.MainActivity;
import com.uw.android310.lesson1.R;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
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
    public void testContentOnActivityLoad() throws Exception {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        TextView content = (TextView) activity.findViewById(R.id.content);
        Assert.assertEquals(content.getText().toString(), activity.getString(R.string.hello_world));
    }
}
