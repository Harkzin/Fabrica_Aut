package webdriver;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenRjux {
    
    private WebDriver driver;


    public static void main(String[] args) {
        OpenRjux rjux = new OpenRjux();
        rjux.startDriver();
        rjux.login();
        rjux.opcoesAvancadas();
        rjux.executarLogin();
        // rjux.stopDriver();
    }

    
    public void startDriver() {
        //System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver"); // Ajuste o caminho para o seu chromedriver
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

  
    public void login() {
        driver.get("https://rjux0172.claro.com.br/v2/login");
    }

    
    public void opcoesAvancadas() {
        try {
            WebElement btAvancado = driver.findElement(By.id("details-button"));
            btAvancado.click();
            WebElement linkAvancado = driver.findElement(By.id("proceed-link"));
            linkAvancado.click();
        } catch (NoSuchElementException e) {
            System.out.println("Opções avançadas não necessárias.");
        }
    }

    
    public void executarLogin() {
        try {
            WebElement login = driver.findElement(By.name("login"));
            String username = "92026474";
            login.sendKeys(username);

            WebElement senha = driver.findElement(By.name("senha"));
            String password = "pricila";
            senha.sendKeys(password);

            WebElement btLogin = driver.findElement(By.name("btnLogin"));
            btLogin.click();
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao realizar login: elemento não encontrado.");
        }
    }

   
    // public void stopDriver() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}
