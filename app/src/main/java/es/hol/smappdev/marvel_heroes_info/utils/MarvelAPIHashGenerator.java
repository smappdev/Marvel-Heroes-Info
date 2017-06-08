package es.hol.smappdev.marvel_heroes_info.utils;


import es.hol.smappdev.marvel_heroes_info.config.MarvelApiKeys;

public class MarvelAPIHashGenerator {

    public static String newHash(String timeStamp) {
        String textToCypher = timeStamp + MarvelApiKeys.PRIVATE_KEY + MarvelApiKeys.PUBLIC_KEY;
        return MD5Generator.generateMD5(textToCypher);
    }

}
