package com.avito.android.advert_core.safedeal;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertSafeDealServicesInteractorImpl_Factory implements Factory<MyAdvertSafeDealServicesInteractorImpl> {
    public final Provider<String> a;
    public final Provider<SafeDealApi> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<SchedulersFactory3> d;

    public MyAdvertSafeDealServicesInteractorImpl_Factory(Provider<String> provider, Provider<SafeDealApi> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MyAdvertSafeDealServicesInteractorImpl_Factory create(Provider<String> provider, Provider<SafeDealApi> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4) {
        return new MyAdvertSafeDealServicesInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MyAdvertSafeDealServicesInteractorImpl newInstance(String str, SafeDealApi safeDealApi, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new MyAdvertSafeDealServicesInteractorImpl(str, safeDealApi, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public MyAdvertSafeDealServicesInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
