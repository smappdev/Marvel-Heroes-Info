package es.hol.smappdev.marvel_heroes_info.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.hol.smappdev.marvel_heroes_info.R;
import es.hol.smappdev.marvel_heroes_info.model.Hero;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeroDetailFragment extends Fragment {

    private TextView heroDetailName;
    private TextView heroDetailDescription;
    private ImageView heroDetailImage;

    public HeroDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hero_detail, container, false);

        heroDetailName = (TextView) view.findViewById(R.id.hero_detail_name);
        heroDetailDescription = (TextView) view.findViewById(R.id.hero_detail_description);
        heroDetailImage = (ImageView) view.findViewById(R.id.hero_detail_image);

        Bundle data = getArguments();
        Hero selectedHero = (Hero) data.getSerializable("HERO");
        heroDetailName.setText(selectedHero.getName());
        heroDetailDescription.setText(selectedHero.getDescription());
        Picasso.with(view.getContext()).load(selectedHero.getThumbnail()).into(heroDetailImage);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_out, android.R.anim.fade_in);

        ft.replace(R.id.hero_detail_fragment, this);
        ft.commit();



        return view;
    }

}
