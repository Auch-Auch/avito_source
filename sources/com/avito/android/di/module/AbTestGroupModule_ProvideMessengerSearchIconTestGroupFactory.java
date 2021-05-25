package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideMessengerSearchIconTestGroupFactory implements Factory<SimpleTestGroup> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideMessengerSearchIconTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideMessengerSearchIconTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideMessengerSearchIconTestGroupFactory(abTestGroupModule, provider);
    }

    public static SimpleTestGroup provideMessengerSearchIconTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (SimpleTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideMessengerSearchIconTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public SimpleTestGroup get() {
        return provideMessengerSearchIconTestGroup(this.a, this.b.get());
    }
}
