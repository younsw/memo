package com.younsw.Memo.post.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.younsw.Memo.common.FileManagerService;
import com.younsw.Memo.post.dao.PostDAO;
import com.younsw.Memo.post.model.Post;

@Service
public class PostBO {
	
	@Autowired
	private PostDAO postDAO;
	
	// userId, 제목, 이름 저장
	public int addPost(int userId, String title, String content, MultipartFile file) {
		
		// 파일을 저장한다 
		String imagePath = FileManagerService.saveFile(userId, file);
		
		// 해당 파일을 오비ㅜ에서 접근할 수 있는 경로를 만들어서 dao로 전달한다
		
		
		
		return postDAO.insertPost(userId, title, content, imagePath);
	}
	
	// userId가 일치하는 메모 리스트 조회
	public List<Post> getPostList(int userId) {
		return postDAO.selectPostList(userId);
	}
	
	public Post selectPost(int id) {
		return postDAO.selectPost(id);
	}

}
