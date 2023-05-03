package org.example.mockUser.mockService;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.example.mockUser.mockRepository.ExpectedData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ExpectedService {


    @Autowired
    ExpectedData expectedData;

    JsonObject expectedUserDetails;

    public String getUserDetails() {
        expectedUserDetails = new JsonObject();
        expectedUserDetails.add("First name",new Gson().toJsonTree(ExpectedData.FIRST_NAME));
        expectedUserDetails.add("Id",new Gson().toJsonTree(ExpectedData.ID));
        return expectedUserDetails.toString();

    }


}
