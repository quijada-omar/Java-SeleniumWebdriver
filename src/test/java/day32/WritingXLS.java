package day32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingXLS {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//newfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		System.out.println(System.getProperty("user.dir"));
		XSSFSheet sheet = workbook.createSheet();
		
		
//		XSSFRow row1 = sheet.createRow(0);
//		
//		row1.createCell(0).setCellValue("welcome");
//		row1.createCell(1).setCellValue("12345");
//		row1.createCell(2).setCellValue("XYZ");
//		
//		
//		XSSFRow row2 = sheet.createRow(1);
//		
//		row2.createCell(0).setCellValue("abc");
//		row2.createCell(1).setCellValue("4567");
//		row2.createCell(2).setCellValue("testing");
		
		Scanner sc = new Scanner(System.in);
		
		for (int r = 0; r<=5; r++) {
			XSSFRow currentRow = sheet.createRow(r);
			for(int c = 0; c < 3; c++) {
//				currentRow.createCell(c).setCellValue("welcome");
				System.out.println("Enter a value ");
				Object object = sc.next();
				currentRow.createCell(c).setCellValue(object.toString());
			}
		}
		
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing is done");
		
		
		
		
		
	}
}
