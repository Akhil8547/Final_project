package Test;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import page.Clinikallybookingpage;
import utilpack.ExcelUtils;

public class Clinikallybookingtest extends Baseclassclinikally {

    @Test(dataProvider = "bookingData")
    public void test(String age, String genderIndex, String filePath, String targetDate) throws InterruptedException, AWTException {
        SoftAssert softAssert = new SoftAssert(); // Create an instance of SoftAssert
        Clinikallybookingpage CB = new Clinikallybookingpage(driver);
        
        CB.book();
        
        // Set age and perform validation
        CB.age(age);
        // You can add assertions to check if age is properly set or valid
        softAssert.assertFalse(age.isEmpty(), "Age should not be empty");

        // Set gender and validate
        CB.gender(); // Assuming gender is passed as index
        // Add gender validation logic if necessary
        
        Thread.sleep(2000);
        CB.label();
        
        // Handle file upload and validate
        CB.fileupload(filePath);
        // Add validation for file upload if necessary

        // Set the date
        CB.datepicker(); // Pass the date from Excel
        // Add date validation logic if necessary
        
        CB.slot();
        CB.submit();
        
        // Add more validations as required
        // Example: Validate the presence of an element or a confirmation message after submission

        // Finally, assert all soft assertions
        softAssert.assertAll();
    }	

    // DataProvider method to supply test data from Excel
    @DataProvider(name = "bookingData")
    public Object[][] getBookingData() throws IOException {
        String excelFilePath = "D:\\workspace eclipse//clinikally.xlsx"; // Update the path to your Excel file
        String sheetName = "Sheet1"; // Update the sheet name accordingly

        ExcelUtils excel = new ExcelUtils(excelFilePath, sheetName);
        int rowCount = excel.getRowCount();

        // Assuming there are 4 columns in the Excel sheet (age, gender, file path, target date)
        Object[][] data = new Object[rowCount - 1][4];

        // Loop through the Excel sheet, starting from row 1 to skip the header
        for (int i = 1; i < rowCount; i++) {
            data[i - 1][0] = excel.getCellData(i, 0); // Age
            data[i - 1][1] = excel.getCellData(i, 1); // Gender index
            data[i - 1][2] = excel.getCellData(i, 2); // File path
            data[i - 1][3] = excel.getCellData(i, 3); // Target date
        }

        excel.closeWorkbook(); // Close the workbook after reading
        return data;
    }
}
