import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMEN\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/login");


        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");


        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("SuperSecretPassword!");


        WebElement loginButton = driver.findElement(By.cssSelector(".fa-sign-in"));
        loginButton.click();


        WebElement successMessage = driver.findElement(By.id("flash"));
        String messageText = successMessage.getText();
        if (messageText.contains("You logged into a secure area")) {
            System.out.println("Правильный логин!");
        } else {
            System.out.println("Неправильный логин.");
        }


        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://the-internet.herokuapp.com/secure")) {
            System.out.println("Успешная авторизация!");
        } else {
            System.out.println("Авторизация не выполнена.");
        }


        driver.quit();
    }
}