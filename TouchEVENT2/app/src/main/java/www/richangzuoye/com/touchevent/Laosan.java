package www.richangzuoye.com.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class Laosan extends TextView {
    public Laosan(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d("tag","老三收到任务");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //消费触摸事件
        boolean flag =true;
        if (flag == false) {
            Log.i("tag", "老三向上传递");
        } else {
            Log.i("tag", "老三把任务完成了.....");
        }
        return flag;
    }
}
