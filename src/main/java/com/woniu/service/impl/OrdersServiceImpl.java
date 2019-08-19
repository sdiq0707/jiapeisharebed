package com.woniu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.Orders;
import com.woniu.mapper.OrdersMapper;
import com.woniu.service.IOrdersService;
@Service
public class OrdersServiceImpl implements IOrdersService {
	@Resource
	private OrdersMapper ordersMapper;
	@Override
	public void addOrders(Orders order) {
		// TODO Auto-generated method stub
		ordersMapper.insert(order);
	}

	@Override
	public List<Orders> findAll() {
		// TODO Auto-generated method stub
		return ordersMapper.selectByExample(null);
	}

	@Override
	public Orders findByCondition(Map map) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public void deleteByID(Integer oid) {
		// TODO Auto-generated method stub
		Orders orders=ordersMapper.selectByPrimaryKey(oid);//软删除，把isdelete设置为1
		orders.setIsdelete(1);
		ordersMapper.updateByPrimaryKey(orders);
	}

	@Override
	public void update(Orders order) {
		// TODO Auto-generated method stub
		ordersMapper.updateByPrimaryKey(order);
	}

}
