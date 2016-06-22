package wesleyjonathan.testingtest.register;

import android.support.annotation.StringRes;
import android.widget.EditText;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import wesleyjonathan.testingtest.R;
import wesleyjonathan.testingtest.base.BaseActivity;

@EActivity(R.layout.activity_main)
public class RegisterActivity extends BaseActivity implements RegisterView {
    @ViewById(R.id.name)
    EditText mName;

    @ViewById(R.id.email)
    EditText mEmail;

    @ViewById(R.id.confirmEmail)
    EditText mConfirmEmail;

    @Bean(RegisterPresenterImpl.class)
    RegisterPresenter mPresenter;

    @Click(R.id.register)
    void onClickRegister() {
        mPresenter.onRegister(mName.getText().toString(),
                mEmail.getText().toString(),
                mConfirmEmail.getText().toString());
    }

    @Override
    protected void attachView() {
        mPresenter.attachView(this);
    }

    @UiThread
    @Override
    public void showNameError(@StringRes int errorRes) {
        mName.setError(getString(errorRes));
        mName.requestFocus();
    }

    @UiThread
    @Override
    public void showEmailError(@StringRes int errorRes) {
        mEmail.setError(getString(errorRes));
        mEmail.requestFocus();
    }

    @UiThread
    @Override
    public void onSuccess() {

    }
}
