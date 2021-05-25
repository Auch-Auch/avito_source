package com.yandex.mapkit.logo;

import androidx.annotation.NonNull;
public interface Logo {
    boolean isValid();

    void setAlignment(@NonNull Alignment alignment);
}
