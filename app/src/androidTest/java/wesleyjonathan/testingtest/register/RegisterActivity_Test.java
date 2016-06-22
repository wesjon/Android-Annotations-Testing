package wesleyjonathan.testingtest.register;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Test;

import wesleyjonathan.testingtest.BaseActivityTest;
import wesleyjonathan.testingtest.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by wesleyjonathan on 4/14/16.
 */
public class RegisterActivity_Test extends BaseActivityTest<RegisterActivity_> {
    @Override
    protected ActivityTestRule<RegisterActivity_> getActivityTestRule() {
        return new ActivityTestRule<>(RegisterActivity_.class);
    }

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.name))
                .perform(ViewActions.typeText("xpto"));

        onView(withId(R.id.email))
                .perform(ViewActions.typeText("xpto@gmail.com"));

        onView(withId(R.id.register))
                .perform(ViewActions.click());

        onView(withId(R.id.email))
                .check(matches(hasErrorText(getString(R.string.confirmation_failed))));
    }
}