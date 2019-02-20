/*
 *
 * Copyright (c) 2018 Ranser Group, Inc. All rights reserved.
 *
 */

import com.google.gson.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.logging.*;

public class FileHelper
{
    public static void setupLogger(Logger logger, String toolName)
    {
        try
        {
            logger.info("initializing - trying to load configuration file ...");
            try (InputStream configFile = new FileInputStream("logger.properties"))
            {
                LogManager.getLogManager().readConfiguration(configFile);
            }

            catch (IOException ex)
            {
                System.out.println("WARNING: Could not open configuration file");
                System.out.println("WARNING: Logging not configured (logging into default log file)");

                Handler fh = new FileHandler("%t/" + toolName + "-tool.%u.%g.log", true);  // append is true
                fh.setFormatter(new SimpleFormatter());
                logger.addHandler(fh);
                // Set the logger level to produce logs at this level and above.
                logger.setLevel(Level.INFO);
            }


        }
        catch (Exception ex)
        {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }


    public static JsonObject readFileAsJson(String fileName)
    {
        JsonObject fileDataJson = null;
        JsonParser parser;
        String fileData;
        try
        {
            fileData = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
            parser = new JsonParser();
            fileDataJson = parser.parse(fileData).getAsJsonObject();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return fileDataJson;
    }

    public static List<String> getCsvHeader(JsonObject getQueryRequest)
    {
        List<String> csvHeader = new ArrayList<>();
        csvHeader.add("id");
        csvHeader.add("name");

        if (getQueryRequest.has("params")
                && getQueryRequest.get("params").getAsJsonObject().has("fields"))
           {
            JsonObject fieldsObj = getQueryRequest.get("params").getAsJsonObject().getAsJsonObject("fields");

            if (fieldsObj.has("attributes"))
             {
                JsonArray attributesArray = fieldsObj.getAsJsonArray("attributes");
                for (JsonElement attrbElem : attributesArray)
                {
                    csvHeader.add(attrbElem.getAsString());
                }
             }

            if (fieldsObj.has("relationships"))
            {
                JsonArray attributesArray = fieldsObj.getAsJsonArray("relationships");
                for (JsonElement attrbElem : attributesArray)
                {
                    csvHeader.add(attrbElem.getAsString());
                }
            }

        }

        List<String> propertyList = Arrays.asList("createdBy", "modifiedBy", "createdDate", "modifiedDate");
        csvHeader.addAll(propertyList);
        return csvHeader;
    }

    public static boolean writeFromJsonToCSVFile(JsonArray jsonElementArray, String fileOutput, List<String> header, boolean firstWrite)
    {
        try
        {
            try (Writer out = new FileWriter(fileOutput, true))
            {
                CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator("\n");
                CSVPrinter csvPrinter = new CSVPrinter(out, csvFileFormat);
                if (firstWrite)
                {
                    csvPrinter.printRecord(header);
                }

                for (JsonElement entity : jsonElementArray)
                {
                    JsonObject entityObj = entity.getAsJsonObject();
                    List<String> record = getRowRecord(entityObj, header);
                    csvPrinter.printRecord(record);
                }
                return true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
    }

    private static List<String> getRowRecord(JsonObject entityObj, List<String> header)
    {

        List<String> record = new ArrayList<>();

        HashMap<String, String> attributeValueMap = new HashMap();

        for (Map.Entry<String, JsonElement> entry : entityObj.entrySet())
        {

            if (entry.getKey().equals("properties"))
            {
                for (Map.Entry<String, JsonElement> propEntry : entry.getValue().getAsJsonObject().entrySet())
                {
                    if (header.contains(propEntry.getKey()))
                    {
                        attributeValueMap.put(propEntry.getKey(), propEntry.getValue().getAsString());
                    }
                }
            }

            if (entry.getKey().equals("data"))
            {
                JsonObject dataObj = entry.getValue().getAsJsonObject();

                // Handle attributes
                if (dataObj.has("attributes"))
                {
                    JsonObject attributesObj = dataObj.getAsJsonObject("attributes");
                    for (Map.Entry<String, JsonElement> attrbElem : attributesObj.entrySet())
                    {
                        if (attrbElem.getValue().getAsJsonObject().has("group"))
                        {
                            continue;
                        }

                        JsonObject attrObj = attrbElem.getValue().getAsJsonObject();
                        if (attrObj.has("values"))
                        {
                            JsonArray attrbArray = attrObj.get("values").getAsJsonArray();
                            if (attrbArray.size() > 0)
                            {
                                JsonObject attrbValObj = attrbArray.get(0).getAsJsonObject();
                                if (attrbValObj.has("value"))
                                {
                                    attributeValueMap.put(attrbElem.getKey(), attrbValObj.get("value").getAsString());
                                }
                            }
                        }

                    }
                }

                //workflow attributes
                if (dataObj.has("contexts"))
                {
                    JsonArray contextsArray = dataObj.getAsJsonArray("contexts");
                    JsonObject wfcontextObj = contextsArray.get(0).getAsJsonObject();
                    if (wfcontextObj.getAsJsonObject().has("context"))
                    {
                        JsonObject wfNameObj = wfcontextObj.get("context").getAsJsonObject();
                        if(wfNameObj.getAsJsonObject().has("workflow"))
                        {
                            attributeValueMap.put("workflowName", wfNameObj.get("workflow").getAsString());
                        }
                    }
                    if (wfcontextObj.getAsJsonObject().has("attributes"))
                    {
                        JsonObject wfAttributesObj = wfcontextObj.get("attributes").getAsJsonObject();
                        if (wfAttributesObj.getAsJsonObject().has("activities"))
                        {
                            JsonObject wfActivitiesObj = wfAttributesObj.get("activities").getAsJsonObject();
                            JsonArray wfGroupArray = wfActivitiesObj.get("group").getAsJsonArray();
                            if (wfGroupArray.size() > 0)
                            {
                                JsonObject wfattrObj = wfGroupArray.get(0).getAsJsonObject();
                                for (Map.Entry<String, JsonElement> attrbElem : wfattrObj.entrySet())
                                {
                                    if (!attrbElem.getKey().equals("id"))
                                    {
                                        JsonObject attrObj = attrbElem.getValue().getAsJsonObject();
                                        if (attrObj.has("values"))
                                        {
                                            JsonArray attrbArray = attrObj.get("values").getAsJsonArray();
                                            if (attrbArray.size() > 0)
                                            {
                                                JsonObject wfAttrbValObj = attrbArray.get(0).getAsJsonObject();
                                                if (wfAttrbValObj.has("value"))
                                                {
                                                    attributeValueMap.put( attrbElem.getKey(), wfAttrbValObj.get("value").getAsString());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }



            }

            if (!entry.getKey().equals("properties") && !(entry.getKey().equals("data")))
            {
                String val;
                if (!entry.getValue().isJsonNull())
                {
                    val = entry.getValue().getAsString();
                }
                else
                {
                    val = "";
                }
                attributeValueMap.put(entry.getKey(), val);
            }
        }

        for (String key : header)
        {
            if (attributeValueMap.keySet().contains(key))
            {
                record.add(attributeValueMap.get(key));
            }
            else
            {
                record.add(null);
            }
        }
        return record;
    }

    public static boolean writeJsonObjectToFile(String fileName, JsonObject data)
    {
        try
        {
            try (Writer writer = new FileWriter(fileName))
            {
                Gson gson = new GsonBuilder().disableHtmlEscaping().create();
                gson.toJson(data, writer);
            }
            return true;

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return false;
    }

    public static Map<String,XSSFCellStyle> createStyleMap(XSSFWorkbook excelWorkbook) {
        Map<String, XSSFCellStyle> styles = new HashMap<>();

        //header style
        XSSFFont headerFont = excelWorkbook.createFont();
        headerFont.setFontName("Calibri");
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());

        //Set font into style
        XSSFCellStyle headerStyle = excelWorkbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setFillForegroundColor(new XSSFColor(new Color(10,25,60)));
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        styles.put("Header",headerStyle);

        //data style
        XSSFFont dataFont = excelWorkbook.createFont();
        dataFont.setFontName("Calibri");
        dataFont.setFontHeightInPoints((short) 11);

        //Set font into style
        XSSFCellStyle dataStyle = excelWorkbook.createCellStyle();
        dataStyle.setFont(dataFont);
        dataStyle.setAlignment(HorizontalAlignment.RIGHT);

        styles.put("Data",dataStyle);

        return styles;
    }

    public static void writeFromJsonToExcelWorkbook(JsonArray jsonElementArray, XSSFWorkbook excelWorkbook, List<String> header, boolean firstWrite, String sheetName, Map<String, XSSFCellStyle> styles) {
        XSSFSheet spreadsheet = excelWorkbook.createSheet(sheetName);

        XSSFCellStyle headerStyle = styles.get("Header");
        XSSFCellStyle dataStyle = styles.get("Data");

        int rowId = 0;
        if(firstWrite){
            printRecord(spreadsheet, header, rowId++, headerStyle);
        }
        for (JsonElement entity : jsonElementArray) {
            JsonObject entityObj = entity.getAsJsonObject();
            List<String> rowRecord = getRowRecord(entityObj, header);
            printRecord(spreadsheet, rowRecord, rowId++, dataStyle);
        }

        for(int i=0; i<header.size();i++){
            spreadsheet.autoSizeColumn(i);
        }
    }

    private static void printRecord(XSSFSheet spreadsheet, List<String> rowRecord, int rowId, XSSFCellStyle style) {
        XSSFRow row = spreadsheet.createRow(rowId);
        int cellId = 0;
        int columnId = 0;
        for(String column : rowRecord) {
            Cell cell = row.createCell(cellId++);
            cell.setCellStyle(style);
            cell.setCellValue(column);
        }
    }
}
