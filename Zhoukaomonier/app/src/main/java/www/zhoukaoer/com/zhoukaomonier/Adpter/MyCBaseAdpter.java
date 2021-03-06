package www.zhoukaoer.com.zhoukaomonier.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import www.zhoukaoer.com.zhoukaomonier.Beans.Beans;
import www.zhoukaoer.com.zhoukaomonier.R;


/**
 * author: Administrator
 * date: 2017/4/15.
 */

public class MyCBaseAdpter extends BaseAdapter {
    private Context context;
    private List<Beans.DataBean> list;

    public MyCBaseAdpter(Context context, List<Beans.DataBean> list) {
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
            view = LayoutInflater.from(context).inflate(R.layout.list_view,null);
            viewHolder.textView = (TextView) view.findViewById(R.id.lv_text);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(list.get(i).getName());
        return view;
    }
    class ViewHolder{
        private TextView textView;
    }
}
