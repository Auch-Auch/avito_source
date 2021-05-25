package com.yandex.mobile.ads.video;

import android.support.annotation.NonNull;
public interface RequestListener<T> {
    void onFailure(@NonNull VideoAdError videoAdError);

    void onSuccess(@NonNull T t);
}
