package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.HomeSkeletonTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideHomeSkeletonTestFactory implements Factory<HomeSkeletonTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideHomeSkeletonTestFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideHomeSkeletonTestFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideHomeSkeletonTestFactory(abTestGroupModule, provider);
    }

    public static HomeSkeletonTestGroup provideHomeSkeletonTest(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (HomeSkeletonTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideHomeSkeletonTest(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public HomeSkeletonTestGroup get() {
        return provideHomeSkeletonTest(this.a, this.b.get());
    }
}
