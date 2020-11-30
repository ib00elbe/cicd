package com.cicd.calculator.domain;

import com.cicd.calculator.CalculatorApplication;
import com.cicd.calculator.CalculatorController;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.event.annotation.AfterTestExecution;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class WebIntegrationTest {

    @LocalServerPort
    private int port;

    private WebDriver webDriver;
    private String baseUrl;
    WebDriverWait wait;

    By usernameLocator  = By.id("username");
    By passwordLocator  = By.id("password");
    By submitButton     = By.cssSelector("button");
    By successMessageLocator = By.cssSelector(".flash.success");

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        baseUrl = "http://localhost:" + this.port;
        webDriver.navigate().to(baseUrl);
        wait = new WebDriverWait(webDriver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/p/a")));
    }

    @Test
    public void verifyTitle() {
        assertEquals("CI/CD Miniräknare", webDriver.findElement(By.xpath("/html/body/div[1]/h1")).getText());
    }

    @Test
    public void verifyMenu() {
        webDriver.findElement(By.className("menu"));
    }

    @Test
    public void verifyContentField() {
        webDriver.findElement(By.cssSelector(".calc-content"));
    }

    @Test
    public void verifySubmitButton(){
        webDriver.findElement(By.cssSelector("input[type='submit']"));
    }


    @Test
    public void testTitle(){
        assertEquals("Calculator - ADD", webDriver.getTitle());
    }

    @Test
    public void testAddPass() {
        //Click add menu
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a")).click();
        //Execute addiction
        webDriver.findElement(By.id("firstValue")).clear();
        webDriver.findElement(By.id("firstValue")).sendKeys("10");
        webDriver.findElement(By.id("secondValue")).clear();
        webDriver.findElement(By.id("secondValue")).sendKeys("5");
        webDriver.findElement(By.className("submit-btn")).click();

        assertEquals("Result", webDriver.findElement(By.xpath("/html/body/div[2]/h1")).getText());
    }

    @Test
    public void testAddFail() {
        //Click add menu
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[1]/a")).click();
        //Execute addition
        webDriver.findElement(By.id("firstValue")).clear();
        webDriver.findElement(By.id("firstValue")).sendKeys("A");
        webDriver.findElement(By.id("secondValue")).clear();
        webDriver.findElement(By.id("secondValue")).sendKeys("B");
        webDriver.findElement(By.className("submit-btn")).click();

        assertEquals("Fyll i ett heltal.", webDriver.findElement(By.cssSelector(".error")).getText());
    }

    @Test
    public void testMultiplicationPass(){
        //Click Multiplikation menu
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a")).click();
        //Execute multiplicerin
        webDriver.findElement(By.id("firstValue")).clear();
        webDriver.findElement(By.id("firstValue")).sendKeys("10");
        webDriver.findElement(By.id("secondValue")).clear();
        webDriver.findElement(By.id("secondValue")).sendKeys("12");
        webDriver.findElement(By.className("submit-btn")).click();

        assertEquals("Result", webDriver.findElement(By.xpath("/html/body/div[2]/h1")).getText());
    }

    @Test
    public void testMultiplicationFail() {
        //Click Multiplikation menu
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[3]/a")).click();
        //Execute multiplicerin
        webDriver.findElement(By.cssSelector("input[name='firstValue']")).clear();
        webDriver.findElement(By.id("firstValue")).sendKeys("A");
        webDriver.findElement(By.cssSelector("input[name='secondValue']")).clear();
        webDriver.findElement(By.id("secondValue")).sendKeys("B");
        webDriver.findElement(By.className("submit-btn")).click();

        assertEquals("Fyll i ett heltal.", webDriver.findElement(By.cssSelector(".error")).getText());
    }

    @Test
    public void testCitat() {
        //Click citat menu
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/ul/li[5]/a")).click();
        //Find header 'Citat'
        assertEquals("Citat", webDriver.findElement(By.xpath("/html/body/div[2]/h1")).getText());
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}