package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ClipPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.adapter.Myadapter;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewpager;
    private MagicIndicator magicator;
    private List<String> mylist=new ArrayList<String>();
    private List<Fragment> myFragment=new ArrayList<Fragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获得资源ID
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        magicator = (MagicIndicator) findViewById(R.id.magicactor);
        //添加数据
        inint();
        //适配数据
        inintdata();

    }

    private void inint() {
        mylist.add("推荐");
        mylist.add("北京");
        mylist.add("热点");
        mylist.add("视频");
        mylist.add("新闻");
        mylist.add("社会");
        mylist.add("时尚");
        myFragment.add(new OneFragment("yl"));
        myFragment.add(new OneFragment("gj"));
        myFragment.add(new OneFragment("cj"));
        myFragment.add(new OneFragment("kj"));
        myFragment.add(new OneFragment("js"));
        myFragment.add(new OneFragment("ty"));
        myFragment.add(new OneFragment("gn"));


    }

    private void inintdata() {

        CommonNavigator commongator=new CommonNavigator(MainActivity.this);
        commongator.setAdapter(new CommonNavigatorAdapter() {
            private ClipPagerTitleView clipagertitle;
            @Override
            public int getCount() {
                //返回数据
                return mylist==null?0:mylist.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                clipagertitle=new  ClipPagerTitleView(context) ;
                clipagertitle.setTextSize(50);
                clipagertitle.setText(mylist.get(index));
                clipagertitle.setTextColor(Color.BLACK);
                clipagertitle.setClipColor(Color.RED);
                clipagertitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        viewpager.setCurrentItem(index);
                    }
                });
                return clipagertitle;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {

                LinePagerIndicator indictor=new LinePagerIndicator(MainActivity.this);
                indictor.setColors(Color.RED);
                return indictor;
            }
        });
        magicator.setNavigator(commongator);
        Myadapter adapter=new Myadapter(this.getSupportFragmentManager(),myFragment);
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicator.onPageScrolled(position,  positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                magicator.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                magicator.onPageScrollStateChanged(state);
            }
        });



    }
}
