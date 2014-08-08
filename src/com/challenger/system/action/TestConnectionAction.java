package com.challenger.system.action;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.challenger.system.entity.Test;
import com.challenger.system.services.TestConnectionService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class TestConnectionAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8286676643856005055L;
	private TestConnectionService testConnectionService;
	static Logger logger = Logger.getLogger(TestConnectionAction.class);
	public String testConnection()
	{
		Test test = new Test();
		String clientIp = ServletActionContext.getRequest().getRemoteAddr();
		test.setClientIp(clientIp);
		Timestamp insertTm = new Timestamp(System.currentTimeMillis());
		test.setInsertTm(insertTm);
		testConnectionService.insertTest(test);
		logger.info("测试成功！" + clientIp + "时间：" + insertTm);
		return Action.SUCCESS;
	}

	public TestConnectionService getTestConnectionService() {
		return testConnectionService;
	}

	public void setTestConnectionService(TestConnectionService testConnectionService) {
		this.testConnectionService = testConnectionService;
	}

}
