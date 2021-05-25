package com.avito.android.serp.ad;

import android.content.Context;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpBannerLoaderImpl_Factory implements Factory<DfpBannerLoaderImpl> {
    public final Provider<Context> a;
    public final Provider<Analytics> b;
    public final Provider<BuildInfo> c;
    public final Provider<Features> d;

    public DfpBannerLoaderImpl_Factory(Provider<Context> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3, Provider<Features> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DfpBannerLoaderImpl_Factory create(Provider<Context> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3, Provider<Features> provider4) {
        return new DfpBannerLoaderImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static DfpBannerLoaderImpl newInstance(Context context, Analytics analytics, BuildInfo buildInfo, Features features) {
        return new DfpBannerLoaderImpl(context, analytics, buildInfo, features);
    }

    @Override // javax.inject.Provider
    public DfpBannerLoaderImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
