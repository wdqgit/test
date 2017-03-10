package kryo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.JavaSerializer;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

public class KryoTest {

	public static void main(String[] args) throws Exception {
		String jsonString = "{\"uid\":17694,\"createtime\":\"2015-09-20 12:15:38\",\"modifytime\":\"2016-12-26 21:08:39\",\"uregistrationid\":\"\",\"ucompany\":901,\"uemployeeid\":\"30617\",\"unt\":\"yanghao7\",\"uname\":\"杨浩\",\"unickname\":\"vjj\",\"unicknamesearch\":\"vjj\",\"upwd\":\"\",\"usign\":\"\",\"udevice\":\"\",\"uisleave\":0,\"uregion\":\"\",\"uheader\":\"http://ai-wemedia-01.oss-cn-beijing.aliyuncs.com/user_header.jpg_9D1D62A2A610CE27916A8FA4AE65E234.jpg\",\"ulocation\":\"北京\",\"uisshownickname\":1,\"uintroduction\":\"%E5%92%8C%E5%A7%90%E5%A7%90%E8%89%B0%E9%9A%BE%E5%9B%B0%E8%8B%A6\",\"usex\":\"M\",\"uorganame\":\"CIT WSD_TDC-BJ\",\"upersonid\":222936,\"ucostcenterid\":\"98156\",\"ucostcentername\":\"CIT WSD\",\"uatallpermission\":0,\"usbu2\":\"CIT\",\"userStatus\":\"\"}";
		TUser tuser = JSON.parseObject(jsonString, TUser.class);
		byte[] s = null;
		Long startTimeWrite = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		s = serializableObject(jsonString);
		System.out.println(System.currentTimeMillis() - startTimeWrite);
		byte[] b = null;
		Long startTimeWrite1 = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++)
		b = serialize(jsonString);
		System.out.println(System.currentTimeMillis() - startTimeWrite1);
		Long start = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			
			unserialize(b);
		}
		System.out.println("java" + (System.currentTimeMillis() - start));
		Long startTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			
			deSerializerObject(s, TUser.class);
		}
		System.out.println("kryc" + (System.currentTimeMillis() - startTime));
		
	
		

	}
	
	public static byte[] serialize(Object object) throws Exception {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			// 序列化
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			throw new Exception("序列化对象失败!", e);
		}finally{
			oos.close();
			baos.close();
		}
	}

	public static Object unserialize(byte[] bytes) throws Exception {
		ByteArrayInputStream bais = null;
		try {
			// 反序列化
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			throw new Exception("反序列化对象失败!", e);
		}
	}
	
	public static <T extends Serializable>  byte[] serializableObject(T t){
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		Output output = new Output(bos);
		kryo.writeClassAndObject(output, t);
		output.flush();
		output.close();
		byte[] b = bos.toByteArray();
		try{
			bos.flush();
			bos.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return b;
	}
	
	public static <T extends Serializable> T deSerializerObject(byte[] obj, Class<T> clazz){
		Kryo kryo = new Kryo();
		kryo.setReferences(false);
		ByteArrayInputStream bis = new ByteArrayInputStream(obj);
		Input input = new Input(bis);
		
		return (T) kryo.readClassAndObject(input);
		
		
		
	}

}
class Student implements Serializable{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}