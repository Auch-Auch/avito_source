package com.avito.android.safedeal.profile_settings.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ProfileDeliverySettingsTrackerModule_ProvidesScreenContentTypeFactory implements Factory<String> {

    public static final class a {
        public static final ProfileDeliverySettingsTrackerModule_ProvidesScreenContentTypeFactory a = new ProfileDeliverySettingsTrackerModule_ProvidesScreenContentTypeFactory();
    }

    public static ProfileDeliverySettingsTrackerModule_ProvidesScreenContentTypeFactory create() {
        return a.a;
    }

    public static String providesScreenContentType() {
        return (String) Preconditions.checkNotNullFromProvides(ProfileDeliverySettingsTrackerModule.INSTANCE.providesScreenContentType());
    }

    @Override // javax.inject.Provider
    public String get() {
        return providesScreenContentType();
    }
}
