package com.avito.android.user_advert.limits_info;

import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class LimitsInfoInteractorImpl_Factory implements Factory<LimitsInfoInteractorImpl> {
    public final Provider<PublishLimitsApi> a;
    public final Provider<SchedulersFactory3> b;

    public LimitsInfoInteractorImpl_Factory(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static LimitsInfoInteractorImpl_Factory create(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new LimitsInfoInteractorImpl_Factory(provider, provider2);
    }

    public static LimitsInfoInteractorImpl newInstance(PublishLimitsApi publishLimitsApi, SchedulersFactory3 schedulersFactory3) {
        return new LimitsInfoInteractorImpl(publishLimitsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public LimitsInfoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
