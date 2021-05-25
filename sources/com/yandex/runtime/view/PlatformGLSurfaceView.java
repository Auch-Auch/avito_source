package com.yandex.runtime.view;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.graphics.GLDebugBinding;
import com.yandex.runtime.view.internal.EGLConfigChooserImpl;
import com.yandex.runtime.view.internal.GLContextFactory;
import com.yandex.runtime.view.internal.MemoryPressureListener;
import com.yandex.runtime.view.internal.PlatformGLRenderer;
import com.yandex.runtime.view.internal.PlatformViewBinding;
import com.yandex.runtime.view.internal.RenderDelegate;
import java.lang.reflect.InvocationTargetException;
public class PlatformGLSurfaceView extends GLSurfaceView implements RenderDelegate, PlatformGLView, PlatformGLRenderer.GLContextListener {
    private static final String LOG_TAG = "PlatformGLSurfaceView";
    private boolean glDebugEnabled;
    private int height;
    private MemoryPressureListener memoryPressureListener;
    private PlatformViewBinding platformViewBinding;
    private int width;

    public PlatformGLSurfaceView(Context context) {
        this(context, null, 0, false);
    }

    private void handlePreserveEGLContextOnPause() {
        String glGetString = GLES20.glGetString(7936);
        if (glGetString == null || !glGetString.toUpperCase().contains("NVIDIA")) {
            try {
                GLSurfaceView.class.getMethod("setPreserveEGLContextOnPause", Boolean.TYPE).invoke(this, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException unused) {
            }
        }
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void destroyNativePlatformView() {
        this.platformViewBinding.destroyNative();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.platformViewBinding.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public NativeObject getNativePlatformView() {
        return this.platformViewBinding.getNative();
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public View getView() {
        return this;
    }

    @Override // com.yandex.runtime.view.internal.PlatformGLRenderer.GLContextListener
    public void onContextCreated() {
        handlePreserveEGLContextOnPause();
        if (this.glDebugEnabled) {
            GLDebugBinding.enable();
        }
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void onMemoryWarning() {
        this.platformViewBinding.onMemoryWarning();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.width = i;
        this.height = i2;
        super.onSizeChanged(i, i2, i3, i4);
        this.platformViewBinding.onSizeChanged(this.width, this.height);
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void pause() {
        this.platformViewBinding.onPause();
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void resume() {
        this.platformViewBinding.onResume();
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void setNoninteractive(boolean z) {
        this.platformViewBinding.setNoninteractive(z);
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void start() {
        if (this.memoryPressureListener == null) {
            this.memoryPressureListener = new MemoryPressureListener(this);
            getContext().registerComponentCallbacks(this.memoryPressureListener);
        }
        onResume();
        this.platformViewBinding.onStart(this.width, this.height);
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void stop() {
        if (this.memoryPressureListener != null) {
            getContext().unregisterComponentCallbacks(this.memoryPressureListener);
            this.memoryPressureListener = null;
        }
        this.platformViewBinding.onStop();
        onPause();
    }

    public PlatformGLSurfaceView(Context context, boolean z) {
        this(context, null, 0, z);
    }

    public PlatformGLSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false);
    }

    public PlatformGLSurfaceView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    public PlatformGLSurfaceView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet);
        this.glDebugEnabled = z;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
        EGLConfigChooserImpl eGLConfigChooserImpl = new EGLConfigChooserImpl();
        setEGLConfigChooser(eGLConfigChooserImpl);
        setEGLContextFactory(new GLContextFactory(z, eGLConfigChooserImpl));
        PlatformGLRenderer platformGLRenderer = new PlatformGLRenderer(this, this);
        this.platformViewBinding = new PlatformViewBinding(platformGLRenderer, this.width, this.height);
        setRenderer(platformGLRenderer);
        setRenderMode(0);
    }
}
