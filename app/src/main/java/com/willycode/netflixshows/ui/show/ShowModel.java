package com.willycode.netflixshows.ui.show;

import com.willycode.netflixshows.App;
import com.willycode.netflixshows.R;
import com.willycode.netflixshows.domain.entity.TvShow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public class ShowModel implements Show.Model{

    List<TvShow> localList =new ArrayList<TvShow>();
    private static ShowModel instance = null;
    protected ShowModel() {
        // Exists only to defeat instantiation.
        String title="Luke Cage";
        String descr= App.getAppContext().getString(R.string.luke_cage_descr);
        String id = UUID.randomUUID().toString();
        int image = R.drawable.luke_cage;
        TvShow tvs1 = new TvShow(title,descr,id,image);
        localList.add(tvs1);

        title="Daredevil";
        descr= App.getAppContext().getString(R.string.daredevil_descr);
        id = UUID.randomUUID().toString();
        image = R.drawable.daredevil;
        TvShow tvs2 = new TvShow(title,descr,id,image);
        localList.add(tvs2);

        title="Jessica Jones";
        descr= App.getAppContext().getString(R.string.jessica_jones_descr);
        id = UUID.randomUUID().toString();
        image = R.drawable.jessica_jones;
        TvShow tvs3 = new TvShow(title,descr,id,image);
        localList.add(tvs3);

        title="House of cards";
        descr= App.getAppContext().getString(R.string.house_of_cards_descr);
        id = UUID.randomUUID().toString();
        image = R.drawable.house_of_cards;
        TvShow tvs4 = new TvShow(title,descr,id,image);
        localList.add(tvs4);

        title="The Getdown";
        descr= App.getAppContext().getString(R.string.the_get_down_descr);
        id = UUID.randomUUID().toString();
        image = R.drawable.the_getdown;
        TvShow tvs5 = new TvShow(title,descr,id,image);
        localList.add(tvs5);
    }
    public static ShowModel getInstance() {
        if(instance == null) {
            instance = new ShowModel();
        }
        return instance;
    }

    @Override
    public List<TvShow> getTvShows() {
        return localList;
    }
}
