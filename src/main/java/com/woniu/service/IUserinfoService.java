package com.woniu.service;

import java.util.List;

import com.woniu.entity.Userinfo;

public interface IUserinfoService {
	public Userinfo login(Userinfo info);
	public List<Userinfo> findAll();
	public Userinfo findById(Integer uid);
	public void save(Userinfo info,Integer[] chk);
	public void update(Userinfo info,Integer[] chk);
	public void delete(Integer uid);
	public void revoke(Integer uid);
}
