package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static String[][] getData(){
		File file = new File(System.getProperty("user.dir")+"//src//test//resources//TestData.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
			
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("AddData");
			
			Row row = sheet.getRow(0);
			
			String [][] data = new String[sheet.getLastRowNum()][row.getLastCellNum()];
			
			for (int i=0;i<sheet.getLastRowNum();i++) {
				Row currentRow = sheet.getRow(i+1);
				for (int j=0;j<row.getLastCellNum();j++) {
					DataFormatter dataFormatter = new DataFormatter();
					data[i][j] = dataFormatter.formatCellValue(currentRow.getCell(j)); 
					
				}
			}
			fis.close();
			wb.close();
			
			return data;
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
