package vttp2023.batch3.ssf.frontcontroller.respositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class AuthenticationRepository {

	@Autowired
    RedisTemplate<String, Object> redisTemplate;


	// TODO Task 5
	// Use this class to implement CRUD operations on Redis

}
