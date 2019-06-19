package com.example.post.controller;

import com.example.post.service.PostService;
import com.example.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class PostController {
	@Autowired
	private PostService guestBookService;
	
	@GetMapping(value="/list")
	public ModelAndView list(Model model) {
		List<Post> list = guestBookService.getList();
		model.addAttribute("list", list);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value="/post", method= RequestMethod.POST)
	public ModelAndView insert(Post vo) {
		guestBookService.insert(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public ModelAndView delete(Post vo) {
		guestBookService.delete(vo);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
}