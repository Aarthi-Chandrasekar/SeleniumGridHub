package stepdefinition;

import com.mycompany.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

public class CartCheckoutOne extends AbstractsStepDefs {

    @Given("the Second item {string} is added to the cart")
    public void sauceLabsBackpackAddedToCart(String labelName){
        homePage.addorRemoveItembyLabelName(labelName);
    }

    @And("the cart icon is clicked")
    public void cartIconClicked(){
        homePage.clickOnCart();
    }

    @And("the Checkout button is clicked")
    public void checkoutButtonClicked(){
        homePage.clickCheckoutButton();
    }

    @And("the First name is filled with {string}")
    public void firstNameFilled(String firstName){
        homePage.fillField(HomePage.FIRSTNAME, firstName);
    }

    @And("the Last name is filled with {string}")
    public void lastNameFilled(String lastName){
        homePage.fillField(HomePage.LASTNAME, lastName);
    }

    @And("the Zip code is filled with {string}")
    public void zipCodeFilled(String zipCode){
        homePage.fillField(HomePage.POSTAL_CODE, zipCode);
    }

    @When("the Continue button is clicked")
    public void continueButtonClicked(){
        homePage.clickContinueButton();
    }

    @Then("{string} should be shown as total price")
    public void total$ShouldBeShown(String total) {

    }

    @And("the First item {string} is added to the cart")
    public void theSauceLabsBikeLightIsAddedToTheCart(String itemName) {
        homePage.addorRemoveItembyLabelName(itemName);
    }

    @Then("the number {string} should be showing on top of the shopping cart")
    public void shoppingCartBadgeNumber(String number) {

    }

    @And("the First item {string} is removed from the cart")
    public void theSauceLabsBackpackIsRemovedFromTheCart(String labelName) {
        homePage.addorRemoveItembyLabelName(labelName);
    }

    @And("the Third item {string} is added to the cart")
    public void theSauceLabsBoltTShirtIsAddedToTheCart(String label) {
        homePage.addorRemoveItembyLabelName(label);
    }

    @And("{string} should be shown as tax")
    public void tax$ShouldBeShownAsTax(String tax) {

    }

    @And("{string} should be shown as an item total")
    public void itemTotal$ShouldBeShownAsAnItemTotal(String itemTotal) {

    }
}
