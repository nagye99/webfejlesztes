package hu.unideb.inf.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String artist;
    private Integer length;
    private String category;

    public Music(String title, String artist, Integer length, String category) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.category = category;
    }
}
