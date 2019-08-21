package com.woniu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Factory;
import com.woniu.mapper.FactoryMapper;
import com.woniu.service.IFactoryService;
@Service
public class FactoryServiceImpl implements IFactoryService {

	@Resource
	private FactoryMapper factoryMapper;
	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		List<Factory> factorys=factoryMapper.selectByExample(null);
		return factorys;
	}

}
