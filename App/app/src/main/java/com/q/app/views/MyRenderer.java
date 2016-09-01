package com.q.app.views;

import android.opengl.GLSurfaceView;
import android.util.Log;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by qli on 16/8/12.
 */
public class MyRenderer implements GLSurfaceView.Renderer {
//    // 定义三棱椎的4个顶点
//    float[] taperVertices = new float[]{
//            0.0f, 0.5f, 0.0f,
//            -0.5f, -0.5f, -0.2f,
//            0.5f, -0.5f, -0.2f,
//            0.0f, -0.2f, 0.2f
//    };
//    // 定义三棱椎的4个顶点的颜色
//    int[] taperColors = new int[]{
//            65535, 0, 0, 0,  // 红色
//            0, 65535, 0, 0,  // 绿色
//            0, 0, 65535, 0,  // 蓝色
//            65535, 65535, 0, 0 //黄色
//    };
//    // 定义三棱椎的4个三角面
//    private byte[] taperFacets = new byte[]{
//            0, 1, 2, //0、1、2三个顶点组成一个面
//            0, 1, 3, //0、1、3三个顶点组成一个面
//            1, 2, 3, //1、2、3三个顶点组成一个面
//            0, 2, 3  //0、2、3三个顶点组成一个面
//    };
//    // 定义立方体的8个顶点
//    float[] cubeVertices = new float[]{
//            // 上顶面正方形的四个顶点
//            0.5f, 0.5f, 0.5f,
//            0.5f, -0.5f, 0.5f,
//            -0.5f, -0.5f, 0.5f,
//            -0.5f, 0.5f, 0.5f,
//            // 下底面正方形的四个顶点
//            0.5f, 0.5f, -0.5f,
//            0.5f, -0.5f, -0.5f,
//            -0.5f, -0.5f, -0.5f,
//            -0.5f, 0.5f, -0.5f
//    };
//    // 定义立方体所需要的6个面（一共是12个三角形所需的顶点）
//    private byte[] cubeFacets = new byte[]{
//            0, 1, 2,
//            0, 2, 3,
//            2, 3, 7,
//            2, 6, 7,
//            0, 3, 7,
//            0, 4, 7,
//            4, 5, 6,
//            4, 6, 7,
//            0, 1, 4,
//            1, 4, 5,
//            1, 2, 6,
//            1, 5, 6
//    };
//
//    FloatBuffer taperVerticesBuffer;
//    IntBuffer taperColorsBuffer;
//    ByteBuffer taperFacetsBuffer;
//    FloatBuffer cubeVerticesBuffer;
//    ByteBuffer cubeFacetsBuffer;
//    // 控制旋转的角度
//    private float rotate;
//
//    public MyRenderer() {
//        // 将三棱椎的顶点位置数据数组包装成FloatBuffer;
//        taperVerticesBuffer = FloatBuffer.wrap(taperVertices);
//        // 将三棱椎的四个面的数组包装成ByteBuffer
//        taperFacetsBuffer = ByteBuffer.wrap(taperFacets);
//        // 将三棱椎的四个定点的颜色数组包装成IntBuffer
//        taperColorsBuffer = IntBuffer.wrap(taperColors);
//        // 将立方体的顶点位置数据数组包装成FloatBuffer;
//        cubeVerticesBuffer = FloatBuffer.wrap(cubeVertices);
//        // 将立方体的6个面（12个三角形）的数组包装成ByteBuffer
//        cubeFacetsBuffer = ByteBuffer.wrap(cubeFacets);
//    }
//
//    @Override
//    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//        // 关闭抗抖动
//        gl.glDisable(GL10.GL_DITHER);
//        // 设置系统对透视进行修正
//        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
//        gl.glClearColor(0, 0, 0, 0);
//        // 设置阴影平滑模式
//        gl.glShadeModel(GL10.GL_SMOOTH);
//        // 启用深度测试
//        gl.glEnable(GL10.GL_DEPTH_TEST);
//        // 设置深度测试的类型
//        gl.glDepthFunc(GL10.GL_LEQUAL);
//    }
//
//    @Override
//    public void onSurfaceChanged(GL10 gl, int width, int height) {
//        // 设置3D视窗的大小及位置
//        gl.glViewport(0, 0, width, height);
//        // 将当前矩阵模式设为投影矩阵
//        gl.glMatrixMode(GL10.GL_PROJECTION);
//        // 初始化单位矩阵
//        gl.glLoadIdentity();
//        // 计算透视视窗的宽度、高度比
//        float ratio = (float) width / height;
//        // 调用此方法设置透视视窗的空间大小。
//        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);
//    }
//
//    // 绘制图形的方法
//    @Override
//    public void onDrawFrame(GL10 gl) {
//        // 清除屏幕缓存和深度缓存
//        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
//        // 启用顶点座标数据
//        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
//        // 启用顶点颜色数据
//        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
//        // 设置当前矩阵模式为模型视图。
//        gl.glMatrixMode(GL10.GL_MODELVIEW);
//        // --------------------绘制第一个图形---------------------
//        // 重置当前的模型视图矩阵
//        gl.glLoadIdentity();
//        gl.glTranslatef(-0.6f, 0.0f, -1.5f);
//        // 沿着Y轴旋转
//        gl.glRotatef(rotate, 0f, 0.2f, 0f);
//        // 设置顶点的位置数据
//        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, taperVerticesBuffer);
//        // 设置顶点的颜色数据
//        gl.glColorPointer(4, GL10.GL_FIXED, 0, taperColorsBuffer);
//        // 按taperFacetsBuffer指定的面绘制三角形
//        gl.glDrawElements(GL10.GL_TRIANGLE_STRIP
//                , taperFacetsBuffer.remaining(),
//                GL10.GL_UNSIGNED_BYTE, taperFacetsBuffer);
//        // --------------------绘制第二个图形---------------------
//        // 重置当前的模型视图矩阵
//        gl.glLoadIdentity();
//        gl.glTranslatef(0.7f, 0.0f, -2.2f);
//        // 沿着Y轴旋转
//        gl.glRotatef(rotate, 0f, 0.2f, 0f);
//        // 沿着X轴旋转
//        gl.glRotatef(rotate, 1f, 0f, 0f);
//        // 设置顶点的位置数据
//        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, cubeVerticesBuffer);
//        // 不设置顶点的颜色数据，还用以前的颜色数据
//        // 按cubeFacetsBuffer指定的面绘制三角形
//        gl.glDrawElements(GL10.GL_TRIANGLE_STRIP
//                , cubeFacetsBuffer.remaining(),
//                GL10.GL_UNSIGNED_BYTE, cubeFacetsBuffer);
//
//        // 绘制结束
//        gl.glFinish();
//        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
//        // 旋转角度增加1
//        rotate += 1;
//    }


