package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.TinkoffCreditCalculatorTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideTinkoffCreditCalculatorTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideTinkoffCreditCalculatorTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideTinkoffCreditCalculatorTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideTinkoffCreditCalculatorTestGroupFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> provideTinkoffCreditCalculatorTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideTinkoffCreditCalculatorTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<TinkoffCreditCalculatorTestGroup> get() {
        return provideTinkoffCreditCalculatorTestGroup(this.a, this.b.get());
    }
}
