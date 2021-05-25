package com.avito.android.payment.di.module;

import com.avito.android.payment.top_up.form.items.TopUpFormItemsComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class TopUpFormModule_ProvideContentsComparatorFactory implements Factory<TopUpFormItemsComparator> {
    public final TopUpFormModule a;

    public TopUpFormModule_ProvideContentsComparatorFactory(TopUpFormModule topUpFormModule) {
        this.a = topUpFormModule;
    }

    public static TopUpFormModule_ProvideContentsComparatorFactory create(TopUpFormModule topUpFormModule) {
        return new TopUpFormModule_ProvideContentsComparatorFactory(topUpFormModule);
    }

    public static TopUpFormItemsComparator provideContentsComparator(TopUpFormModule topUpFormModule) {
        return (TopUpFormItemsComparator) Preconditions.checkNotNullFromProvides(topUpFormModule.provideContentsComparator());
    }

    @Override // javax.inject.Provider
    public TopUpFormItemsComparator get() {
        return provideContentsComparator(this.a);
    }
}
