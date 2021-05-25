package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.AdvertItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HistoryDetailsModule_ProviderAdvertItemPresenterFactory implements Factory<AdvertItemPresenter> {
    public final HistoryDetailsModule a;

    public HistoryDetailsModule_ProviderAdvertItemPresenterFactory(HistoryDetailsModule historyDetailsModule) {
        this.a = historyDetailsModule;
    }

    public static HistoryDetailsModule_ProviderAdvertItemPresenterFactory create(HistoryDetailsModule historyDetailsModule) {
        return new HistoryDetailsModule_ProviderAdvertItemPresenterFactory(historyDetailsModule);
    }

    public static AdvertItemPresenter providerAdvertItemPresenter(HistoryDetailsModule historyDetailsModule) {
        return (AdvertItemPresenter) Preconditions.checkNotNullFromProvides(historyDetailsModule.providerAdvertItemPresenter());
    }

    @Override // javax.inject.Provider
    public AdvertItemPresenter get() {
        return providerAdvertItemPresenter(this.a);
    }
}
