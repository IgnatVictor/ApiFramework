import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.user.model.UserModel;
import org.example.user.service.UserService;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserServiceTestCase {


    UserModel[] expectedUsersDetailList;

    private void generateExpectedUserDetailsList() {
        expectedUsersDetailList = new UserModel[6];

        expectedUsersDetailList[0] = new UserModel("1", "George", "Bluth");
        expectedUsersDetailList[1] = new UserModel("2", "Janet", "Weaver");
        expectedUsersDetailList[2] = new UserModel("3", "Emma", "Wong");
        expectedUsersDetailList[3] = new UserModel("4", "Eve", "Holt");
        expectedUsersDetailList[4] = new UserModel("5", "Charles", "Morris");
        expectedUsersDetailList[5] = new UserModel("6", "Tracey", "Ramos");

    }


    @Test
    public void checkThatUsersFetchedFromApiAreCorrect() throws JsonProcessingException {
        final UserService userService = new UserService();
        generateExpectedUserDetailsList();

        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < userService.generateUsersDetailsFromApi().length; i++) {
            softAssert.assertEquals(userService.generateUsersDetailsFromApi()[i].getFirstName(), expectedUsersDetailList[i].getFirstName());
            softAssert.assertEquals(userService.generateUsersDetailsFromApi()[i].getLastName(), expectedUsersDetailList[i].getLastName());
            softAssert.assertEquals(userService.generateUsersDetailsFromApi()[i].getId(), expectedUsersDetailList[i].getId());

        }

        softAssert.assertAll();
    }
}
