package com.avito.android.basket.paid_services;

import com.avito.android.tariff.routing.PaidServiceDeeplinkHandler;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PaidServicesActivity_MembersInjector implements MembersInjector<PaidServicesActivity> {
    public final Provider<PaidServiceDeeplinkHandler> a;

    public PaidServicesActivity_MembersInjector(Provider<PaidServiceDeeplinkHandler> provider) {
        this.a = provider;
    }

    public static MembersInjector<PaidServicesActivity> create(Provider<PaidServiceDeeplinkHandler> provider) {
        return new PaidServicesActivity_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.basket.paid_services.PaidServicesActivity.deeplinkHandler")
    public static void injectDeeplinkHandler(PaidServicesActivity paidServicesActivity, PaidServiceDeeplinkHandler paidServiceDeeplinkHandler) {
        paidServicesActivity.deeplinkHandler = paidServiceDeeplinkHandler;
    }

    public void injectMembers(PaidServicesActivity paidServicesActivity) {
        injectDeeplinkHandler(paidServicesActivity, this.a.get());
    }
}
