package com.avito.android.user_advert.advert;

import android.os.Bundle;
import com.avito.android.Features;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyAdvertDetailsInteractorImpl_Factory implements Factory<MyAdvertDetailsInteractorImpl> {
    public final Provider<UserAdvertApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<Features> d;
    public final Provider<Bundle> e;

    public MyAdvertDetailsInteractorImpl_Factory(Provider<UserAdvertApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Features> provider4, Provider<Bundle> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static MyAdvertDetailsInteractorImpl_Factory create(Provider<UserAdvertApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<Features> provider4, Provider<Bundle> provider5) {
        return new MyAdvertDetailsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static MyAdvertDetailsInteractorImpl newInstance(UserAdvertApi userAdvertApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, Features features, Bundle bundle) {
        return new MyAdvertDetailsInteractorImpl(userAdvertApi, schedulersFactory3, typedErrorThrowableConverter, features, bundle);
    }

    @Override // javax.inject.Provider
    public MyAdvertDetailsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
