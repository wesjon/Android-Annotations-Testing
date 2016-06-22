package wesleyjonathan.testingtest.register;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import retrofit2.Call;
import retrofit2.mock.Calls;
import wesleyjonathan.testingtest.R;
import wesleyjonathan.testingtest.rest.KnowledgeLearningCenterInterface;
import wesleyjonathan.testingtest.rest.model.CourseStatusDTO;

/**
 * Created by wesleyjonathan on 4/13/16.
 */
public class RegisterPresenterImplTest {
    @Mock
    RegisterView mView;

    RegisterPresenter mPresenter;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        KnowledgeLearningCenterInterface service = new KnowledgeLearningCenterInterface() {
            @Override
            public Call<CourseStatusDTO> checkApiStatus() {
                CourseStatusDTO x = new CourseStatusDTO();
                Call<CourseStatusDTO> courseStatus = Calls.response(x);
                x.success = " yay ";

                return courseStatus;
            }
        };
        mPresenter = new RegisterPresenterImpl()
                .useApi(service);
        mPresenter.attachView(mView);
    }

    @Test
    public void testOnRegisterWithAllFieldsEmpty_fail() throws Exception {
        mPresenter.onRegister("", "", "");

        Mockito.verify(mView).showNameError(R.string.required_field);
    }

    @Test
    public void testOnRegisterWithEmailEmpty_fail() throws Exception {
        mPresenter.onRegister("Joao", "", "");

        Mockito.verify(mView).showEmailError(R.string.required_field);
    }

    @Test
    public void testOnRegisterWithDifferentPasswordAndConfirmation_fail() throws Exception {
        mPresenter.onRegister("Joao", "email@gmail.com", "not_the_same_email@gmail.com");

        Mockito.verify(mView).showEmailError(R.string.confirmation_failed);
    }

    @Test
    public void testOnRegisterValidInfo_success() throws Exception {
        mPresenter.onRegister(" yay ", "email@gmail.com", "email@gmail.com");
        Mockito.verify(mView).onSuccess();
    }
}