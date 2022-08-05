package com.younsw.Memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.younsw.Memo.common.EncrypthUtils;
import com.younsw.Memo.user.dao.UserDAO;
import com.younsw.Memo.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int insertUser(String loginId, String password, String name, String email) {
		
		String encryptPassword = EncrypthUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	// 아이디롸 패스워드 전달 받고 일치하는 
	public User getUser(String loginId, String password) {
		
		String encryptPassword = EncrypthUtils.md5(password);
		
		return userDAO.selectUser(loginId, encryptPassword);
		
	}
	
}
