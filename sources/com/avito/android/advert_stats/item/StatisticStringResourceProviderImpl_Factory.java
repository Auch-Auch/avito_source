package com.avito.android.advert_stats.item;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StatisticStringResourceProviderImpl_Factory implements Factory<StatisticStringResourceProviderImpl> {
    public final Provider<Resources> a;

    public StatisticStringResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static StatisticStringResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new StatisticStringResourceProviderImpl_Factory(provider);
    }

    public static StatisticStringResourceProviderImpl newInstance(Resources resources) {
        return new StatisticStringResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public StatisticStringResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
