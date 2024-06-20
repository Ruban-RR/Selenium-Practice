package codes;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;
import java.io.File;
public class WriteExcel {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Friends Details");
			Map<String, Object []> record = new TreeMap<String, Object []>();
			record.put("0", new Object[] {"Name","Age","Place"});
			record.put("1", new Object[] {"Ruban",20,"Thiruvottriyur"});
			record.put("2", new Object[] {"Monish",20,"Kaladipet"});
			record.put("3", new Object[] {"Mani",21,"Tondiarpet"});
			record.put("4", new Object[] {"Pandian",20,"Kodungaiyur"});
			record.put("5", new Object[] {"Sai",19,"Periyar Nagar"});
			int rowcount = 0;
			Set<String> keyset = record.keySet();
			for(String key:keyset) 
			{
				Row row = sheet.createRow(rowcount++);
				Object[] val= record.get(key);
				int colcount = 0;
				for(Object ob : val) 
		        {
					Cell col = row.createCell(colcount++);
					if(ob instanceof String) 
					{
						col.setCellValue((String)ob);
					}
					if(ob instanceof Integer) 
					{
						col.setCellValue((Integer)ob);
					}
		        }
			}
			try 
			{
				FileOutputStream out = new FileOutputStream("D://new.xlsx");
				workbook.write(out);
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}
	       
	}

}
