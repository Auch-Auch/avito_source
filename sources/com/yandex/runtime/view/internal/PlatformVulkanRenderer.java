package com.yandex.runtime.view.internal;

import android.view.Surface;
import com.yandex.runtime.NativeObject;
public class PlatformVulkanRenderer {
    private NativeObject nativeObject = null;

    public PlatformVulkanRenderer(boolean z) {
        this.nativeObject = createNative(z);
    }

    private static native NativeObject createNative(boolean z);

    public native void surfaceChanged(Surface surface, int i, int i2);

    public native void surfaceCreated(Surface surface, int i, int i2);

    public native void surfaceDestroyed(Surface surface);
}
