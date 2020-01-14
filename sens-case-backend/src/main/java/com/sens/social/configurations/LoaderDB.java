package com.sens.social.configurations;



import com.sens.social.entities.TagEntity;
import com.sens.social.entities.TweetEntity;
import com.sens.social.entities.UserEntity;
import com.sens.social.repositories.TagRepository;
import com.sens.social.repositories.TweetRepository;
import com.sens.social.twetter.TwitterSearch;
import twitter4j.Status;

import twitter4j.HashtagEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class LoaderDB {
    private Logger logger = LoggerFactory.getLogger(TwitterSearch.class);

    @Bean
    public CommandLineRunner initDatabase(TweetRepository tweetRepository, TagRepository tagRepository) {
        return args -> {
            List<String> hashs = new ArrayList<String>();
            hashs.add("#openbanking");
            hashs.add("#apifirst");
            hashs.add("#devops");
            hashs.add("#cloudfirst");
            hashs.add("#microservices");
            hashs.add("#apigateway");
            hashs.add("#oauth");
            hashs.add("#swagger");
            hashs.add("#raml");
            hashs.add("#openapis");

            TwitterSearch twitterSearch = new TwitterSearch();
            List<Status> statuses = twitterSearch.getStatusByHashtags(hashs);

            logger.info("Loader start");

            for (Status s : statuses) {
                TweetEntity tweet = new TweetEntity();
                tweet.setId(s.getId());
                tweet.setCreatedAt(s.getCreatedAt());
                tweet.setUser(new UserEntity(s.getUser().getId(), String.format("@%s", s.getUser().getScreenName()), Long.valueOf(s.getUser().getFollowersCount()), s.getLang(), s.getUser().getLocation(), null));
                tweetRepository.save(tweet);

                HashtagEntity tags[] = s.getHashtagEntities();
                Arrays.stream(tags).filter(x -> hashs.contains("#" + x.getText().toLowerCase())).forEach(h -> {
                            TagEntity tagEntity = new TagEntity();
                            tagEntity.setId(1234l);
                            tagEntity.setTag(h.getText().toLowerCase());
                            tagEntity.setTweet(tweet);
                            tagRepository.save(tagEntity);
                        }
                );

            }
            logger.info("Loader finish");
        };
    }

}
