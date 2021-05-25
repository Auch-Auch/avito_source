package com.avito.android.serp.ad;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexBannerLoaderImpl_Factory implements Factory<YandexBannerLoaderImpl> {
    public final Provider<Context> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<Analytics> c;

    public YandexBannerLoaderImpl_Factory(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<Analytics> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static YandexBannerLoaderImpl_Factory create(Provider<Context> provider, Provider<SchedulersFactory3> provider2, Provider<Analytics> provider3) {
        return new YandexBannerLoaderImpl_Factory(provider, provider2, provider3);
    }

    public static YandexBannerLoaderImpl newInstance(Context context, SchedulersFactory3 schedulersFactory3, Analytics analytics) {
        return new YandexBannerLoaderImpl(context, schedulersFactory3, analytics);
    }

    @Override // javax.inject.Provider
    public YandexBannerLoaderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
