package wesleyjonathan.testingtest.register;

import wesleyjonathan.testingtest.base.BasePresenter;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
public interface RegisterPresenter extends BasePresenter<RegisterView> {
    void onRegister(String name, String email, String confirmEmail);
}
