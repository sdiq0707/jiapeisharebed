package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.entity.Userinfo;
import com.woniu.entity.UserinforoleExample;
import com.woniu.entity.UserinforoleKey;
import com.woniu.mapper.UserinfoMapper;
import com.woniu.mapper.UserinforoleMapper;
import com.woniu.service.IUserinfoService;

@Service
public class UserinfoServiceImpl implements IUserinfoService {

	@Resource
	private UserinfoMapper userinfoMapper;
	@Resource
	private UserinforoleMapper userinforoleMapper;

	@Override
	@Transactional(readOnly = true)
	public Userinfo login(Userinfo info) {
		return userinfoMapper.login(info);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Userinfo> findAll() {
		return userinfoMapper.selectByExample(null);
	}

	@Override
	@Transactional
	public void save(Userinfo info, Integer[] chk) {
		// 插入userinfo
		userinfoMapper.insert(info);
		// 插入userinforole
		if (chk != null) {
			for (Integer rid : chk) {
				UserinforoleKey ufkey = new UserinforoleKey();
				ufkey.setUid(info.getUid());
				ufkey.setRid(rid);
				userinforoleMapper.insert(ufkey);
			}
		}
	}

	@Override
	@Transactional
	public void delete(Integer uid) {
		Userinfo info = new Userinfo();
		info.setUid(uid);
		info.setIsdelete(0);
		userinfoMapper.updateByPrimaryKeySelective(info);
	}

	@Override
	@Transactional
	public void revoke(Integer uid) {
		Userinfo info = new Userinfo();
		info.setUid(uid);
		info.setIsdelete(1);
		userinfoMapper.updateByPrimaryKeySelective(info);
	}

	@Override
	@Transactional(readOnly = true)
	public Userinfo findById(Integer uid) {
		return userinfoMapper.selectByPrimaryKey(uid);
	}

	@Override
	@Transactional
	public void update(Userinfo info, Integer[] chk) {
		// 修改userinfo
		userinfoMapper.updateByPrimaryKeySelective(info);
		//删除对应用户所有角色
		UserinforoleExample example = new UserinforoleExample();
		example.createCriteria().andUidEqualTo(info.getUid());
		userinforoleMapper.deleteByExample(example);
		// 修改userinforole
		if (chk != null) {
			for (Integer rid : chk) {
				UserinforoleKey ufkey = new UserinforoleKey();
				ufkey.setUid(info.getUid());
				ufkey.setRid(rid);
				userinforoleMapper.insert(ufkey);
			}
		}
	}

}
