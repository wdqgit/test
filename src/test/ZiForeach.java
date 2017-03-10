package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Writer;

public class ZiForeach {

	public static void main(String[] args) throws Exception {
		File file = new File("file.txt");
		FileWriter fw = new FileWriter(file);
		//8500个“万”字	500个“物”字	1000个“营”	3000个“者”	2000个“同”

		int i = 8500;//万10
		int j = 500;//物11
		int k = 0;//皆12
		int yun = 0;//运13
		int y = 1000;//营14
		int shu = 0;//2017  15
		int xin = 0;//信16
		int z = 3000;//者17
		int t = 0;//同18
		int xing = 2960;//行19
		while(y > 0){
			
			if(i > 0){
				fw.write(10 + "\n");
				i--;
			}
			if(j > 0){
				fw.write(11 + "\n");
				j--;
			}
			if(k > 0){
				fw.write(12 + "\n");
				k--;
			}
			if(yun > 0){
				fw.write(13 + "\n");
				yun--;
			}
			if(y > 0){
				fw.write(14 + "\n");
				y--;
			}
			if(shu > 0){
				fw.write(15 + "\n");
				shu--;
			}
			if(xin > 0){
				fw.write(16 + "\n");
				xin--;
			}
			if(z > 0){
				fw.write(17 + "\n");
				z--;
			}
			if(t > 0){
				fw.write(18 + "\n");
				t--;
			}
			if(xing > 0){
				fw.write(19 + "\n");
				xing--;
			}
		}
		fw.close();
		
		

	}

}
