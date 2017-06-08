package es.hol.smappdev.marvel_heroes_info.model.entities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Saul on 03/02/2017.
 */
public class CharacterThumbnailEntity {

    @SerializedName("path") private String path;
    @SerializedName("extension") private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
