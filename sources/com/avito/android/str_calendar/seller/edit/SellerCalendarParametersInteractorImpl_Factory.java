package com.avito.android.str_calendar.seller.edit;

import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SellerCalendarParametersInteractorImpl_Factory implements Factory<SellerCalendarParametersInteractorImpl> {
    public final Provider<ShortTermRentApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<LocalPretendInteractor> d;

    public SellerCalendarParametersInteractorImpl_Factory(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SellerCalendarParametersInteractorImpl_Factory create(Provider<ShortTermRentApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<LocalPretendInteractor> provider4) {
        return new SellerCalendarParametersInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static SellerCalendarParametersInteractorImpl newInstance(ShortTermRentApi shortTermRentApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter, LocalPretendInteractor localPretendInteractor) {
        return new SellerCalendarParametersInteractorImpl(shortTermRentApi, schedulersFactory, typedErrorThrowableConverter, localPretendInteractor);
    }

    @Override // javax.inject.Provider
    public SellerCalendarParametersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
