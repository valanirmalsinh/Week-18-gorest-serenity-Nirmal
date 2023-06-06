package com.gorest.userinfo;

import com.gorest.constants.EndPoints;
import com.gorest.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserSteps {

    @Step("Creating user with name :{0},email : {1},gender : {2},status : {3} ")
    public ValidatableResponse createUser( String name, String email, String gender,
                                           String status){
        UserPojo userPojo = UserPojo.getUserPojo(name,email,gender,status);
        return SerenityRest.given()
                .contentType(ContentType.JSON)
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                .when()
                .body(userPojo)
                .post()
                .then();
    }


    @Step("Getting the user  information with userId : {0}")
    public int  getUserId(int id){
       return SerenityRest.given()
                .header("Authorization", "Bearer 57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                .pathParams("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then().statusCode(200)
                .extract()
                .path("id");

    }
    @Step("Getting the User information with id : {0}")
    public ValidatableResponse getUserInformationById(int id){
        return SerenityRest.given()
                .header("Authorization","Bearer  57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                .pathParams("id",id)
                .when()
                .get(EndPoints.GET_SINGLE_USER_BY_ID)
                .then();
    }

    @Step("Updating user information with id: {0}, name: {1}, email: {2}, gender: {3},status: {4}")
    public ValidatableResponse updateUser(int id,String name, String email, String gender,
                                             String status){
        UserPojo userPojo = UserPojo.getUserPojo(name,email,gender,status);

       return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization","Bearer 57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                .pathParams("id", id)
                .when()
                .body(userPojo)
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();



    }
    @Step("Deleting user information with userId: {0}")
    public ValidatableResponse deleteUser(int id) {
        return SerenityRest.given().log().all()
                .header("Authorization", "Bearer 57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                .pathParam("id", id)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }


        @Step("Getting all User information")
        public ValidatableResponse getAllUserInfo(){
        return SerenityRest.given()
                    .header("Authorization","Bearer 57a081dd4669814ea0f6e6681c3e28bfa86977769ec6d47a5673c55835839316")
                    .when()
                    .get(EndPoints.GET_ALL_USERS)
                    .then();


    }


    }


