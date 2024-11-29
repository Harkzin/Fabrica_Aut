package webdriver.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OpenRjuxSteps {

    private WebDriver driver;

    @Before
    @Dado("que o usuário abra o navegador")
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @E("que o usuário acessa o sistema Rjux")
    public void acessoRjux() {
        driver.get("https://rjux0172.claro.com.br/v2/login");
    }

    @Quando("o usuário avança pelas opções avançadas")
    public void acessoAvancado() {
        try {
            WebElement btAvancado = driver.findElement(By.id("details-button"));
            btAvancado.click();
            WebElement linkAvancado = driver.findElement(By.id("proceed-link"));
            linkAvancado.click();
        } catch (NoSuchElementException e) {
            System.out.println("Opções avançadas não necessárias.");
        }
    }

    @Quando("o usuário insere o login {string} e a senha {string}")
    public void login(String username, String password) {
        try {
            WebElement login = driver.findElement(By.name("login"));
            login.sendKeys(username);

            WebElement senha = driver.findElement(By.name("senha"));
            senha.sendKeys(password);

            WebElement btLogin = driver.findElement(By.name("btnLogin"));
            btLogin.click();
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao realizar login: elemento não encontrado.");
        }
    }



    /*@After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }*/
}
