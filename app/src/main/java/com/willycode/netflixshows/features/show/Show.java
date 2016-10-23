package com.willycode.netflixshows.features.show;

import android.support.annotation.NonNull;

import com.willycode.netflixshows.domain.entity.TvShow;
import com.willycode.netflixshows.base.Mvp;

import java.util.List;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public interface Show {
    interface View extends Mvp.View{
        void setLoadingIndicator(boolean active);
        void showTvShows(List<TvShow> shows);
        void showTvShowDetailsUi(String showId);
        void showLoadingTvShowsError();
        void showNoTvShows();
    }

    interface Model extends Mvp.Model{
        List<TvShow> getTvShows();
    }

    interface Presenter extends Mvp.Presenter<View>{
        List<TvShow> loadTvShows(boolean forceUpdate);
        void openTvShowDetails(@NonNull TvShow requestedTvShow);
    }
}
