package www.zhoukaoer.com.zhoukaomonier.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import www.zhoukaoer.com.zhoukaomonier.Beans.JsonBean;
import www.zhoukaoer.com.zhoukaomonier.R;


/**
 * author: Administrator
 * date: 2017/4/15.
 */

public class MyBaseAdpter extends BaseAdapter {
    private Context context;
    private List<JsonBean.DataBean> list;

    public MyBaseAdpter(Context context, List<JsonBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.mybase,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.basetext);
            viewHolder.textView2 = (TextView) view.findViewById(R.id.basetext2);
            viewHolder.textView3 = (TextView) view.findViewById(R.id.basetext3);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(list.get(i).getTitle());
        viewHolder.textView2.setText(list.get(i).getApply());
        viewHolder.textView3.setText(list.get(i).getBuy_price());
        return view;
    }
    class ViewHolder{
        private TextView textView,textView2,textView3;
    }
}
