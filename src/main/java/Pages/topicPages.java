package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class topicPages {

    WebDriver driver;

    WebDriverWait wait;


    public topicPages(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 100);

    }

    public void login_page(String uName, String pass){
        // username and password
        By inputUsername = By.xpath("//input[@placeholder='your@email.com']");
        wait.until(ExpectedConditions.elementToBeClickable(inputUsername)).sendKeys(uName);
        By inputPassword = By.xpath("//input[@type='password']");
        wait.until(ExpectedConditions.elementToBeClickable(inputPassword)).sendKeys(pass);
        // login button
        By clickLogin = By.xpath("//span[normalize-space()='Login']");
        wait.until(ExpectedConditions.elementToBeClickable(clickLogin)).click();
    }

    public void add_topic(String topicName){
        By clickMenuTopic = By.xpath("//span[normalize-space()='Multichat']");
        wait.until(ExpectedConditions.elementToBeClickable(clickMenuTopic)).click();
        By clickTopic = By.xpath("//span[normalize-space()='Topic']");
        wait.until(ExpectedConditions.elementToBeClickable(clickTopic)).click();
        By clickAdd = By.xpath("//button[@class='mat-focus-indicator font-bold mat-flat-button mat-button-base mat-primary']");
        wait.until(ExpectedConditions.elementToBeClickable(clickAdd)).click();

        By inputTopicName = By.xpath("//input[@type='text']");
        wait.until(ExpectedConditions.elementToBeClickable(inputTopicName)).sendKeys(topicName);
        By clickDropDown = By.xpath("//body/app-root/app-layout/mat-sidenav-container/mat-sidenav-content/main/app-add-topic/div/mat-card/mat-card-content/div/form[@autocomplete='off']/div/mat-form-field[@appearance='outline']/div/div/div/mat-select[@role='combobox']/div/div[1]");
        wait.until(ExpectedConditions.elementToBeClickable(clickDropDown)).click();
        By inputDropDown = By.xpath("//span[normalize-space()='True']");
        wait.until(ExpectedConditions.elementToBeClickable(inputDropDown)).click();


        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Page = driver.findElement(By.xpath("//span[normalize-space()='Add']"));
        js.executeScript("arguments[0].scrollIntoView();", Page);

        By clickAddButton = By.xpath("//span[normalize-space()='Add']");
        wait.until(ExpectedConditions.elementToBeClickable(clickAddButton)).click();
    }

    public void search_topic(String topicName){

        By searchTopic = By.xpath("//input[@autocomplete='off'][1]");
        wait.until(ExpectedConditions.elementToBeClickable(searchTopic)).sendKeys(topicName);

    }

    public void delete_topic(){




        By clickDelete = By.xpath("//tbody/tr[1]/td[5]/div[2]");
        wait.until(ExpectedConditions.elementToBeClickable(clickDelete)).click();

        By clickDelete2 = By.xpath("//span[normalize-space()='Delete']");
        wait.until(ExpectedConditions.elementToBeClickable(clickDelete2)).click();
    }


}
