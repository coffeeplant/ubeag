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
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, name= "short_link")
    @EqualsAndHashCode.Include
    private String shortLink = "test";
    @Column(nullable = false, name= "long_link")
    @EqualsAndHashCode.Include
    private String longLink;

}
