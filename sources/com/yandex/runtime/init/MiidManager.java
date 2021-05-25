package com.yandex.runtime.init;

import androidx.annotation.NonNull;
public interface MiidManager {
    boolean isValid();

    void submit(@NonNull MiidListener miidListener);
}
