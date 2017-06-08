package es.hol.smappdev.marvel_heroes_info.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterDataEntity {

    @SerializedName("total") private int total;
    @SerializedName("results") private List<CharacterResultsEntity> results;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<CharacterResultsEntity> getResults() {
        return results;
    }

    public void setResults(List<CharacterResultsEntity> results) {
        this.results = results;
    }
}
