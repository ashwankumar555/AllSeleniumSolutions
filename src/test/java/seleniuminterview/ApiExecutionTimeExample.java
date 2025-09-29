package seleniuminterview;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiExecutionTimeExample {
    public static void main(String[] args) {
        // Define API URL
        String url = "https://jsonplaceholder.typicode.com/posts/1";

        // Capture start time
        long startTime = System.currentTimeMillis();

        // Send GET request
        Response response = RestAssured.get(url);

        // Capture end time
        long endTime = System.currentTimeMillis();

        // Calculate total execution time
        long executionTime = endTime - startTime;

        // Print details
        System.out.println("API URL        : " + url);
        System.out.println("Status Code    : " + response.getStatusCode());
        System.out.println("Start Time(ms) : " + startTime);
        System.out.println("End Time(ms)   : " + endTime);
        System.out.println("Execution Time : " + executionTime + " ms");
    }
}

