package com.example.within_back.dto;

import com.example.within_back.entity.Board;
import com.example.within_back.entity.Post;
import com.example.within_back.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostReqDto {
    private String title;
    private String content;

        public Post toEntity(Board board,User author){
            return new Post(board, author,title,content);
        }
    }
