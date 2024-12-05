package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class g1 {

    private WebDriver driver;

    public static void main(String[] args) {
        g1 siteG1 = new g1();
        siteG1.setupG1();
        siteG1.acessarGoogle();
        siteG1.procurarSite();
        siteG1.clicarSite();
        siteG1.aceitarCookies();
        siteG1.clicarMenu();
        siteG1.clicarLogar();
        siteG1.digitarEmail();
        // siteG1.stopDriver();
    }

    public void setupG1() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void acessarGoogle() {
        driver.get("https://www.google.com");
    }

    public void procurarSite() {
        try {
            WebElement pesquisa = driver.findElement(By.name("q"));
            pesquisa.sendKeys("G1");
            pesquisa.sendKeys(Keys.RETURN);
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao procurar o site: elemento não encontrado.");
        }
    }

    public void clicarSite() {
        WebElement btAcessar = driver.findElement(By.xpath("(//h3[normalize-space()='g1 - O portal de notícias da Globo'])[1]"));
        btAcessar.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    public void aceitarCookies() {
        WebElement btAceitar = driver.findElement(By.className("cookie-banner-lgpd_accept-button"));
        btAceitar.click();
    }

    public void clicarMenu() {
        WebElement btMenu = driver.findElement(By.xpath("(//span[@class='menu-label'][normalize-space()='MENU'])[1]"));
        btMenu.click();
    }

    public void clicarLogar() {
        WebElement btLogar = driver.findElement(By.xpath("(//span[@class='menu-product-color'])[1]"));
        btLogar.click();
    }


    public void digitarEmail() {
        try {
            WebElement login = driver.findElement(By.xpath("(//input[@id=':r0:'])[1]"));
            String email = "912830929813@gmail.com";
            login.sendKeys(email);

            WebElement btLogin = driver.findElement(By.xpath("(//button[normalize-space()='Continuar'])[1]"));
            btLogin.click();
        } catch (NoSuchElementException e) {
            System.out.println("Erro ao realizar login: elemento não encontrado.");
        }
    }
}
