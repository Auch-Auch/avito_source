package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.AdvertItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.AdvertItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideAdvertItemBlueprintFactory implements Factory<AdvertItemBlueprint> {
    public final HistoryDetailsModule a;
    public final Provider<AdvertItemPresenter> b;

    public HistoryDetailsModule_ProvideAdvertItemBlueprintFactory(HistoryDetailsModule historyDetailsModule, Provider<AdvertItemPresenter> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvideAdvertItemBlueprintFactory create(HistoryDetailsModule historyDetailsModule, Provider<AdvertItemPresenter> provider) {
        return new HistoryDetailsModule_ProvideAdvertItemBlueprintFactory(historyDetailsModule, provider);
    }

    public static AdvertItemBlueprint provideAdvertItemBlueprint(HistoryDetailsModule historyDetailsModule, AdvertItemPresenter advertItemPresenter) {
        return (AdvertItemBlueprint) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideAdvertItemBlueprint(advertItemPresenter));
    }

    @Override // javax.inject.Provider
    public AdvertItemBlueprint get() {
        return provideAdvertItemBlueprint(this.a, this.b.get());
    }
}
