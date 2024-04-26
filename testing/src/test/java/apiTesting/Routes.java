package apiTesting;

public class Routes {
    public static String base_url = "http://localhost:8080/swagger-ui/index.html#";
    public static String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtaWtpZDE5OTdAZ21haWwuY29tIiwiRmlyc3RfTmFtZSI6IkR1dGEiLCJMYXN0X05hbWUiOiJNaWhhaSIsImlhdCI6MTcxNDA3NDUzNSwiZXhwIjoxNzE0MDc4MTM1fQ.c6pyHhFJ9JMeHkhL0X3C9xxOH9fNS3PJLhYo57L92gM";
    public static String auth_token = "Bearer " + token;


    public static String login_post_url = base_url + "/auth-controller/authenticateUser";
}
