package com.avito.android.settings;

import android.content.res.Resources;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SettingsResourceProviderImpl_Factory implements Factory<SettingsResourceProviderImpl> {
    public final Provider<Resources> a;
    public final Provider<SupportEmailResourceProvider> b;

    public SettingsResourceProviderImpl_Factory(Provider<Resources> provider, Provider<SupportEmailResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SettingsResourceProviderImpl_Factory create(Provider<Resources> provider, Provider<SupportEmailResourceProvider> provider2) {
        return new SettingsResourceProviderImpl_Factory(provider, provider2);
    }

    public static SettingsResourceProviderImpl newInstance(Resources resources, SupportEmailResourceProvider supportEmailResourceProvider) {
        return new SettingsResourceProviderImpl(resources, supportEmailResourceProvider);
    }

    @Override // javax.inject.Provider
    public SettingsResourceProviderImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
