package fr.mds.animay.controller;

import fr.mds.animay.model.Anime;
import fr.mds.animay.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<Anime> findAll() {
        return animeService.findAll();
    }

    @GetMapping("{id}")
    public Anime findById(@PathVariable Long id) {
        return animeService.findById(id);
    }

    @PostMapping
    public Anime create(@RequestBody Anime anime) {
        return animeService.create(anime);
    }

    @PutMapping("{id}")
    public Anime update(@PathVariable Long id, @RequestBody Anime anime) {
        return animeService.update(id, anime);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        animeService.deleteById(id);
    }
}
