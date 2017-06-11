package org.thinkingingis.web.model;

import java.util.List;

import org.thinkingingis.web.jsonview.Views;

import com.fasterxml.jackson.annotation.JsonView;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;

	@JsonView(Views.Public.class)
	String code;

	@JsonView(Views.Public.class)
	User user;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
//	public List<User> getResult() {
//		return result;
//	}
//
//	public void setResult(List<User> result) {
//		this.result = result;
//	}
}
