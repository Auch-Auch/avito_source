package com.avito.android.certificate_pinning;

import com.avito.android.Features;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
public final class UnsafeNetworkInteractorImpl_Factory implements Factory<UnsafeNetworkInteractorImpl> {
    public final Provider<Features> a;
    public final Provider<Set<Interceptor>> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<OkHttpClient> d;

    public UnsafeNetworkInteractorImpl_Factory(Provider<Features> provider, Provider<Set<Interceptor>> provider2, Provider<SchedulersFactory> provider3, Provider<OkHttpClient> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static UnsafeNetworkInteractorImpl_Factory create(Provider<Features> provider, Provider<Set<Interceptor>> provider2, Provider<SchedulersFactory> provider3, Provider<OkHttpClient> provider4) {
        return new UnsafeNetworkInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static UnsafeNetworkInteractorImpl newInstance(Features features, Set<Interceptor> set, SchedulersFactory schedulersFactory, Provider<OkHttpClient> provider) {
        return new UnsafeNetworkInteractorImpl(features, set, schedulersFactory, provider);
    }

    @Override // javax.inject.Provider
    public UnsafeNetworkInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d);
    }
}
