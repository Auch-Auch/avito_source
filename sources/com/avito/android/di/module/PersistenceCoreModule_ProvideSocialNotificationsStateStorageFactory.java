package com.avito.android.di.module;

import com.avito.android.preferences.SocialNotificationStateStorage;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceCoreModule_ProvideSocialNotificationsStateStorageFactory implements Factory<SocialNotificationStateStorage> {
    public final PersistenceCoreModule a;
    public final Provider<Preferences> b;

    public PersistenceCoreModule_ProvideSocialNotificationsStateStorageFactory(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        this.a = persistenceCoreModule;
        this.b = provider;
    }

    public static PersistenceCoreModule_ProvideSocialNotificationsStateStorageFactory create(PersistenceCoreModule persistenceCoreModule, Provider<Preferences> provider) {
        return new PersistenceCoreModule_ProvideSocialNotificationsStateStorageFactory(persistenceCoreModule, provider);
    }

    public static SocialNotificationStateStorage provideSocialNotificationsStateStorage(PersistenceCoreModule persistenceCoreModule, Preferences preferences) {
        return (SocialNotificationStateStorage) Preconditions.checkNotNullFromProvides(persistenceCoreModule.provideSocialNotificationsStateStorage(preferences));
    }

    @Override // javax.inject.Provider
    public SocialNotificationStateStorage get() {
        return provideSocialNotificationsStateStorage(this.a, this.b.get());
    }
}
