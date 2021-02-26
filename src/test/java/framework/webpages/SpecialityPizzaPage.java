package framework.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SpecialityPizzaPage extends BasePage {
    private int countOrder = 0;

    private By addToOrdersButtons = By.xpath("//section[@class='card']//a[contains(text(),'Add to Order')]");
    private By orderCart = By.xpath("//div[@class='nav__group nav__group--cart']//a");
    private By checkOut = By.xpath("//a[@data-quid='order-checkout-button']");

    public void addToOrders() {
        List<WebElement> orderButtons = getWebElements(addToOrdersButtons);
        for (WebElement element : orderButtons) {
            element.click();
            countOrder++;
        }
    }

    public int getNumberOfOrders(){
        return countOrder;
    }

    public int getNumberOfOrdersFromOrderCart(){
        String order = getWebElement(orderCart).getAttribute("data-order-qty");
        return Integer.valueOf(order);
    }

    public void iSelectCheckOutButton(){
        clickOnWebElement(checkOut);
    }
}
