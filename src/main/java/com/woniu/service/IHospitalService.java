package com.woniu.service;

import java.util.List;

import com.woniu.entity.Hospital;
import com.woniu.entity.Hospitalmanger;
import com.woniu.entity.PageBean;
import com.woniu.entity.Province;
import com.woniu.entity.Userinfo;

public interface IHospitalService {
	void save(Hospital hospital);
	void update(Hospital hospital);
	void delete(Integer hid);
	List<Hospital> findAll(PageBean pageBean);
	List<Hospital> findByName(PageBean pageBean,String hname);
	List<Hospital> findAll();
	Hospital findOne(Integer hid);
	List<Userinfo> findHospitalManager(Integer pid);
	

}
