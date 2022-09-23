package utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

//	public static String capturescreenshot() throws IOException
//	{
//		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
//        LocalDateTime now=LocalDateTime.now();
//	String timeAnddate=dtf.format(now);
//		WebDriver driver=new ChromeDriver();
//		TakesScreenshot take=(TakesScreenshot)driver;
//     	File src=take.getScreenshotAs(OutputType.FILE);
//		File desti=new File("C:\\Users\\DELL\\OneDrive\\Desktop\\Screenshot\\test"+timeAnddate+".jpg");
//		FileHandler.copy(src, desti);
//		return "desti";
//	}
	
	
	public static String getdata(int rowIndex, int cellIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file= new FileInputStream ("C:\\Users\\DELL\\OneDrive\\Desktop\\TestDataFB.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("Sheet1");
		Cell z=sh.getRow( rowIndex).getCell(cellIndex);
//		String value=z.getStringCellValue();
		//return value;
	    try{
	    	String value=z.getStringCellValue();
	    	return value;
	    }
	    catch(IllegalStateException e)
	    {
	    	long data=(long)z.getNumericCellValue();
	    	String value=String.valueOf(data);
	    	return value;
	    }
	   
	}

}	

