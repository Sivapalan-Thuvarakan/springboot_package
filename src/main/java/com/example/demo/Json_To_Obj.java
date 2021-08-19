package com.example.demo;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;  
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;   

public class Json_To_Obj {

	public static JSONArray convertJsonArray(String str) 
	{		
		JSONArray jsonArray = new JSONArray(str); 
		return jsonArray;
    }  

	public static void createExcel(String excelName,JSONArray rowJsonArray,JSONArray columnHeaderJsonArray) throws Invalid_column_Name
	{
		  Workbook workbook = new XSSFWorkbook();

		  Sheet sheet = workbook.createSheet(excelName);
		  Row header = sheet.createRow(0);
		  CellStyle headerStyle = workbook.createCellStyle();
		  headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
		  headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		  XSSFFont font = ((XSSFWorkbook) workbook).createFont();
			for (int count=0;count<columnHeaderJsonArray.length();count++) 
			{		
					  String width;
					  String fontName;
					  String fontHeight;
					  String bold;
					  String name;
					  
					  try
					  {
						width=columnHeaderJsonArray.getJSONObject(count).getString("Width");
					  }
					  catch(Exception e)
					  {
						  width="6000";
					  }
					 
					  try
					  {
						 fontName=columnHeaderJsonArray.getJSONObject(count).getString("FontName");
					  }
					  catch(Exception e)
					  {
						  fontName="Verdana";
					  }
					  
					  try
					  {
						 fontHeight=columnHeaderJsonArray.getJSONObject(count).getString("FontHeight");
					  }
					  catch(Exception e)
					  {
						  fontHeight="16";
					  }
					 
					  try
					  {
						  bold=columnHeaderJsonArray.getJSONObject(count).getString("Bold");
					  }
					  catch(Exception e)
					  {
						  bold="false";
					  }

					  try
					  {
						  	  name=columnHeaderJsonArray.getJSONObject(count).getString("Name");
						
						  	  if(name=="")
						  	  {
						  		  throw new Invalid_column_Name("Column Name must consist of atleast one letter");
						  	  }
							  if(width=="")
							  {
								  width="6000";
								  System.out.println(width);
							  }
							  if(fontName=="")
							  {
								  fontName="Verdana";
								  System.out.println(fontName);
							  }
							  if(fontHeight=="")
							  {
								  fontHeight="16";
								  System.out.println(fontHeight);
							  }
							  if(bold=="")
							  {
								  bold="false";
								  System.out.println(bold);
							  }
							  if(width=="" && fontName=="")
							  {
								  width="6000";
								  fontName="Verdana";
								  System.out.println(width);
								  System.out.println(fontName);
							  }
							  if(fontHeight=="" && fontName=="")
							  {
								  fontHeight="16";
								  fontName="Verdana";
								  System.out.println(fontHeight);
								  System.out.println(fontName);
							  }
							  if(fontHeight=="" && bold=="")
							  {
								  fontHeight="16";
								  bold="false";
								  System.out.println(fontHeight);
								  System.out.println(bold);
							  }
							  if(fontHeight=="" && width=="")
							  {
								  fontHeight="16";
								  width="6000";
								  System.out.println(fontHeight);
								  System.out.println(width);
							  }
							  if(bold=="" && fontName=="")
							  {
								  fontName="Verdana";
								  bold="false";
								  System.out.println(bold);
								  System.out.println(fontName);
							  }
							  if(bold =="" && fontName=="" && fontHeight=="" && width=="")
							  {
								  fontHeight="16";
								  width="6000";
								  fontName="Verdana";
								  bold="false";
								  System.out.println(fontHeight);
								  System.out.println(width);
								  System.out.println(bold);
								  System.out.println(fontName);
							  }
	
							  sheet.setColumnWidth(count,Integer.parseInt(width));
							  font.setFontName(fontName);
							  font.setFontHeightInPoints((short)Integer.parseInt(fontHeight));
							  font.setBold(Boolean.parseBoolean(bold));
							  headerStyle.setFont(font);
							  Cell headerCell = header.createCell(count);
							  headerCell.setCellValue(name);
							  headerCell.setCellStyle(headerStyle);
					  
						  }
						  catch(Exception e)
						  {
							  System.out.println(e.getMessage());
						  }
			}		
			
		 CellStyle style = workbook.createCellStyle();
		 style.setWrapText(true);
		  try 
		  {
			  for(int count=0;count<rowJsonArray.length();count++)
			  {
				  Row row = sheet.createRow(count+1);
		
					  for(int columnCount=0;columnCount<columnHeaderJsonArray.length();columnCount++)
					  {
						  Cell cell = row.createCell(columnCount);
						  cell.setCellValue(rowJsonArray.getJSONObject(count).getString(columnHeaderJsonArray.getJSONObject(columnCount).getString("Name")));
						  cell.setCellStyle(style);
					  }
			  }
		  }
		  catch (Exception e)
		  {
		      System.out.println(e.getMessage());
		  }
		  
		  File currDir = new File(".");
		  String path = currDir.getAbsolutePath();
		  String fileLocation = path.substring(0, path.length() - 1) + "new.xlsx";
		 try 
		 {
			 FileOutputStream outputStream = new FileOutputStream(fileLocation);
			  workbook.write(outputStream);
			  workbook.close();	
		 } 
		 catch (Exception e) 
		 {
			// TODO: handle exception
		 }
	}
}
