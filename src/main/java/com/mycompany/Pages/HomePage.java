package com.mycompany.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    public static final By USERNAME = By.id("user-name");

    public static final By PASSWORD = By.id("password");

    public static final By FIRSTNAME = By.id("first-name");

    public static final By LASTNAME = By.id("last-name");

    public static final By POSTAL_CODE = By.id("postal-code");


    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackToCartButton;

    @FindBy(name = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    @FindBy(name = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addSauceLabsBoltShirtToCartButton;


    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(id = "first-name")
    private WebElement firstname;

    @FindBy(id = "last-name")
    private WebElement lastname;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "summary_total_label")
    private WebElement totalLabel;

    @FindBy(className = "summary_tax_label")
    private WebElement taxLabel;

    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotalLabel;
    @FindBy(className = "product_sort_container")
    private WebElement productSortButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[2]")
    private  WebElement nameZTOAButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")
    private  WebElement lowToHighButton;
    @FindBy(xpath = "//*[@id=\"item_3_title_link\"]/div")
    private WebElement tShirtRed;

    @FindBy(xpath = "//*[@id=\"item_2_title_link\"]/div")
    private WebElement sauceLabsOnesie;

    @FindBy(xpath = "//*[@id=\"item_5_title_link\"]/div")
    private WebElement sauceLabsFleeceJacket;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    private WebElement sauceLabsBoltTShirt;

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    private WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//*[@id=\"item_4_title_link\"]/div")
    private WebElement sauceLabsBackpack;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(){
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"react-burger-menu-btn\"]")
    private WebElement reactBurgerMenuButton;
    @FindBy(xpath = "//*[@id=\"reset_sidebar_link\"]")
    private WebElement resetAppStateButton;

    @FindAll({@FindBy(css = "#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div")})
    private List<WebElement> priceList;

    public void fillField(By locator, String value) {
        getField(locator).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void clickReactBurgerMenuButton(){
        reactBurgerMenuButton.click();
    }

    public void clickResetAppStateButton(){
        resetAppStateButton.click();
    }

    public void addBackPackToCart(){
        addorRemoveItembyLabelName("Sauce Labs Backpack");

    }

    public void addBikeLightToCart() {
        addorRemoveItembyLabelName("Sauce Labs Bike Light");
    }

    public void addSauceLabsBoltShirtToCart() {
        addorRemoveItembyLabelName("Sauce Labs Bolt T-Shirt");
    }

    public void addorRemoveItembyLabelName(String labelName){
        List<WebElement> labels = driver.findElements(By.cssSelector(".inventory_details_name"));
        List<WebElement> buttons = driver.findElements(By.cssSelector(".btn_inventory"));
        for(int i=0;i<labels.size();i++){
            if(labels.get(i).getText().equalsIgnoreCase(labelName)){
                buttons.get(i).click();
            }
            return;
        }
    }

    public void removeBackpack(){
        addorRemoveItembyLabelName("Sauce Labs Backpack");
    }

    public void clickOnCart(){
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement shoppingCartLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_link")));
        shoppingCartLink.click();
    }

    public void clickCheckoutButton(){
        checkoutButton.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void clickProductSortButton(){
        productSortButton.click();
    }

    public void clickNameZToAButton() {
        Select select = new Select(productSortButton);
        // Select the first option by index (index 0)
        select.selectByIndex(1);


    }

    public void clickLowToHighButton() {

        Select select = new Select(productSortButton);
        // Select the first option by index (index 0)
        select.selectByIndex(1);
    }

    public String getTotal(){
        return totalLabel.getText();
    }


    public ArrayList<String> getProductListSorted(){
        ArrayList<String> productList = new ArrayList();
        productList.add(tShirtRed.getText());
        productList.add(sauceLabsOnesie.getText());
        productList.add(sauceLabsFleeceJacket.getText());
        productList.add(sauceLabsBoltTShirt.getText());
        productList.add(sauceLabsBikeLight.getText());
        productList.add(sauceLabsBackpack.getText());

        Collections.sort(productList);
        return productList;
    }

    public ArrayList<String> getPriceListSorted(){
        ArrayList<String> sortList = new ArrayList<>();
        for(WebElement element: priceList){
            sortList.add(element.getText());
        }
        Collections.sort(sortList);
        return sortList;
    }



    public String getShoppingCartBadgeNumber() {
        WebDriverWait wait = new WebDriverWait(driver, 10); // Maximum wait time of 10 seconds
        WebElement shoppingCartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        return shoppingCartBadge.getText();
    }

    public String getTax() {
        return taxLabel.getText();
    }

    public String getItemTotal() {
        return itemTotalLabel.getText();
    }
}
