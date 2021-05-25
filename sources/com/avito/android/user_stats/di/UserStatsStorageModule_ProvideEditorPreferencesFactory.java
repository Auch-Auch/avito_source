package com.avito.android.user_stats.di;

import android.app.Application;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class UserStatsStorageModule_ProvideEditorPreferencesFactory implements Factory<Preferences> {
    public final Provider<Application> a;
    public final Provider<PreferenceFactory> b;

    public UserStatsStorageModule_ProvideEditorPreferencesFactory(Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static UserStatsStorageModule_ProvideEditorPreferencesFactory create(Provider<Application> provider, Provider<PreferenceFactory> provider2) {
        return new UserStatsStorageModule_ProvideEditorPreferencesFactory(provider, provider2);
    }

    public static Preferences provideEditorPreferences(Application application, PreferenceFactory preferenceFactory) {
        return (Preferences) Preconditions.checkNotNullFromProvides(UserStatsStorageModule.INSTANCE.provideEditorPreferences(application, preferenceFactory));
    }

    @Override // javax.inject.Provider
    public Preferences get() {
        return provideEditorPreferences(this.a.get(), this.b.get());
    }
}
