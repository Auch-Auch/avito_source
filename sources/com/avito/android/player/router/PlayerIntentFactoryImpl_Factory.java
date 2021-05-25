package com.avito.android.player.router;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlayerIntentFactoryImpl_Factory implements Factory<PlayerIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<CoreActivityIntentFactory> b;

    public PlayerIntentFactoryImpl_Factory(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PlayerIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<CoreActivityIntentFactory> provider2) {
        return new PlayerIntentFactoryImpl_Factory(provider, provider2);
    }

    public static PlayerIntentFactoryImpl newInstance(Application application, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new PlayerIntentFactoryImpl(application, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public PlayerIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
