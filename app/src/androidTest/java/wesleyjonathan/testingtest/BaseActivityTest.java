package wesleyjonathan.testingtest;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

import wesleyjonathan.testingtest.base.BaseActivity;

/**
 * Created by wesleyjonathan on 4/14/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public abstract class BaseActivityTest<T extends BaseActivity> {

    @Rule
    public final ActivityTestRule<T> mActivityRule;

    public BaseActivityTest() {
        mActivityRule = getActivityTestRule();
    }

    protected abstract ActivityTestRule<T> getActivityTestRule();

    public String getString(@StringRes int messageRes) {
        return mActivityRule.getActivity().getString(messageRes);
    }
}
