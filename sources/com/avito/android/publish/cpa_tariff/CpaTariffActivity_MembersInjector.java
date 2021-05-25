package com.avito.android.publish.cpa_tariff;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CpaTariffActivity_MembersInjector implements MembersInjector<CpaTariffActivity> {
    public final Provider<CpaTariffViewModelFactory> a;

    public CpaTariffActivity_MembersInjector(Provider<CpaTariffViewModelFactory> provider) {
        this.a = provider;
    }

    public static MembersInjector<CpaTariffActivity> create(Provider<CpaTariffViewModelFactory> provider) {
        return new CpaTariffActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.publish.cpa_tariff.CpaTariffActivity.viewModelFactory")
    public static void injectViewModelFactory(CpaTariffActivity cpaTariffActivity, CpaTariffViewModelFactory cpaTariffViewModelFactory) {
        cpaTariffActivity.viewModelFactory = cpaTariffViewModelFactory;
    }

    public void injectMembers(CpaTariffActivity cpaTariffActivity) {
        injectViewModelFactory(cpaTariffActivity, this.a.get());
    }
}
