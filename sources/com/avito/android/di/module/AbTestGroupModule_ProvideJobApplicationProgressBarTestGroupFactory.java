package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideJobApplicationProgressBarTestGroupFactory implements Factory<ExposedAbTestGroup<SimpleTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideJobApplicationProgressBarTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideJobApplicationProgressBarTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideJobApplicationProgressBarTestGroupFactory(abTestGroupModule, provider);
    }

    public static ExposedAbTestGroup<SimpleTestGroup> provideJobApplicationProgressBarTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideJobApplicationProgressBarTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<SimpleTestGroup> get() {
        return provideJobApplicationProgressBarTestGroup(this.a, this.b.get());
    }
}
