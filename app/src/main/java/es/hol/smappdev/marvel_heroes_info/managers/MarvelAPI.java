package es.hol.smappdev.marvel_heroes_info.managers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import java.util.UUID;

import es.hol.smappdev.marvel_heroes_info.adapter.HeroesAdapter;
import es.hol.smappdev.marvel_heroes_info.config.MarvelApiKeys;
import es.hol.smappdev.marvel_heroes_info.model.Hero;
import es.hol.smappdev.marvel_heroes_info.model.HeroesList;
import es.hol.smappdev.marvel_heroes_info.model.entities.CharacterResponseEntity;
import es.hol.smappdev.marvel_heroes_info.model.entities.CharacterResultsEntity;
import es.hol.smappdev.marvel_heroes_info.utils.MarvelAPIHashGenerator;

public class MarvelAPI {

    // https://gateway.marvel.com:443/v1/public/characters?apikey=a6db90ab56d48965159b1095a702d53b

    public static final String CHARACTERS_URL = "https://gateway.marvel.com:443/v1/public/characters?";

    String timeStamp = UUID.randomUUID().toString();
    String apiUrl = CHARACTERS_URL
            + "apikey=" + MarvelApiKeys.PUBLIC_KEY
            + "&ts=" + timeStamp
            + "&hash=" + MarvelAPIHashGenerator.newHash(timeStamp)
            + "&limit=100";
    HeroesList heroesList = new HeroesList();
    String offset = "&offset=0";
    String name = "";
    //
    HeroesAdapter adapter;

    public void getAllSuperHeroes(final Context context, final RecyclerView heroesRecyclerView){
        RequestQueue queue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(apiUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE", response);

                Reader reader = new StringReader(response);
                Gson gson = new GsonBuilder().create();

                CharacterResponseEntity characterResponse = gson.fromJson(reader, CharacterResponseEntity.class);
                List<CharacterResultsEntity> parseResult = characterResponse.getData().getResults();

                for (CharacterResultsEntity result : parseResult) {

                    Hero newHero = new Hero();

                    String heroName = result.getName();
                    if (result.getName().contains("(")){
                        String[] substring = result.getName().split("\\(");
                        heroName = substring[0];
                    }
                    newHero.setName(heroName);


                    if (result.getDescription().equals("")){
                        newHero.setDescription("No description available...");
                    }else {
                        newHero.setDescription(result.getDescription());
                    }
                    newHero.setThumbnail(result.getThumbnail().getPath() + "." + result.getThumbnail().getExtension());

                    heroesList.getHeroesList().add(newHero);
                    //System.out.println(newHero.getDescription());
                    //System.out.println(result.getThumbnail().getPath() + "." + result.getThumbnail().getExtension());
                }
                HeroesAdapter adapter = new HeroesAdapter(heroesList, context);
                int lastFirstVisiblePosition = ((LinearLayoutManager) heroesRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
                heroesRecyclerView.setAdapter(adapter);
                (heroesRecyclerView.getLayoutManager()).scrollToPosition(lastFirstVisiblePosition);
                //adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroesList getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(HeroesList characterList) {
        this.heroesList = characterList;
    }

    //

    public HeroesAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(HeroesList heroesList, Context context) {
        this.adapter = new HeroesAdapter(this.heroesList,context);
    }

    //


}
