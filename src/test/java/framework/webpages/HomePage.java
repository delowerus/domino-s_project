package framework.webpages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By carryoutButton = By.xpath("(//div[@class='smart-order']//a[contains(text(),'Carryout')])[1]");
    private By closeMessageButton = By.xpath("(//div[@class='toast__inner']//button[contains(@class,'toast__close')])[1]");

    public void checkCarryout(){
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

