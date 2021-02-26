package framework.webpages;

import org.openqa.selenium.By;

public class CheckOutPage extends BasePage{
    private By popUpCardHeader = By.xpath("//header[@class='card__header ']");
    private By popUpCloseButton = By.xpath("//button[@aria-label='close']");

    public void closePopUp(){
        if(isWebElementDisplayed(popUpCardHeader)){
            clickOnWebElement(popUpCloseButton);
        }else {
            System.out.println("popUp is not displayed");
        }
    }
}
