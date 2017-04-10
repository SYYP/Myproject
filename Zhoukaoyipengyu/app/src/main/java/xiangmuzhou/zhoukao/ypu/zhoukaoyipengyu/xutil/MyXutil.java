package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.xutil;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.Uri.uri;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class MyXutil {
    private String lujin;
    private Addinter ads;

    public MyXutil(String lujin) {
        this.lujin = lujin;
    }

    public void initutils(){
        RequestParams reparams=new RequestParams(uri.ur2);

        reparams.addQueryStringParameter("uri",lujin);
        Log.d("tag","88888888"+lujin);
        x.http().get(reparams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {

               ads.getaddinter(result);
            }


            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });

    }
    public interface  Addinter{
    public void getaddinter(String result);
    }
      public void huidiao(Addinter ad){
          this.ads=ad;
      }

}
