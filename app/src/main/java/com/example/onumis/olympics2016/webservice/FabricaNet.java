/**************************************************************************************
 *Projeto: FabricaNet
 *Descricao: classe responsavel pelo gerenciamento de resolucao de video e componentes
 *Autor: Silvano Malfatti
 * Local : Palmas-TO
 **************************************************************************************/

//Pacote de recursos
package conexao;

//Pacotes utilizados

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class FabricaNet
{
    public synchronized static String buscaDadosWebService(String ender)
    {
        String sJson;

        try
        {
            //Realiza a leitura dos dados no servidor via HTTP
            HttpClient vrCliente = new DefaultHttpClient();
            HttpGet vrGet = new HttpGet();

            URL vrURL = new URL(ender);
            HttpURLConnection vrConexaoHttp = (HttpURLConnection) vrURL.openConnection();
            vrGet.setURI(new URI(ender));
            HttpResponse vrResponce = vrCliente.execute(vrGet);
            HttpEntity vrEntity = vrResponce.getEntity();

            if (vrEntity != null)
            {
                InputStream vrInput = vrEntity.getContent();
                sJson = inputString(vrInput);
                vrInput.close();
                return sJson;
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    //Metodo utilizado para o agrupamehto dos bytes vindos da operacao http
    private static String inputString(InputStream is) throws IOException
    {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int lidos;
        while ((lidos = is.read(bytes)) > 0)
        {
            baos.write(bytes, 0, lidos);
        }
        return new String(baos.toByteArray());
    }
}