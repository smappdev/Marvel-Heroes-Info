package es.hol.smappdev.marvel_heroes_info.model.entities;

import com.google.gson.annotations.SerializedName;


public class CharacterResultsEntity {

    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("description") private String description;
    @SerializedName("thumbnail") private CharacterThumbnailEntity thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CharacterThumbnailEntity getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(CharacterThumbnailEntity thumbnail) {
        this.thumbnail = thumbnail;
    }
}
