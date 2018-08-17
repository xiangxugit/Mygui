import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;



public class App  extends Application{

    private static final String TAG = "App";

    private static App instance;
    private static boolean APP_DBG = false; // 是否是debug模式

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        APP_DBG = isDebug();
        // 初始化崩溃日志收集器
        //初始化xutils
//        x.Ext.init(this);
//        x.Ext.setDebug(false);
    }

//    public static  DbManager getdb(){
//        return db;
//    }

    public static Context getInstance() {
        return instance;
    }



    public static boolean isAppDbg() {
        return APP_DBG;
    }

    private boolean isDebug(){
        ApplicationInfo applicationInfo = this.getApplicationInfo();
        return null != applicationInfo &&
                (applicationInfo.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
    }

}

