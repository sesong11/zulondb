package com.example.zumlondb.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zumlondb.model.ZulView;
import com.example.zumlondb.repository.ZulViewRepository;
import com.example.zumlondb.service.ZulViewService;

@Service("zulViewService")
public class ZulViewServiceImpl implements ZulViewService{

	@Autowired
	ZulViewRepository repo;
	
	@Override
	public Optional<ZulView> findOne(String path) {
		return repo.findByPath(path);
	}

	@Override
	public ZulView save(ZulView entity) {
		return repo.save(entity);
	}

}
