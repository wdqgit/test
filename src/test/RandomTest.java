package test;

import java.util.HashMap;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		/*int total = 20000;
        int num = 1000;
        int min = 5;
        HashMap<Integer, Integer> stmt = new HashMap<Integer, Integer>();
        
        for(int i = 0;i < num;i++){
            int safe_total = (total - (num - i) * min)/(num -i);
           
            double rate = new Random().nextInt(100) / 100.0;
            System.out.println(safe_total + " " + rate);
            
            int money = new Double((rate * (safe_total - min) + min)).intValue();
            total = total - money;
            System.out.println(total + " " + money);
            System.out.println("-------");
        }*/
		int key = -1;
		for(int i = 0; i < 20; i++)
		System.out.println(key == 9 ? (key = 0) : ++key);

	}

}
