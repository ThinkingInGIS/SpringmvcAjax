package org.thinkingingis.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thinkingingis.web.jsonview.Views;
import org.thinkingingis.web.model.AjaxResponseBody;
import org.thinkingingis.web.model.SearchCriteria;
import org.thinkingingis.web.model.User;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("search")
public class AjaxController {

	List<User> users;

	// @ResponseBody, not necessary, since class is annotated with
	// @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped
	// by field name.
	// @JsonView(Views.Public.class) - Optional, filters json data to display.
	@JsonView(Views.Public.class)
	@RequestMapping("getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();

		if (isValidSearchCriteria(search)) {
//			System.out.println(search.getUsername());
//			System.out.println(search.getEmail());
			User user = findByUserNameOrEmail(search.getUsername(),
					search.getEmail());
			if (user != null) {
				result.setCode("200");
				result.setMsg("Found the user!");
				result.setUser(user);
			} else {
				result.setCode("204");
				result.setMsg("No user!");
			}

		} else {
			result.setCode("400");
			result.setMsg("Search criteria is empty!");
		}

		// AjaxResponseBody will be converted into json format and send back to
		// the request.
		return result;

	}

	private boolean isValidSearchCriteria(SearchCriteria search) {

		boolean valid = true;

		if (search == null) {
			valid = false;
		}

		if ((StringUtils.isEmpty(search.getUsername()))
				&& (StringUtils.isEmpty(search.getEmail()))) {
			valid = false;
		}

		return valid;
	}

	private User findByUserNameOrEmail(String username, String email) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = null;
		User user = new User();
		session = factory.openSession();
		if (username != "" && email == "") {
			session.beginTransaction();
			String hql = " from User where username=?";
			Query query = session.createQuery(hql);
			query.setString(0, username);
			ArrayList<User> list = ((ArrayList<User>) query.list());
			if(list.size()>0){
				user = list.get(0);
				return user;
			}
		} else if (email != "") {
			session.beginTransaction();
			String hql = " from User where email=?";
			Query query = session.createQuery(hql);
			query.setString(0, email);
			ArrayList<User> list = ((ArrayList<User>) query.list());
			if(list.size()>0){
				user = list.get(0);
				return user;
			}
		}
//		session.close();
		return null;
	}
}
