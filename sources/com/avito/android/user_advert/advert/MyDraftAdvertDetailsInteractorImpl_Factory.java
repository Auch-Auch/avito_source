package com.avito.android.user_advert.advert;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyDraftAdvertDetailsInteractorImpl_Factory implements Factory<MyDraftAdvertDetailsInteractorImpl> {
    public final Provider<UserAdvertApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<PublishRelay<String>> d;

    public MyDraftAdvertDetailsInteractorImpl_Factory(Provider<UserAdvertApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<PublishRelay<String>> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MyDraftAdvertDetailsInteractorImpl_Factory create(Provider<UserAdvertApi> provider, Provider<SchedulersFactory3> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<PublishRelay<String>> provider4) {
        return new MyDraftAdvertDetailsInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static MyDraftAdvertDetailsInteractorImpl newInstance(UserAdvertApi userAdvertApi, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, PublishRelay<String> publishRelay) {
        return new MyDraftAdvertDetailsInteractorImpl(userAdvertApi, schedulersFactory3, typedErrorThrowableConverter, publishRelay);
    }

    @Override // javax.inject.Provider
    public MyDraftAdvertDetailsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
