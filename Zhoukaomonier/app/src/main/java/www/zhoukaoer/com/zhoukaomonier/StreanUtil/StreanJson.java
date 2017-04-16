package www.zhoukaoer.com.zhoukaomonier.StreanUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by ypu on 2017/3/16.
 */

public class StreanJson {


     public static  String getJson(InputStream stream){

           StringBuffer buffer=new StringBuffer();
         BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
         String str;
         try {
             while ((str=reader.readLine())!=null){

              buffer.append(str);
             }
         } catch (Exception e){
             e.printStackTrace();
         }



         return buffer.toString();
     }
}
