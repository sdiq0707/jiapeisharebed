package com.woniu.util.cache;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


import org.apache.ibatis.cache.Cache;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache implements Cache{

	private RedisTemplate<Object, Object> redisTemplate;
	private String id;
	
	public RedisCache(String id) {
		if(id==null)
			throw new RuntimeException("参数不能为空");
		this.id=id;
		redisTemplate=(RedisTemplate<Object, Object>) ApplicationContextHolder.getBean("redisTemplate");
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void putObject(Object key, Object value) {
		// TODO Auto-generated method stub
		readWriteLock.writeLock().lock();
		try {
			this.redisTemplate.opsForValue().set(key, value);
			this.redisTemplate.expire(key, new Random().nextInt(60), TimeUnit.MINUTES);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}finally {
			readWriteLock.writeLock().unlock();
		}
		
	}
	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		readWriteLock.writeLock().lock();
		try {
			Object obj = this.redisTemplate.opsForValue().get(key);
			if(obj==null)//为了应对缓存穿透
				this.redisTemplate.opsForValue().set(key, null);
			return obj;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			readWriteLock.writeLock().unlock();
		}
		return null;
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		readWriteLock.writeLock().lock();
		try {
			this.redisTemplate.delete(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}finally {
			readWriteLock.writeLock().unlock();
			return null;
		}
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		//this.redisTemplate.getConnectionFactory().getConnection().flushDb();不准这么用
		this.redisTemplate.execute(new RedisCallback() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				connection.flushDb();
				return null;
			}
			
			
		});
	}

	@Override
	public int getSize() {
		Object size=this.redisTemplate.execute(new RedisCallback() {

			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				// TODO Auto-generated method stub
				return connection.dbSize();
			}
			
			
		});
		return Integer.parseInt(size+"");
	}
	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
}
