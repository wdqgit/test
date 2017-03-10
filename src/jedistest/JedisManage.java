package jedistest;



import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisManage {
	private static Jedis jedis = new Jedis("127.0.0.1", 6379,100000);
	
	
	
	
	
	public static void string(){
		jedis.set("test", "11");
	}
	
	public static void getString(){
		System.out.println(jedis.get("test"));
	}
	public static void main(String[] args){
		
		getString();
	}

}
