package br.ufes.inf.pi1;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.open-meteo.com/v1/forecast?latitude=-20.27&longitude=-40.31&current_weather=true&forecast_days=1&timezone=America%2FSao_Paulo");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        
        HttpEntity entity1 = response1.getEntity();
        JsonObject json = JsonParser.parseString(EntityUtils.toString(entity1)).getAsJsonObject();
        Double temperature = json.getAsJsonObject("current_weather").get("temperature").getAsDouble();
        System.out.println(temperature);
    
        response1.close();
        
    }
}
