package com.q.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ImageView mIv_image;

    private TextView tv_text;

    private LruCache<String, Bitmap> stringBitmapLruCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("cv", "000");

        initThread();


//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
    }

    private void initThread() {
        mIv_image = (ImageView) findViewById(R.id.iv_image);
        tv_text = (TextView) findViewById(R.id.tv_text);
//        ThreadPoolExecutor g = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
//        ExecutorService e = Executors.newSingleThreadExecutor();
//        e.execute();


//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);

//        BitmapDrawable b = new BitmapDrawable(getResources());

//        Drawable drawable = getDrawable(R.mipmap.android_q);

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.android_q, options);
        options.inSampleSize = initImageView(options, 200, 200);
        options.inJustDecodeBounds = false;

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        stringBitmapLruCache = new LruCache<String, Bitmap>(maxMemory / 8) {

            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };

        stringBitmapLruCache.put("android_q", BitmapFactory.decodeResource(getResources(), R.mipmap.android_q, options));
        tv_text.setText(stringBitmapLruCache.size() + "k");
        mIv_image.setImageBitmap(stringBitmapLruCache.get("android_q"));

        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringBitmapLruCache.evictAll();
                tv_text.setText(stringBitmapLruCache.size() + "k");
            }
        });
    }

    private int initImageView(BitmapFactory.Options options, int width, int height) {
        int mWidth = options.outWidth;
        int mHeight = options.outHeight;

        int ins = 1;

        int i = mWidth / width;

        if (mWidth > width || height > mHeight) {
            int halfWidth = mWidth / i;
            int halfHeight = mHeight / i;

            while ((halfWidth / ins) >= width && (halfHeight / ins) >= height) {
                ins *= 2;
            }
        }

        return ins;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stringBitmapLruCache.evictAll();
    }
}
