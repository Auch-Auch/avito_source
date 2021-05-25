package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.image.ImageProvider;
public interface IconSet {
    void add(@NonNull AnimatedImageProvider animatedImageProvider);

    void add(@NonNull ImageProvider imageProvider);

    void add(@NonNull String str, @NonNull AnimatedImageProvider animatedImageProvider);

    void add(@NonNull String str, @NonNull ImageProvider imageProvider);

    boolean isValid();
}
