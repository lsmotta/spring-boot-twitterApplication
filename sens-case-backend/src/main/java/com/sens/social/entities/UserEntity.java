package com.sens.social.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class UserEntity {

    @Id
    private Long id;
    private String ScreenName;
    private Long followers;
    private String idiom;

    private String location;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TweetEntity> tweets;
}