package com.woniu.service;

import com.woniu.entity.Hospital;

public interface IHospitalService {
	void save(Hospital hospital);
	void update(Hospital hospital);
	void delete(Integer hid);
	void findAll();
	void findOne(Integer hid);

}
