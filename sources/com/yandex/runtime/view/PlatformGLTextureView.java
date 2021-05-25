package com.yandex.runtime.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.graphics.GLDebugBinding;
import com.yandex.runtime.view.internal.GLTextureView;
import com.yandex.runtime.view.internal.MemoryPressureListener;
import com.yandex.runtime.view.internal.PlatformGLRenderer;
import com.yandex.runtime.view.internal.PlatformViewBinding;
import com.yandex.runtime.view.internal.RenderDelegate;
public class PlatformGLTextureView extends GLTextureView implements RenderDelegate, PlatformGLView, PlatformGLRenderer.GLContextListener {
    public boolean glDebugEnabled;
    private int height;
    private MemoryPressureListener memoryPressureListener;
    private PlatformViewBinding platformViewBinding;
    private int width;

    public PlatformGLTextureView(Context context) {
        this(context, null, 0, false);
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void destroyNativePlatformView() {
        stopRenderThread();
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
        if (this.glDebugEnabled) {
            GLDebugBinding.enable();
        }
    }

    @Override // com.yandex.runtime.view.PlatformGLView
    public void onMemoryWarning() {
        this.platformViewBinding.onMemoryWarning();
    }

    @Override // android.view.TextureView, android.view.View
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

    public PlatformGLTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, false);
    }

    public PlatformGLTextureView(Context context, boolean z) {
        this(context, null, 0, z);
    }

    public PlatformGLTextureView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, false);
    }

    public PlatformGLTextureView(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(context, attributeSet, z);
        this.glDebugEnabled = z;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.width = displayMetrics.widthPixels;
        this.height = displayMetrics.heightPixels;
        PlatformGLRenderer platformGLRenderer = new PlatformGLRenderer(this, this);
        this.platformViewBinding = new PlatformViewBinding(platformGLRenderer, this.width, this.height);
        setRenderer(platformGLRenderer);
    }
}
