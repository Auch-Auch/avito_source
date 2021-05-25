package com.avito.android.module.serp.adapter.ad.yandex.content;

import com.avito.android.ab_tests.configs.OrangeAdBadgeTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.AdBannerEventListener;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class YandexContentItemPresenterImpl_Factory implements Factory<YandexContentItemPresenterImpl> {
    public final Provider<AdBannerEventListener> a;
    public final Provider<Analytics> b;
    public final Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> c;

    public YandexContentItemPresenterImpl_Factory(Provider<AdBannerEventListener> provider, Provider<Analytics> provider2, Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static YandexContentItemPresenterImpl_Factory create(Provider<AdBannerEventListener> provider, Provider<Analytics> provider2, Provider<ExposedAbTestGroup<OrangeAdBadgeTestGroup>> provider3) {
        return new YandexContentItemPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static YandexContentItemPresenterImpl newInstance(Lazy<AdBannerEventListener> lazy, Analytics analytics, ExposedAbTestGroup<OrangeAdBadgeTestGroup> exposedAbTestGroup) {
        return new YandexContentItemPresenterImpl(lazy, analytics, exposedAbTestGroup);
    }

    @Override // javax.inject.Provider
    public YandexContentItemPresenterImpl get() {
        return newInstance(DoubleCheck.lazy(this.a), this.b.get(), this.c.get());
    }
}
