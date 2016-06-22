package wesleyjonathan.testingtest.base;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
public interface BasePresenter<T extends BaseView> {
    void attachView(T view);
}
