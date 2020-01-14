package com.sens.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sens.social.entities.TagEntity;
import com.sens.social.model.TweetByTagByUserIdiomVO;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, String> {
    @Query("SELECT new com.sens.social.model.TweetByTagByUserIdiomVO(count(tag.tweet), tag.tweet.user.ScreenName,  tag.tag, tag.tweet.user.idiom, tag.tweet.user.location) " +
            "FROM TagEntity tag GROUP BY tag.tag, tag.tweet.user.ScreenName, tag.tweet.user.idiom, tag.tweet.user.location ORDER BY 1, tag.tag")
    public List<TweetByTagByUserIdiomVO> listTweetAmountByTagsByUser();
}