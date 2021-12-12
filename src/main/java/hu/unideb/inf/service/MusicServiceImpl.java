package hu.unideb.inf.service;

import hu.unideb.inf.entity.Music;
import hu.unideb.inf.model.MusicDto;
import hu.unideb.inf.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public void addMusic(MusicDto musicDto){
        Music music = dtoToEntity(musicDto);
        music = musicRepository.save(music);
    }

    @Override
    public void updateMusic(MusicDto musicDto){
        Optional<Music> musicOptional = musicRepository.findById(musicDto.getId());
        if(musicOptional.isPresent()){
            Music music = musicOptional.get();
            music.setTitle(musicDto.getTitle());
            music.setArtist(musicDto.getArtist());
            music.setCategory(musicDto.getCategory());
            music.setLength(musicDto.getLength());
            musicRepository.save(music);
        }
    }

    @Override
    public void deleteMusic(MusicDto musicDto) {
        musicRepository.deleteById(musicDto.getId());
    }

    @Override
    public List<MusicDto> listMusics(){
        List<Music> musicList = musicRepository.findAll();
        return musicList.stream().map(this::entityToDto).collect(Collectors.toList());
    }



    private Music dtoToEntity(MusicDto musicDto){
        Music music = Music.builder().title(musicDto.getTitle()).artist(musicDto.getArtist()).category(musicDto.getCategory()).length(musicDto.getLength()).build();
        return music;
    }

    private MusicDto entityToDto(Music music){
        MusicDto musicDto = MusicDto.builder().id(music.getId()).title(music.getTitle()).artist(music.getArtist()).category(music.getCategory()).length(music.getLength()).build();
        return musicDto;
    }
}
