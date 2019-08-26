package com.woniu.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.data.domain.Page;

import com.woniu.entity.Bed;
import com.woniu.entity.PageBean;
import com.woniu.entity.Trouble;
import com.woniu.entity.TroubleSearchExample;

public interface ITroubleService {
	public List findAll(PageBean pb);
	public List search(TroubleSearchExample example);
	public void save(Trouble trouble);
	public void delete(Integer tid);
	public void revoke(Integer tid);
	public Trouble findById(Integer tid);
	public void update(Trouble trouble);
}
