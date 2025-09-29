package seleniuminterview;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class CriticalSeleniumLocators {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://example.com"); // replace with your AUT

        // ============================
        // 1. Locate SVG element
        // ============================
        WebElement svgPath = driver.findElement(By.xpath("//*[local-name()='svg']//*[local-name()='path']"));
        System.out.println("SVG Path Found: " + svgPath.isDisplayed());

        // ============================
        // 2. Handle Canvas (workaround via JS)
        // ============================
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("var canvas = document.querySelector('canvas');" +
                "var ctx = canvas.getContext('2d');" +
                "ctx.fillStyle = 'red'; ctx.fillRect(10, 10, 50, 50);"); // just draws for validation

        // ============================
        // 3. Shadow DOM element
        // ============================
        WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector")); 
        SearchContext shadowRoot = shadowHost.getShadowRoot(); 
        WebElement insideShadow = shadowRoot.findElement(By.cssSelector("button#submit"));
        insideShadow.click();

        // ============================
        // 4. Switch to iframe
        // ============================
        driver.switchTo().frame("frameNameOrId");
        WebElement frameElement = driver.findElement(By.id("insideFrame"));
        frameElement.click();
        driver.switchTo().defaultContent();

        // ============================
        // 5. Handle Dynamic IDs
        // ============================
        WebElement dynId = driver.findElement(By.xpath("//input[starts-with(@id,'input-')]"));
        dynId.sendKeys("test123");

        // ============================
        // 6. Hidden Element (Force Click using JS)
        // ============================
        WebElement hiddenBtn = driver.findElement(By.id("hiddenBtn"));
        js.executeScript("arguments[0].click();", hiddenBtn);

        // ============================
        // 7. File Upload
        // ============================
        WebElement fileUpload = driver.findElement(By.id("fileUpload"));
        fileUpload.sendKeys("C:\\path\\file.txt");

        // ============================
        // 8. Drag & Drop via JS (for HTML5)
        // ============================
        WebElement source = driver.findElement(By.id("dragSource"));
        WebElement target = driver.findElement(By.id("dropTarget"));
        js.executeScript(
            "function createEvent(typeOfEvent) {" +
            " var event = document.createEvent('CustomEvent');" +
            " event.initCustomEvent(typeOfEvent,true, true, null);" +
            " event.dataTransfer = { data: {}, setData: function(key, value){this.data[key] = value;}, getData: function(key){return this.data[key];} };" +
            " return event; }" +
            "function dispatchEvent(element, event, transferData) {" +
            " if(transferData) {event.dataTransfer = transferData;} " +
            " element.dispatchEvent(event); }" +
            "var dragStartEvent = createEvent('dragstart');" +
            "dispatchEvent(arguments[0], dragStartEvent);" +
            "var dropEvent = createEvent('drop');" +
            "dispatchEvent(arguments[1], dropEvent, dragStartEvent.dataTransfer);" +
            "var dragEndEvent = createEvent('dragend');" +
            "dispatchEvent(arguments[0], dragEndEvent, dropEvent.dataTransfer);",
            source, target);

        // ============================
        // 9. ContentEditable / Rich Text Editor
        // ============================
        WebElement editor = driver.findElement(By.cssSelector("div[contenteditable='true']"));
        editor.clear();
        editor.sendKeys("Typing inside rich text editor...");

        // Cleanup
        Thread.sleep(3000);
        driver.quit();
    }
}
