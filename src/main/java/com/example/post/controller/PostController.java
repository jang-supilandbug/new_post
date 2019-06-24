package com.example.post.controller;

import com.example.post.service.PostService;
import com.example.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
	@Autowired
	private PostService postService;
	
	@GetMapping(value="/list")
	public ModelAndView list() {
		List<Post> list = postService.getList();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("list", list);

		return mav;
	}
	
	
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ModelAndView insert(Post vo) {
		postService.insert(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value="/del", method= RequestMethod.GET)
	public ModelAndView delete(Post vo) {
		postService.delete(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}
