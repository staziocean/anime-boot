package fr.mds.animay.service;

import fr.mds.animay.model.Anime;
import fr.mds.animay.repository.AnimeRepository;
import org.springframework.stereotype.Service;

@Service
public class AnimeService extends GenericService<Anime, Long, AnimeRepository> {

    public AnimeService(AnimeRepository repository) {
        super(repository);
    }


}
