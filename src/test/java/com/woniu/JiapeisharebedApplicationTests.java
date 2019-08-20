package com.woniu;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.woniu.entity.Hospital;
import com.woniu.mapper.HospitalMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiapeisharebedApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Resource
	private HospitalMapper hm;

	@Test
	public void testName() throws Exception {
		List<Hospital> list = hm.selectByExample(null);
		System.out.println(list);
	}
}
