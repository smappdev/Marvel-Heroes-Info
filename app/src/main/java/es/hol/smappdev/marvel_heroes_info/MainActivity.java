package es.hol.smappdev.marvel_heroes_info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import es.hol.smappdev.marvel_heroes_info.adapter.HeroesAdapter;
import es.hol.smappdev.marvel_heroes_info.model.Hero;
import es.hol.smappdev.marvel_heroes_info.model.HeroesList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView heroesRecyclerView;
    private HeroesAdapter heroesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heroesRecyclerView = (RecyclerView) this.findViewById(R.id.heroes_recyclerview);
        heroesRecyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(), 3));


        HeroesList myHeroesList = new HeroesList();

        for (int i = 0; i < 40; i++) {
            Hero myHero = new Hero();
            myHero.setName("Hero " + i);
            myHeroesList.getHeroesList().add(myHero);
            System.out.println(myHero.getName());
        }

        for (Hero hero:
             myHeroesList.getHeroesList()) {
            System.out.println(hero.getName());
        }

        heroesAdapter = new HeroesAdapter(myHeroesList, this);
        heroesRecyclerView.setAdapter(heroesAdapter);
    }
}
