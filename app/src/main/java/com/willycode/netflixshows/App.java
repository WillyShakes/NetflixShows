package com.willycode.netflixshows;

import android.app.Application;
import android.content.Context;

/**
 * Created by Manuel ELO'O on 18/10/2016.
 */
public class App extends Application{
    private static App instance;

    public App() {
        instance = this;
    }

    public static Context getAppContext()
    {
        return instance;
    }
}
