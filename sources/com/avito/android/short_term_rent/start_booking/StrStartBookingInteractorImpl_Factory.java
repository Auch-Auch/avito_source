package com.avito.android.short_term_rent.start_booking;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrStartBookingInteractorImpl_Factory implements Factory<StrStartBookingInteractorImpl> {
    public final Provider<ShortTermRentApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<String> d;

    public StrStartBookingInteractorImpl_Factory(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<String> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static StrStartBookingInteractorImpl_Factory create(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<String> provider4) {
        return new StrStartBookingInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static StrStartBookingInteractorImpl newInstance(ShortTermRentApi shortTermRentApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, String str) {
        return new StrStartBookingInteractorImpl(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter, str);
    }

    @Override // javax.inject.Provider
    public StrStartBookingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
