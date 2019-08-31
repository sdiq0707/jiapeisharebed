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
		//根据spring aop织入获取RedisTemplate 的实例
		//此处redisTemplate有两个，需要按名称装配，按类型会报错！！！！
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
		readWriteLock.writeLock().lock();//加入了写锁
		try {
			this.redisTemplate.opsForValue().set(key, value);
			//可以预防缓存击穿，加入了超时(随机生成)
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
		readWriteLock.readLock().lock();//加入了读锁
		try {
			Object obj = this.redisTemplate.opsForValue().get(key);
			if(obj==null)//可以应对缓存穿透(没有读取到数据时，赋值为null)
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
		readWriteLock.writeLock().lock();//加入了写锁
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
		// 现在的clear清空整个缓存
		//this.redisTemplate.getConnectionFactory().getConnection().flushDb();不准这么用
		this.redisTemplate.execute(new RedisCallback() {
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
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
				return connection.dbSize();
			}
		});
		return Integer.parseInt(size+"");
	}
	
	//加入读写锁
	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	private ReentrantReadWriteLock readWriteLock=new ReentrantReadWriteLock();
}
