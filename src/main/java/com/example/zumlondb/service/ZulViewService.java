package com.example.zumlondb.service;

import java.util.Optional;

import com.example.zumlondb.model.ZulView;

public interface ZulViewService {
	Optional<ZulView> findOne(String page);
	ZulView save(ZulView home);
}
