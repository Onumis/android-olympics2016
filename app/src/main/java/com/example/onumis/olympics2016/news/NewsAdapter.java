package com.example.onumis.olympics2016.news;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.onumis.olympics2016.R;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<NewsContent.News> {
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
