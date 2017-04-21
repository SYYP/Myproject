package www.richangzuoye.com.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class LaoEr extends RelativeLayout {
    public LaoEr(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("tag","老二收到任务");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean flag=true;
        if(flag=false){
            Log.d("tag","老二没独自完任务");

        }
        else{
            Log.d("tag","老二拦截任务");
        }
        return flag;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //消费触摸事件
        boolean flag =true;
        if (flag == false) {
            Log.i("tag", "老二向上传递");
        } else {
            Log.i("tag", "老二把任务完成了.....");
        }
        return flag;
    }
}
