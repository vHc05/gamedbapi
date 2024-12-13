package com.example.crudapp.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gameid;

    @Column(name = "game_name", nullable = false)
    private String gameName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "release_date", nullable = false)
    private LocalDateTime releaseDate;

    // Getters and Setters

    public int getGameid() {
        return gameid;
    }

    public void setGameid(int gameid) {
        this.gameid = gameid;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }
}