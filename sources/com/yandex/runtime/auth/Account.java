package com.yandex.runtime.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public interface Account {
    @Nullable
    String httpAuth(@NonNull String str);

    void invalidateToken(@NonNull String str);

    void requestToken(@NonNull TokenListener tokenListener);

    @NonNull
    String uid();
}
