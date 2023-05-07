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

public class LoginStep extends env_target {

    @Given("User in home page")
    public void userInHomePage() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(baseUrl);
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajaxArea\"]/main"))
        );

    }

    @When("User click login page")
    public void userClickLoginPage() {
        driver.findElement(By.xpath("//*[@id=\"navbar-signin-button\"]")).click();
    }

    @When("User fill email and password")
    public void userFillEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"loginEmailSide\"]")).sendKeys("rupsku@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).sendKeys("Illarra24");

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wzrk_wrapper\"]/div[2]"))
        );
    }

    @And("User click button login")
    public void userClickButtonLogin() {
        driver.findElement(By.xpath("//*[@id=\"wzrk-cancel\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"signin-email-submit-button\"]")).click();
    }

    @Then("User verify login result")
    public void userVerifyLoginResult() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-navbar\"]/nav/div[3]/div[1]/div/div/form/div[1]"))
        );
    }

    @When("User fill invalid email and password")
    public void userFillInvalidEmailAndPassword() {
        driver.findElement(By.xpath("//*[@id=\"loginEmailSide\"]")).sendKeys("rupsku@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"loginPassword\"]")).sendKeys("invalidPassword");

        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"wzrk_wrapper\"]/div[2]"))
        );
    }

    @Then("User get invalid login result")
    public void userGetInvalidLoginResult() {
        Duration duration = Duration.ofSeconds(5);
        WebDriverWait wait = new WebDriverWait(driver,duration);
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"signin-form-loginpage\"]/div/div[1]/div"))
        );
    }
}
