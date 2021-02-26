package framework.webpages;

import org.openqa.selenium.By;

public class ContinueCheckOutPage extends BasePage{

    private By continueCheckButton = By.xpath("//a[contains(text(),'Continue Checkout')]");

    public void clickOnContinueCheckButton(){
        clickOnWebElement(continueCheckButton);
    }
}
