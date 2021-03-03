package framework.webpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.SharedSD;

public class HomePage extends BasePage {

    private By carryoutButton = By.xpath("(//div[@class='smart-order']//a[contains(text(),'Carryout')])[1]");
    private By closeMessageButton = By.xpath("(//div[@class='toast__inner']//button[contains(@class,'toast__close')])[1]");

    public void checkCarryout(){
        try{
            //Wait 10 seconds till alert is present

            WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), 10);
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            //Accepting alert.
            alert.accept();
            System.out.println("Accepted the alert successfully.");
        }catch(Throwable e){
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }
        clickOnWebElement(carryoutButton);
    }

    public void closePopUp(){
        if (isWebElementDisplayed(closeMessageButton)){
            clickOnElement(closeMessageButton);
        }
        else {
            System.out.println("Pop Up Window is not displayed!!");
        }
    }

    public void clickOnElement(By locator){
        webAction(locator).click();
    }

}

