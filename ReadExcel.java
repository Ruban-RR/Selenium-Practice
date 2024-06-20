package codes;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class ReadExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{
			FileInputStream input = new FileInputStream("D://new.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(input);
			XSSFSheet sheet = workbook.getSheetAt(0);
			for(Row row:sheet) {
				for(Cell col:row) {
					System.out.print(col+"   ");
				}System.out.println();
			}
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}

}
