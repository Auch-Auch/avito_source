package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.models.AbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideJustDialSellerPhoneTestGroupFactory implements Factory<AbTestGroup<SimpleTestGroupWithControl2>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideJustDialSellerPhoneTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideJustDialSellerPhoneTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideJustDialSellerPhoneTestGroupFactory(abTestGroupModule, provider);
    }

    public static AbTestGroup<SimpleTestGroupWithControl2> provideJustDialSellerPhoneTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (AbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideJustDialSellerPhoneTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public AbTestGroup<SimpleTestGroupWithControl2> get() {
        return provideJustDialSellerPhoneTestGroup(this.a, this.b.get());
    }
}
