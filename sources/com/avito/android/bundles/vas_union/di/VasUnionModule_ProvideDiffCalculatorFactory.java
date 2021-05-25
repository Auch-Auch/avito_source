package com.avito.android.bundles.vas_union.di;

import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class VasUnionModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<ContentsComparator> a;

    public VasUnionModule_ProvideDiffCalculatorFactory(Provider<ContentsComparator> provider) {
        this.a = provider;
    }

    public static VasUnionModule_ProvideDiffCalculatorFactory create(Provider<ContentsComparator> provider) {
        return new VasUnionModule_ProvideDiffCalculatorFactory(provider);
    }

    public static DiffCalculator provideDiffCalculator(ContentsComparator contentsComparator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(VasUnionModule.provideDiffCalculator(contentsComparator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get());
    }
}
