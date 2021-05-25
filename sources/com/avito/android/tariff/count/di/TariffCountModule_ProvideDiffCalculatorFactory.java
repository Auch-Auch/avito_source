package com.avito.android.tariff.count.di;

import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class TariffCountModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<ContentsComparator> a;
    public final Provider<ChangePayloadCreator> b;

    public TariffCountModule_ProvideDiffCalculatorFactory(Provider<ContentsComparator> provider, Provider<ChangePayloadCreator> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TariffCountModule_ProvideDiffCalculatorFactory create(Provider<ContentsComparator> provider, Provider<ChangePayloadCreator> provider2) {
        return new TariffCountModule_ProvideDiffCalculatorFactory(provider, provider2);
    }

    public static DiffCalculator provideDiffCalculator(ContentsComparator contentsComparator, ChangePayloadCreator changePayloadCreator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(TariffCountModule.provideDiffCalculator(contentsComparator, changePayloadCreator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get(), this.b.get());
    }
}
