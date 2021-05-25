package com.avito.android.messenger.service.direct_reply;

import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DirectReplyServiceDelegateImpl_Factory implements Factory<DirectReplyServiceDelegateImpl> {
    public final Provider<DirectReplyServiceInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<RandomKeyProvider> c;

    public DirectReplyServiceDelegateImpl_Factory(Provider<DirectReplyServiceInteractor> provider, Provider<SchedulersFactory> provider2, Provider<RandomKeyProvider> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static DirectReplyServiceDelegateImpl_Factory create(Provider<DirectReplyServiceInteractor> provider, Provider<SchedulersFactory> provider2, Provider<RandomKeyProvider> provider3) {
        return new DirectReplyServiceDelegateImpl_Factory(provider, provider2, provider3);
    }

    public static DirectReplyServiceDelegateImpl newInstance(DirectReplyServiceInteractor directReplyServiceInteractor, SchedulersFactory schedulersFactory, RandomKeyProvider randomKeyProvider) {
        return new DirectReplyServiceDelegateImpl(directReplyServiceInteractor, schedulersFactory, randomKeyProvider);
    }

    @Override // javax.inject.Provider
    public DirectReplyServiceDelegateImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
