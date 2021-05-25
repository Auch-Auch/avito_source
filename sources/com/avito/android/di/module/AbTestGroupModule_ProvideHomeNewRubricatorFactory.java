package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.HomeNewRubricatorTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideHomeNewRubricatorFactory implements Factory<HomeNewRubricatorTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideHomeNewRubricatorFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideHomeNewRubricatorFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideHomeNewRubricatorFactory(abTestGroupModule, provider);
    }

    public static HomeNewRubricatorTestGroup provideHomeNewRubricator(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (HomeNewRubricatorTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideHomeNewRubricator(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public HomeNewRubricatorTestGroup get() {
        return provideHomeNewRubricator(this.a, this.b.get());
    }
}
