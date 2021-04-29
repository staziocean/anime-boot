package fr.mds.animay.controller;

import fr.mds.animay.model.Anime;
import fr.mds.animay.service.AnimeService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('VIEW_ANIMES_LIST')")
    public List<Anime> findAll() {
        return animeService.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('VIEW_ANIMES_DETAILS')")
    public Anime findById(@PathVariable Long id) {
        return animeService.findById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Anime create(@RequestBody Anime anime) {
        return animeService.create(anime);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Anime update(@PathVariable Long id, @RequestBody Anime anime) {
        return animeService.update(id, anime);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        animeService.deleteById(id);
    }
}
