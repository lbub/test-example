package pl.lbu.test.example.backend.git.authorizations;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
import lombok.extern.log4j.Log4j2;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.lbu.test.example.TestExampleApp;
import pl.lbu.test.example.backend.BaseApi;
import pl.lbu.test.example.git.user.request.UserRequest;
import pl.lbu.test.example.git.user.response.UserResponse;
import pl.lbu.test.example.utils.test.reports.AllureReport;

import static io.restassured.RestAssured.given;

@Listeners({AllureReport.class})
@SpringBootTest(classes = TestExampleApp.class)
@Epic("example")
@Feature("how to rest - auth")
@Log4j2
public class UserTest extends AbstractTestNGSpringContextTests {

    private SoftAssert softAssert;

    @Autowired
    private BaseApi baseApi;
    @Autowired
    private UserRequest request;

    @BeforeMethod
    public void softAssert() {
        softAssert = new SoftAssert();
    }

    @Test
    public void user() {
        UserResponse response = given()
                .log().all()
                .baseUri(baseApi.getGitUrl())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .get(request.getSubdirectoryUrl(), request.getQueryParams().getUser())
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().body().as(UserResponse.class);
        softAssert.assertEquals(response.getLogin(), "lbub");
        softAssert.assertAll();
    }
}
