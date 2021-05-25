package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface SublayerManager {
    @NonNull
    Sublayer appendSublayer(@NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Nullable
    Integer findFirstOf(@NonNull String str);

    @Nullable
    Integer findFirstOf(@NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @Nullable
    Sublayer get(int i);

    @NonNull
    Sublayer insertSublayerAfter(int i, @NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    @NonNull
    Sublayer insertSublayerBefore(int i, @NonNull String str, @NonNull SublayerFeatureType sublayerFeatureType);

    boolean isValid();

    void moveAfter(int i, int i2);

    void moveBefore(int i, int i2);

    void moveToEnd(int i);

    void remove(int i);

    int size();
}
