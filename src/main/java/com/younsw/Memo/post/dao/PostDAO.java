package com.younsw.Memo.post.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.younsw.Memo.post.model.Post;

@Repository
public interface PostDAO {
	
	public int insertPost(
			@Param("userId") int post
			, @Param("title") String title
			, @Param("content") String content
			, @Param("image") String image);
	
	public List<Post> selectPostList(
			@Param("userId") int userId);
	
	public Post selectPost(@Param("id") int id);

}
