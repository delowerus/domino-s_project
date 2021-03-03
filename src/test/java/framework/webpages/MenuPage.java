package framework.webpages;

import org.openqa.selenium.By;

public class MenuPage extends BasePage{

    private By specialtyPizza = By.xpath("//h2[contains(text(),'Specialty Pizzas')]");

    public void clickOnSpecialtyPizza(){
        clickOnWebElement(specialtyPizza);
    }
}
