package es.hol.smappdev.marvel_heroes_info.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.hol.smappdev.marvel_heroes_info.MainActivity;
import es.hol.smappdev.marvel_heroes_info.R;
import es.hol.smappdev.marvel_heroes_info.fragments.HeroDetailFragment;
import es.hol.smappdev.marvel_heroes_info.model.Hero;
import es.hol.smappdev.marvel_heroes_info.model.HeroesList;
import es.hol.smappdev.marvel_heroes_info.view.HeroListViewHolder;


public class HeroesAdapter extends RecyclerView.Adapter<HeroListViewHolder> {

    private View view;
    private HeroesList heroes;
    private LayoutInflater layoutInflater;


    public HeroesAdapter(HeroesList heroesList, Context context) {
        this.heroes = heroesList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public HeroListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = layoutInflater.inflate(R.layout.hero_row, parent, false);
        return new HeroListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroListViewHolder holder, int position) {
        final Hero hero = heroes.getHeroesList().get(position);
        holder.setHeroName(hero.getName());
        holder.setHeroThumbnail(hero.getThumbnail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentJump(hero);
            }
        });
    }

    @Override
    public int getItemCount() {
        return heroes.getHeroesList().size();
    }

    private void fragmentJump(Hero heroSelected) {
        Fragment mFragment = new HeroDetailFragment();
        Bundle data = new Bundle();
        data.putSerializable("HERO", heroSelected);
        mFragment.setArguments(data);
        switchContent(R.id.hero_detail_fragment, mFragment);
    }

    public void switchContent(int id, Fragment fragment) {
        MainActivity mainActivity = (MainActivity) view.getContext();
        mainActivity.switchContent(id, fragment);
    }
}
