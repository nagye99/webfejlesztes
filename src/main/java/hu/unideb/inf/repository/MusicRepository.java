package hu.unideb.inf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import hu.unideb.inf.entity.Music;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    Optional<Music> findById(Long id);

    List<Music> findAll();

    @Transactional
    void deleteById(Long id);
}
