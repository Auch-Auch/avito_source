package com.avito.android.async_phone;

import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AsyncPhonePresenterImpl_Factory implements Factory<AsyncPhonePresenterImpl> {
    public final Provider<AsyncPhoneInteractor> a;
    public final Provider<TypedErrorThrowableConverter> b;
    public final Provider<AsyncPhoneTracker> c;
    public final Provider<SchedulersFactory3> d;
    public final Provider<AccountStateProvider> e;
    public final Provider<Features> f;
    public final Provider<AsyncPhoneAuthRouter> g;
    public final Provider<TypedErrorThrowableConverter> h;

    public AsyncPhonePresenterImpl_Factory(Provider<AsyncPhoneInteractor> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<AsyncPhoneTracker> provider3, Provider<SchedulersFactory3> provider4, Provider<AccountStateProvider> provider5, Provider<Features> provider6, Provider<AsyncPhoneAuthRouter> provider7, Provider<TypedErrorThrowableConverter> provider8) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
        this.h = provider8;
    }

    public static AsyncPhonePresenterImpl_Factory create(Provider<AsyncPhoneInteractor> provider, Provider<TypedErrorThrowableConverter> provider2, Provider<AsyncPhoneTracker> provider3, Provider<SchedulersFactory3> provider4, Provider<AccountStateProvider> provider5, Provider<Features> provider6, Provider<AsyncPhoneAuthRouter> provider7, Provider<TypedErrorThrowableConverter> provider8) {
        return new AsyncPhonePresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AsyncPhonePresenterImpl newInstance(AsyncPhoneInteractor asyncPhoneInteractor, TypedErrorThrowableConverter typedErrorThrowableConverter, AsyncPhoneTracker asyncPhoneTracker, SchedulersFactory3 schedulersFactory3, AccountStateProvider accountStateProvider, Features features, Lazy<AsyncPhoneAuthRouter> lazy, TypedErrorThrowableConverter typedErrorThrowableConverter2) {
        return new AsyncPhonePresenterImpl(asyncPhoneInteractor, typedErrorThrowableConverter, asyncPhoneTracker, schedulersFactory3, accountStateProvider, features, lazy, typedErrorThrowableConverter2);
    }

    @Override // javax.inject.Provider
    public AsyncPhonePresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), DoubleCheck.lazy(this.g), this.h.get());
    }
}
