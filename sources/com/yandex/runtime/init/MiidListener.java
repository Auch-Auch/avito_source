package com.yandex.runtime.init;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface MiidListener {
    void onMiidError(@NonNull Error error);

    void onMiidReceived(@NonNull String str);
}
