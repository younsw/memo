package com.younsw.Memo.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.younsw.Memo.post.bo.PostBO;
import com.younsw.Memo.post.model.Post;

@Controller
public class PostController {
	
	@Autowired
	private PostBO postBO;
	
	@GetMapping("post/list/view")
	public String postList(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		
		// 로그인한 사용자의 userId
		int userId = (Integer)session.getAttribute("userId");
		
		List<Post> postList = postBO.getPostList(userId);
		model.addAttribute("memoList", postList);
		
		return "post/list";
	}
	
	// 메모 입력 페이지
	@GetMapping("/post/creat/view")
	public String postInput() {
		
		return "post/create";
		
	}
	
	// 메모 세부 페이지
	@GetMapping("/post/detail/view")
	public String postDeatil(@RequestParam("id") int id, Model model) {
		
		Post post = postBO.selectPost(id);
		
		model.addAttribute("memo", post);
		
		return "post/detail";
	}

}
