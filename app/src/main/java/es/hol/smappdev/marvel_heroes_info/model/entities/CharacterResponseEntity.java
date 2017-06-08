package es.hol.smappdev.marvel_heroes_info.model.entities;


import com.google.gson.annotations.SerializedName;

public class CharacterResponseEntity {

    @SerializedName("data") CharacterDataEntity data;

    public CharacterDataEntity getData() {
        return data;
    }

    public void setData(CharacterDataEntity data) {
        this.data = data;
    }
}
