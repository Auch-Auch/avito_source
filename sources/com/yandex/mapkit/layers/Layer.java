package com.yandex.mapkit.layers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface Layer {
    void activate(boolean z);

    void clear();

    void invalidate(@NonNull String str);

    boolean isValid();

    void remove();

    void resetStyles();

    void setLayerLoadedListener(@Nullable LayerLoadedListener layerLoadedListener);

    boolean setStyle(int i, @NonNull String str);
}
