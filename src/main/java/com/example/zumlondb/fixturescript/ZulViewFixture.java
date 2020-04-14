package com.example.zumlondb.fixturescript;

import javax.annotation.Priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.zumlondb.model.ZulView;
import com.example.zumlondb.service.ZulViewService;

@Component
@Priority(1)
public class ZulViewFixture implements ApplicationRunner{

	@Autowired
	ZulViewService zulViewService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		var menu ="<n:ul><n:li><a href='./home'>Home</a></n:li><n:li><a href='./page'>Other Page</a></n:li></n:ul>";
		var home = new ZulView();
		home.setPath("/zul/home.zul");
		home.setZul("<zk xmlns:n='native'>"+menu+"<span>Welcome Home</span></zk>");
		zulViewService.save(home);
		
		var page = new ZulView();
		page.setPath("/zul/page.zul");
		page.setZul("<zk xmlns:n='native'>"+menu+"<span>Other Page</span></zk>");
		zulViewService.save(page);
		
	}

}
