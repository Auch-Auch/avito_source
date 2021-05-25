package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.CallsEarlyBeepsTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_CallsEarlyBeepsTestGroupFactory implements Factory<SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_CallsEarlyBeepsTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> callsEarlyBeepsTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SingleManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.callsEarlyBeepsTestGroup(abTestsConfigProvider));
    }

    public static AbTestGroupModule_CallsEarlyBeepsTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_CallsEarlyBeepsTestGroupFactory(abTestGroupModule, provider);
    }

    @Override // javax.inject.Provider
    public SingleManuallyExposedAbTestGroup<CallsEarlyBeepsTestGroup> get() {
        return callsEarlyBeepsTestGroup(this.a, this.b.get());
    }
}
