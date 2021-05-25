package com.avito.android.serp.adapter;

import android.content.res.Resources;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SerpShortcutBannerWidthProvider_Factory implements Factory<SerpShortcutBannerWidthProvider> {
    public final Provider<Resources> a;
    public final Provider<BuildInfo> b;

    public SerpShortcutBannerWidthProvider_Factory(Provider<Resources> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SerpShortcutBannerWidthProvider_Factory create(Provider<Resources> provider, Provider<BuildInfo> provider2) {
        return new SerpShortcutBannerWidthProvider_Factory(provider, provider2);
    }

    public static SerpShortcutBannerWidthProvider newInstance(Resources resources, BuildInfo buildInfo) {
        return new SerpShortcutBannerWidthProvider(resources, buildInfo);
    }

    @Override // javax.inject.Provider
    public SerpShortcutBannerWidthProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
