package wesleyjonathan.testingtest.register;

import android.support.annotation.StringRes;

import wesleyjonathan.testingtest.base.BaseView;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
public interface RegisterView extends BaseView {
    void showNameError(@StringRes int errorRes);
    void showEmailError(@StringRes int errorRes);
    void onSuccess();
}
