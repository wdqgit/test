package kryo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.objenesis.strategy.StdInstantiatorStrategy;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoException;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class Kryo1 {
	 public static void main(String[] args) throws IOException {  
	        long start =  System.currentTimeMillis();  
	        setSerializableObject();  
	        System.out.println("Kryo Serializable writeObject time:" + (System.currentTimeMillis() - start) + " ms" );  
	        start =  System.currentTimeMillis();  
	        for(int i = 0; i < 10000; i++)
	        getSerializableObject();  
	        System.out.println("Kryo Serializable readObject time:" + (System.currentTimeMillis() - start) + " ms");  
	  
	    }  
	  
	    public static void setSerializableObject() throws FileNotFoundException{  
	  
	        Kryo kryo = new Kryo();  
	  
	        kryo.setReferences(false);  
	  
	        kryo.setRegistrationRequired(false);  
	  
	        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
	  
	        kryo.register(TUser.class);  
	  
	        Output output = new Output(new FileOutputStream("file.bin"));
	        String jsonString = "{\"uid\":17694,\"createtime\":\"2015-09-20 12:15:38\",\"modifytime\":\"2016-12-26 21:08:39\",\"uregistrationid\":\"\",\"ucompany\":901,\"uemployeeid\":\"30617\",\"unt\":\"yanghao7\",\"uname\":\"杨浩\",\"unickname\":\"vjj\",\"unicknamesearch\":\"vjj\",\"upwd\":\"\",\"usign\":\"\",\"udevice\":\"\",\"uisleave\":0,\"uregion\":\"\",\"uheader\":\"http://ai-wemedia-01.oss-cn-beijing.aliyuncs.com/user_header.jpg_9D1D62A2A610CE27916A8FA4AE65E234.jpg\",\"ulocation\":\"北京\",\"uisshownickname\":1,\"uintroduction\":\"%E5%92%8C%E5%A7%90%E5%A7%90%E8%89%B0%E9%9A%BE%E5%9B%B0%E8%8B%A6\",\"usex\":\"M\",\"uorganame\":\"CIT WSD_TDC-BJ\",\"upersonid\":222936,\"ucostcenterid\":\"98156\",\"ucostcentername\":\"CIT WSD\",\"uatallpermission\":0,\"usbu2\":\"CIT\",\"userStatus\":\"\"}";
			TUser tuser = JSON.parseObject(jsonString, TUser.class);
	            
	            kryo.writeObject(output,tuser );  
	     
	        output.flush();  
	        output.close();  
	    }  
	  
	  
	    public static void getSerializableObject(){  
	        Kryo kryo = new Kryo();  
	  
	        kryo.setReferences(false);  
	  
	        kryo.setRegistrationRequired(false);  
	  
	        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());  
	        TUser tuser = null; 
	        Input input;  
	        try {  
	            input = new Input(new FileInputStream("file.bin"));  
	            while((tuser=kryo.readObject(input, TUser.class)) != null){  
	            }  
	  
	            input.close();  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch(KryoException e){  
	  
	        }  
	    }  
}
