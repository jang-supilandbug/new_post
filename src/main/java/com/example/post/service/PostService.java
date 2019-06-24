package com.example.post.service;

import com.example.post.mapper.PostMapper;
import com.example.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
	@Autowired
	private PostMapper mapper;

	public List<Post> getList(){
		return mapper.getList();
	}
	
	public boolean insert(Post vo ) {
		return mapper.insert(vo);
	}
	
	public boolean delete(Post vo) {
		return mapper.delete(vo.getIdx());
	}
}

