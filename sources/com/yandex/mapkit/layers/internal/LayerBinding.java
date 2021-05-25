package com.yandex.mapkit.layers.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.layers.Layer;
import com.yandex.mapkit.layers.LayerLoadedListener;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class LayerBinding implements Layer {
    private Subscription<LayerLoadedListener> layerLoadedListenerSubscription = new Subscription<LayerLoadedListener>() { // from class: com.yandex.mapkit.layers.internal.LayerBinding.1
        public NativeObject createNativeListener(LayerLoadedListener layerLoadedListener) {
            return LayerBinding.createLayerLoadedListener(layerLoadedListener);
        }
    };
    private final NativeObject nativeObject;

    public LayerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createLayerLoadedListener(LayerLoadedListener layerLoadedListener);

    @Override // com.yandex.mapkit.layers.Layer
    public native void activate(boolean z);

    @Override // com.yandex.mapkit.layers.Layer
    public native void clear();

    @Override // com.yandex.mapkit.layers.Layer
    public native void invalidate(@NonNull String str);

    @Override // com.yandex.mapkit.layers.Layer
    public native boolean isValid();

    @Override // com.yandex.mapkit.layers.Layer
    public native void remove();

    @Override // com.yandex.mapkit.layers.Layer
    public native void resetStyles();

    @Override // com.yandex.mapkit.layers.Layer
    public native void setLayerLoadedListener(@Nullable LayerLoadedListener layerLoadedListener);

    @Override // com.yandex.mapkit.layers.Layer
    public native boolean setStyle(int i, @NonNull String str);
}
