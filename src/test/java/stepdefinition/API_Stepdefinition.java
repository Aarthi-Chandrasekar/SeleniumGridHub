package stepdefinition;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class API_Stepdefinition {
	private static final String BASE_URL = "http://localhost:8088";
	private static RequestSpecification request;
	private static Response response;

	@Given("A Get all employees service API endpoint is available")
	public void setTheEmployeeServiceAPIEndpoint() {
		request = given().baseUri(BASE_URL);
	}

	@When("I make the GET request to retrieve all employees")
	public void retrieveAllEmployees() {
		response = request.get("/employees");
	}

	@When("I create the employee")
	public void createEmployee() {
		response = request.contentType("application/json").body(getCreateEmployeeDataFromCsv()).post("/employees");
	}

	@When("I update the employee")
	public void updateEmployee() {
		response = request.contentType("application/json").body(getUpdateEmployeeDataFromCsv()).put("/employees/{id}", 8);  // Sample ID
	}

	@When("I delete the employee")
	public void deleteEmployee() {
		response = request.delete("/employees/{id}", 8);  // Sample ID
	}

	@Then("The response status code should be {int}")
	public void checkStatusCode(int statusCode) {
		assertEquals(statusCode, response.getStatusCode());
	}

	public String getCreateEmployeeDataFromCsv() {
		URL jsonResource = getClass().getClassLoader().getResource("data.json");
		if (jsonResource == null) {
			return "";
		}
		Path jsonPath = null;
		try {
			jsonPath = Paths.get(jsonResource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		File jsonFile = jsonPath.toFile();
		String requestBody = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> employeeData = null;
		try {
			employeeData = objectMapper.readValue(jsonFile, Map.class);
			requestBody = objectMapper.writeValueAsString(employeeData);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return requestBody;
	}

	public String getUpdateEmployeeDataFromCsv() {
		URL jsonResource = getClass().getClassLoader().getResource("update.json");
		if (jsonResource == null) {
			return "";
		}
		Path jsonPath = null;
		try {
			jsonPath = Paths.get(jsonResource.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		File jsonFile = jsonPath.toFile();
		String requestBody = "";
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Object> employeeData = null;
		try {
			employeeData = objectMapper.readValue(jsonFile, Map.class);
			requestBody = objectMapper.writeValueAsString(employeeData);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return requestBody;
	}
}
/*
 * Sample Rest API To Test with Rest Assured - 
 * Step 1. Clone the below repository to your local machine "git clone  https://github.com/onlyfullstack/rest-assured-tutorial.git"
 * Step 2 Run spring-boot mvn command in command prompt "mvn spring-boot:run "
 */
