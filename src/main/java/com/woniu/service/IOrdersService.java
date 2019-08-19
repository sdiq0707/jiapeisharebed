package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.woniu.entity.Orders;

public interface IOrdersService {
	void addOrders(Orders order);//增加订单
	List<Orders> findAll();//查询全部订单
	Orders findByCondition(Map map);//订单的条件查询，Map中存放的条件
	void deleteByID(Integer oid);//根据订单号删除订单，原怎上应该是软删除
	void update(Orders order);//修改订单，应该是修改订单的状态，其他类目应该不能修改的
}
