package framework.webpages;

import org.openqa.selenium.By;

public class StoreLocatorPage extends BasePage{

    private By postalCode = By.xpath("//input[@id='Postal_Code_Sep']");
    private By searchButton = By.xpath("//button[@type='submit']");

    public void enterPostalCode(String code){
        setValue(postalCode, code);
    }

    public void iClickOnSearchButton(){
        clickOnWebElement(searchButton);
    }

}
