package com.xianmuyi.ypu.myprojectdemo.Asny;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class MyAsnytask extends AsyncTask<String,Integer,String> {
    private Jiekou Jiekou;
    @Override
    protected String doInBackground(String... params) {
        StringBuffer sb = new StringBuffer();
        try{
            URL url = new URL(params[0]);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            connect.setReadTimeout(5000);
            connect.setConnectTimeout(5000);

            if(connect.getResponseCode()==200){
                InputStream stream = connect.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(stream,"utf-8"));
                String str;
                while((str=br.readLine())!=null){
                    sb.append(str);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return sb.toString();
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public interface Jiekou{
        public void Jiekoustr(String str);
    }
    public void huidiao(Jiekou get){
        this.Jiekou=get;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Jiekou.Jiekoustr(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
