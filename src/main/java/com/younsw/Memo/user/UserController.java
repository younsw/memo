package com.younsw.Memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	
	@GetMapping("/user/singup/view")
	public String singupView() {
		return "user/singup"; 
	}

}
