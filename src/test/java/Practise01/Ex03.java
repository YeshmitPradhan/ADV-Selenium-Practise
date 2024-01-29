package Practise01;

import GenericUtilities.JavaUtilities;

public class Ex03 
{

	public static void main(String[] args) throws Throwable 
	{
   /* FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Writedata.properties");	
	Properties p = new Properties();
	p.load(fis);
	p.setProperty("EMAIL","yeshit@gmial.com");
	
	
	FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\Writedata.properties");
	p.store(fos, null);
	
	System.out.println("done");
	//
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestDataEx01.xlsx");
	Workbook w = WorkbookFactory.create(fi);
    w.getSheet("Sheet2").createRow(1).createCell(1).setCellValue("yeshmit@gmail");
    
    FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\TestDataEx01.xlsx");
    w.write(fo);
    w.close();
    System.out.println("done");
    */
		
		//PropertyFileUtilities pfu = new PropertyFileUtilities();
		//System.out.println(pfu.readDataFromPropertyFile("url"));
		
		//ExcelFileUtilities efu = new ExcelFileUtilities();
		//System.out.println(efu.readDataFromExcelFile("Sheet1", 1, 2));
		
		
		JavaUtilities ju = new JavaUtilities();
		System.out.println(ju.GetSystemDate());
		
		
		
		
		
		/*
		int sum = abc(30,50);
		System.out.println(sum);
		abc(20,20);
		System.out.println(abc(20,20));
		*/
	}
	
	/*
	public static int abc(int a, int b)
	{   
		int c = a+b;
		return c;
	}
	*/
}