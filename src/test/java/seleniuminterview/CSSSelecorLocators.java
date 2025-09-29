package seleniuminterview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelecorLocators {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C://Users//user//OneDrive//Desktop//Sample.html");

        // Equivalent to: //input[@id='username' and @name='user' and @type='text']
        driver.findElement(By.cssSelector("input#username[name='user'][type='text']")).sendKeys("Ashwin");

        // Equivalent to: //input[@id='username' or @name='user' or @type='text']
        // ❌ CSS does not support OR directly → Need multiple finds. Example below:
        driver.findElement(By.cssSelector("input#username, input[name='user'], input[type='text']")).sendKeys("Ganji");

        // Equivalent to: //a[contains(text(),'Sign Up')]
        // ❌ CSS can’t locate by text() → Use XPath here
        driver.findElement(By.xpath("//a[contains(text(),'Sign Up')]")).click();
        driver.navigate().back();
        Thread.sleep(1000);

        // Equivalent to: //a[normalize-space(text()='Sign Up')]
        // ❌ Again CSS doesn’t support normalize-space/text
        driver.findElement(By.xpath("//a[normalize-space(text())='Sign Up']")).click();
        driver.navigate().back();

        // Equivalent to: //input[contains(@placeholder,'password')]
        driver.findElement(By.cssSelector("input[placeholder*='password']")).sendKeys("Kumar");

        // Equivalent to: //input[starts-with(@id,'use')]
        driver.findElement(By.cssSelector("input[id^='use']")).sendKeys("Akhira");

        // Equivalent to: //input[starts-with(@id,'pas')]
        driver.findElement(By.cssSelector("input[id^='pas']")).sendKeys("1234567");

        // Equivalent to: //input[ends-with(@placeholder,'name')]
        driver.findElement(By.cssSelector("input[placeholder$='name']")).sendKeys("Amyra");

        // Equivalent to: //input[ends-with(@placeholder,'word')]
        driver.findElement(By.cssSelector("input[placeholder$='word']")).sendKeys("1234567");

        // Equivalent to: //input[@id='username']/parent::div
        driver.findElement(By.cssSelector("input#username")).findElement(By.xpath("..")).getText();
        // (.. is required since CSS has no parent axis)

        // Equivalent to: //th[contains(text(),'Name')]/parent::tr
        List<WebElement> list = driver.findElements(By.xpath("//th[contains(text(),'Name')]/parent::tr"));
        for (WebElement ele : list) {
            System.out.println(ele.getText());
        }

        // Equivalent to: //ul[contains(@id,'menu')]/child::li
        List<WebElement> list2 = driver.findElements(By.cssSelector("ul[id*='menu'] > li"));
        for (WebElement ele : list2) {
            System.out.println(ele.getText());
        }

        // Equivalent to: //li[text()='Products']/following-sibling::li
        System.out.println(driver.findElement(By.xpath("//li[text()='Products']/following-sibling::li")).getText());

        // Equivalent to: //li[text()='Products']/preceding-sibling::li
        System.out.println(driver.findElement(By.xpath("//li[text()='Products']/preceding-sibling::li")).getText());

        // Equivalent to: //div[@id='container']//h1[@class='title']
        System.out.println(driver.findElement(By.cssSelector("div#container h1.title")).getText());

        // Equivalent to: //table[@id='employee']//tr[td[text()='Alice']]/td[2]
        System.out.println(driver.findElement(By.xpath("//table[@id='employee']//tr[td[text()='Alice']]/td[2]")).getText());

        // Equivalent to: //td[text()='John']/ancestor::table
        System.out.println(driver.findElement(By.xpath("//td[text()='John']/ancestor::table")).getAttribute("id"));

        // Equivalent to: //div[@id='container']/descendant::a
        System.out.println(driver.findElement(By.cssSelector("div#container a")).getAttribute("class"));

        // Equivalent to: //li[1]
        System.out.println(driver.findElement(By.cssSelector("ul#menu li:first-child")).getText());

        // Equivalent to: //li[last()]
        System.out.println(driver.findElement(By.cssSelector("ul#menu li:last-child")).getText());

        // Equivalent to: //li[3]
        System.out.println(driver.findElement(By.cssSelector("ul#menu li:nth-child(3)")).getText());
    }
}
