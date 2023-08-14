package ru.netology.afisha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmManagerTest {

    @Test
    public void shouldShowIfEmpty() {
        FilmManager manager = new FilmManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewFilm() {
        FilmManager manager = new FilmManager();

        manager.addNewFilm("Film1");
        manager.addNewFilm("Film2");

        String[] expected = {"Film1", "Film2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastAddedUnderLimit() {
        FilmManager manager = new FilmManager(3);

        manager.addNewFilm("Film1");
        manager.addNewFilm("Film2");


        String[] expected = {"Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastAddedEqualsLimit() {
        FilmManager manager = new FilmManager(3);

        manager.addNewFilm("Film1");
        manager.addNewFilm("Film2");
        manager.addNewFilm("Film3");


        String[] expected = {"Film3", "Film2", "Film1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowLastAddedOverLimit() {
        FilmManager manager = new FilmManager(3);

        manager.addNewFilm("Film1");
        manager.addNewFilm("Film2");
        manager.addNewFilm("Film3");
        manager.addNewFilm("Film4");
        manager.addNewFilm("Film5");


        String[] expected = {"Film5", "Film4", "Film3"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }


}
