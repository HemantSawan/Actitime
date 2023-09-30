package com.Actitime.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is generic class which is non static method to read data from property and excel file.
 * @author Hemant
 *
 */
public class Filelibrary 
{
	/**
	 * This method is a non static method used to read data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String readdatafromProperty(String key)throws IOException{
	FileInputStream fis=new FileInputStream("./Testdata/common data.property");
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(key);
	return value;
}
	/**
	 * This method is non static method used  to read data from excel sheet.
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
 
	public String readdatafromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("/.Testdata/BANKINGinfo.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		Filelibrary f=new Filelibrary();
		f.readdatafromExcel("Sheet1", 1, 1);
		
	}
}
