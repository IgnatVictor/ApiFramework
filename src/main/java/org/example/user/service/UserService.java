package org.example.user.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.user.model.UserModel;
import org.example.user.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class UserService {


    UserRepository userRepository;

    private UserModel[] userModelsList;
    RestTemplate restTemplate = new RestTemplate();


    public UserService() {
        this.userRepository = new UserRepository();
        generateUserDetails();
    }


    public UserService(int id) throws JsonProcessingException {
        generateUserDetailsFromApi(id);
    }

    private final String API_BASE_URL = "https://reqres.in/api/users";

    private void generateUserDetailsFromApi(int id) throws JsonProcessingException {
        userModelsList = new UserModel[1];
        ResponseEntity<String> response = restTemplate.getForEntity(API_BASE_URL + "/" + id, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode firstName = root.path("data").path("first_name");
        JsonNode idForFirstName = root.path("data").path("id");
        userModelsList[0] = new UserModel(idForFirstName.asText(), firstName.asText());
//
    }

    public UserModel[] generateUsersDetailsFromApi() throws JsonProcessingException {
        userModelsList = new UserModel[6];
        ResponseEntity<String> response = restTemplate.getForEntity(API_BASE_URL + "?page=1", String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        for (int i = 0; i < root.path("data").size(); i++) {
            JsonNode firstName = root.path("data").get(i).path("first_name");
            JsonNode lastName = root.path("data").get(i).path("last_name");
            JsonNode idForFirstName = root.path("data").get(i).path("id");

            userModelsList[i] = new UserModel(idForFirstName.asText(), firstName.asText(), lastName.asText());
        }

        return userModelsList;
    }

    private void generateUserDetails() {
        userModelsList = new UserModel[2];
        userModelsList[0] = new UserModel(userRepository.ID, userRepository.FIRST_NAME);
        userModelsList[1] = new UserModel(userRepository.ID, userRepository.FIRST_NAME);

    }

    private void generateUserDetailsWithIdFirstNameAndLastName(){
        userModelsList = new UserModel[6];

    }




    public String getName(int index) {

        return userModelsList[index].getFirstName();
    }

    public String getId(int index) {

        return userModelsList[index].getId();
    }

    public String getUserDetails(int index) {

        return userModelsList[index].getFirstName();
    }


}



