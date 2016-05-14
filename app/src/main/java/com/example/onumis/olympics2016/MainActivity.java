package com.example.onumis.olympics2016;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.onumis.olympics2016.athletes.AthleteListActivity;
import com.example.onumis.olympics2016.dummy.DummyContent;
import com.example.onumis.olympics2016.modalities.ModalityDetailActivity;
import com.example.onumis.olympics2016.modalities.ModalityDetailFragment;
import com.example.onumis.olympics2016.modalities.ModalityListActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView newsList=null;

    protected static final String[] FRAGMENT_NAMES = {
        "news", "modalities", "atheletes", "transmissions"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);






    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_modalities) {
            startActivity(new Intent(getApplicationContext(), ModalityListActivity.class));
        } else if (id == R.id.nav_athletes) {
            startActivity(new Intent(getApplicationContext(), AthleteListActivity.class));
        } else if (id == R.id.nav_transmission) {
            startActivity(new Intent(getApplicationContext(), TransmissionsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class Adaptador extends ArrayAdapter<News> implements AdapterView.OnItemClickListener {

        Activity contextoAtual = null;
        ArrayList<News> arrayModelo = null;

        public Adaptador (Activity activity, ArrayList<News> array) {
            super(activity, 0, array);
            this.contextoAtual = activity;
            this.arrayModelo = array;
        }
        public View getView(int indice, View celulaReciclada, ViewGroup pai) {
            //se a celula reciclada for igual a null
            if (celulaReciclada == null) {
                celulaReciclada = LayoutInflater.from(contextoAtual).inflate(R.layout.fragment_news, null);
            }

            TextView title = (TextView) celulaReciclada.findViewById(R.id.titleTV);
            title.setText(arrayModelo.get(indice).title);

            TextView body = (TextView) celulaReciclada.findViewById(R.id.bodyTV);
            body.setText(arrayModelo.get(indice).text);

            ImageView picture = (ImageView) celulaReciclada.findViewById(R.id.pictureIV);
            picture.setBackgroundResource(R.drawable.news765x350);

            return celulaReciclada;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        }
    }

    public class News{
        String title ="Lorem Ipsum is simply dummy text";
        String text ="Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";


    }

}
