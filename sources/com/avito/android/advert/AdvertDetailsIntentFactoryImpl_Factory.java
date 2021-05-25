package com.avito.android.advert;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsIntentFactoryImpl_Factory implements Factory<AdvertDetailsIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public AdvertDetailsIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AdvertDetailsIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new AdvertDetailsIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static AdvertDetailsIntentFactoryImpl newInstance(Application application, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new AdvertDetailsIntentFactoryImpl(application, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
