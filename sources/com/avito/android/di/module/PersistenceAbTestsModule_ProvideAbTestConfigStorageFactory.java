package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestPrefs;
import com.avito.android.ab_tests.AbTestsConfigStorage;
import com.avito.android.ab_tests.UsedAbTestReporter;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.BuildInfo;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class PersistenceAbTestsModule_ProvideAbTestConfigStorageFactory implements Factory<AbTestsConfigStorage> {
    public final PersistenceAbTestsModule a;
    public final Provider<AbTestPrefs> b;
    public final Provider<UsedAbTestReporter> c;
    public final Provider<Features> d;
    public final Provider<Analytics> e;
    public final Provider<BuildInfo> f;
    public final Provider<Gson> g;

    public PersistenceAbTestsModule_ProvideAbTestConfigStorageFactory(PersistenceAbTestsModule persistenceAbTestsModule, Provider<AbTestPrefs> provider, Provider<UsedAbTestReporter> provider2, Provider<Features> provider3, Provider<Analytics> provider4, Provider<BuildInfo> provider5, Provider<Gson> provider6) {
        this.a = persistenceAbTestsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static PersistenceAbTestsModule_ProvideAbTestConfigStorageFactory create(PersistenceAbTestsModule persistenceAbTestsModule, Provider<AbTestPrefs> provider, Provider<UsedAbTestReporter> provider2, Provider<Features> provider3, Provider<Analytics> provider4, Provider<BuildInfo> provider5, Provider<Gson> provider6) {
        return new PersistenceAbTestsModule_ProvideAbTestConfigStorageFactory(persistenceAbTestsModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static AbTestsConfigStorage provideAbTestConfigStorage(PersistenceAbTestsModule persistenceAbTestsModule, AbTestPrefs abTestPrefs, UsedAbTestReporter usedAbTestReporter, Features features, Analytics analytics, BuildInfo buildInfo, Gson gson) {
        return (AbTestsConfigStorage) Preconditions.checkNotNullFromProvides(persistenceAbTestsModule.provideAbTestConfigStorage(abTestPrefs, usedAbTestReporter, features, analytics, buildInfo, gson));
    }

    @Override // javax.inject.Provider
    public AbTestsConfigStorage get() {
        return provideAbTestConfigStorage(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}
