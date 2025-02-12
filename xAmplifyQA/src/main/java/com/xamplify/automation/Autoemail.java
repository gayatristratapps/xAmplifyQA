package com.xamplify.automation;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Autoemail {
	public static void main(String[] args) {
	        String filePath = "emails_with_headers.xlsx";

	        try (Workbook workbook = new XSSFWorkbook()) {
	            Sheet sheet = workbook.createSheet("Email IDs");

	            // Create header row
	            Row headerRow = sheet.createRow(0);
	            Cell headerCell1 = headerRow.createCell(0);
	            headerCell1.setCellValue("FIRSTNAME");
	            Cell headerCell2 = headerRow.createCell(1);
	            headerCell2.setCellValue("LASTNAME");

	            Cell headerCell3 = headerRow.createCell(2);
	            headerCell3.setCellValue("COMPANY");
	            Cell headerCell4 = headerRow.createCell(3);
	            headerCell4.setCellValue("JOBTITLE");
	            Cell headerCell5 = headerRow.createCell(4);
	            headerCell5.setCellValue("EMAILID");
	            Cell headerCell6 = headerRow.createCell(5);
	            headerCell6.setCellValue("ADDRESS");
	            
	            
	            Cell headerCell7 = headerRow.createCell(6);
	            headerCell7.setCellValue("CITY");
	            Cell headerCell8 = headerRow.createCell(7);
	            headerCell8.setCellValue("STATE");
	            Cell headerCell9 = headerRow.createCell(8);
	            headerCell9.setCellValue("ZIP CODE");
	            Cell headerCell10 = headerRow.createCell(9);
	            headerCell10.setCellValue("COUNTRY");
	            
	            Cell headerCell11 = headerRow.createCell(10);
	            headerCell11.setCellValue("MOBILE NUMBER");
	           
	            
	            
	            
	            // Add some email IDs and last names
	            for (int i = 1; i <= 100; i++) {
	                Row row = sheet.createRow(i);
	                //Cell cell1 = row.createCell(0);
	               Cell cell2 = row.createCell(2);
	                Cell cell4 = row.createCell(4);

	                String email = "Gayatri" + i + "@analytify.com";
	                String lastName = "Gayatri" + i;
	                cell2.setCellValue(lastName);
	                cell4.setCellValue(email);

	            }
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }

            System.out.println("Email IDs generated and written to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    
	        try (FileInputStream fileInputStream = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

	            Sheet sheet = workbook.getSheetAt(0);
	            for (Row row : sheet) {
	                for (Cell cell : row) {
	                    switch (cell.getCellType()) {
	                        case STRING:
	                            System.out.print(cell.getStringCellValue() + "\t");
	                            break;
	                        case NUMERIC:
	                            System.out.print(cell.getNumericCellValue() + "\t");
	                            break;
	                        default:
	                            System.out.print("Unknown Cell Type\t");
	                            break;
	                    }
	                }
	                System.out.println();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


}

