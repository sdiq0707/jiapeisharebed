package com.woniu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.woniu.entity.Hospital;
import com.woniu.entity.PageBean;
import com.woniu.entity.Trouble;
import com.woniu.mapper.TroubleMapper;
import com.woniu.service.ITroubleService;

@Service
public class TroubleServiceImpl implements ITroubleService {
	@Resource
	private TroubleMapper mapper;

	@Override
	public List findAll(PageBean pb) {
		List<Trouble> list = mapper.selectByExample(null,new RowBounds(pb.getOffset(),pb.getLimit()));
		int count=mapper.countByExample(null);
		pb.setCount(count);
		return list;
	}

	@Override
	public void save(Trouble trouble) {
		trouble.setTstatus(true);
		trouble.setIsdelete(0);
		trouble.setIsdeclare(true);
		trouble.setTdeclaretime(new Date());
		mapper.insertSelective(trouble);
	}

	@Override
	public void delete(Integer tid) {
		Trouble trouble = mapper.selectByPrimaryKey(tid);
		trouble.setIsdelete(1);
		mapper.updateByPrimaryKeySelective(trouble);
		
	}

	@Override
	public void revoke(Integer tid) {
		Trouble trouble = mapper.selectByPrimaryKey(tid);
		trouble.setIsdelete(0);
		mapper.updateByPrimaryKeySelective(trouble);
		
	}

	@Override
	public Trouble findById(Integer tid) {
		return mapper.selectByPrimaryKey(tid);
	}

	@Override
	public void update(Trouble trouble) {
		mapper.updateByPrimaryKey(trouble);
	}


}
