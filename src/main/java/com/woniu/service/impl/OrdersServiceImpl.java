package com.woniu.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.woniu.entity.OrderSelect;
import com.woniu.entity.Orders;
import com.woniu.entity.OrdersExample;
import com.woniu.entity.OrdersExample.Criteria;
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
	public List<Orders> findAll(OrderSelect orderSelect) {
		//定义开始和结束的时间字段
		Date btime=null;
		Date etime=null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// TODO Auto-generated method stub
		OrdersExample example = new OrdersExample();
		Criteria criteria = example.createCriteria();
		//下面开始塞入查找的条件
		//根据订单号查找
		if(orderSelect.getOnum()!=null&&!"".equals(orderSelect.getOnum()))
			criteria.andOnumEqualTo(orderSelect.getOnum());
		//根据订单状态查找
		if(orderSelect.getStatus()!=null)
			criteria.andOrderstatusEqualTo(orderSelect.getStatus());
		//根据开始和结束的时间查找
		if(orderSelect.getBtime()==null||"".equals(orderSelect.getBtime())) {
			btime = new Date(0);
		}else {
			try {
				btime = sdf.parse(orderSelect.getBtime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(orderSelect.getEtime()==null||"".equals(orderSelect.getEtime())) {
			etime = new Date();
		}else {
			try {
				etime = sdf.parse(orderSelect.getBtime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		criteria.andOrdertimeBetween(btime, etime);
		
		//根据医院查找
		//criteria.andBidIn(values);
		//根据科室查找
		return ordersMapper.selectByExample(example);
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

	@Override
	public Orders findById(Integer oid) {
		// TODO Auto-generated method stub
		return ordersMapper.selectByPrimaryKey(oid);
	}

}
