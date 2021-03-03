package framework.webpages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{

    private By pageHeader = By.xpath("//h1[contains(text(),'Checkout')]");
    private By placeYourOrderButton = By.xpath("//button[contains(text(), 'Place Your Order')]");
    private By paymentTypeError = By.xpath("//span[@id='Payment_Type-error']");

    public boolean isPlaceOrderButtonEnabled(){
        return isButtonEnabled(placeYourOrderButton);
    }

    public String getCheckoutPageHeader(){
        return getTextFromElement(pageHeader);
    }

    public String getCheckoutPageUrl(){
        return getPageUrl();
    }

    public void clickOnPlaceYourOrderButton(){
        clickOnWebElement(placeYourOrderButton);
    }

    public boolean isPaymentTypeErrorDisplayed(){
        return isWebElementDisplayed(paymentTypeError);
    }
}
