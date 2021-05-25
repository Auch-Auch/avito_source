package com.avito.android.publish_limits_info.history;

import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishLimitsHistoryViewModelFactory_Factory implements Factory<PublishLimitsHistoryViewModelFactory> {
    public final Provider<ItemId> a;
    public final Provider<PublishLimitsHistoryInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<RandomKeyProvider> d;

    public PublishLimitsHistoryViewModelFactory_Factory(Provider<ItemId> provider, Provider<PublishLimitsHistoryInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<RandomKeyProvider> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static PublishLimitsHistoryViewModelFactory_Factory create(Provider<ItemId> provider, Provider<PublishLimitsHistoryInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<RandomKeyProvider> provider4) {
        return new PublishLimitsHistoryViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static PublishLimitsHistoryViewModelFactory newInstance(ItemId itemId, PublishLimitsHistoryInteractor publishLimitsHistoryInteractor, SchedulersFactory3 schedulersFactory3, RandomKeyProvider randomKeyProvider) {
        return new PublishLimitsHistoryViewModelFactory(itemId, publishLimitsHistoryInteractor, schedulersFactory3, randomKeyProvider);
    }

    @Override // javax.inject.Provider
    public PublishLimitsHistoryViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
