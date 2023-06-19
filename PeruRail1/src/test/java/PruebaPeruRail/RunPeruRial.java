package PruebaPeruRail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class RunPeruRial {

    private WebDriver driver;
    By rdbIda =By.xpath("//*[@class=\"input-radio\"][2]/label/span");
    By slcOri =By.name("Filtros.Ida_Origen");
    By slcDest =By.name("Filtros.Ida_Destino");
    By slcCantP =By.id("countParentsChildren");
    By slcCantParents =By.id("btnAddAdult");
    By slcCantChildren =By.id("btnAddChild");
    By btnCerrParChil =By.className("cerrar-passanger");
    By btnFechViaje =By.id("Filtros_Ida_Fecha");

    By btnBuscar =By.id("btn_search");


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.perurail.com/es/");

    }
    @Test

    public void FlujoCompleto() throws InterruptedException {

        Compra();
    }
    protected static void scrollByVisibleElement(WebDriver driver, By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        } catch (RuntimeException t) {
            Logger.getLogger("[LOG]-Scroll: " + t);
            throw t;
        }
    }
    public void Compra() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(rdbIda).click();
        Thread.sleep(1000);
        Select origen = new Select(driver.findElement(slcOri));
        origen.selectByVisibleText("MachuPicchu");
        Thread.sleep(1000);
        Select destino = new Select(driver.findElement(slcDest));
        destino.selectByValue("6022");
        Thread.sleep(1000);
        driver.findElement(slcCantP).click();
        driver.findElement(slcCantParents).click();
        driver.findElement(slcCantChildren).click();
        driver.findElement(slcCantChildren).click();
        driver.findElement(btnCerrParChil).click();
        driver.findElement(btnFechViaje).click();
        driver.findElement(btnFechViaje).sendKeys("30052023");
        driver.findElement(btnBuscar).click();
        Thread.sleep(15000);
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
