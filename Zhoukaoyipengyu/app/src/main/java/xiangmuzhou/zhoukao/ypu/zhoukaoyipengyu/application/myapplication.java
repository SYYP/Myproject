package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.application;

import android.app.Application;
import android.util.Log;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.DbManager;
import org.xutils.db.table.TableEntity;
import org.xutils.x;

import java.io.File;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class myapplication extends Application {


    private DbManager.DaoConfig daoConfig;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
       // x.Ext.setDebug(false); //输出debug日志，开启会影响性能
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCacheExtraOptions(480,640).build();
        ImageLoader.getInstance().init(configuration);
        //初始化DaoConfig配置
        //设置数据库名，默认的xutils.db
//设置数据库的路径，默认储存在app的私有目录
//设数据库的版本号
//设置打开数据库的监听
//开启数据库支持多线程操作，提升性能，对写入加速提升巨大
//设置数据库更新的监听
//设置表创建的监听
        daoConfig = new DbManager.DaoConfig()
        //设置数据库名，默认的xutils.db
        .setDbName("mydb.db")
        //设置数据库的路径，默认储存在app的私有目录
//        .setDbDir(new File("/mnt/sdcard"))
         //设数据库的版本号
        .setDbVersion(2)
         //设置打开数据库的监听
        .setDbOpenListener(new DbManager.DbOpenListener() {
            @Override
            public void onDbOpened(DbManager db) {
                //开启数据库支持多线程操作，提升性能，对写入加速提升巨大
                db.getDatabase().enableWriteAheadLogging();
            }
        })//设置数据库更新的监听
        .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
            @Override
            public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
            }
        })
                //设置表创建的监听
                .setTableCreateListener(new DbManager.TableCreateListener() {
                    @Override
                    public void onTableCreated(DbManager db, TableEntity<?> table){
                        Log.i("JAVA", "onTableCreated：" + table.getName());
                    }
                })
                    //s设置是否允许事务 默认为true
       .setAllowTransaction(true);

        DbManager db= x.getDb(daoConfig);
    }
    public DbManager.DaoConfig daoConfig (){

        return daoConfig;

    }
}
