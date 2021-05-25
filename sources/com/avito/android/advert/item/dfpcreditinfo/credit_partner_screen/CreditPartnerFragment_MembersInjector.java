package com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CreditPartnerFragment_MembersInjector implements MembersInjector<CreditPartnerFragment> {
    public final Provider<SravniWebAnalyticsHandler> a;

    public CreditPartnerFragment_MembersInjector(Provider<SravniWebAnalyticsHandler> provider) {
        this.a = provider;
    }

    public static MembersInjector<CreditPartnerFragment> create(Provider<SravniWebAnalyticsHandler> provider) {
        return new CreditPartnerFragment_MembersInjector(provider);
    }

    @InjectedFieldSignature("com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragment.sravniWebAnalyticsHandler")
    public static void injectSravniWebAnalyticsHandler(CreditPartnerFragment creditPartnerFragment, SravniWebAnalyticsHandler sravniWebAnalyticsHandler) {
        creditPartnerFragment.sravniWebAnalyticsHandler = sravniWebAnalyticsHandler;
    }

    public void injectMembers(CreditPartnerFragment creditPartnerFragment) {
        injectSravniWebAnalyticsHandler(creditPartnerFragment, this.a.get());
    }
}
