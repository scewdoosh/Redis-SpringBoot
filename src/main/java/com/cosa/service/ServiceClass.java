package com.cosa.service;

import java.util.Collection;
import java.util.Map;

import org.jspecify.annotations.NonNull;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cosa.model.JwhatModel;

@Service
public class ServiceClass {
	private HashOperations<String, Object, Object> hashOps = null;
	
	public ServiceClass(RedisTemplate<String, JwhatModel> rtemp) {
		hashOps=rtemp.opsForHash();
	}
	
	public String saveToken(@RequestBody JwhatModel model) {
		hashOps.put("TOKENS",model.getTokenUser(),model);
		return model.getTokenUser()+"'s token saved successfully"; 
	}
	
	public Collection<Object> getAlluserAndToken(){
		Map<@NonNull Object, Object> map = hashOps.entries("TOKENS");
		Collection<Object> ref = map.values();
		return ref;
	}
}
