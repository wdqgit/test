package kryo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;

public class kryo1_1 {
	 public static void main(String[] args) throws IOException, ClassNotFoundException {  
	        long start =  System.currentTimeMillis();  
	        setSerializableObject();  
	        System.out.println("java Serializable writeObject time:" + (System.currentTimeMillis() - start) + " ms" );  
	        start =  System.currentTimeMillis(); 
	        for(int i =0; i < 10000; i++)
	        getSerializableObject();  
	        System.out.println("java Serializable readObject time:" + (System.currentTimeMillis() - start) + " ms");  
	    }  
	  
	    public static void setSerializableObject() throws IOException{  
	  
	        FileOutputStream fo = new FileOutputStream("data.ser");  
	  
	        ObjectOutputStream so = new ObjectOutputStream(fo);  
	        String jsonString = "{\"uid\":17694,\"createtime\":\"2015-09-20 12:15:38\",\"modifytime\":\"2016-12-26 21:08:39\",\"uregistrationid\":\"\",\"ucompany\":901,\"uemployeeid\":\"30617\",\"unt\":\"yanghao7\",\"uname\":\"杨浩\",\"unickname\":\"vjj\",\"unicknamesearch\":\"vjj\",\"upwd\":\"\",\"usign\":\"\",\"udevice\":\"\",\"uisleave\":0,\"uregion\":\"\",\"uheader\":\"http://ai-wemedia-01.oss-cn-beijing.aliyuncs.com/user_header.jpg_9D1D62A2A610CE27916A8FA4AE65E234.jpg\",\"ulocation\":\"北京\",\"uisshownickname\":1,\"uintroduction\":\"%E5%92%8C%E5%A7%90%E5%A7%90%E8%89%B0%E9%9A%BE%E5%9B%B0%E8%8B%A6\",\"usex\":\"M\",\"uorganame\":\"CIT WSD_TDC-BJ\",\"upersonid\":222936,\"ucostcenterid\":\"98156\",\"ucostcentername\":\"CIT WSD\",\"uatallpermission\":0,\"usbu2\":\"CIT\",\"userStatus\":\"\"}";
			TUser tuser = JSON.parseObject(jsonString, TUser.class);
	        
	            so.writeObject(tuser);  
	        so.flush();  
	        so.close();  
	    }  
	  
	    public static void getSerializableObject(){  
	         FileInputStream fi;  
	        try {  
	            fi = new FileInputStream("data.ser");  
	            ObjectInputStream si = new ObjectInputStream(fi);  
	  
	            TUser tuser =null;  
	            while((tuser=(TUser)si.readObject()) != null){  
	                //System.out.println(simple.getAge() + "  " + simple.getName());  
	            }  
	            fi.close();  
	            si.close();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            //e.printStackTrace();  
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	  
	  
	    } 
}
