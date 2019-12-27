package com.example.zumlondb.vm;

import java.util.HashMap;

import javax.servlet.ServletRequest;

import org.springframework.web.servlet.HandlerMapping;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Notification;

import lombok.Getter;

public class MainVM {
	
	@Getter
	private String page;
	
	@Init
	public void init() {
		ServletRequest request = (ServletRequest) Executions.getCurrent().getNativeRequest();
		HashMap<?, ?> pathVariables = (HashMap<?, ?>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		String page = (String) pathVariables.get("page");
		this.page = page+".zul";
		Notification.show("Say Hello!!!", "warning", null, "middle_center", 0);
	}

}
