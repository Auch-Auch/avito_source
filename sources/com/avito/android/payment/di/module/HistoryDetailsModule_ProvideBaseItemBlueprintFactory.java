package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.BaseItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.BaseItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideBaseItemBlueprintFactory implements Factory<BaseItemBlueprint> {
    public final HistoryDetailsModule a;
    public final Provider<BaseItemPresenter> b;

    public HistoryDetailsModule_ProvideBaseItemBlueprintFactory(HistoryDetailsModule historyDetailsModule, Provider<BaseItemPresenter> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvideBaseItemBlueprintFactory create(HistoryDetailsModule historyDetailsModule, Provider<BaseItemPresenter> provider) {
        return new HistoryDetailsModule_ProvideBaseItemBlueprintFactory(historyDetailsModule, provider);
    }

    public static BaseItemBlueprint provideBaseItemBlueprint(HistoryDetailsModule historyDetailsModule, BaseItemPresenter baseItemPresenter) {
        return (BaseItemBlueprint) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideBaseItemBlueprint(baseItemPresenter));
    }

    @Override // javax.inject.Provider
    public BaseItemBlueprint get() {
        return provideBaseItemBlueprint(this.a, this.b.get());
    }
}
