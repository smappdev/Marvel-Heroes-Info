package es.hol.smappdev.marvel_heroes_info.model;


import java.util.LinkedList;
import java.util.List;

public class HeroesList {

    private List<Hero> heroesList = new LinkedList<>();

    public List<Hero> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(List<Hero> heroesList) {
        this.heroesList = heroesList;
    }
}
