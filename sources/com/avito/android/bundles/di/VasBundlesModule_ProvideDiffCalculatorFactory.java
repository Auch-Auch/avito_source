package com.avito.android.bundles.di;

import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasBundlesModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<ContentsComparator> a;

    public VasBundlesModule_ProvideDiffCalculatorFactory(Provider<ContentsComparator> provider) {
        this.a = provider;
    }

    public static VasBundlesModule_ProvideDiffCalculatorFactory create(Provider<ContentsComparator> provider) {
        return new VasBundlesModule_ProvideDiffCalculatorFactory(provider);
    }

    public static DiffCalculator provideDiffCalculator(ContentsComparator contentsComparator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(VasBundlesModule.provideDiffCalculator(contentsComparator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get());
    }
}
