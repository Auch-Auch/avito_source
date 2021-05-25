package com.avito.android.messenger.channels.mvi.di;

import android.content.SharedPreferences;
import com.avito.android.messenger.folders.FolderOnboardingStatusStorage;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory implements Factory<FolderOnboardingStatusStorage> {
    public final Provider<SharedPreferences> a;

    public ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory(Provider<SharedPreferences> provider) {
        this.a = provider;
    }

    public static ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory create(Provider<SharedPreferences> provider) {
        return new ChannelsModule_ProvideFoldersOnboardingStatusStorageFactory(provider);
    }

    public static FolderOnboardingStatusStorage provideFoldersOnboardingStatusStorage(SharedPreferences sharedPreferences) {
        return (FolderOnboardingStatusStorage) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideFoldersOnboardingStatusStorage(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public FolderOnboardingStatusStorage get() {
        return provideFoldersOnboardingStatusStorage(this.a.get());
    }
}
