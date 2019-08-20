package com.woniu.service;

import java.util.List;

import com.woniu.entity.Bed;

public interface IBedService {
	public List findAll();//查找所有床的信息
	public void save(Bed bed);
}
