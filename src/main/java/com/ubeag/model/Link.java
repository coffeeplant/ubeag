package com.ubeag.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;
    @Column(nullable = false)
    private String shortLink;
    @Column(nullable=false)
    private String longLink;

}
