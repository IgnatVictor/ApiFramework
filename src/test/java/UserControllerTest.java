import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.Application;
import org.example.mockUser.mockService.ExpectedService;
import org.example.user.controller.UserController;
import org.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest extends AbstractTestNGSpringContextTests {


    private UserController userController;





    @Autowired
    ExpectedService expectedService;


    @Test
    public void verifyUserServiceWithUserRepositoryEqualToUserApi() throws JsonProcessingException {
       final UserService userService = new UserService();
        userController = new UserController("userServiceRepository");
        JsonObject actualUserDetails = userController.getUserDetails().getAsJsonObject();


        String expectedUserDetails = userService.getUserDetails(0);
        JsonObject expectedJasonOutput = new JsonObject();
        expectedJasonOutput.add("First name", new Gson().toJsonTree(expectedUserDetails));


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUserDetails.toString(), expectedJasonOutput);

        softAssert.assertAll();
    }


    @Test
    public void verifyUserServiceRegresApiEqualsToUserApi() throws JsonProcessingException {
        final UserService userService = new UserService(2);
        userController = new UserController("apiUserService");
        JsonObject actualUserDetails = userController.getUserDetails();


        String expectedUserDetails = userService.getUserDetails(0);
        JsonObject expectedJasonOutput = new JsonObject();
        expectedJasonOutput.add("First name", new Gson().toJsonTree(expectedUserDetails));


        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualUserDetails.toString(), expectedJasonOutput);

        softAssert.assertAll();
    }



}
