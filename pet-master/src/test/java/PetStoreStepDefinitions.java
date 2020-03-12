import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class PetStoreStepDefinitions {

    Response response;
    private Map<String, String> parameters;
    private String url = "https://petstore.swagger.io/v2";

    @Given("^Enter name '(.*?)'$")
    public void given_name(String name) {
        url += "/pet";
        System.out.println("Add URL :" + url);
        System.out.println("searchTerm :" + name);

        parameters = new HashMap<>();
        
        parameters.put("id", "1");
        parameters.put("name", name);
        parameters.put("status", "available");
    }

    @When("^Do post request$")
	public void post_requst() {

        System.out.println("Request POST =====> :" + url);

		response = given().
            contentType("application/json").
			body(parameters).
		when().
            post(url);
    }
    
    @When("^Do delete request$")
	public void delete_request() {

        System.out.println("Request Delete =====> :" + url);

        // Create default Pet
		response = given().
            contentType("application/json").
			body(parameters).
		when().
            post(url);

        Pet pet = response.as(Pet.class);

        System.out.println(pet.getId());
        System.out.println(pet.getName());
        System.out.println(pet.getStatus());

        url += "/" + pet.getId();

        System.out.println("Request Delete =====> :" + url);

        // Delete current Pet
        response = given().
            contentType("application/json").
		when().
            delete(url);
    }
    
    @When("^Do place order request$")
	public void place_order_request() {

        System.out.println("Request Place Order =====> :" + url);

        // Create default Pet
		response = given().
            contentType("application/json").
			body(parameters).
		when().
            post(url);

        Pet pet = response.as(Pet.class);

        System.out.println(pet.getId());
        System.out.println(pet.getName());
        System.out.println(pet.getStatus());

        url = "https://petstore.swagger.io/v2/store/order";

        System.out.println("Request Delete =====> :" + url);

        parameters = new HashMap<>();
        
        parameters.put("petId", pet.getId().toString());
        parameters.put("quantity", "1");
        parameters.put("status", "placed");
        parameters.put("shipDate", "2020-03-04T06:45:02.322Z");

        // Place order
        response = given().
            contentType("application/json").
			body(parameters).
		when().
            post(url);
	}

	@Then("^Status for '(.*?)'$")
	public void assertSingleResult(int expected) {
		assertEquals(expected, response.statusCode());
	}

}
