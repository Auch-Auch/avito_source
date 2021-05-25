package com.avito.android.short_term_rent.confirm_booking;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class StrConfirmBookingInteractorImpl_Factory implements Factory<StrConfirmBookingInteractorImpl> {
    public final Provider<ShortTermRentApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<LocalPretendInteractor> d;
    public final Provider<String> e;

    public StrConfirmBookingInteractorImpl_Factory(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<String> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static StrConfirmBookingInteractorImpl_Factory create(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4, Provider<String> provider5) {
        return new StrConfirmBookingInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StrConfirmBookingInteractorImpl newInstance(ShortTermRentApi shortTermRentApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, LocalPretendInteractor localPretendInteractor, String str) {
        return new StrConfirmBookingInteractorImpl(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter, localPretendInteractor, str);
    }

    @Override // javax.inject.Provider
    public StrConfirmBookingInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
