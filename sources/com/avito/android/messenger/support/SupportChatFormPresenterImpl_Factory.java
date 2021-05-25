package com.avito.android.messenger.support;

import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SupportChatFormPresenterImpl_Factory implements Factory<SupportChatFormPresenterImpl> {
    public final Provider<Integer> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<SupportChatFormInteractor> c;
    public final Provider<Formatter<Throwable>> d;

    public SupportChatFormPresenterImpl_Factory(Provider<Integer> provider, Provider<SchedulersFactory> provider2, Provider<SupportChatFormInteractor> provider3, Provider<Formatter<Throwable>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SupportChatFormPresenterImpl_Factory create(Provider<Integer> provider, Provider<SchedulersFactory> provider2, Provider<SupportChatFormInteractor> provider3, Provider<Formatter<Throwable>> provider4) {
        return new SupportChatFormPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SupportChatFormPresenterImpl newInstance(int i, SchedulersFactory schedulersFactory, SupportChatFormInteractor supportChatFormInteractor, Formatter<Throwable> formatter) {
        return new SupportChatFormPresenterImpl(i, schedulersFactory, supportChatFormInteractor, formatter);
    }

    @Override // javax.inject.Provider
    public SupportChatFormPresenterImpl get() {
        return newInstance(this.a.get().intValue(), this.b.get(), this.c.get(), this.d.get());
    }
}
