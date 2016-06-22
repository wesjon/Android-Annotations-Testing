package wesleyjonathan.testingtest.register;

import org.androidannotations.annotations.EBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import wesleyjonathan.testingtest.R;
import wesleyjonathan.testingtest.base.BasePresenterImpl;
import wesleyjonathan.testingtest.rest.KnowledgeLearningCenterInterface;
import wesleyjonathan.testingtest.rest.model.CourseStatusDTO;
import wesleyjonathan.testingtest.util.StringUtils;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
@EBean
public class RegisterPresenterImpl extends BasePresenterImpl<RegisterView> implements RegisterPresenter {
    public KnowledgeLearningCenterInterface mApi;

    @Override
    public void attachView(RegisterView view) {
        super.attachView(view);
    }

    @Override
    public void onRegister(final String name, String email, String confirmEmail) {
        if (StringUtils.isEmpty(name)) {
            getView().showNameError(R.string.required_field);
            return;
        }

        if (StringUtils.isEmpty(email)) {
            getView().showEmailError(R.string.required_field);
            return;
        }

        if (!StringUtils.equals(email, confirmEmail)) {
            getView().showEmailError(R.string.confirmation_failed);
            return;
        }

        mApi.checkApiStatus().enqueue(new Callback<CourseStatusDTO>() {
            @Override
            public void onResponse(Call<CourseStatusDTO> call, Response<CourseStatusDTO> response) {
                CourseStatusDTO course = response.body();
                if (StringUtils.equals(course.success, name)) {
                    getView().onSuccess();
                }
            }

            @Override
            public void onFailure(Call<CourseStatusDTO> call, Throwable t) {

            }
        });
    }

    public RegisterPresenter useApi(KnowledgeLearningCenterInterface service) {
        mApi = service;
        return this;
    }
}
