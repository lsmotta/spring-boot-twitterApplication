package com.sens.social.resources;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sens.social.model.TweetByTagByUserIdiomVO;
import com.sens.social.repositories.TagRepository;

import java.util.List;

@RestController
public class TagResourceApi {

    @Autowired
    private TagRepository tagRepository;

    @ApiOperation(value = "Total de postagem agrupados por hora")
    @RequestMapping(value = "/twee-tag", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<TweetByTagByUserIdiomVO>> getTags() {
        List<TweetByTagByUserIdiomVO> tags = tagRepository.listTweetAmountByTagsByUser();
        return new ResponseEntity<List<TweetByTagByUserIdiomVO>>(tags, HttpStatus.OK);
    }

}
