package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public void createSheets() throws IOException {
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Reports\\ExcelData\\Excel_Output.xlsx");
		
		XSSFSheet sheet1=workbook.createSheet("Honda Bikes <4L");
		XSSFSheet sheet2=workbook.createSheet("Popular Model Cars");
		
		workbook.write(fo);
		workbook.close();
		fo.close();
		
	}
	
	public void writeData(String sheetName, int rownum, int colnum, String data) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Reports\\ExcelData\\Excel_Output.xlsx");
		XSSFWorkbook wbook=new XSSFWorkbook(file); //Opening the excel file
		XSSFSheet sheet3;
		XSSFRow row;
		XSSFCell cell;
		if(wbook.getSheetIndex(sheetName)==-1) {
		wbook.createSheet(sheetName);              //Creating the sheet if it does not exist
		}
		sheet3=wbook.getSheet(sheetName);
		if(sheet3.getRow(rownum)==null)
		sheet3.createRow(rownum);
		row =sheet3.getRow(rownum);                    
		cell=row.createCell(colnum);              // Creating cell
		cell.setCellValue(data);                  //Setting the data in the column
		
		// Writing the data by fileOutput
		
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\Reports\\ExcelData\\Excel_Output.xlsx");
		wbook.write(fo);
		wbook.close();
		file.close();
		fo.close();
	}
}
