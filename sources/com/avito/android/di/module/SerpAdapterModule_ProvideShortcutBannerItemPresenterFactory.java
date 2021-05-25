package com.avito.android.di.module;

import android.app.Activity;
import com.avito.android.serp.adapter.ShortcutBannerItemListener;
import com.avito.android.serp.adapter.ShortcutBannerItemPresenter;
import com.avito.android.serp.adapter.ShortcutBannerWidthProvider;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory implements Factory<ShortcutBannerItemPresenter> {
    public final Provider<ShortcutBannerItemListener> a;
    public final Provider<ShortcutBannerWidthProvider> b;
    public final Provider<Activity> c;

    public SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory(Provider<ShortcutBannerItemListener> provider, Provider<ShortcutBannerWidthProvider> provider2, Provider<Activity> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory create(Provider<ShortcutBannerItemListener> provider, Provider<ShortcutBannerWidthProvider> provider2, Provider<Activity> provider3) {
        return new SerpAdapterModule_ProvideShortcutBannerItemPresenterFactory(provider, provider2, provider3);
    }

    public static ShortcutBannerItemPresenter provideShortcutBannerItemPresenter(Lazy<ShortcutBannerItemListener> lazy, ShortcutBannerWidthProvider shortcutBannerWidthProvider, Activity activity) {
        return (ShortcutBannerItemPresenter) Preconditions.checkNotNullFromProvides(SerpAdapterModule.provideShortcutBannerItemPresenter(lazy, shortcutBannerWidthProvider, activity));
    }

    @Override // javax.inject.Provider
    public ShortcutBannerItemPresenter get() {
        return provideShortcutBannerItemPresenter(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
