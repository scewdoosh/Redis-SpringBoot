package com.cosa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.cosa.model.JwhatModel;

@Configuration
public class RedisConfig {
	@Bean
	public JedisConnectionFactory jFactory() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, JwhatModel> rTemplate(){
		RedisTemplate<String, JwhatModel> rtemp = new RedisTemplate<>();
		rtemp.setConnectionFactory(jFactory());
		rtemp.setKeySerializer(new StringRedisSerializer());
		rtemp.setValueSerializer(new JacksonJsonRedisSerializer<>(JwhatModel.class));
		rtemp.setHashKeySerializer(new StringRedisSerializer());
		rtemp.setHashValueSerializer(new JacksonJsonRedisSerializer<>(JwhatModel.class));
		return rtemp;
	}
}
