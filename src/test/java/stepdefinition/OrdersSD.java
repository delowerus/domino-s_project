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
    WebDriver driver;

    HomePage homePage = new HomePage();
    SearchPage searchPage = new SearchPage();
    LocationResultPage locationResultPage = new LocationResultPage();
    AllEntryPage allEntryPage = new AllEntryPage();
    SpecialityPizzaPage specialityPizzaPage = new SpecialityPizzaPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    ContinueCheckOutPage continueCheckOutPage = new ContinueCheckOutPage();

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
        try{
            //Wait 10 seconds till alert is present

            WebDriverWait wait = new WebDriverWait(driver, 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }
        homePage.checkCarryout();
    }

    @Then("^I enter zip code$")
    public void iEnterZipCode(){
        searchPage.enterPostalCode("11428");
    }

    @And("^I enter search location$")
    public void iEnterSearch(){
        searchPage.iClickOnSearchButton();
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
        checkOutPage.closePopUp();
    }

    @And("^I click continue checkout$")
    public void iCkickOnContinueCheckOut(){
        continueCheckOutPage.clickOnContinueCheckButton();

    }
}

