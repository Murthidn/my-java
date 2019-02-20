/*
 *
 * Copyright (c) 2019 Ranser Group, Inc. All rights reserved.
 *
 */

import java.io.File;
import java.util.Map;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.text.SimpleDateFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class SmartWorkBook{
    public static void main(String[] args){
        String fileFormat = "excel";

        try{
            if (fileFormat != null && fileFormat.equalsIgnoreCase("excel")){
                String outputExcelFileName = "SystemReport_" + new SimpleDateFormat("yyyyMMddHHmm'.xlsx'").format(new Date());

                XSSFWorkbook excelWorkbook = new XSSFWorkbook();

                Map<String, XSSFCellStyle> styles = FileHelper.createStyleMap(excelWorkbook);

                String file = "/home/murthidn/excel.json";
                JsonObject requestPayload = FileHelper.readFileAsJson(file);

                try (FileOutputStream fileOutputStream = new FileOutputStream(new File(outputExcelFileName))){
                    excelWorkbook.write(fileOutputStream);
                }

                List<String> header = new ArrayList<>();
                header.add("producer");

                JsonArray lagArray = requestPayload.getAsJsonArray("infoObjects");
                FileHelper.writeFromJsonToExcelWorkbook(lagArray, excelWorkbook, header, true, "Lag Report", styles);
            }
        }
        catch (Exception e){

        }
    }
}