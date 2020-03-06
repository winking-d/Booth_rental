package com.irs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irs.mapper.MainMapper;
import com.irs.mapper.TbUsersMapper;
import com.irs.pojo.TbUsers;
import com.irs.pojo.TbUsersExample;
import com.irs.pojo.TbUsersExample.Criteria;
import com.irs.service.MainService;
@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private TbUsersMapper tbUsersMapper;
	
	@Autowired
	private MainMapper mainMapper;

	@Override
	public List<TbUsers> selUserList() {
		TbUsersExample example=new TbUsersExample();
		return tbUsersMapper.selectByExample(example);
	}
	
	@Override
	public List<TbUsers> selUsersToday() {
		return mainMapper.selUsersToday();
	}

	@Override
	public List<TbUsers> selUsersYestoday() {
		return mainMapper.selUsersYesterday();
	}


	@Override
	public List<TbUsers> selUsersYearWeek() {
		// TODO Auto-generated method stub
		return mainMapper.selUsersYearWeek();
	}
	
	@Override
	public List<TbUsers> selUsersMonth() {
		// TODO Auto-generated method stub
		return mainMapper.selUsersMonth();
	}

	@Override
	public int seUserCountBygender(int i) {
		// TODO Auto-generated method stub
		TbUsersExample example=new TbUsersExample();
		Criteria criteria = example.createCriteria();
		criteria.andSexEqualTo(i+"");
		List<TbUsers> list = tbUsersMapper.selectByExample(example);
		return list.size();
	}

}
