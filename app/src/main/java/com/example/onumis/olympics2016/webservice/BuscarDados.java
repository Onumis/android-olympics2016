package rastreio;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.jorgelucasl91gmail.minhamercadoria.R;

import java.util.ArrayList;
import java.util.Map;

import adaptador.Adaptador;
import conexao.FabricaNet;
import modelos.ModeloInfoRastreio;


/**

 * @author Jorge Lucas on 13/11/2015

 * clase  reponsavel por baixar as informações do webService
 */
public class BuscarDados extends AsyncTask<String, Void, ArrayList<ModeloInfoRastreio>> {

    private Activity activity = null;
    private ProgressDialog progresso = null;
    private ListView lista;
    public static final String URL = "http://developers.agenciaideias.com.br/correios/rastreamento/json/";

    public BuscarDados(Activity copia) {

        activity = copia;
        lista = (ListView) activity.findViewById(R.id.listView);
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
    protected ArrayList<ModeloInfoRastreio> doInBackground(String... params) {
        try {
            String json = FabricaNet.buscaDadosWebService(params[0]);

            ArrayList<ModeloInfoRastreio> arrayList = new ArrayList<>();

            if (!json.contains("DOCTYPE")) {
                Gson gson = new Gson();

                ArrayList<Map<String, String>> dadosrecebidos = (ArrayList<Map<String, String>>) gson.fromJson(json, ArrayList.class);

                for (int i = 0; i < dadosrecebidos.size(); i++) {
                    ModeloInfoRastreio modeloInfoRastreio = new ModeloInfoRastreio();
                    modeloInfoRastreio.setData(dadosrecebidos.get(i).get("data"));
                    modeloInfoRastreio.setAcao(dadosrecebidos.get(i).get("acao"));
                    modeloInfoRastreio.setLocal(dadosrecebidos.get(i).get("local"));
                    modeloInfoRastreio.setDetalhes(dadosrecebidos.get(i).get("detalhes"));

                    arrayList.add(modeloInfoRastreio);
                }
            }


            return arrayList;
        } catch (JsonSyntaxException jsonSyntaxException) {
   //         Toast.makeText(activity, jsonSyntaxException.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        } catch (RuntimeException e) {
//            Toast.makeText(activity,e.getMessage(), Toast.LENGTH_LONG).show();
        }

        return null;
    }
//metodo utilizado para exibir os dados na lista
    public void onPostExecute(ArrayList<ModeloInfoRastreio> dadosRastreio) {

        progresso.dismiss();
        try {
            if (dadosRastreio.size() != 0) {
                Adaptador adaptador = new Adaptador(activity, dadosRastreio);
                this.lista.setAdapter(adaptador);
                this.lista.setOnItemClickListener(adaptador);

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
        }catch (NullPointerException e)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Atenção");
            builder.setMessage("verifique o codigo e tente novamente...");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                }
            });
            builder.show();
        }



    }


}
