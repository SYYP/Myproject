package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.R;
import xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.application.ImageLoaderOptionsUtils;
import xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.bean.User;


/**
 * date : ${Data}
 * author:衣鹏宇(ypu)
 */

public class mybaseadapters extends BaseAdapter{

   private List<User.ResultBean.DataBean> list;
     private Context context;

    public mybaseadapters(List<User.ResultBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           ViewHolder holder;
            if(convertView==null){
                holder=new ViewHolder();
                convertView=View.inflate(context, R.layout.list_view,null);
                holder.count= (TextView) convertView.findViewById(R.id.count);
                holder.title= (TextView) convertView.findViewById(R.id.titles);
                holder.image= (ImageView) convertView.findViewById(R.id.images);
                convertView.setTag(holder);
            }
            else{
               holder= (ViewHolder) convertView.getTag();
            }
            holder.count.setText(list.get(position).getTitle());
            holder.title.setText(list.get(position).getAuthor_name());
            ImageLoader.getInstance().displayImage(list.get(position).getThumbnail_pic_s(),holder.image, ImageLoaderOptionsUtils.getOptions(R.mipmap.ic_launcher));
            return convertView;
        }

        class ViewHolder{


            TextView title,count;
            ImageView image;
        }
    }


