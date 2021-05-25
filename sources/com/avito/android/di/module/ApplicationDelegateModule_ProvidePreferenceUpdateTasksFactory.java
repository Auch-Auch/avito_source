package com.avito.android.di.module;

import android.content.SharedPreferences;
import com.avito.android.preferences.migration.delegate.PreferenceUpdateTask;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.List;
import javax.inject.Provider;
public final class ApplicationDelegateModule_ProvidePreferenceUpdateTasksFactory implements Factory<List<PreferenceUpdateTask>> {
    public final ApplicationDelegateModule a;
    public final Provider<SharedPreferences> b;

    public ApplicationDelegateModule_ProvidePreferenceUpdateTasksFactory(ApplicationDelegateModule applicationDelegateModule, Provider<SharedPreferences> provider) {
        this.a = applicationDelegateModule;
        this.b = provider;
    }

    public static ApplicationDelegateModule_ProvidePreferenceUpdateTasksFactory create(ApplicationDelegateModule applicationDelegateModule, Provider<SharedPreferences> provider) {
        return new ApplicationDelegateModule_ProvidePreferenceUpdateTasksFactory(applicationDelegateModule, provider);
    }

    public static List<PreferenceUpdateTask> providePreferenceUpdateTasks(ApplicationDelegateModule applicationDelegateModule, SharedPreferences sharedPreferences) {
        return (List) Preconditions.checkNotNullFromProvides(applicationDelegateModule.providePreferenceUpdateTasks(sharedPreferences));
    }

    @Override // javax.inject.Provider
    public List<PreferenceUpdateTask> get() {
        return providePreferenceUpdateTasks(this.a, this.b.get());
    }
}
