package apiTesting;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoginTest {
    static Users usersPayload;

    @BeforeAll
    public static void setup() {
        usersPayload = new Users();

        usersPayload.setUsername("mikid1997@gmail.com");
        usersPayload.setPassword("f425fc68594449e2c0408791a29a30a1e42141e5f8424d7926734b5e1676af0d");
    }

    @Test
    public void testLoginUser() {

        Response response = LoginEndPoints.loginUser(usersPayload);
        response.then().log().all();

        Assertions.assertEquals(response.getStatusCode(), 200);
    }

}
