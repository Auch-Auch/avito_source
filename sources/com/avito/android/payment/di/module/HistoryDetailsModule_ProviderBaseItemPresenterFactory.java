package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.BaseItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HistoryDetailsModule_ProviderBaseItemPresenterFactory implements Factory<BaseItemPresenter> {
    public final HistoryDetailsModule a;

    public HistoryDetailsModule_ProviderBaseItemPresenterFactory(HistoryDetailsModule historyDetailsModule) {
        this.a = historyDetailsModule;
    }

    public static HistoryDetailsModule_ProviderBaseItemPresenterFactory create(HistoryDetailsModule historyDetailsModule) {
        return new HistoryDetailsModule_ProviderBaseItemPresenterFactory(historyDetailsModule);
    }

    public static BaseItemPresenter providerBaseItemPresenter(HistoryDetailsModule historyDetailsModule) {
        return (BaseItemPresenter) Preconditions.checkNotNullFromProvides(historyDetailsModule.providerBaseItemPresenter());
    }

    @Override // javax.inject.Provider
    public BaseItemPresenter get() {
        return providerBaseItemPresenter(this.a);
    }
}
