package com.sens.social.resources;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sens.social.model.TweetCountByHourOfDayVO;
import com.sens.social.repositories.TweetRepository;

import java.util.List;

@RestController
public class TweetResourceApi {

    @Autowired
    private TweetRepository tweetRepository;

    @ApiOperation(value = "Retorna a quantidade de Postagens por Hora do dia")
    @RequestMapping(value = "/tweet-group-hours", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TweetCountByHourOfDayVO>> getTweetCountByHourOfDay() {
        List<TweetCountByHourOfDayVO> tweets = tweetRepository.listTweetCountByHourOfDay();
        return new ResponseEntity<List<TweetCountByHourOfDayVO>>(tweets, HttpStatus.OK);
    }

}
