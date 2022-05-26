package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null;
	String sheetName = "Sheet1";
	String[][] dataArray;

	public FileInputStream getFile() {
		// Define path of file which need to access
		String filePath = System.getProperty("user.dir") + "/src/test/java/testdata/userRegistrationData.xlsx";
		// Create object of file to open file
		File scrFile = new File(filePath);
		try {
			fis = new FileInputStream(scrFile);
		} catch (FileNotFoundException e) {
			System.out.print("File is not found !!");
		}
		return fis;
	}

	public Object[][] getExcelData() throws IOException {
		fis = getFile();
		// Create object from XSSFWorkbook (representation of XLSX file)
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// To access specific sheet
		XSSFSheet sheet = workbook.getSheet(sheetName);
		// Return all rows of selected sheet
		int rows = (sheet.getLastRowNum()) +1;
		int columns = sheet.getRow(0).getLastCellNum();
		dataArray = new String[rows][columns];
		for (int r = 0; r < rows; r++) {
			// Access specific row from all rows
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < row.getLastCellNum(); c++) {
				// Access to all cells of row (get data values)
				dataArray[r][c] = row.getCell(c).toString();
			}
		}
		workbook.close();
		return dataArray;
	}
}
