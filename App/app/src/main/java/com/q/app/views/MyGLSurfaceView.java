package com.q.app.views;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by qli on 16/8/12.
 */
public class MyGLSurfaceView extends GLSurfaceView {
    public MyGLSurfaceView(Context context) {
        super(context);

        try {
            // Create an OpenGL ES 2.0 context
            setEGLContextClientVersion(2);

            // Set the Renderer for drawing on the GLSurfaceView
            setRenderer(new MyRenderer());

            // Render the view only when there is a change in the drawing
            // data
            setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

            // 注意上面语句的顺序，反了可能会出错

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
