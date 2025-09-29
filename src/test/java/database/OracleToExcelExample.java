package database;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OracleToExcelExample {
    public static void main(String[] args) {
        // JDBC connection info
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // Change XE to your service name/SID
        String username = "INVENTORY1";   // Your DB username
        String password = "INVENTORY1";   // Your DB password

        // SQL query
        String sql = "SELECT * from CUSTOMER";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);
             Workbook workbook = new XSSFWorkbook()) {

            // Create Excel sheet
            Sheet sheet = workbook.createSheet("CUSTOMER");
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("FIRST_NAME");
            headerRow.createCell(1).setCellValue("LAST_NAME");
            headerRow.createCell(2).setCellValue("MIDDLE_NAME");
            //headerRow.createCell(3).setCellValue("Salary");

            int rowNum = 1;

            // Loop through DB rows and write into Excel
            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getString("FIRST_NAME"));
                row.createCell(1).setCellValue(rs.getString("LAST_NAME"));
                row.createCell(2).setCellValue(rs.getString("MIDDLE_NAME"));
                //row.createCell(3).setCellValue(rs.getDouble("salary"));
            }

            // Auto-size columns
            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }

            // Save Excel file
            try (FileOutputStream fileOut = new FileOutputStream("C:\\Users\\user\\Screenshots\\Customer.xlsx")) {
                workbook.write(fileOut);
            }

            System.out.println("Data exported successfully to Customer.xlsx");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
