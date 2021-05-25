package com.avito.android.advert_core.short_term_rent;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertStrBlockInteractorImpl_Factory implements Factory<AdvertStrBlockInteractorImpl> {
    public final Provider<String> a;
    public final Provider<ShortTermRentApi> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;

    public AdvertStrBlockInteractorImpl_Factory(Provider<String> provider, Provider<ShortTermRentApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static AdvertStrBlockInteractorImpl_Factory create(Provider<String> provider, Provider<ShortTermRentApi> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4) {
        return new AdvertStrBlockInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static AdvertStrBlockInteractorImpl newInstance(String str, ShortTermRentApi shortTermRentApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new AdvertStrBlockInteractorImpl(str, shortTermRentApi, schedulersFactory3, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public AdvertStrBlockInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
