package stepdefinition;

import com.mycompany.Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;



import static org.junit.Assert.fail;

public class LoginStepDefs extends AbstractsStepDefs {
    @And("the Username is filled with {string}")
    public void usernameIsFilledWithStandard_user(String username){
        homePage.fillField(HomePage.USERNAME, username);
    }

    @And("the Password is filled with {string}")
    public void passwordIsFilledWithSecret_sauce(String password){
        homePage.fillField(HomePage.PASSWORD, password);
    }

    @And("the login button is clicked")
    public void loginButtonClicked(){
        homePage.clickLoginButton();
    }


}
