package com.q.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.util.LruCache;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.q.app.views.MyRenderer;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import org.greenrobot.eventbus.EventBus;

import java.util.Objects;
import java.util.Random;

public class MainActivity extends Activity {

    private ImageView mIv_image;

    private TextView tv_text;

    private Button button;

    private LruCache<String, Bitmap> stringBitmapLruCache;

    private Request<Bitmap> bitmapRequest;

    private int number = -1;

    private Fragment fragment;

    private ListView mListView;

    private SparseArray sparseArray = new SparseArray();


    private Handler handler = new Handler();

    float lastX, lastY;

    private String url = "http://a.hiphotos.baidu.com/baike/w%3D268/sign=c335df545dafa40f3cc6c9db9365038c/8ad4b31c8701a18b37137a29992f07082938fed8.jpg";

    private GLSurfaceView glView; // Use GLSurfaceView
    Random rnd = new Random();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(android.R.style.Theme_Translucent_NoTitleBar);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        glView = new GLSurfaceView(this); // Allocate a GLSurfaceView
        glView.setRenderer(new MyRenderer()); // Use a custom renderer
        glView.getAlpha();
        this.setContentView(glView);

        thread.start();

        thread2.start();

//        finish();
//        if (Looper.getMainLooper() == null) {
//
//            Looper.prepare();
//        }
//        Looper.myLooper();
//        CrashReport.testJavaCrash();


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                Looper.prepare();
//
//
//
//            }
//        }).start();

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {


            for (int i = 0; i < 10; i++) {
                number++;
                Log.e("fsdfsd", "----->" + i);
            }
        }
    });

    private Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = number; i < number + 10; i++) {
                number++;
                Log.e("fsdfsd2", "----->" + i);
            }
        }
    });


    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
        android.provider.Settings.System.putInt(this.getContentResolver(),
                android.provider.Settings.System.SCREEN_BRIGHTNESS,
                rnd.nextInt(256));

    }

    private void initViews() {

        button = (Button) findViewById(R.id.bt);
        button.setOnTouchListener(on);
    }

    private View.OnTouchListener on = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            float rawX = event.getRawX();
            float rawY = event.getRawY();


            switch (event.getAction()) {

                case MotionEvent.ACTION_DOWN:
                    lastX = rawX;
                    lastY = rawY;
                    break;

                case MotionEvent.ACTION_UP:
                    Toast.makeText(MainActivity.this, "--->", Toast.LENGTH_SHORT).show();
                    break;

                case MotionEvent.ACTION_MOVE:

                    float offsetX = rawX - lastX;

                    float offsetY = rawY - lastY;


                    Log.e("OnTouchListener", "----->" + v.getLeft() + "----" + v.getRight() + "----->" + v.getTop() + "----->" + v.getBottom());


                    button.layout(v.getLeft() + (int) offsetX, v.getTop() + (int) offsetY, v.getRight() + (int) offsetX, v.getBottom() + (int) offsetY);
                    lastX = rawX;
                    lastY = rawY;

                    break;
            }
            return false;
        }
    };


    private OnResponseListener<Bitmap> onResponseListener = new OnResponseListener<Bitmap>() {
        @Override
        public void onStart(int i) {

        }

        @Override
        public void onSucceed(int i, Response<Bitmap> response) {
            mIv_image.setImageBitmap(response.get());
        }

        @Override
        public void onFailed(int i, String s, Object o, Exception e, int i1, long l) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            Drawable drawable = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                drawable = getDrawable(R.mipmap.ic_launcher);
            }
            mIv_image.setImageDrawable(drawable);
        }

        @Override
        public void onFinish(int i) {

        }
    };

//    private void initThread() {
////        mIv_image = (ImageView) findViewById(R.id.iv_image);
//
////        mIv_image.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                Intent intent = new Intent(MainActivity.this, MyBroadCast.class);
////                sendBroadcast(intent);
////            }
////        });
////        tv_text = (TextView) findViewById(R.id.tv_text);
//        bitmapRequest = NoHttp.createImageRequest(url, RequestMethod.GET);
//
//        RequestQueue requestQueue = NoHttp.newRequestQueue();
//// 或者传一个并发值，允许三个请求同时并发
//// RequestQueue requestQueue = NoHttp.newRequestQueue(3);
//
//// 发起请求
//        requestQueue.add(100, bitmapRequest, onResponseListener);
//        NoHttp.startRequestSync(bitmapRequest);
//
////        ThreadPoolExecutor g = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
////        ExecutorService e = Executors.newSingleThreadExecutor();
////        e.execute();
//
//
////        BitmapFactory.Options options = new BitmapFactory.Options();
////        options.inJustDecodeBounds = true;
////        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
//
////        BitmapDrawable b = new BitmapDrawable(getResources());
//
////        Drawable drawable = getDrawable(R.mipmap.android_q);
////        BluetoothAdapter
////        BitmapFactory.Options options = new BitmapFactory.Options();
////        options.inJustDecodeBounds = true;
////        BitmapFactory.decodeResource(getResources(), R.mipmap.android_q, options);
////        options.inSampleSize = initImageView(options, 200, 200);
////        options.inJustDecodeBounds = false;
////
////        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
////        stringBitmapLruCache = new LruCache<String, Bitmap>(maxMemory / 8) {
////
////            @Override
////            protected int sizeOf(String key, Bitmap value) {
////                return value.getRowBytes() * value.getHeight() / 1024;
////            }
////        };
////
////        stringBitmapLruCache.put("android_q", BitmapFactory.decodeResource(getResources(), R.mipmap.android_q, options));
////        tv_text.setText(stringBitmapLruCache.size() + "k");
////        mIv_image.setImageBitmap(stringBitmapLruCache.get("android_q"));
////
////        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                stringBitmapLruCache.evictAll();
////                tv_text.setText(stringBitmapLruCache.size() + "k");
////            }
////        });
//    }

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
        EventBus.getDefault().unregister(this);
//        bitmapRequest.cancel();
//        stringBitmapLruCache.evictAll();
    }
}
