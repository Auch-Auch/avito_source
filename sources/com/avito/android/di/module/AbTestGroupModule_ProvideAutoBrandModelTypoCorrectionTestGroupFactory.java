package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.AutoBrandModelTypoCorrectionTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideAutoBrandModelTypoCorrectionTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideAutoBrandModelTypoCorrectionTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideAutoBrandModelTypoCorrectionTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideAutoBrandModelTypoCorrectionTestGroupFactory(abTestGroupModule, provider);
    }

    public static SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> provideAutoBrandModelTypoCorrectionTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideAutoBrandModelTypoCorrectionTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<AutoBrandModelTypoCorrectionTestGroup> get() {
        return provideAutoBrandModelTypoCorrectionTestGroup(this.a, this.b.get());
    }
}
