package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonStepDefs extends AbstractsStepDefs {
    @Given("the homepage is open")
    public void homePageIsOpened() {
        homePage.openPage();
    }


    @And("the page is refreshed")
    public void refreshPage(){
        driver.navigate().refresh();
    }
}
