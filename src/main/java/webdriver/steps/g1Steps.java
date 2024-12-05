package webdriver.steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class g1Steps {
    
    private WebDriver driver;

    @Before
    @Dado("que o usuário abra o navegador para acessar o G1")
    public void setupG1() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @E("que acesse o google")
    public void acessarGoogle() {
        driver.get("https://www.google.com");
    }

    @E("que procure o site G1")
    public void procurarSite() {
        try {
            WebElement pesquisa = driver.findElement(By.name("q"));
            pesquisa.sendKeys("G1");
            pesquisa.sendKeys(Keys.RETURN);
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao procurar o site: elemento não encontrado.");
        }
    }

    @E("Clique no link do site")
    public void clicarSite() {
        WebElement btAcessar = driver.findElement(By.xpath("(//h3[normalize-space()='g1 - O portal de notícias da Globo'])[1]"));
        btAcessar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @E("Aceite os Cookies")
    public void aceitarCookies() {
        WebElement btAceitar = driver.findElement(By.className("cookie-banner-lgpd_accept-button"));
        btAceitar.click();
    }

    @E("Clique no menu")
    public void clicarMenu() {
        WebElement btMenu = driver.findElement(By.xpath("(//span[@class='menu-label'][normalize-space()='MENU'])[1]"));
        btMenu.click();
    }

    @Dado("Que o usuario abriu o menu")
    public void clicarLogar() {
        WebElement btLogar = driver.findElement(By.xpath("(//span[@class='menu-product-color'])[1]"));
        btLogar.click();
    }

    @Quando("o usuário insere o email {string}")
    public void digitarEmail(String email) {
        try {
            WebElement login = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
            login.sendKeys(email);

            WebElement btLogin = driver.findElement(By.xpath("(//button[normalize-space()='Continuar'])[1]"));
            btLogin.click();
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao realizar login: elemento não encontrado.");
        }
    }
}
