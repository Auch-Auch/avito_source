package com.avito.android.serp.ad;

import android.content.Context;
import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetBannerLoaderImpl_Factory implements Factory<MyTargetBannerLoaderImpl> {
    public final Provider<Context> a;
    public final Provider<Analytics> b;
    public final Provider<MyTargetImageBgProvider> c;

    public MyTargetBannerLoaderImpl_Factory(Provider<Context> provider, Provider<Analytics> provider2, Provider<MyTargetImageBgProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static MyTargetBannerLoaderImpl_Factory create(Provider<Context> provider, Provider<Analytics> provider2, Provider<MyTargetImageBgProvider> provider3) {
        return new MyTargetBannerLoaderImpl_Factory(provider, provider2, provider3);
    }

    public static MyTargetBannerLoaderImpl newInstance(Context context, Analytics analytics, MyTargetImageBgProvider myTargetImageBgProvider) {
        return new MyTargetBannerLoaderImpl(context, analytics, myTargetImageBgProvider);
    }

    @Override // javax.inject.Provider
    public MyTargetBannerLoaderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
