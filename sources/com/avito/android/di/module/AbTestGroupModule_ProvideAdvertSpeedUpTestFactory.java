package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNoneControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAdvertSpeedUpTestFactory implements Factory<AbTestGroup<SimpleTestGroupWithNoneControl2>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAdvertSpeedUpTestFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAdvertSpeedUpTestFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAdvertSpeedUpTestFactory(abTestGroupModule, provider);
    }

    public static AbTestGroup<SimpleTestGroupWithNoneControl2> provideAdvertSpeedUpTest(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (AbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAdvertSpeedUpTest(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public AbTestGroup<SimpleTestGroupWithNoneControl2> get() {
        return provideAdvertSpeedUpTest(this.a, this.b.get());
    }
}
