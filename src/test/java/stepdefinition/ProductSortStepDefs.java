package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ProductSortStepDefs extends AbstractsStepDefs {

    @Given("the Product Sort Button is clicked")
    public void sortButtonClicked(){
        homePage.clickProductSortButton();
    }


    @When("the Name \\(Z to A) is clicked")
    public void theNameZToAIsClicked() {
        homePage.clickNameZToAButton();
    }

    @Then("the Reverse Alphabetical order is shown")
    public void theZToAOrderIsShown() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.className("inventory_item_name"));
        for(WebElement we:elementList){
            obtainedList.add(we.getText());
        }

        ArrayList<String> sortedList =  homePage.getProductListSorted();
        Collections.reverse(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
    }

    @When("the Price \\(low to high) is clicked")
    public void thePriceLowToHighIsClicked() {

    }
    @Then("the Product list is sorted by price from low to high")
    public void theLowToHighPriceIsShown() {
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList= driver.findElements(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div"));
        for(WebElement we:elementList){
            obtainedList.add(we.getText());
        }

        ArrayList<String> sortedList =  homePage.getPriceListSorted();
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
    }


}
