package hu.unideb.inf.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MusicDto {
    private Long id;
    private String title;
    private String artist;
    private String category;
    private Integer length;
}
