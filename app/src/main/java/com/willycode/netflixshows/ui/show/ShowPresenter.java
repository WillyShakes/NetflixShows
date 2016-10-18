package com.willycode.netflixshows.ui.show;

import android.support.annotation.NonNull;

import com.willycode.netflixshows.domain.entity.TvShow;

import java.util.List;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public class ShowPresenter implements Show.Presenter {


    private Show.View mTvShowsView;

    public ShowPresenter(Show.View mTvShowsView) {
        attachView(mTvShowsView);
    }

    @Override
    public void attachView(Show.View view) {
    mTvShowsView = view;
    }

    @Override
    public List<TvShow> loadTvShows(boolean forceUpdate) {
        return ShowModel.getInstance().getTvShows();
    }

    @Override
    public void openTvShowDetails(@NonNull TvShow requestedTvShow) {
       //TBD
    }
}
