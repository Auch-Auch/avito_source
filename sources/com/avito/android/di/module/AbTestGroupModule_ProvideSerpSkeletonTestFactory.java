package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SerpSkeletonTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideSerpSkeletonTestFactory implements Factory<SerpSkeletonTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideSerpSkeletonTestFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideSerpSkeletonTestFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideSerpSkeletonTestFactory(abTestGroupModule, provider);
    }

    public static SerpSkeletonTestGroup provideSerpSkeletonTest(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SerpSkeletonTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideSerpSkeletonTest(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SerpSkeletonTestGroup get() {
        return provideSerpSkeletonTest(this.a, this.b.get());
    }
}
