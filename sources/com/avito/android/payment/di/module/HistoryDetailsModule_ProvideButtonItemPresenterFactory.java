package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HistoryDetailsModule_ProvideButtonItemPresenterFactory implements Factory<ButtonItemPresenter> {
    public final HistoryDetailsModule a;

    public HistoryDetailsModule_ProvideButtonItemPresenterFactory(HistoryDetailsModule historyDetailsModule) {
        this.a = historyDetailsModule;
    }

    public static HistoryDetailsModule_ProvideButtonItemPresenterFactory create(HistoryDetailsModule historyDetailsModule) {
        return new HistoryDetailsModule_ProvideButtonItemPresenterFactory(historyDetailsModule);
    }

    public static ButtonItemPresenter provideButtonItemPresenter(HistoryDetailsModule historyDetailsModule) {
        return (ButtonItemPresenter) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideButtonItemPresenter());
    }

    @Override // javax.inject.Provider
    public ButtonItemPresenter get() {
        return provideButtonItemPresenter(this.a);
    }
}
