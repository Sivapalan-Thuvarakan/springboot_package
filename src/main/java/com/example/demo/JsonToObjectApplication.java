package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonToObjectApplication {

	public static void main(String[] args) {
		String excelName="Json_String";
		
		String strcolumnWithHeasderNameOnly ="[{\"Name\":\"Name\"},"
				+ " {\"Name\":\"Age\"},"
				+ "{\"Name\":\"Address\"},"
				+ "{\"Name\":\"city\"},"
				+ "{\"Name\":\"country\"}]";
		
		String strrowforColumnHeader = "[{\"Name\":\"Thuva\",\"Address\":\"Manipay\",\"Age\":\"23\",\"city\":\"jaffna\",\"country\":\"srilanka\"},"
				+ "{\"Name\":\"Thuva2\",\"Address\":\"Manipay2\",\"Age\":\"23\",\"city\":\"jaffna2\",\"country\":\"srilanka2\"},"
				+ "{\"Name\":\"Thuva3\",\"Address\":\"Manipay3\",\"Age\":\"23\",\"city\":\"jaffna3\",\"country\":\"srilanka3\"}]";
		
		String strcolumn = "[{\"Name\":\"Name\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ " {\"Name\":\"Age\",\"Width\":\"6000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"Address\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"city\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"country\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"}]";
		
		String strcolumnempty = "[{\"Name\":\"Name\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ " {\"Name\":\"Age\",\"Width\":\"6000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"Address\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"city\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"}]";

		String strcolumnerr = "[{\"Name\":\"Name\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ " {\"Name\":\"Age\",\"Width\":\"6000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"Address\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Name\":\"city\",\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"},"
				+ "{\"Width\":\"16000\",\"FontName\":\"Arial\",\"FontHeight\":\"16\",\"Bold\":\"true\"}]";
		
		String strrow = "[{\"Name\":\"Thuva\",\"Address\":\"Manipay\",\"Age\":\"23\",\"city\":\"jaffna\",\"country\":\"srilanka\"},"
				+ "{\"Name\":\"Thuva2\",\"Address\":\"Manipay2\",\"Age\":\"23\",\"city\":\"jaffna2\",\"country\":\"srilanka2\"},"
				+ "{\"Name\":\"Thuva3\",\"Address\":\"Manipay3\",\"Age\":\"23\",\"city\":\"jaffna3\",\"country\":\"srilanka3\"}]";
		
		String strrowerr = "[{\"Name\":\"Thuva\",\"Address\":\"Manipay\",\"Age\":\"23\",\"city\":\"jaffna\",\"country\":\"srilanka\"},"
				+ "{\"Name\":\"Thuva2\",\"Address\":\"Manipay2\",\"Age\":\"23\",\"city\":\"jaffna2\",\"country\":\"srilanka2\"},"
				+ "{\"Name\":\"Thuva3\",\"Age\":\"23\",\"city\":\"jaffna3\",\"country\":\"srilanka3\"}]";
		
		String strrowmore = "[{\"Name\":\"Thuva\",\"Address\":\"Manipay\",\"Age\":\"23\",\"city\":\"jaffna\",\"country\":\"srilanka\",\"postal\":\"40000\"},"
				+ "{\"Name\":\"Thuva2\",\"Address\":\"Manipay2\",\"Age\":\"23\",\"city\":\"jaffna2\",\"country\":\"srilanka2\"},"
				+ "{\"Name\":\"Thuva3\",\"Address\":\"Manipay3\",\"Age\":\"23\",\"city\":\"jaffna3\",\"country\":\"srilanka3\"}]";
		
		//normal && no error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrow);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumn);
		
		//columnname with empty string && error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrow);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumnempty);
		
//		//strcolumnWithHeasderNameOnly && strrow && no error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrowforColumnHeader);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumnWithHeasderNameOnly);
		
//		//column header && error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrow);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumnerr);
//		
//		//more row data && not error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrowmore);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumn);
//		
//		//row error &&  error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrowerr);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumn);
//		
//		//row error && column error && error
//		JSONArray rowJsonArray=Json_To_Obj.convertJsonArray(strrowerr);
//		JSONArray columnHeaderJsonArray=Json_To_Obj.convertJsonArray(strcolumnerr);
		
		try
		{
			Json_To_Obj.createExcel(excelName, rowJsonArray, columnHeaderJsonArray);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
