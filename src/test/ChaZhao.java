package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ChaZhao {

	public static void main(String[] args) throws Exception{
		File file = new File("aa.txt");
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		File file1 = new File("excel.xlsx");
		FileOutputStream fos = new FileOutputStream(file1);
		
		WritableWorkbook ww = Workbook.createWorkbook(fos);
		
		WritableSheet ws = ww.createSheet("first1", 0);
		String line = null;
		int i = 0;
		while((line = br.readLine()) != null){
			String[] ss = line.split(",");
			for(int j = 0; j < ss.length; j ++){
				ws.addCell(new Label(j, i, ss[j]));
			}
			i++;
		}
		ww.write();
		ww.close();
		fr.close();

	}

}
