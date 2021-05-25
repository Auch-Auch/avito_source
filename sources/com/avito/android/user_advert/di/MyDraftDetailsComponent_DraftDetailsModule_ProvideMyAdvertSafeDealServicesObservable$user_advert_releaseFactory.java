package com.avito.android.user_advert.di;

import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.user_advert.di.MyDraftDetailsComponent;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class MyDraftDetailsComponent_DraftDetailsModule_ProvideMyAdvertSafeDealServicesObservable$user_advert_releaseFactory implements Factory<Relay<MyAdvertSafeDeal>> {

    public static final class a {
        public static final MyDraftDetailsComponent_DraftDetailsModule_ProvideMyAdvertSafeDealServicesObservable$user_advert_releaseFactory a = new MyDraftDetailsComponent_DraftDetailsModule_ProvideMyAdvertSafeDealServicesObservable$user_advert_releaseFactory();
    }

    public static MyDraftDetailsComponent_DraftDetailsModule_ProvideMyAdvertSafeDealServicesObservable$user_advert_releaseFactory create() {
        return a.a;
    }

    public static Relay<MyAdvertSafeDeal> provideMyAdvertSafeDealServicesObservable$user_advert_release() {
        return (Relay) Preconditions.checkNotNullFromProvides(MyDraftDetailsComponent.DraftDetailsModule.INSTANCE.provideMyAdvertSafeDealServicesObservable$user_advert_release());
    }

    @Override // javax.inject.Provider
    public Relay<MyAdvertSafeDeal> get() {
        return provideMyAdvertSafeDealServicesObservable$user_advert_release();
    }
}
