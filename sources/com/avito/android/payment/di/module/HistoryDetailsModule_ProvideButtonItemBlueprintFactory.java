package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.ButtonItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.ButtonItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideButtonItemBlueprintFactory implements Factory<ButtonItemBlueprint> {
    public final HistoryDetailsModule a;
    public final Provider<ButtonItemPresenter> b;

    public HistoryDetailsModule_ProvideButtonItemBlueprintFactory(HistoryDetailsModule historyDetailsModule, Provider<ButtonItemPresenter> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvideButtonItemBlueprintFactory create(HistoryDetailsModule historyDetailsModule, Provider<ButtonItemPresenter> provider) {
        return new HistoryDetailsModule_ProvideButtonItemBlueprintFactory(historyDetailsModule, provider);
    }

    public static ButtonItemBlueprint provideButtonItemBlueprint(HistoryDetailsModule historyDetailsModule, ButtonItemPresenter buttonItemPresenter) {
        return (ButtonItemBlueprint) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideButtonItemBlueprint(buttonItemPresenter));
    }

    @Override // javax.inject.Provider
    public ButtonItemBlueprint get() {
        return provideButtonItemBlueprint(this.a, this.b.get());
    }
}
