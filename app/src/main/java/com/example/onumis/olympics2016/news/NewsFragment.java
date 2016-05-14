package com.example.onumis.olympics2016.news;

import android.app.Activity;
import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.onumis.olympics2016.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsFragment extends Fragment {

    private ArrayList<NewsContent.News> mNewsList = null;
    private ListView listView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);
        listView = (ListView) view.findViewById(R.id.news_list);
        mNewsList = new ArrayList<>(NewsContent.ITEM_MAP.values());

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView.setAdapter(new NewsAdapter(this.getActivity(), mNewsList));
    }


    private class NewsAdapter extends ArrayAdapter<NewsContent.News> {
        Activity context=null;
        ArrayList<NewsContent.News> mNewsList = null;

        public NewsAdapter(Activity activity, ArrayList<NewsContent.News> itens){
            super(activity,0,itens);
            context = activity;
            mNewsList = itens;
        }

        public View getView(int indice, View celulaReciclada, ViewGroup pai){

            if(celulaReciclada==null){
                celulaReciclada = context.getLayoutInflater().inflate(R.layout.news_list_content,null);
            }

            TextView title = (TextView) celulaReciclada.findViewById(R.id.titleTV);
            title.setText(mNewsList.get(indice).title);

            TextView body = (TextView) celulaReciclada.findViewById(R.id.bodyTV);
            body.setText(mNewsList.get(indice).text);

            return celulaReciclada;
        }

    }

}
