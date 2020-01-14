package com.sens.social.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TWEET")
public class TweetEntity {
    @Id
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String location;
    
    @ManyToOne(cascade = {
            CascadeType.ALL
    })
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @OneToMany(mappedBy = "tweet", cascade = CascadeType.ALL)
    private Set<TagEntity> tags;
}
