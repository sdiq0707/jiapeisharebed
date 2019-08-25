package com.woniu.service;

import java.util.List;
import java.util.Map;

import com.woniu.entity.OrderSelect;
import com.woniu.entity.Orders;

public interface IOrdersService {
	void addOrders(Orders order);//增加订单
	List<Orders> findAll(OrderSelect orderSelect);//查询全部订单
	void deleteByID(Integer oid);//根据订单号删除订单，软删除
	void update(Orders order);//修改订单，应该是修改订单的状态，其他类目应该不能修改的
	Orders findById(Integer oid);
	void revokeByID(Integer oid);//根据订单号恢复被软删除的订单
}
