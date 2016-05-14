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
import com.example.onumis.olympics2016.webservice.BuscarDados;

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
//        listView.setAdapter(new NewsAdapter(this.getActivity(), mNewsList));

        BuscarDados dados = new BuscarDados(this.getActivity());
        String url = BuscarDados.URL + "api/news";
        dados.execute(url);

    }

}
