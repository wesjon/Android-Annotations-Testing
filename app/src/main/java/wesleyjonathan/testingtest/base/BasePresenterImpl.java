package wesleyjonathan.testingtest.base;

import org.androidannotations.annotations.EBean;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
@EBean
public class BasePresenterImpl<T extends BaseView> {
    private T mView;

    public void attachView(T view) {
        mView = view;
    }

    public T getView() {
        return mView;
    }
}
