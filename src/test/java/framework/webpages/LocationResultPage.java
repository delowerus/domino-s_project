package framework.webpages;

import org.openqa.selenium.By;

public class LocationResultPage extends BasePage{

    private By storePickUp  = By.xpath("(//a[contains(text(), 'Store Pickup')])[1]");

    public void selectFirstStore() {
        clickOnWebElement(storePickUp);
    }

}