    private String TAG = "GLRender";
    float roateTri;//用于三角形的角度
    float roateQuad;//用于四边形的角度
    int one = 0x10000;
    /*//三角形三个顶点
    private IntBuffer triggerBuffer = IntBuffer.wrap(new int[]{
        0,one,0,
        -one,-one,0,
        one,-one,0,
    });
    //四边形四个顶点
    private IntBuffer quaterBuffer = IntBuffer.wrap(new int[]{
            -one,one,0,
            one,one,0,
            one,-one,0,
            -one,-one,0,
    });*/
    int[] colorArray = {
            one, 0, 0, one,
            0, one, 0, one,
            0, 0, one, one,
    };
    int[] triggerArray = {
            0, one, 0,
            -one, -one, 0,
            one, -one, 0};
    int[] quaterArray = {
            one, one, 0,
            -one, one, 0,
            one, -one, 0,
            -one, -one, 0,
    };

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        // TODO Auto-generated method stub
//        Log.i(TAG, "onSurfaceCreated");
        //告诉系统对透视进行修正，会使透视图看起来好看点
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        //黑色背景
        gl.glClearColor(0, 0, 0, 0);//红，绿，蓝，apaha
        //启动阴影平滑
        gl.glShadeModel(GL10.GL_SMOOTH);

