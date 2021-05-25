package com.avito.android.in_app_calls.logging;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppLogStreamer_Factory implements Factory<AppLogStreamer> {
    public final Provider<String[]> a;

    public AppLogStreamer_Factory(Provider<String[]> provider) {
        this.a = provider;
    }

    public static AppLogStreamer_Factory create(Provider<String[]> provider) {
        return new AppLogStreamer_Factory(provider);
    }

    public static AppLogStreamer newInstance(String[] strArr) {
        return new AppLogStreamer(strArr);
    }

    @Override // javax.inject.Provider
    public AppLogStreamer get() {
        return newInstance(this.a.get());
    }
}
