package com.avito.android.async_phone;

import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AsyncPhoneInteractorImpl_Factory implements Factory<AsyncPhoneInteractorImpl> {
    public final Provider<AsyncPhoneApi> a;
    public final Provider<SchedulersFactory3> b;

    public AsyncPhoneInteractorImpl_Factory(Provider<AsyncPhoneApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AsyncPhoneInteractorImpl_Factory create(Provider<AsyncPhoneApi> provider, Provider<SchedulersFactory3> provider2) {
        return new AsyncPhoneInteractorImpl_Factory(provider, provider2);
    }

    public static AsyncPhoneInteractorImpl newInstance(AsyncPhoneApi asyncPhoneApi, SchedulersFactory3 schedulersFactory3) {
        return new AsyncPhoneInteractorImpl(asyncPhoneApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public AsyncPhoneInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
