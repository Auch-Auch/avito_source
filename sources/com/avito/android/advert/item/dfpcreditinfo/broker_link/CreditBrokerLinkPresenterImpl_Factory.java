package com.avito.android.advert.item.dfpcreditinfo.broker_link;

import com.avito.android.advert.item.dfpcreditinfo.broker_link.CreditBrokerLinkPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreditBrokerLinkPresenterImpl_Factory implements Factory<CreditBrokerLinkPresenterImpl> {
    public final Provider<CreditBrokerLinkPresenter.Listener> a;

    public CreditBrokerLinkPresenterImpl_Factory(Provider<CreditBrokerLinkPresenter.Listener> provider) {
        this.a = provider;
    }

    public static CreditBrokerLinkPresenterImpl_Factory create(Provider<CreditBrokerLinkPresenter.Listener> provider) {
        return new CreditBrokerLinkPresenterImpl_Factory(provider);
    }

    public static CreditBrokerLinkPresenterImpl newInstance(CreditBrokerLinkPresenter.Listener listener) {
        return new CreditBrokerLinkPresenterImpl(listener);
    }

    @Override // javax.inject.Provider
    public CreditBrokerLinkPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
