package wesleyjonathan.testingtest.rest;


import retrofit2.Call;
import retrofit2.http.GET;
import wesleyjonathan.testingtest.rest.model.CourseStatusDTO;

/**
 * This holds all endpoints to HTTPS requests. It is proxyed by Retrofit.
 */

public interface KnowledgeLearningCenterInterface {

    @GET("status/claro-cursos")
    Call<CourseStatusDTO> checkApiStatus();
}


