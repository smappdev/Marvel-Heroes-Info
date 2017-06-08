package es.hol.smappdev.marvel_heroes_info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.hol.smappdev.marvel_heroes_info.R;
import es.hol.smappdev.marvel_heroes_info.adapter.HeroesAdapter;
import es.hol.smappdev.marvel_heroes_info.managers.EndlessRecyclerViewScrollListener;
import es.hol.smappdev.marvel_heroes_info.managers.MarvelAPI;
import es.hol.smappdev.marvel_heroes_info.model.HeroesList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroListFragment extends Fragment {

    private RecyclerView heroesRecyclerView;
    private HeroesAdapter heroesAdapter;
    final MarvelAPI m = new MarvelAPI();
    private EndlessRecyclerViewScrollListener scrollListener;

    public HeroListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_list, container, false);

        heroesRecyclerView = (RecyclerView) view.findViewById(R.id.heroes_recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(view.getContext(), 3);
        heroesRecyclerView.setLayoutManager(gridLayoutManager);

        final HeroesList myHeroesList = new HeroesList();


        m.setAdapter(myHeroesList, getContext());
        m.getAllSuperHeroes(view.getContext(), heroesRecyclerView);

        scrollListener = new EndlessRecyclerViewScrollListener(gridLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadNextDataDromApi(page, m);
            }
        };
        heroesRecyclerView.addOnScrollListener(scrollListener);

        setHasOptionsMenu(true);


        return view;
    }

    private void loadNextDataDromApi(int page, MarvelAPI m) {
        if (m.getName().equals("")) {

            m.setOffset("&offset=" + (page * 100));
            String newURL = m.getApiUrl().replaceFirst("(.*)&offset=(.*)", "");
            m.setApiUrl(newURL + m.getOffset());
            m.getAllSuperHeroes(getContext(), heroesRecyclerView);
            m.setApiUrl(newURL);
        }else{
            return;
        }
    }
}
