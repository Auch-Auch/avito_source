package com.avito.android.di.module;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.models.AbTestGroup;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AbTestGroupModule_ProvideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroupFactory implements Factory<AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup>> {
    public final AbTestGroupModule a;
    public final Provider<AbTestsConfigProvider> b;

    public AbTestGroupModule_ProvideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroupFactory(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        this.a = abTestGroupModule;
        this.b = provider;
    }

    public static AbTestGroupModule_ProvideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroupFactory create(AbTestGroupModule abTestGroupModule, Provider<AbTestsConfigProvider> provider) {
        return new AbTestGroupModule_ProvideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroupFactory(abTestGroupModule, provider);
    }

    public static AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> provideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroup(AbTestGroupModule abTestGroupModule, AbTestsConfigProvider abTestsConfigProvider) {
        return (AbTestGroup) Preconditions.checkNotNullFromProvides(abTestGroupModule.provideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroup(abTestsConfigProvider));
    }

    @Override // javax.inject.Provider
    public AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> get() {
        return provideSendEmployersPhoneOnCallButtonClickInVacanciesTestGroup(this.a, this.b.get());
    }
}
