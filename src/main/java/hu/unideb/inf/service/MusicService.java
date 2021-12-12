package hu.unideb.inf.service;


import hu.unideb.inf.model.MusicDto;

import java.util.List;

public interface MusicService {

    void addMusic(MusicDto musicDto);

    void updateMusic(MusicDto musicDto);

    void deleteMusic(MusicDto musicDto);

    List<MusicDto> listMusics();
}
