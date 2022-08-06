package com.example.within_back.controller;

import com.example.within_back.dto.BoardResDto;
import com.example.within_back.dto.PostReqDto;
import com.example.within_back.dto.PostResDto;
import com.example.within_back.service.PostService;
import com.example.within_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;
    UserService userService;

    @RequestMapping(value="/{userId}/boards", method= RequestMethod.GET)
    public ArrayList<BoardResDto> getMyBoard(@PathVariable Long userId) throws Exception {
        return userService.getMyBoard(userId);

    } //내 게시판 조회

    @RequestMapping(value="/boards/{category}", method=RequestMethod.GET)
    public ArrayList<PostResDto> getPosts(@PathVariable String category){
        return PostService.getPosts(category);
    }
    //게시판 게시물 조회 (GET 방식)


//    @RequestMapping(value="/boards/{category}", method=RequestMethod.POST)
//    public Long postWrite(@RequestBody PostResDto postResDto, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
//        postService.postWrite(postResDto,multipartHttpServletRequest);
//        return
//    } //게시물 작성 (POST 방식)

    @RequestMapping(value="/boards/{category}", method=RequestMethod.POST)
    public Long save(@RequestBody PostReqDto postResDto, @PathVariable String category){
        return postService.save(postResDto,category);
    } //게시물 작성 (POST 방식)



    @RequestMapping(value="/boards/{postId}", method=RequestMethod.GET)
    public PostResDto findById(@PathVariable Long postId){
        return postService.findById(postId);
    } //게시글 조회
}





