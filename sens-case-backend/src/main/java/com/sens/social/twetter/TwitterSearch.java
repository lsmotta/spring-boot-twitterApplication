package com.sens.social.twetter;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilities class to capture Twitter posts
 * @author Ednei Parmigiani Júnior
 */
public class TwitterSearch implements Serializable {
    private Logger logger = LoggerFactory.getLogger(TwitterSearch.class);

    /**
     * Gets posts for multiple hashtags
     *
     * @param hashtags List of hashtag
     * @return List<Status>
     */
    public List<Status> getStatusByHashtags(List<String> hashtags) {
        List<Status> statuses = new ArrayList<Status>();
        for (String ht : hashtags) {
            if (StringUtils.isNotBlank(ht))
                statuses.addAll(getStatusByHashtag(ht));
        }

        return statuses;
    }

    /**
     * Gets the posts of a given hashtag
     *
     * @param ht hashtag for search
     * @return List<Status>
     */
    public List<Status> getStatusByHashtag(String ht) {
        List<Status> statuses = null;

        if (StringUtils.isBlank(ht))
            throw new RuntimeException("hashtag can not by empty");

        logger.info(String.format("fetching posts to hashtag [%s]", ht));
        try {
            QueryResult queryResult = getTwitterConfiguration().search(new Query(ht));
            statuses = queryResult.getTweets();
        } catch (TwitterException e) {
            logger.error(String.format("error fetching posts to hashtag [%s]", ht), e);
        }

        return statuses;
    }

    /**
     * Get Twitter Configuration
     *
     * @return Twitter
     */
    private Twitter getTwitterConfiguration() {
        ConfigurationBuilder cb = new ConfigurationBuilder()
                .setDebugEnabled(true)
                .setOAuthConsumerKey("EACUFJQ17VqtBYvBn7A9XPOVu")
                .setOAuthConsumerSecret("BiQuFFO9ExD8PPM6SxBOfAwyKj3iWt2n2tIKnoaghLTghV0i80")
                .setOAuthAccessToken("1084119416336510978-UaW8A5XWUHzdONNDJQA4f6DioYQ1uR")
                .setOAuthAccessTokenSecret("d0cfneMgq76IHGIFUxmV91WnVUPEq1qwwESaNqaSnpzZm");

        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        Twitter twitter = twitterFactory.getInstance();

        return twitter;
    }

}
