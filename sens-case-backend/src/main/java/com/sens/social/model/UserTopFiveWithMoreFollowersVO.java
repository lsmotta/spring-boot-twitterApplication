package com.sens.social.model;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class UserTopFiveWithMoreFollowersVO {
    private Long id;
    private String screenName;
    private Long followers;
}
