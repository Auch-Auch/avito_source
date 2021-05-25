package com.avito.android.tariff.fees_methods.limits_info;

import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PaidPublishLimitsInfoRepositoryImpl_Factory implements Factory<PaidPublishLimitsInfoRepositoryImpl> {
    public final Provider<PublishLimitsApi> a;
    public final Provider<SchedulersFactory3> b;

    public PaidPublishLimitsInfoRepositoryImpl_Factory(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PaidPublishLimitsInfoRepositoryImpl_Factory create(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new PaidPublishLimitsInfoRepositoryImpl_Factory(provider, provider2);
    }

    public static PaidPublishLimitsInfoRepositoryImpl newInstance(PublishLimitsApi publishLimitsApi, SchedulersFactory3 schedulersFactory3) {
        return new PaidPublishLimitsInfoRepositoryImpl(publishLimitsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public PaidPublishLimitsInfoRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
