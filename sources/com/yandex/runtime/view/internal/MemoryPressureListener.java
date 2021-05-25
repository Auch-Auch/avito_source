package com.yandex.runtime.view.internal;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.yandex.runtime.view.PlatformGLView;
import java.lang.ref.WeakReference;
public class MemoryPressureListener implements ComponentCallbacks2 {
    private WeakReference<PlatformGLView> weakPlatformView;

    public MemoryPressureListener(PlatformGLView platformGLView) {
        this.weakPlatformView = new WeakReference<>(platformGLView);
    }

    private void onMemoryWarning() {
        PlatformGLView platformGLView = this.weakPlatformView.get();
        if (platformGLView != null) {
            platformGLView.onMemoryWarning();
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onMemoryWarning();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 80 || i == 20 || i == 10 || i == 15) {
            onMemoryWarning();
        }
    }
}
