package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AdvertDetailsIcebreakerStyleTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertDetailsIcebreakerStyleTestGroupFactory implements Factory<AdvertDetailsIcebreakerStyleTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertDetailsIcebreakerStyleTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertDetailsIcebreakerStyleTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertDetailsIcebreakerStyleTestGroupFactory(abTestGroupModule, provider);
    }

    public static AdvertDetailsIcebreakerStyleTestGroup provideAdvertDetailsIcebreakerStyleTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (AdvertDetailsIcebreakerStyleTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertDetailsIcebreakerStyleTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public AdvertDetailsIcebreakerStyleTestGroup get() {
        return provideAdvertDetailsIcebreakerStyleTestGroup(this.a, this.b.get());
    }
}
