package com.willycode.netflixshows.ui.show;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.willycode.netflixshows.R;
import com.willycode.netflixshows.domain.entity.TvShow;

import java.util.ArrayList;
import java.util.List;

public class TvShowsActivity extends AppCompatActivity implements Show.View{
    ListView list;
    LazyAdapter adapter;
    private ShowPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mPresenter = new ShowPresenter(this);
        list=(ListView)findViewById(R.id.list);
        setLoadingIndicator(true);
        List<TvShow> shows = mPresenter.loadTvShows(true);
        if(shows.isEmpty())
        {
            showLoadingTvShowsError();
            showNoTvShows();
        }
        else
            showTvShows(shows);
        setLoadingIndicator(false);
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showTvShows(List<TvShow> shows) {
        adapter=new LazyAdapter(this, shows);
        list.setAdapter(adapter);
    }

    @Override
    public void showTvShowDetailsUi(String showId) {

    }

    @Override
    public void showLoadingTvShowsError() {

    }

    @Override
    public void showNoTvShows() {
        adapter=new LazyAdapter(this, new ArrayList<TvShow>());
        list.setAdapter(adapter);
    }

    public class LazyAdapter extends BaseAdapter {

        private Activity activity;
        private List<TvShow> data;
        private LayoutInflater inflater=null;


        public LazyAdapter(Activity a, List<TvShow> d) {
            activity = a;
            data=d;
            inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public int getCount() {
            return data.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View vi=convertView;
            if(convertView==null)
                vi = inflater.inflate(R.layout.row_item, null);

            TextView title = (TextView)vi.findViewById(R.id.title); // title
            TextView descr = (TextView)vi.findViewById(R.id.description);
            ImageView thumb_image=(ImageView)vi.findViewById(R.id.list_image); // thumb image


            TvShow show = data.get(position);

            // Setting all values in listview
            title.setText(show.getTitle());
            descr.setText(show.getDescription());
            Picasso.with(TvShowsActivity.this).load(show.getImage()).into(thumb_image);


            return vi;
        }
    }
}
