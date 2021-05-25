package com.avito.android.code_confirmation.timer;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RxTimerImpl_Factory implements Factory<RxTimerImpl> {
    public final Provider<SchedulersFactory> a;

    public RxTimerImpl_Factory(Provider<SchedulersFactory> provider) {
        this.a = provider;
    }

    public static RxTimerImpl_Factory create(Provider<SchedulersFactory> provider) {
        return new RxTimerImpl_Factory(provider);
    }

    public static RxTimerImpl newInstance(SchedulersFactory schedulersFactory) {
        return new RxTimerImpl(schedulersFactory);
    }

    @Override // javax.inject.Provider
    public RxTimerImpl get() {
        return newInstance(this.a.get());
    }
}
