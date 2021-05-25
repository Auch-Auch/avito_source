package com.avito.android.settings;

import android.app.Application;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SettingsIntentFactoryImpl_Factory implements Factory<SettingsIntentFactoryImpl> {
    public final Provider<Application> a;
    public final Provider<Features> b;
    public final Provider<CoreActivityIntentFactory> c;

    public SettingsIntentFactoryImpl_Factory(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SettingsIntentFactoryImpl_Factory create(Provider<Application> provider, Provider<Features> provider2, Provider<CoreActivityIntentFactory> provider3) {
        return new SettingsIntentFactoryImpl_Factory(provider, provider2, provider3);
    }

    public static SettingsIntentFactoryImpl newInstance(Application application, Features features, CoreActivityIntentFactory coreActivityIntentFactory) {
        return new SettingsIntentFactoryImpl(application, features, coreActivityIntentFactory);
    }

    @Override // javax.inject.Provider
    public SettingsIntentFactoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
