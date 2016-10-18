package com.willycode.netflixshows.domain.entity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public class TvShow {

    @NonNull
    private final String mId;

    @Nullable
    private final String mTitle;

    @Nullable
    private final String mDescription;

    private final int mImage;

    /**
     * Use this constructor to create a new TvShow.
     *
     * @param title       title of the show
     * @param description description of the show
     * @param id          id of the show
     * @param bitmap   image of the show
     */
    public TvShow(@Nullable String title, @Nullable String description,
                  @NonNull String id, int bitmap) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mImage = bitmap;
    }

    @NonNull
    public String getId() {
        return mId;
    }

    @Nullable
    public String getTitle() {
        return mTitle;
    }

    @Nullable
    public String getDescription() {
        return mDescription;
    }

    public int getImage() {
        return mImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvShow show = (TvShow) o;
        return mId.equals(show.mId) &&
                mTitle.equals(show.mTitle) &&
                mDescription.equals(show.mDescription);
    }

    @Override
    public String toString() {
        return "TvShow with title " + mTitle;
    }
}
