package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcelToJsonConverter {

    public static void main(String[] args) throws Exception {
        String excelPath = "src/test/resources/testdata/loginData.xlsx";
        String jsonPath = "src/test/resources/testdata/loginData.json";

        List<Map<String, Object>> sheetData = readExcel(excelPath);
        writeJson(sheetData, jsonPath);
    }

    // Read Excel and return List of Maps
    public static List<Map<String, Object>> readExcel(String filePath) throws IOException {
        List<Map<String, Object>> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            int colCount = headerRow.getLastCellNum();

            // Iterate through rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, Object> rowData = new LinkedHashMap<>();

                for (int j = 0; j < colCount; j++) {
                    String columnName = headerRow.getCell(j).getStringCellValue();
                    Cell cell = row.getCell(j);

                    if (cell == null) {
                        rowData.put(columnName, null);
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        rowData.put(columnName, cell.getNumericCellValue());
                    } else {
                        rowData.put(columnName, cell.getStringCellValue());
                    }
                }
                dataList.add(rowData);
            }
        }
        return dataList;
    }

    // Write JSON array
    public static void writeJson(List<Map<String, Object>> data, String jsonPath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonPath), data);
    }
}
