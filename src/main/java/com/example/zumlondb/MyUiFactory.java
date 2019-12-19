package com.example.zumlondb;
import org.zkoss.zk.ui.http.SimpleUiFactory;
import org.zkoss.zk.ui.metainfo.PageDefinition;
import org.zkoss.zk.ui.sys.RequestInfo;

import com.example.zumlondb.service.ZulViewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyUiFactory extends SimpleUiFactory {
		
	@Override
	public PageDefinition getPageDefinition(RequestInfo ri, String path) {
		PageDefinition pgdef = super.getPageDefinition(ri, path);
		if (pgdef == null) {
			ZulViewService zulViewService = (ZulViewService)SpringContext.getAppContext().getBean("zulViewService");
			var optZul = zulViewService.findOne(path);
			if(optZul.isPresent()) {
				var zul = optZul.get();
				pgdef = getPageDefinitionDirectly(ri, zul.getZul(), "zul");
			} else {
				pgdef = getPageDefinitionDirectly(ri, "<zk><span>Page Not Found</span></zk>", "zul");
			}
		}
		log.info("path::{}::{}", path, pgdef.getRequestPath());
		return pgdef;
	}
}