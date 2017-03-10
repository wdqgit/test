package fastJson;

import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class FastJSONTest {

	public static void main(String[] args) {
		System.out.println(JSON.toJSONString(new User(1, "Õı")));
		String s = "{\"id\":1,\"name\":\"Õı\"}";
		User user = JSON.parseObject(s, User.class);
		System.out.println(user);
		Date date = new Date();
		System.out.println(JSON.toJSONString(date, SerializerFeature.WriteDateUseDateFormat));
		System.out.println(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat));
		String ss = "{\"users\":{\"id\":2,\"name\":\"¿Ó\"}}";
		Map<String, User> maps = JSON.parseObject(ss, new TypeReference<Map<String, User>>(){});
		System.out.println(maps.get("users"));
		
		
	}

}
