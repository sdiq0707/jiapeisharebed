package com.woniu.service;

import java.util.List;

import com.woniu.entity.Shareholder;

public interface IShareholderService {
	public List findAll();
	public Shareholder findById(Integer uid);
}
