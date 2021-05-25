package com.yandex.runtime.i18n;

import androidx.annotation.NonNull;
public interface I18nManager {
    @NonNull
    CanonicalUnit canonicalSpeed(double d);

    @NonNull
    I18nPrefs getPrefs();

    @NonNull
    SystemOfMeasurement getSom();

    @NonNull
    TimeFormat getTimeFormat();

    boolean isValid();

    @NonNull
    String localizeCanonicalUnit(@NonNull CanonicalUnit canonicalUnit);

    @NonNull
    String localizeDataSize(long j);

    @NonNull
    String localizeDistance(int i);

    @NonNull
    String localizeDuration(int i);

    @NonNull
    String localizeSpeed(double d);

    void setPrefs(@NonNull I18nPrefs i18nPrefs);

    void setSom(@NonNull SystemOfMeasurement systemOfMeasurement);

    void setTimeFormat(@NonNull TimeFormat timeFormat);
}
