package com.avito.android.di.module;

import com.avito.android.ab_tests.ABTestConfigTracker;
import com.avito.android.ab_tests.AbTestPrefs;
import com.avito.android.util.preferences.Preferences;
import com.google.gson.Gson;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAbTestsModule_ProvideAbTestPrefsFactory implements Factory<AbTestPrefs> {
    public final PersistenceAbTestsModule a;
    public final Provider<Gson> b;
    public final Provider<Preferences> c;
    public final Provider<ABTestConfigTracker> d;

    public PersistenceAbTestsModule_ProvideAbTestPrefsFactory(PersistenceAbTestsModule persistenceAbTestsModule, Provider<Gson> provider, Provider<Preferences> provider2, Provider<ABTestConfigTracker> provider3) {
        this.a = persistenceAbTestsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static PersistenceAbTestsModule_ProvideAbTestPrefsFactory create(PersistenceAbTestsModule persistenceAbTestsModule, Provider<Gson> provider, Provider<Preferences> provider2, Provider<ABTestConfigTracker> provider3) {
        return new PersistenceAbTestsModule_ProvideAbTestPrefsFactory(persistenceAbTestsModule, provider, provider2, provider3);
    }

    public static AbTestPrefs provideAbTestPrefs(PersistenceAbTestsModule persistenceAbTestsModule, Lazy<Gson> lazy, Preferences preferences, ABTestConfigTracker aBTestConfigTracker) {
        return (AbTestPrefs) Preconditions.checkNotNullFromProvides(persistenceAbTestsModule.provideAbTestPrefs(lazy, preferences, aBTestConfigTracker));
    }

    @Override // javax.inject.Provider
    public AbTestPrefs get() {
        return provideAbTestPrefs(this.a, DoubleCheck.lazy(this.b), this.c.get(), this.d.get());
    }
}
