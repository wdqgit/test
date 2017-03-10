package excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelTest {

	public static void main(String[] args) throws Exception {
		File file = new File("excel.xls");
		FileOutputStream fos = new FileOutputStream(file);
		
		WritableWorkbook ww = Workbook.createWorkbook(fos);
		
		WritableSheet ws = ww.createSheet("first1", 0);
		ws.addCell(new Label(0, 0, "RED_PACKET_ID"));
		ws.addCell(new Label(1, 0, "RED_PACKET_NO"));
		ws.addCell(new Label(2, 0, "AMOUNT"));
		ws.addCell(new Label(3, 0, "ROUND"));
		ws.addCell(new Label(4, 0, "WINNER_NT"));
		ws.addCell(new Label(5, 0, "WINNER_NAME"));
		ws.addCell(new Label(6, 0, "TYPE"));
		ws.addCell(new Label(7, 0, "GET_WAY_TYPE"));
		int oldmax = 6000;
		int max = 6000;
		int sheetNum = 0;
		for(int i = 1; i <= 10000; i++){
			if(i > max){
				ww.createSheet("2", ++sheetNum);
				ws = ww.getSheet(sheetNum);
				max = max + oldmax;
			}
			ws.addCell(new Label(0, i - max + oldmax, String.valueOf(i)));
		}
		
		

		ww.write();
		ww.close();

	}

}
