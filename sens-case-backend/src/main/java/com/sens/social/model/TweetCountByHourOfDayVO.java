package com.sens.social.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
public class TweetCountByHourOfDayVO {
    private Long amount;
    private String date;

    public TweetCountByHourOfDayVO(Long amount, String dataFormated) {
        this.amount = amount;
        this.date = dataFormated;
    }

    public TweetCountByHourOfDayVO(Long amount, Integer hour) {
        this.amount = amount;
        this.date = String.format("%sh", hour);
    }
}
