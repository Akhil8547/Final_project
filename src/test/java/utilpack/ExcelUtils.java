package utilpack;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    // Constructor to load the Excel file and sheet
    public ExcelUtils(String excelFilePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelFilePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    // Get the number of rows in the sheet
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get data from the cell based on row and column index
    public String getCellData(int rowIndex, int colIndex) {
        DataFormatter formatter = new DataFormatter();
        Row row = sheet.getRow(rowIndex);
        if (row == null || row.getCell(colIndex) == null) {
            return "";
        } else {
            return formatter.formatCellValue(row.getCell(colIndex));
        }
    }

    // Close the workbook after the data has been read
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}
