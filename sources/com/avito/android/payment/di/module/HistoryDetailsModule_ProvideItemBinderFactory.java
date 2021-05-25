package com.avito.android.payment.di.module;

import com.avito.android.payment.wallet.history.details.item.AdvertItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.BaseItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.ButtonItemBlueprint;
import com.avito.android.payment.wallet.history.details.item.SimpleItemBlueprint;
import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class HistoryDetailsModule_ProvideItemBinderFactory implements Factory<ItemBinder> {
    public final HistoryDetailsModule a;
    public final Provider<AdvertItemBlueprint> b;
    public final Provider<BaseItemBlueprint> c;
    public final Provider<SimpleItemBlueprint> d;
    public final Provider<ButtonItemBlueprint> e;

    public HistoryDetailsModule_ProvideItemBinderFactory(HistoryDetailsModule historyDetailsModule, Provider<AdvertItemBlueprint> provider, Provider<BaseItemBlueprint> provider2, Provider<SimpleItemBlueprint> provider3, Provider<ButtonItemBlueprint> provider4) {
        this.a = historyDetailsModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
    }

    public static HistoryDetailsModule_ProvideItemBinderFactory create(HistoryDetailsModule historyDetailsModule, Provider<AdvertItemBlueprint> provider, Provider<BaseItemBlueprint> provider2, Provider<SimpleItemBlueprint> provider3, Provider<ButtonItemBlueprint> provider4) {
        return new HistoryDetailsModule_ProvideItemBinderFactory(historyDetailsModule, provider, provider2, provider3, provider4);
    }

    public static ItemBinder provideItemBinder(HistoryDetailsModule historyDetailsModule, AdvertItemBlueprint advertItemBlueprint, BaseItemBlueprint baseItemBlueprint, SimpleItemBlueprint simpleItemBlueprint, ButtonItemBlueprint buttonItemBlueprint) {
        return (ItemBinder) Preconditions.checkNotNullFromProvides(historyDetailsModule.provideItemBinder(advertItemBlueprint, baseItemBlueprint, simpleItemBlueprint, buttonItemBlueprint));
    }

    @Override // javax.inject.Provider
    public ItemBinder get() {
        return provideItemBinder(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
