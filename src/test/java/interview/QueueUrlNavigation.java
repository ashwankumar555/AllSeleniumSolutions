package interview;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.Stack;

	public class QueueUrlNavigation {
	    public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        Queue<String> urlQueue = new LinkedList<>();

	        // Enqueue URLs
	        urlQueue.add("https://gmail.com");
	        urlQueue.add("https://www.google.com");
	        urlQueue.add("https://www.wikipedia.org");

	        while (!urlQueue.isEmpty()) {
	            String url = urlQueue.poll(); // FIFO
	            driver.get(url);
	            System.out.println("Opened: " + url + " | Title: " + driver.getTitle());
	        }

	        Stack<String> urlStack = new Stack<>();
	        urlStack.push("https://gmail.com");
	        urlStack.push("https://www.google.com");
	        urlStack.push("https://www.wikipedia.org");

	        while (!urlStack.isEmpty()) {
	            String url2 = urlStack.pop(); // LIFO
	            driver.get(url2);
	            System.out.println("Opened: " + url2 + " | Title: " + driver.getTitle());
	        }
	    }
	}

