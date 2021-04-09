package fr.mds.animay.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Anime implements IdEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String studio;

    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private Season season;

    private Integer numberOfEpisodes;

}
