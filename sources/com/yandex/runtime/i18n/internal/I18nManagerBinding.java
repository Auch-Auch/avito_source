package com.yandex.runtime.i18n.internal;

import androidx.annotation.NonNull;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.i18n.CanonicalUnit;
import com.yandex.runtime.i18n.I18nManager;
import com.yandex.runtime.i18n.I18nPrefs;
import com.yandex.runtime.i18n.SystemOfMeasurement;
import com.yandex.runtime.i18n.TimeFormat;
public class I18nManagerBinding implements I18nManager {
    private final NativeObject nativeObject;

    public I18nManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native CanonicalUnit canonicalSpeed(double d);

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native I18nPrefs getPrefs();

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native SystemOfMeasurement getSom();

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native TimeFormat getTimeFormat();

    @Override // com.yandex.runtime.i18n.I18nManager
    public native boolean isValid();

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native String localizeCanonicalUnit(@NonNull CanonicalUnit canonicalUnit);

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native String localizeDataSize(long j);

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native String localizeDistance(int i);

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native String localizeDuration(int i);

    @Override // com.yandex.runtime.i18n.I18nManager
    @NonNull
    public native String localizeSpeed(double d);

    @Override // com.yandex.runtime.i18n.I18nManager
    public native void setPrefs(@NonNull I18nPrefs i18nPrefs);

    @Override // com.yandex.runtime.i18n.I18nManager
    public native void setSom(@NonNull SystemOfMeasurement systemOfMeasurement);

    @Override // com.yandex.runtime.i18n.I18nManager
    public native void setTimeFormat(@NonNull TimeFormat timeFormat);
}
