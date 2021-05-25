package com.avito.android.user_advert.advert.autobooking_block;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoBookingBlockViewModelFactory_Factory implements Factory<AutoBookingBlockViewModelFactory> {
    public final Provider<String> a;
    public final Provider<AutoBookingChangeStateInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<AutoBookingBlockResourceProvider> e;

    public AutoBookingBlockViewModelFactory_Factory(Provider<String> provider, Provider<AutoBookingChangeStateInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AutoBookingBlockResourceProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AutoBookingBlockViewModelFactory_Factory create(Provider<String> provider, Provider<AutoBookingChangeStateInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AutoBookingBlockResourceProvider> provider5) {
        return new AutoBookingBlockViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoBookingBlockViewModelFactory newInstance(String str, AutoBookingChangeStateInteractor autoBookingChangeStateInteractor, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, AutoBookingBlockResourceProvider autoBookingBlockResourceProvider) {
        return new AutoBookingBlockViewModelFactory(str, autoBookingChangeStateInteractor, schedulersFactory3, typedErrorThrowableConverter, autoBookingBlockResourceProvider);
    }

    @Override // javax.inject.Provider
    public AutoBookingBlockViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
