package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead {

	public static void main(String[] args) throws Exception {
		File file = new File("file.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String i = "";
		int wan =0;
		int wu = 0;
		int jie = 0;
		int yun = 0;
		int ying = 0;
		int shu = 0;
		int zhe = 0;
		int xin = 0;
		int tong = 0;
		int xing = 0;
		while((i = br.readLine()) != null){
			if(i.equals("10")){
				wan++;
			}
			if(i.equals("11")){
				wu++;
			}
			if(i.equals("12")){
				jie++;
			}
			if(i.equals("13")){
				yun++;
			}
			if(i.equals("14")){
				ying++;
			}
			if(i.equals("15")){
				shu++;
			}
			if(i.equals("16")){
				zhe++;
			}
			if(i.equals("17")){
				xin++;
			}
			if(i.equals("18")){
				tong++;
			}
			if(i.equals("19")){
				xing++;
			}
			
		}
		fr.close();
		System.out.println("万：" + wan);
		System.out.println("物：" + wu);
		System.out.println("皆：" + jie);
		System.out.println("运：" + yun);
		System.out.println("营：" + ying);
		System.out.println("2017:" + shu);
		System.out.println("者:" + zhe);
		System.out.println("信：" + xin);
		System.out.println("同：" + tong);
		System.out.println("行：" + xing);

	}

}
