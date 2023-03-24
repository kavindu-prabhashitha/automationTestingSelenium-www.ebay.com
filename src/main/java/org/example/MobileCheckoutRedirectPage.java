package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileCheckoutRedirectPage extends Main{
    private String  itemName;
    private String itemPrice;
    private String quantity;

    @Test(priority = 8)
    public void selectModel() {
        try {
            WebElement ModelDropDown = driver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectboxlabel = new Select(ModelDropDown);
            selectboxlabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Model dropdown not found");
        }
    }

    @Test(priority = 9)
    public void selectCarrier() {
        try {
            WebElement CarrierDropDown = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectboxlabel = new Select(CarrierDropDown);
            selectboxlabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Carrier dropdown not found");
        }
    }

    @Test(priority = 10)
    public void selectStorage() {
        try {
            WebElement ModelDropDown = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity']"));
            Select selectboxlabel = new Select(ModelDropDown);
            selectboxlabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Storage Capacity dropdown not found");
        }
    }

    @Test(priority = 11)
    public void selectColor() {
        try {
            WebElement ColorDropDown = driver.findElement(By.cssSelector("select[selectboxlabel='Color']"));
            Select selectboxlabel = new Select(ColorDropDown);
            selectboxlabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Color dropdown not found");
        }
    }

    @Test(priority = 12)
    public void selectCosmetics() {
        try {
            WebElement CosmeticDropDown = driver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectboxlabel = new Select(CosmeticDropDown);
            selectboxlabel.selectByIndex(1);
        } catch (Exception e) {
            System.out.println("Cosmetic dropdown not found");
        }
    }

    @Test(priority = 13)
    public void getItemName() {
        WebElement getItemName = driver.findElement(By.xpath("//*[@id=\"LeftSummaryPanel\"]/div[1]/div[1]/div/h1"));
        itemName = getItemName.getText();
        System.out.println("Item Name is " +itemName);
    }

    @Test(priority = 14)
    public void getItemPrice() {
        WebElement getItemPrice = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[1]/div/div[2]/div/span[1]/span"));
        itemPrice= getItemPrice.getText();
        System.out.println("Item Price is "+itemPrice );

    }

    @Test(priority = 15)
    public void getItemCondition() {
        WebElement getItemCondition = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[1]/div[1]/div/div[2]/div[1]/div/span/span[1]/span"));
        System.out.println("Item Condition is "+getItemCondition.getText());
    }

    @Test(priority = 16)
    public void getItemQuantity() {
        WebElement getItemQuantity = driver.findElement(By.xpath("//*[@id=\"qtyTextBox\"]"));
        quantity = getItemQuantity.getAttribute("value");
        System.out.println("Item Quantity is "+quantity);
    }

    @Test(priority = 17)
    public void selectAddToCart() {
        WebElement selectCart = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/form/div[2]/div/div[1]/div[2]/ul/li[2]/div/a"));
        selectCart.click();
    }
    @Test(priority = 18)
    public void assertSelectedDetails(){
        String cartItemName = driver.findElement(By.className("item-title")).getText();
        String cartItemPrice = driver.findElement(By.cssSelector("div[class='item-price font-title-3']")).getText();
        Assert.assertEquals(cartItemName,itemName);
        Assert.assertEquals(cartItemPrice, itemPrice);

    }
    @Test(priority = 19)
    public void assertQuantity(){
        String cartItemQty = driver.findElement(By.cssSelector("select[data-test-id='qty-dropdown']")).getText();
        Assert.assertFalse(cartItemQty.isEmpty());
        System.out.println("Cart item quantity: " + cartItemQty);
    }

    @Test(priority = 20)
    public void subtotal(){
        String cartSubtotal = driver.findElement(By.cssSelector("div[data-test-id=\"SUBTOTAL\"]")).getText();
        //String cartSubtotal = driver.findElement(By.cssSelector("div.cart-subtotal__price span")).getText();
        Assert.assertEquals(cartSubtotal, itemPrice);
    }
    @Test(priority = 21)
    public void getShippingValue(){
        String shippingPrice = driver.findElement(By.cssSelector("div[data-test-id=\"SHIPPING\"]")).getText();
        //String shippingPrice = driver.findElement(By.cssSelector("div.cart-shipping__cost span")).getText();
        System.out.println("Shipping price: " + shippingPrice);
    }

    @Test(priority = 22)
    public void closeBrowser(){
        driver.quit();
    }

}
