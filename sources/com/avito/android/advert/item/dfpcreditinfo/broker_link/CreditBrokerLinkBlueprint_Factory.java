package com.avito.android.advert.item.dfpcreditinfo.broker_link;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreditBrokerLinkBlueprint_Factory implements Factory<CreditBrokerLinkBlueprint> {
    public final Provider<CreditBrokerLinkPresenter> a;

    public CreditBrokerLinkBlueprint_Factory(Provider<CreditBrokerLinkPresenter> provider) {
        this.a = provider;
    }

    public static CreditBrokerLinkBlueprint_Factory create(Provider<CreditBrokerLinkPresenter> provider) {
        return new CreditBrokerLinkBlueprint_Factory(provider);
    }

    public static CreditBrokerLinkBlueprint newInstance(CreditBrokerLinkPresenter creditBrokerLinkPresenter) {
        return new CreditBrokerLinkBlueprint(creditBrokerLinkPresenter);
    }

    @Override // javax.inject.Provider
    public CreditBrokerLinkBlueprint get() {
        return newInstance(this.a.get());
    }
}
