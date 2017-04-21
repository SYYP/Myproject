package www.richangzuoye.com.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class LaoDa extends FrameLayout {
    public LaoDa(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("tag","老大收到任务");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean flag=true;
        if(flag=false){
            Log.d("tag","老大没独自完任务");

        }
        else{
            Log.d("tag","老大拦截任务");
        }
        return flag;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //消费触摸事件
        boolean flag =true;
        if (flag == false) {
            Log.i("tag", "老大向上传递");
        } else {
            Log.i("tag", "老大把任务完成了.....");
        }
        return flag;
    }
}
