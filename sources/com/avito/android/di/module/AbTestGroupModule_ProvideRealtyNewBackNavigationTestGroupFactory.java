package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideRealtyNewBackNavigationTestGroupFactory implements Factory<ManuallyExposedAbTestGroup<SimpleTestGroupWithNone>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideRealtyNewBackNavigationTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideRealtyNewBackNavigationTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideRealtyNewBackNavigationTestGroupFactory(abTestGroupModule, provider);
    }

    public static ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> provideRealtyNewBackNavigationTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ManuallyExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideRealtyNewBackNavigationTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public ManuallyExposedAbTestGroup<SimpleTestGroupWithNone> get() {
        return provideRealtyNewBackNavigationTestGroup(this.a, this.b.get());
    }
}
