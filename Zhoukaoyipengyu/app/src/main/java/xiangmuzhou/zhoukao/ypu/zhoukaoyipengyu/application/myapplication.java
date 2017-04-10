package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.application;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,640).build();


        ImageLoader.getInstance().init(configuration);
    }
}
