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

public class myutils {

    private Addinters add;
    public void myXutils(){
    RequestParams reparams=new RequestParams(uri.url1);


    x.http().get(reparams, new Callback.CommonCallback<String>() {
        @Override
        public void onSuccess(String result) {

            add.getaddinters(result);
        }


        @Override
        public void onError(Throwable ex, boolean isOnCallback) {

        }

        @Override
        public void onCancelled(Callback.CancelledException cex) {

        }

        @Override
        public void onFinished() {

        }
    });

}
    public interface  Addinters{
    public void getaddinters(String result);
}
    public void huidiaos(Addinters ad){
        this.add=ad;
    }
}
