package com.example.within_back.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "post_id")
    @ManyToOne
    private Post post;

    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"myPosts"})
    @ManyToOne
    private User user;

    @Builder
    public Likes(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}
