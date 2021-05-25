package com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SoaInfoInteractorImpl_Factory implements Factory<SoaInfoInteractorImpl> {
    public final Provider<UserAdvertsApi> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<TypedErrorThrowableConverter> c;

    public SoaInfoInteractorImpl_Factory(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SoaInfoInteractorImpl_Factory create(Provider<UserAdvertsApi> provider, Provider<SchedulersFactory> provider2, Provider<TypedErrorThrowableConverter> provider3) {
        return new SoaInfoInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SoaInfoInteractorImpl newInstance(UserAdvertsApi userAdvertsApi, SchedulersFactory schedulersFactory, TypedErrorThrowableConverter typedErrorThrowableConverter) {
        return new SoaInfoInteractorImpl(userAdvertsApi, schedulersFactory, typedErrorThrowableConverter);
    }

    @Override // javax.inject.Provider
    public SoaInfoInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