        //设置深度缓存
        gl.glClearDepthf(1.0f);
        //启用深度测试
        gl.glEnable(GL10.GL_DEPTH_TEST);
        //所做深度测试的类型
        gl.glDepthFunc(GL10.GL_LEQUAL);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        // TODO Auto-generated method stub
//        Log.i(TAG, "onSurfaceChanged width:" + width + " height:" + height);//1920 944
//
        float radio = (float) width / height;

        //设置OpenGL场景的大小
        gl.glViewport(0, 0, width, height);
        //设置投影矩阵,投影矩阵负责为场景增加透视
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重置投影矩阵
        gl.glLoadIdentity();
        //设置视口的大小 前四个参数去顶窗口的大小，分别是左，右，下，上，后两个参数分别是在场景中所能绘制深度的起点和终点
        gl.glFrustumf(-radio, radio, -1, 1, 1, 10);
        //指明任何新的变换即那个会影响 模型观察矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // TODO Auto-generated method stub
        roateTri += 0.5f;
        roateQuad -= 0.5f;

        //清除屏幕和深度缓存
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        // 重置当前的模型观察矩阵
        gl.glLoadIdentity();
        //移动当前中心点，左移1.5单位，并移入屏幕6.0，y不变
        //注意：屏幕内移动的单位数必须小于前面我们通过
        //glFrustumf方法所设置的最远距离，否则显示不出来。
        //腰围OpenGL设置一个顶点数组，故需要告诉OpenGL要设置
        //顶点这个功能。
        //开启顶点设置功能
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        //设置某无题沿着指定的轴旋转
        //参数1：旋转的角度
        //后三个参数共通决定旋转的方向
        //注意：要在画图前，使用旋转
        gl.glRotatef(roateTri, 0.0f, -1.0f, 0.0f);

        //开启颜色渲染功能
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        //设置颜色,平滑着色
        gl.glColorPointer(4, GL10.GL_FIXED, 0, bufferUtil(colorArray));

        //允许设置顶点
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        //设置三角形
        //参数1：描述顶点的尺寸，本例中使用X,Y,Z坐标系，所以是3
        //参数2：描述顶点的类型，本例中数据是固定的，所以使用了GL_FIXED表示固定顶点
        //参数3：描述步长
        //参数4：顶点缓存，即我们创建的顶点数组
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, bufferUtil(triggerArray));
        //绘制三角形
        //参数1：绘制模式，GL_TRIANGLES：表示绘制三角形
        //参数2：开始位置
        //参数3：要绘制的顶点计数
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        //重置当前的模型观察矩阵
        gl.glLoadIdentity();


        //关闭颜色渲染
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);

        //左移1.5单位，并移入屏幕6.0
        gl.glTranslatef(1.5f, 0.0f, -6.0f);

        gl.glRotatef(roateQuad, 1.0f, 0.0f, 0.0f);

        //开启颜色渲染功能
        gl.glEnableClientState(GL10.GL_COLOR_BUFFER_BIT);
        //设置颜色，单调着色 （r,g,b,a）
        gl.glColor4f(0.5f, 0.5f, 1.0f, 1.0f);

        //设置和绘制正方形
        gl.glVertexPointer(3, GL10.GL_FIXED, 0, bufferUtil(quaterArray));
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 4);

        gl.glFinish();

        //关闭颜色渲染
        gl.glDisableClientState(GL10.GL_COLOR_BUFFER_BIT);
        //取消顶点设置
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);

    }

    /*
     * OpenGL 是一个非常底层的画图接口，它所使用的缓冲区存储结构是和我们的 java 程序中不相同的。
     * Java 是大端字节序(BigEdian)，而 OpenGL 所需要的数据是小端字节序(LittleEdian)。
     * 所以，我们在将 Java 的缓冲区转化为 OpenGL 可用的缓冲区时需要作一些工作。建立buff的方法如下
     * */
    public Buffer bufferUtil(int[] arr) {
        IntBuffer mBuffer;

        //先初始化buffer,数组的长度*4,因为一个int占4个字节
        ByteBuffer qbb = ByteBuffer.allocateDirect(arr.length * 4);
        //数组排列用nativeOrder
        qbb.order(ByteOrder.nativeOrder());

        mBuffer = qbb.asIntBuffer();
        mBuffer.put(arr);
        mBuffer.position(0);

        return mBuffer;
    }
}
