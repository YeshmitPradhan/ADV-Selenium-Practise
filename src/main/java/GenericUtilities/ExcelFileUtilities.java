package GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtilities 
{

	public String readDataFromExcelFile(String sheet, int row, int cell) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestDataEx01.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        String da = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return da;
	}
}
