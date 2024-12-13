package com.example.crudapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.example.crudapp.model.Juego;
import com.example.crudapp.repository.JuegoRepository;

@RestController
@RequestMapping("api/juegos")
public class JuegoController {

    @Autowired
    private JuegoRepository juegoRepository;

    // Get all games
    @GetMapping
    public List<Juego> getAllJuegos() {
        return juegoRepository.findAll();
    }

    // Get a game by ID
    @GetMapping("/{id}")
    public Optional<Juego> getJuegoById(@PathVariable int id) {
        return juegoRepository.findById(id);
    }

    // Create a new game
    @PostMapping
    public Juego createJuego(@RequestBody Juego juego) {
        return juegoRepository.save(juego);
    }

    // Update an existing game
    @PutMapping("/{id}")
    public Juego updateJuego(@PathVariable int id, @RequestBody Juego juegoDetails) {
        return juegoRepository.findById(id).map(juego -> {
            juego.setGameName(juegoDetails.getGameName());
            juego.setPrice(juegoDetails.getPrice());
            juego.setReleaseDate(juegoDetails.getReleaseDate());
            return juegoRepository.save(juego);
        }).orElseThrow(() -> new RuntimeException("Juego not found with id " + id));
    }

    // Delete a game
    @DeleteMapping("/{id}")
    public void deleteJuego(@PathVariable int id) {
        juegoRepository.deleteById(id);
    }
}