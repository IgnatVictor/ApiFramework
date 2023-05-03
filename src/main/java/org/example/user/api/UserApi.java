package org.example.user.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.List;


public class UserApi {

    private JsonObject jsonObject;
    private List<JsonObject> jsonObjects;

    public JsonObject getUserDetails(String name, String id) {
        jsonObject = new JsonObject();
        jsonObject.add("First name",new Gson().toJsonTree(name));
        jsonObject.add("Id",new Gson().toJsonTree(id));

        return jsonObject;
    }

//    public List<JsonObject> getUsers(List<JsonObject> users) {
//        jsonObjects = new ArrayList<>();
//
//    }

}
