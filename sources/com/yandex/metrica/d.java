package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public interface d extends IReporter {
    void a(@Nullable String str, @Nullable String str2);

    void b(@NonNull String str, @Nullable String str2);
}
