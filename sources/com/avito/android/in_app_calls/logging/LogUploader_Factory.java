package com.avito.android.in_app_calls.logging;

import com.avito.android.calls.remote.CallsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LogUploader_Factory implements Factory<LogUploader> {
    public final Provider<CallsApi> a;
    public final Provider<SchedulersFactory3> b;

    public LogUploader_Factory(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LogUploader_Factory create(Provider<CallsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new LogUploader_Factory(provider, provider2);
    }

    public static LogUploader newInstance(CallsApi callsApi, SchedulersFactory3 schedulersFactory3) {
        return new LogUploader(callsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public LogUploader get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
