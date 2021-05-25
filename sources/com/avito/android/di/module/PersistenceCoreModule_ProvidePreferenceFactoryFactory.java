package com.avito.android.di.module;

import com.avito.android.util.preferences.PreferenceFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PersistenceCoreModule_ProvidePreferenceFactoryFactory implements Factory<PreferenceFactory> {
    public final PersistenceCoreModule a;

    public PersistenceCoreModule_ProvidePreferenceFactoryFactory(PersistenceCoreModule persistenceCoreModule) {
        this.a = persistenceCoreModule;
    }

    public static PersistenceCoreModule_ProvidePreferenceFactoryFactory create(PersistenceCoreModule persistenceCoreModule) {
        return new PersistenceCoreModule_ProvidePreferenceFactoryFactory(persistenceCoreModule);
    }

    public static PreferenceFactory providePreferenceFactory(PersistenceCoreModule persistenceCoreModule) {
        return (PreferenceFactory) Preconditions.checkNotNullFromProvides(persistenceCoreModule.providePreferenceFactory());
    }

    @Override // javax.inject.Provider
    public PreferenceFactory get() {
        return providePreferenceFactory(this.a);
    }
}
