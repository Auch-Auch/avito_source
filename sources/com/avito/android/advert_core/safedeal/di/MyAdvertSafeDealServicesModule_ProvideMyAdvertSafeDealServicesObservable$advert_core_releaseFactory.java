package com.avito.android.advert_core.safedeal.di;

import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory implements Factory<Relay<MyAdvertSafeDeal>> {

    public static final class a {
        public static final MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory a = new MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory();
    }

    public static MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory create() {
        return a.a;
    }

    public static Relay<MyAdvertSafeDeal> provideMyAdvertSafeDealServicesObservable$advert_core_release() {
        return (Relay) Preconditions.checkNotNullFromProvides(MyAdvertSafeDealServicesModule.INSTANCE.provideMyAdvertSafeDealServicesObservable$advert_core_release());
    }

    @Override // javax.inject.Provider
    public Relay<MyAdvertSafeDeal> get() {
        return provideMyAdvertSafeDealServicesObservable$advert_core_release();
    }
}
