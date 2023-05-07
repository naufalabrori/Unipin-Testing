package StepDef;

import config.env_target;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchingStep extends env_target{

    @Given(": User in home page")
    public void userInHomePage() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-navbar\"]/nav"))
        );
    }

    @When(": User fill product name in search field")
    public void userFillProductNameInSearchField() {
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).sendKeys("Mobile Legends");

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wzrk_wrapper\"]/div[2]"))
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"redeem-info-modal\"]"))
        );

        driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"redeem-info-modal\"]/div/div/button")).click();
    }

    @And(": User click search button")
    public void userClickSearchButton() {
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).submit();
    }

    @Then(": User get product search result")
    public void userGetProductSearchResult() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajaxArea\"]/main/div/div/div/div[3]/div[2]/div[2]"))
        );
    }

    @When(": User fill invalid product name in search field")
    public void userFillInvalidProductNameInSearchField() {
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"search_input\"]")).sendKeys("Basreng");

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wzrk_wrapper\"]/div[2]"))
        );
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"redeem-info-modal\"]"))
        );

        driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"redeem-info-modal\"]/div/div/button")).click();
    }

    @Then(": User get missing product result")
    public void userGetMissingProductResult() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajaxArea\"]/main/div/div/div/div[3]"))
        );
    }
}
