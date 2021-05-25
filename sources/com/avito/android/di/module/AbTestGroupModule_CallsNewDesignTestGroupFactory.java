package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.CallsNewDesignTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_CallsNewDesignTestGroupFactory implements Factory<ExposedAbTestGroup<CallsNewDesignTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_CallsNewDesignTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static ExposedAbTestGroup<CallsNewDesignTestGroup> callsNewDesignTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (ExposedAbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.callsNewDesignTestGroup(abTestsConfigProvider));
    }

    public static AbTestGroupModule_CallsNewDesignTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_CallsNewDesignTestGroupFactory(abTestGroupModule, provider);
    }

    @Override // javax.inject.Provider
    public ExposedAbTestGroup<CallsNewDesignTestGroup> get() {
        return callsNewDesignTestGroup(this.a, this.b.get());
    }
}
