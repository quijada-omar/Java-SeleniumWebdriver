package day32;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingXLS {
	 public static void main(String[] args) throws IOException {

	        FileInputStream file = new FileInputStream("C:\\Users\\omarq\\OneDrive\\Documentos\\GitHub\\Java-SeleniumWebdriver\\testdata\\TestData.xlsx");

	        XSSFWorkbook book = new XSSFWorkbook(file);

	        XSSFSheet sheet = book.getSheet("sheet1");

	        int totalRows = sheet.getLastRowNum();

	        int totalCells = sheet.getRow(1).getLastCellNum();

	        System.out.println("Total cells " + totalCells);  // Start from  0
	        System.out.println("Total rows " + totalRows);    // starts from 1

	        for(int row = 0; row <= totalRows; row++){
	            // Capture particular row
	            XSSFRow currentRow = sheet.getRow(row);
	            for (int cell = 0; cell<totalCells; cell++){
	                XSSFCell currentCell = currentRow.getCell(cell);
	                String value = currentCell.toString();
	                System.out.print(value + "\t | \t");
	            }
	            System.out.println();
	        }
	        book.close();
	        file.close();
	    }
}
