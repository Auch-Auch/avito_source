package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.SerpItemsPrefetchTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory implements Factory<SerpItemsPrefetchTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideSerpItemsPrefetchTestGroupFactory(abTestGroupModule, provider);
    }

    public static SerpItemsPrefetchTestGroup provideSerpItemsPrefetchTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SerpItemsPrefetchTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideSerpItemsPrefetchTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SerpItemsPrefetchTestGroup get() {
        return provideSerpItemsPrefetchTestGroup(this.a, this.b.get());
    }
}
