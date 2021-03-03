package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webpages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrdersSD {
    HomePage homePage = new HomePage();
    StoreLocatorPage storeLocatorPage = new StoreLocatorPage();
    LocationResultsPage locationResultPage = new LocationResultsPage();
    MenuPage allEntryPage = new MenuPage();
    SpecialityPizzaPage specialityPizzaPage = new SpecialityPizzaPage();
    PopUp menuPage = new PopUp();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Given("^I am on dominos homepage$")
    public void iAmOnHomePage() throws InterruptedException {
        Thread.sleep(2000);
        homePage.closePopUp();
        String expectedUrl = "https://www.dominos.com/en/";
        String actualUrl = homePage.getPageUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("^I select carryout$")
    public void iSelectCarryout(){
        homePage.checkCarryout();
    }

    @Then("^I enter zip code$")
    public void iEnterZipCode(){
        storeLocatorPage.enterPostalCode("11428");
    }

    @And("^I enter search location$")
    public void iEnterSearch(){
        storeLocatorPage.iClickOnSearchButton();
    }

    @Then("^I select the first store$")
    public void iSelectStore() throws InterruptedException {
        Thread.sleep(3000);
        locationResultPage.selectFirstStore();
    }

    @Then("^I select speciality pizza$")
    public void iSelectSpecialtyPizza(){
        allEntryPage.clickOnSpecialtyPizza();
    }

    @And("^I add all the speciality pizza to the cart$")
    public void iSelectAllSpecialityPizza() throws InterruptedException {
        Thread.sleep(3000);
        specialityPizzaPage.addToOrders();
    }

    @Then("^I validate cart displayed the right amount of pizza$")
    public void iValidateRightAmountOfOrder() throws InterruptedException {
        int expectedOrders = specialityPizzaPage.getNumberOfOrders();
        Thread.sleep(3000);
        int actualOrdersFromCart = specialityPizzaPage.getNumberOfOrdersFromOrderCart();
        System.out.println(actualOrdersFromCart);
        System.out.println(expectedOrders);
        Assert.assertEquals(expectedOrders,actualOrdersFromCart);
    }

    @Then("^I select checkout$")
    public void iSelectCheckOut(){
        specialityPizzaPage.iSelectCheckOutButton();
    }

    @Then("^I close any upSell popup$")
    public void iClosePopUp() throws InterruptedException {
        Thread.sleep(3000);
        menuPage.closePopUp();
    }

    @And("^I click continue checkout$")
    public void iCkickOnContinueCheckOut(){
        cartPage.clickOnContinueCheckButton();
    }

    @Then("^I verify checkout page has displayed$")
    public void iVerifyCheckoutPageDisplayed(){
        String expectedPageTitle = "CHECKOUT";
        String actualPageTitle = checkoutPage.getCheckoutPageHeader();
        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @Then("^Verify place your order button is functional$")
    public void iVerifyPlaceOrderButtonIsFunctional(){
        //String previousUrl = checkoutPage.getCheckoutPageUrl();
        checkoutPage.clickOnPlaceYourOrderButton();
        Assert.assertTrue(checkoutPage.isPaymentTypeErrorDisplayed());
    }
}

