package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.SimpleItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class HistoryDetailsModule_ProvideSimpleItemPresenterFactory implements Factory<SimpleItemPresenter> {
    public final HistoryDetailsModule a;

    public HistoryDetailsModule_ProvideSimpleItemPresenterFactory(HistoryDetailsModule historyDetailsModule) {
        this.a = historyDetailsModule;
    }

    public static HistoryDetailsModule_ProvideSimpleItemPresenterFactory create(HistoryDetailsModule historyDetailsModule) {
        return new HistoryDetailsModule_ProvideSimpleItemPresenterFactory(historyDetailsModule);
    }

    public static SimpleItemPresenter provideSimpleItemPresenter(HistoryDetailsModule historyDetailsModule) {
        return (SimpleItemPresenter) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideSimpleItemPresenter());
    }

    @Override // javax.inject.Provider
    public SimpleItemPresenter get() {
        return provideSimpleItemPresenter(this.a);
    }
}
