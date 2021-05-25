package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.SimpleItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.SimpleItemPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideSimpleItemBlueprintFactory implements Factory<SimpleItemBlueprint> {
    public final HistoryDetailsModule a;
    public final Provider<SimpleItemPresenter> b;

    public HistoryDetailsModule_ProvideSimpleItemBlueprintFactory(HistoryDetailsModule historyDetailsModule, Provider<SimpleItemPresenter> provider) {
        this.a = historyDetailsModule;
        this.b = provider;
    }

    public static HistoryDetailsModule_ProvideSimpleItemBlueprintFactory create(HistoryDetailsModule historyDetailsModule, Provider<SimpleItemPresenter> provider) {
        return new HistoryDetailsModule_ProvideSimpleItemBlueprintFactory(historyDetailsModule, provider);
    }

    public static SimpleItemBlueprint provideSimpleItemBlueprint(HistoryDetailsModule historyDetailsModule, SimpleItemPresenter simpleItemPresenter) {
        return (SimpleItemBlueprint) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideSimpleItemBlueprint(simpleItemPresenter));
    }

    @Override // javax.inject.Provider
    public SimpleItemBlueprint get() {
        return provideSimpleItemBlueprint(this.a, this.b.get());
    }
}
