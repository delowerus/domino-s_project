package framework.webpages;

import org.openqa.selenium.By;

public class AllEntryPage extends BasePage{

    private By specialtyPizza = By.xpath("//h2[contains(text(),'Specialty Pizzas')]");

    public void clickOnSpecialtyPizza(){
        clickOnWebElement(specialtyPizza);
    }
}
