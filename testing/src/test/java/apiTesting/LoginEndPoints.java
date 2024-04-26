package apiTesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpHeaders;

import static io.restassured.RestAssured.given;

public class LoginEndPoints {
    public static Response loginUser(Users payload) {

        Response response = given().
                header("Authorization", Routes.auth_token).
//                contentType(ContentType.JSON).
//                accept(ContentType.JSON).
                body(payload).
                when().
                post(Routes.login_post_url);

        return response;
    }
}
