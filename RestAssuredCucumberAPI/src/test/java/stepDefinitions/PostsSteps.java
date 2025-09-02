package stepDefinitions;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;

import io.cucumber.java.en.*;

public class PostsSteps {
    Response response;

    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {int} posts")
    public void the_response_should_contain_posts(Integer count) {
        response.then().body("size()", equalTo(count));
    }

    @Then("the response should contain the post with id {int}")
    public void the_response_should_contain_the_post_with_id(Integer id) {
        response.then().body("id", equalTo(id));
    }

    // New POST step
    @Given("I send a POST request to {string} with body:")
    public void i_send_a_post_request_to_with_body(String endpoint, String body) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("the response should contain the new post with userId {int}")
    public void the_response_should_contain_the_new_post_with_userId(Integer userId) {
        response.then().body("userId", equalTo(userId));
    }

    // New PUT step
    @Given("I send a PUT request to {string} with body:")
    public void i_send_a_put_request_to_with_body(String endpoint, String body) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint);
    }

    @Then("the response should reflect the updated title {string}")
    public void the_response_should_reflect_the_updated_title(String title) {
        response.then().body("title", equalTo(title));
    }

    // DELETE step
    @Given("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .delete(endpoint);
    }

    // PATCH step
    @Given("I send a PATCH request to {string} with body:")
    public void i_send_a_patch_request_to_with_body(String endpoint, String body) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .patch(endpoint);
    }

}
