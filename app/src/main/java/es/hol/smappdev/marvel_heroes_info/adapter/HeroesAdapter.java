package es.hol.smappdev.marvel_heroes_info.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.hol.smappdev.marvel_heroes_info.R;
import es.hol.smappdev.marvel_heroes_info.model.Hero;
import es.hol.smappdev.marvel_heroes_info.model.HeroesList;
import es.hol.smappdev.marvel_heroes_info.view.HeroListViewHolder;


public class HeroesAdapter extends RecyclerView.Adapter<HeroListViewHolder> {

    private HeroesList heroes;
    private LayoutInflater layoutInflater;

    public HeroesAdapter(HeroesList heroesList, Context context) {
        this.heroes = heroesList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public HeroListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hero_row, parent, false);
        return new HeroListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroListViewHolder holder, int position) {
        Hero hero = heroes.getHeroesList().get(position);
        holder.setHeroName(hero.getName());
        holder.setHeroThumbnail(hero.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return heroes.getHeroesList().size();
    }
}
