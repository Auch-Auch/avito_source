package com.avito.android.di.module;

import android.content.SharedPreferences;
import com.avito.android.preferences.migration.PreferencesMigrationManager;
import com.avito.android.preferences.migration.delegate.PreferenceUpdateTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvidePreferencesMigrationManagerFactory implements Factory<PreferencesMigrationManager> {
    public final ApplicationDelegateModule a;
    public final Provider<SharedPreferences> b;
    public final Provider<List<PreferenceUpdateTask>> c;

    public ApplicationDelegateModule_ProvidePreferencesMigrationManagerFactory(ApplicationDelegateModule applicationDelegateModule, Provider<SharedPreferences> provider, Provider<List<PreferenceUpdateTask>> provider2) {
        this.a = applicationDelegateModule;
        this.b = provider;
        this.c = provider2;
    }

    public static ApplicationDelegateModule_ProvidePreferencesMigrationManagerFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<SharedPreferences> provider, Provider<List<PreferenceUpdateTask>> provider2) {
        return new ApplicationDelegateModule_ProvidePreferencesMigrationManagerFactory(applicationDelegateModule, provider, provider2);
    }

    public static PreferencesMigrationManager providePreferencesMigrationManager(ApplicationDelegateModule applicationDelegateModule, SharedPreferences sharedPreferences, List<PreferenceUpdateTask> list) {
        return (PreferencesMigrationManager) Preconditions.checkNotNullFromProvides(applicationDelegateModule.providePreferencesMigrationManager(sharedPreferences, list));
    }

    @Override // javax.inject.Provider
    public PreferencesMigrationManager get() {
        return providePreferencesMigrationManager(this.a, this.b.get(), this.c.get());
    }
}
