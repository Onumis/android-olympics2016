package com.example.onumis.olympics2016.webservice;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.onumis.olympics2016.R;
import com.example.onumis.olympics2016.news.NewsAdapter;
import com.example.onumis.olympics2016.news.NewsContent;
import com.example.onumis.olympics2016.news.NewsFragment;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.Map;



/**

 * @author Jorge Lucas on 13/11/2015

 * clase  reponsavel por baixar as informações do webService
 */
public class BuscarDados extends AsyncTask<String, Void, ArrayList<NewsContent.News>> {

    private Activity activity = null;
    private ProgressDialog progresso = null;
    private ListView lista;
    public static final String URL = "http://174418f1.ngrok.io/";

    public BuscarDados(Activity copia) {
        activity = copia;
        lista = (ListView) activity.findViewById(R.id.news_list);
    }

    /**
     * metodo utilizado para exibir ProgressDialog para o usuário
     */
    public void onPreExecute() {
        Log.d("preparando", "executou");
        progresso = new ProgressDialog(activity);
        progresso.setCancelable(false);
        progresso.setCanceledOnTouchOutside(false);
        progresso.setTitle("Baixando informações");
        progresso.setMessage("Aguarde...");
        progresso.show();
    }

    @Override
    //metodo utilizado por baixar as informações do webService e add em um ArrayList
    protected ArrayList<NewsContent.News> doInBackground(String... params) {
        String json = FabricaNet.buscaDadosWebService(params[0]);
        ArrayList<NewsContent.News> arrayList = new ArrayList<>();
        if (!json.contains("DOCTYPE")) {
            Gson gson = new Gson();
            ArrayList<Map<String, String>> dadosrecebidos = (ArrayList<Map<String, String>>) gson.fromJson(json, ArrayList.class);
            for (int i = 0; i < dadosrecebidos.size(); i++) {
                NewsContent.News modeloInfoRastreio = new NewsContent.News(
                        String.valueOf(dadosrecebidos.get(i).get("id")),
                        dadosrecebidos.get(i).get("title"),
                        dadosrecebidos.get(i).get("body"));
                arrayList.add(modeloInfoRastreio);
            }
        }
        return arrayList;
    }
//metodo utilizado para exibir os dados na lista
    public void onPostExecute(ArrayList<NewsContent.News> dadosRastreio) {
        progresso.dismiss();
        if (dadosRastreio.size() != 0) {
            NewsAdapter adaptador = new NewsAdapter(activity, dadosRastreio);
            this.lista.setAdapter(adaptador);
//                this.lista.setOnItemClickListener(adaptador);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Atenção");
            builder.setMessage("Codigo de rastreio inválido...");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                }
            });
            builder.show();
        }

    }


}
