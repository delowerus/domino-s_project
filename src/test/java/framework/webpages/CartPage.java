package framework.webpages;

import org.openqa.selenium.By;

public class CartPage extends BasePage{

    private By continueCheckoutButton = By.xpath("//a[contains(text(),'Continue Checkout')]");

    public void clickOnContinueCheckButton(){
        clickOnWebElement(continueCheckoutButton);
    }
}
