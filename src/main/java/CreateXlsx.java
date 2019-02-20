/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import  java.io.*;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CreateXlsx{
    public static void main(String[]args){
        try{
            String filename = "/home/murthidn/Documents/File.xlsx" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Address");
            rowhead.createCell(3).setCellValue("Email");

            HSSFRow row = sheet.createRow((short)1);
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("Sankumarsingh");
            row.createCell(2).setCellValue("India");
            row.createCell(3).setCellValue("sankumarsingh@gmail.com");

            HSSFSheet sheet2 = workbook.createSheet("SecondSheet");

            HSSFRow rowhead2 = sheet2.createRow((short)0);
            rowhead2.createCell(0).setCellValue("No.");
            rowhead2.createCell(1).setCellValue("Name");
            rowhead2.createCell(2).setCellValue("Address");
            rowhead2.createCell(3).setCellValue("Email");

            HSSFRow row2 = sheet2.createRow((short)1);
            row2.createCell(0).setCellValue("1");
            row2.createCell(1).setCellValue("Sankumarsingh");
            row2.createCell(2).setCellValue("India");
            row2.createCell(3).setCellValue("murthi267@gmail.com");

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated! in " + filename);
        }
        catch ( Exception ex ){
            System.out.println(ex);
        }
    }
}