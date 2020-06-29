package com.woo.study.springboot.web;

import com.woo.study.springboot.config.auth.LoginUser;
import com.woo.study.springboot.config.auth.dto.SessionUser;
import com.woo.study.springboot.service.posts.PostsService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser sessionUser){
        model.addAttribute("posts", postsService.findAllDesc());
        if(sessionUser != null){
            model.addAttribute("userName", sessionUser.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String posts(@PathVariable Long id, Model model){
        model.addAttribute("id", id);
        model.addAttribute("post",postsService.findById(id));
        return "posts-update";
    }
}
