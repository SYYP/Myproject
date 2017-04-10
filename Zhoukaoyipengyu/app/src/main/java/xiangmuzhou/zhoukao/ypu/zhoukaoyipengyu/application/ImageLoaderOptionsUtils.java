package xiangmuzhou.zhoukao.ypu.zhoukaoyipengyu.application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by lenovo on 2017/3/17.
 */

public class ImageLoaderOptionsUtils {
    public static DisplayImageOptions getOptions(int imageId) {
        DisplayImageOptions options =
                new DisplayImageOptions.Builder().
                        displayer(new RoundedBitmapDisplayer(0)).
                        showImageOnLoading(imageId).showImageForEmptyUri(imageId)
                        .cacheInMemory()
                        .cacheOnDisk(true)
                        .build();
        return options;
    }

}