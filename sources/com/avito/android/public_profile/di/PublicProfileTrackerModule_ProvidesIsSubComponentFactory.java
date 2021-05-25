package com.avito.android.public_profile.di;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class PublicProfileTrackerModule_ProvidesIsSubComponentFactory implements Factory<Boolean> {
    public final Provider<Boolean> a;

    public PublicProfileTrackerModule_ProvidesIsSubComponentFactory(Provider<Boolean> provider) {
        this.a = provider;
    }

    public static PublicProfileTrackerModule_ProvidesIsSubComponentFactory create(Provider<Boolean> provider) {
        return new PublicProfileTrackerModule_ProvidesIsSubComponentFactory(provider);
    }

    public static boolean providesIsSubComponent(boolean z) {
        return PublicProfileTrackerModule.INSTANCE.providesIsSubComponent(z);
    }

    @Override // javax.inject.Provider
    public Boolean get() {
        return Boolean.valueOf(providesIsSubComponent(this.a.get().booleanValue()));
    }
}
