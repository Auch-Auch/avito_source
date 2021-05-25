package com.avito.android.user_advert.advert.autopublish_block;

import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AutoPublishBlockViewModelFactory_Factory implements Factory<AutoPublishBlockViewModelFactory> {
    public final Provider<String> a;
    public final Provider<AutoPublishChangeStateInteractor> b;
    public final Provider<SchedulersFactory3> c;
    public final Provider<TypedErrorThrowableConverter> d;
    public final Provider<AutoPublishBlockResourceProvider> e;

    public AutoPublishBlockViewModelFactory_Factory(Provider<String> provider, Provider<AutoPublishChangeStateInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AutoPublishBlockResourceProvider> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AutoPublishBlockViewModelFactory_Factory create(Provider<String> provider, Provider<AutoPublishChangeStateInteractor> provider2, Provider<SchedulersFactory3> provider3, Provider<TypedErrorThrowableConverter> provider4, Provider<AutoPublishBlockResourceProvider> provider5) {
        return new AutoPublishBlockViewModelFactory_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AutoPublishBlockViewModelFactory newInstance(String str, AutoPublishChangeStateInteractor autoPublishChangeStateInteractor, SchedulersFactory3 schedulersFactory3, TypedErrorThrowableConverter typedErrorThrowableConverter, AutoPublishBlockResourceProvider autoPublishBlockResourceProvider) {
        return new AutoPublishBlockViewModelFactory(str, autoPublishChangeStateInteractor, schedulersFactory3, typedErrorThrowableConverter, autoPublishBlockResourceProvider);
    }

    @Override // javax.inject.Provider
    public AutoPublishBlockViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
