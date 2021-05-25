package com.avito.android.publish_limits_info.history;

import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublishLimitsHistoryInteractorImpl_Factory implements Factory<PublishLimitsHistoryInteractorImpl> {
    public final Provider<PublishLimitsApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public PublishLimitsHistoryInteractorImpl_Factory(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static PublishLimitsHistoryInteractorImpl_Factory create(Provider<PublishLimitsApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new PublishLimitsHistoryInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static PublishLimitsHistoryInteractorImpl newInstance(PublishLimitsApi publishLimitsApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new PublishLimitsHistoryInteractorImpl(publishLimitsApi, schedulersFactory3, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public PublishLimitsHistoryInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
