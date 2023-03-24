package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MobileCheckoutProcess extends Main {
    @Test(priority = 1)
    @Parameters({"url"})
    public void getUrl(String url) {
        driver.get(url);
    }

    @Test(priority = 2)
    @Parameters({"url"})
    public void verifyUrl(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    @Test(priority = 3)
    public void selectProductCategory(){
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        categoryDropDown.click();
        WebElement cellPhonesAndAccessories = driver.findElement(By.xpath("//option[@value='15032']"));
        cellPhonesAndAccessories.click();
    }

    @Test(priority = 4)
    public void searchTypeMobilePhone(){
        WebElement typeOnSearchBar = driver.findElement(By.id("gh-ac"));
        typeOnSearchBar.sendKeys("Mobile phone");
    }

    @Test(priority = 5)
    public void clickSearchButton(){
        try{
            WebElement searchButton = driver.findElement(By.id("gh-btn"));
            searchButton.click();
        }
        catch (Exception e) {
            System.out.println("Search Button Not Clicked");
        }
    }

    @Test(priority = 6)
    public void selectMobileBrand(){
        try {
            WebElement appleCheckbox = driver.findElement(By.xpath("//*[@id=\"x-refine__group_1__0\"]/ul/li[1]/div/a/div/div/div/span[1]"));
            appleCheckbox.click();
        } catch (Exception e) {
            System.out.println("Apple checkbox not found");
        }
    }

    @Test(priority = 7)
    public void SelectFirstSearchItem()throws InterruptedException{
        WebElement firstItem = driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a"));
        firstItem.click();
        Thread.sleep(5000);
        for (String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}
