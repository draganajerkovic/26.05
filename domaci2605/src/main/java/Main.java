/*
Otići na kupujemprodajem.com,
u pretragu ukucati iphone 13, kliknuti na prvi rezultat. Proveriti
 da je naslov oglasa onaj koji smo uočili i tokom manuelnog izvođenja kejsa.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Korisnik\\Desktop\\IT bootcamp\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/");
        driver.manage().window().maximize();

        WebElement klikniSaStrane=driver.findElement(By.xpath("//*[@id=\"bodyTag\"]/div[9]/div/div[2]"));
        klikniSaStrane.click();
        WebElement searchPolje=driver.findElement(By.xpath("//*[@id=\"searchKeywordsInput\"]"));
        searchPolje.sendKeys("iphone 13");
        searchPolje.sendKeys(Keys.ENTER);
        WebElement prazno=driver.findElement(By.xpath("//*[@id=\"bodyTag\"]"));
        for(int i=0; i<8; i++){
            prazno.sendKeys(Keys.ARROW_DOWN);
        }

        WebElement prviOglas=driver.findElement(By.xpath("//*[@id=\"adDescription7321776\"]/div/section[2]/div[1]/div[1]/a"));
        prviOglas.click();
        WebElement tekstOglasa=driver.findElement(By.xpath("//*[@id=\'oglas-holder\']/section/div[1]/h1"));
       String tekst=tekstOglasa.getText();
       String expected="iPhone 13, iPhone 12, iPhone 11 - NOVO!";
       if(tekst.equals(expected)){
           System.out.println("validno!");
       }

       driver.close();
    }
}
