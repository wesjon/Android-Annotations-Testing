package wesleyjonathan.testingtest.base;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EActivity;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
@EActivity
public abstract class BaseActivity extends AppCompatActivity {
    @AfterInject
    protected abstract void attachView();
}
