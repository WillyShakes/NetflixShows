package com.willycode.netflixshows.base;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public interface Mvp {
    interface View{
    }
    interface Model{}
    interface Presenter<V>{
        public void attachView(V view);
    }
}
