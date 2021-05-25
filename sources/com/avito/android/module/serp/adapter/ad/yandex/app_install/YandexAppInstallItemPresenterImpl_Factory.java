package com.avito.android.module.serp.adapter.ad.yandex.app_install;

import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdBannerEventListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexAppInstallItemPresenterImpl_Factory implements Factory<YandexAppInstallItemPresenterImpl> {
    public final Provider<AdBannerEventListener> a;
    public final Provider<Analytics> b;

    public YandexAppInstallItemPresenterImpl_Factory(Provider<AdBannerEventListener> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static YandexAppInstallItemPresenterImpl_Factory create(Provider<AdBannerEventListener> provider, Provider<Analytics> provider2) {
        return new YandexAppInstallItemPresenterImpl_Factory(provider, provider2);
    }

    public static YandexAppInstallItemPresenterImpl newInstance(Lazy<AdBannerEventListener> lazy, Analytics analytics) {
        return new YandexAppInstallItemPresenterImpl(lazy, analytics);
    }

    @Override // javax.inject.Provider
    public YandexAppInstallItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get());
    }
}
