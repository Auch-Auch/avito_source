package com.avito.android.safedeal.profile_settings.konveyor;

import dagger.internal.Factory;
public final class ProfileDeliverySettingsContentsComparator_Factory implements Factory<ProfileDeliverySettingsContentsComparator> {

    public static final class a {
        public static final ProfileDeliverySettingsContentsComparator_Factory a = new ProfileDeliverySettingsContentsComparator_Factory();
    }

    public static ProfileDeliverySettingsContentsComparator_Factory create() {
        return a.a;
    }

    public static ProfileDeliverySettingsContentsComparator newInstance() {
        return new ProfileDeliverySettingsContentsComparator();
    }

    @Override // javax.inject.Provider
    public ProfileDeliverySettingsContentsComparator get() {
        return newInstance();
    }
}
