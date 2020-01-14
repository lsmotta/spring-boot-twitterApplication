package com.sens.social.model;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import com.sens.social.resources.TagResourceApi;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class TweetByTagByUserIdiomVO extends ResourceSupport {
    private Long tweets;
    private String ScreenName;
    private String hastTag;
    private String idiom;
    private String location;

    
    public TweetByTagByUserIdiomVO(Long tweets, String ScreenName, String hastTag, String idiom, String location) {
        this.tweets = tweets;
        this.ScreenName = ScreenName;
        this.hastTag = String.format("#%s", hastTag);
        this.idiom = idiom;
        this.location = location;

        
    }
}
