package seleniuminterview;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImagesCheck {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/broken_images");

        // Get all <img> tags
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images found: " + images.size());

        // Loop through each image
        for (WebElement img : images) {
            String imageUrl = img.getAttribute("src");

            if (imageUrl == null || imageUrl.isEmpty()) {
                System.out.println("Image with missing src attribute.");
                continue;
            }

            try {
                // Create connection
                HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();

                if (responseCode >= 400) {
                    System.out.println("❌ Broken Image: " + imageUrl + " | Response Code: " + responseCode);
                } else {
                    System.out.println("✅ Valid Image: " + imageUrl);
                }

                connection.disconnect();
            } catch (Exception e) {
                System.out.println("⚠️ Exception for URL: " + imageUrl + " | " + e.getMessage());
            }
        }

        driver.quit();
    }
}

