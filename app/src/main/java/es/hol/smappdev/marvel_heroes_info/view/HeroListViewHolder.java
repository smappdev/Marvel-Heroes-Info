package es.hol.smappdev.marvel_heroes_info.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import es.hol.smappdev.marvel_heroes_info.R;


public class HeroListViewHolder extends RecyclerView.ViewHolder {

    private String heroName;
    private String heroThumbnail;

    private TextView heroNameText;
    private ImageView heroImageView;

    public HeroListViewHolder(View itemView) {
        super(itemView);

        heroNameText = (TextView) itemView.findViewById(R.id.hero_name);
        heroImageView = (ImageView) itemView.findViewById(R.id.hero_thumbnail);
    }

    public void setHeroName(String heroName) {
        this.heroNameText.setText(heroName);
    }

    public void setHeroThumbnail(String heroThumbnail) {
        this.heroThumbnail = heroThumbnail;
    }
}
