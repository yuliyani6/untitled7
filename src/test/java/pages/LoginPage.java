package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    public void inputPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isOnProductsPage() {
        return driver.getCurrentUrl().contains("inventory");
    }
}