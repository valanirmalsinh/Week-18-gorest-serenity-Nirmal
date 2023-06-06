package com.gorest.userinfo;

import com.gorest.testbase.TestBase;
import com.gorest.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class UserCRUDTestWithSteps extends TestBase {
    static String name = "Shubh" + TestUtils.getRandomValue();
    static String email = "Shubh" + TestUtils.getRandomValue() + "@gmail.com";
    static String gender = "Male";
    static String status = "Active";
    static int id;

    @Steps
    UserSteps userSteps;

    @Title("This will create a new user")
    @Test
    public void test001() {
        ValidatableResponse response = userSteps.createUser(name, email, gender, status);
        response.log().all().statusCode(201);
        id = response.extract().path("id");
    }

    @Title("Verify if the user was added to the application")
    @Test
    public void test002() {
        int userId = userSteps.getUserId(id);
        Assert.assertEquals(userId, id);
    }

    @Title("Update the user information and verify the updated information ")
    @Test
    public void test003() {
        userSteps.updateUser(id, name, email, gender, status).statusCode(200);
        int userId = userSteps.getUserId(id);
        Assert.assertEquals(userId, id);
    }

    @Title("This will delete user and verify that user is deleted")
    @Test
    public void test004() {
        userSteps.deleteUser(id).statusCode(204);
       // userSteps.getAllUserInfo().statusCode(404);


    }
}
