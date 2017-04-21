package www.richangzuoye.com.touchevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("tag", "上机颁布任务");
        switch (ev.getAction()){
            case MotionEvent.ACTION_CANCEL:
                Log.e("MOTION","MotionEvent.ACTION_CANCEL");
                break;
            case MotionEvent.ACTION_DOWN:
                Log.e("MOTION","MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("MOTION","MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("MOTION","MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_MASK:
                Log.e("MOTION","MotionEvent.ACTION_MASK");
                break;
            case MotionEvent.ACTION_OUTSIDE:
                Log.e("MOTION","MotionEvent.ACTION_OUTSIDE");
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.e("MOTION","MotionEvent.ACTION_POINTER_DOWN");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.e("MOTION","MotionEvent.ACTION_POINTER_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //假如调用到这里的方法,说明下边的子控件把事件传递上边来了.就是所有的控件都没有处理这个事件...

        Log.i("tag", "没有人完任务....");
        return super.onTouchEvent(event);
    }
}
