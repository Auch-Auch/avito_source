package com.yandex.runtime.i18n;

import androidx.annotation.NonNull;
public interface LocaleListener {
    void onLocaleReceived(@NonNull String str);
}
