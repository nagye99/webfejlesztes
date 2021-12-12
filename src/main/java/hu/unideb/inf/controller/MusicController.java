package hu.unideb.inf.controller;

import hu.unideb.inf.model.MusicDto;
import hu.unideb.inf.service.MusicService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("musicController")
@SessionScope
public class MusicController {
        @Autowired
        private MusicService musicService;

        private String actionLabel;
        private MusicDto musicDto;
        private List<MusicDto> musicDtoList;
        private List<String> categoryList;

        public void saveMusicInfo() {
            System.out.println(this.getMusicDto());
            musicService.addMusic(this.getMusicDto());
            getAllMusic();
            this.setMusicDto(new MusicDto());
        }

    public void updateMusicInfo() {
        System.out.println(this.getMusicDto());
        musicService.updateMusic(this.getMusicDto());
        getAllMusic();
        this.setMusicDto(new MusicDto());
    }

        @PostConstruct
        public void getAllMusic() {
            if (!this.getMusicDtoList().isEmpty()) {
                this.getMusicDtoList().clear();
                this.getCategoryList().clear();
            }
            this.getMusicDtoList().addAll(musicService.listMusics());
            ArrayList<String> categories =new ArrayList<String>();
            categories.add("pop");
            categories.add("rock");
            categories.add("metal");
            categories.add("jazz");
            categories.add("folk");
            this.getCategoryList().addAll(categories);
            this.setActionLabel("Add");
        }

        public void deleteMusic(MusicDto musicDto) {
            musicService.deleteMusic(musicDto);
            getAllMusic();
        }

        public void editMusic(MusicDto musicDto) {
            this.setActionLabel("Update");
            BeanUtils.copyProperties(musicDto, this.getMusicDto());
        }

        public MusicDto getMusicDto() {
            if (musicDto == null) {
                musicDto = new MusicDto();
            }
            return musicDto;
        }

        public void setMusicDto(MusicDto musicDto) {
            this.musicDto = musicDto;
        }

        public List<MusicDto> getMusicDtoList() {
            if (null == musicDtoList) {
                musicDtoList = new ArrayList<>();
            }
            return musicDtoList;
        }

        public String getActionLabel() {
            return actionLabel;
        }

        public void setActionLabel(String actionLabel) {
            this.actionLabel = actionLabel;
        }

    public List<String> getCategoryList() {
        if (categoryList == null) {
            categoryList = new ArrayList<>();
        }
        return categoryList;
    }
}
