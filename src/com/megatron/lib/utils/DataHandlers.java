package com.megatron.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataHandlers {
	
	public static String getDataFromExcel(String fileName,String sheetName,int RowIndex, int cellIndex)
	{
		String data = null;
		try {
			File f = new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(RowIndex);
			Cell c= r.getCell(cellIndex);
			data = c.toString();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	public static void setDataToExcel(String fileName,String sheetName,int RowIndex, int cellIndex,String data)
	{
		try {
			File f = new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st = wb.getSheet(sheetName);
			Row r = st.getRow(RowIndex);
			Cell c= r.getCell(cellIndex);
			c.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getDataFromProperties(String fileName,String key)
	{
		String value = null;
		try {
			File f = new File("./config-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Properties pr = new Properties();
			pr.load(fis);
			value = (String) pr.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	public void setDataToProperties(String fileName,String key, String value,String comment) throws IOException
	{
		File f = new File("./config-data/"+fileName+".properties");
		FileInputStream fis = new FileInputStream(f);
		Properties pr = new Properties();
		pr.load(fis);
		pr.put(key, value);
		FileOutputStream fos = new FileOutputStream(f);
		pr.store(fos, comment);
	}

	public static ArrayList<String> getExcelDataUsingColunmName(String fileName,String sheetName,String colName)
	{
		ArrayList<String> al = new ArrayList<String>();;
		try {
			File f = new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb;
			Sheet st;
			Row r;
			Cell c;
			int cellNo = 0;			
			wb = WorkbookFactory.create(fis);
			st = wb.getSheet(sheetName);
			r = st.getRow(0);
			for(int i = 0;i<r.getLastCellNum();i++)
			{
				c=r.getCell(i);
				if(c.toString().equals(colName))
				{
					cellNo=i;
				}
			}
			for(int i=1;i<=st.getLastRowNum();i++)
			{
				al.add(st.getRow(i).getCell(cellNo).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

	public static ArrayList<String> getExcelDataForParticularRow(String fileName,String sheetName,String RowData,String [] colNames)
	{
		ArrayList<String> al = new ArrayList<String>();;
		try {
			File f = new File("./test-data/"+fileName+".properties");
			FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(sheetName);
			Row r;
			int noOfCol = colNames.length;
			int[] cellNo = new int[noOfCol];
			
			//To get the cell no. of columns
			r = st.getRow(0);
			for(int i=0;i<noOfCol;i++)
			{
				for(int k=0;k<r.getLastCellNum();k++)
				{
					if(r.getCell(k).toString().equals(colNames[i]))
					{
						cellNo[i]=k;
						break;
					}
				}
			}
			//To get the column value of particular row
			for(int i=0;i<=st.getLastRowNum();i++)
			{
				r = st.getRow(i);
				if(r.getCell(0).toString().equals(RowData))
				{
					for(int k=0;k<cellNo.length;k++)
					{
						al.add(r.getCell(cellNo[k]).toString());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}

