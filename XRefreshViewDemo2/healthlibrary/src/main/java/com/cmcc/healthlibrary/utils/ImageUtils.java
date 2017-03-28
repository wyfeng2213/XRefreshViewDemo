package com.cmcc.healthlibrary.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Description:
 * Date：2017/03/21 09:56
 * Author: wangyong
 */

public class ImageUtils {

    public static final int LOAD_CICLE = 0;
    public static final int LOAD_ROUND = 1;

    /**
     * load normal  for img 加载url
     *
     * @param url
     * @param erroImg  错误图片
     * @param emptyImg 加载时的站位图
     * @param iv
     */
    public static void Loader(Context context, String url, int erroImg, int emptyImg, ImageView iv) {
        //原生 API
        Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).into(iv);
    }

    /**
     * 加载 drawable
     *
     * @param context
     * @param drawable
     * @param iv
     */
    public static void Loader(Context context, int drawable, ImageView iv) {
        //原生 API
        Glide.with(context).load(drawable).into(iv);
    }

    /**
     * load normal  for  circle or round img
     *
     * @param url
     * @param erroImg  错误图片
     * @param emptyImg 加载时的站位图
     * @param iv
     * @param tag      加载圆形还是圆角 0圆形
     */
    public static void Loader(Context context, String url, int erroImg, int emptyImg, ImageView iv, int tag) {
        if (LOAD_CICLE == tag) {
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideCircleTransform(context)).into(iv);
        } else if (LOAD_ROUND == tag) {
            Glide.with(context).load(url).placeholder(emptyImg).error(erroImg).transform(new GlideRoundTransform(context, 10)).into(iv);
        }
    }

    /**
     * load normal  for  circle or round img
     *
     * @param drwable
     * @param iv
     * @param tag     加载圆形还是圆角 0圆形
     */
    public static void Loader(Context context, int drwable, ImageView iv, int tag) {
        if (LOAD_CICLE == tag) {
            Glide.with(context).load(drwable).transform(new GlideCircleTransform(context)).into(iv);
        } else if (LOAD_ROUND == tag) {
            Glide.with(context).load(drwable).transform(new GlideRoundTransform(context, 10)).into(iv);
        }
    }

}
