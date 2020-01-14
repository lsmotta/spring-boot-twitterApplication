package com.sens.social.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sens.social.entities.TweetEntity;
import com.sens.social.model.TweetCountByHourOfDayVO;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long> {
	@Query("SELECT new com.sens.social.model.TweetCountByHourOfDayVO(count (1), HOUR(t.createdAt)) FROM TweetEntity t GROUP BY HOUR(t.createdAt) ORDER BY HOUR(t.createdAt)")
	public List<TweetCountByHourOfDayVO> listTweetCountByHourOfDay();
}