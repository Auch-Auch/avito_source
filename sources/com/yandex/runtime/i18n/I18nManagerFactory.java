package com.yandex.runtime.i18n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class I18nManagerFactory {
    @NonNull
    public static native I18nManager getI18nManagerInstance();

    public static native void getLocale(@NonNull LocaleListener localeListener);

    public static native void setLocale(@Nullable String str);
}
