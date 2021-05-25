package com.avito.android.safedeal.profile_settings;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileDeliverySettingsResourceProviderImpl_Factory implements Factory<ProfileDeliverySettingsResourceProviderImpl> {
    public final Provider<Resources> a;

    public ProfileDeliverySettingsResourceProviderImpl_Factory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ProfileDeliverySettingsResourceProviderImpl_Factory create(Provider<Resources> provider) {
        return new ProfileDeliverySettingsResourceProviderImpl_Factory(provider);
    }

    public static ProfileDeliverySettingsResourceProviderImpl newInstance(Resources resources) {
        return new ProfileDeliverySettingsResourceProviderImpl(resources);
    }

    @Override // javax.inject.Provider
    public ProfileDeliverySettingsResourceProviderImpl get() {
        return newInstance(this.a.get());
    }
}
