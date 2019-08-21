package com.woniu.service;

import java.util.List;

import com.woniu.entity.Hospital;

public interface IHospitalService {
	void save(Hospital hospital);
	void update(Hospital hospital);
	void delete(Integer hid);
	List<Hospital> findAll();
	Hospital findOne(Integer hid);

}
