package com.avito.android.social_management.di;

import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SocialManagementModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<ContentsComparator> a;
    public final Provider<EqualityComparator> b;

    public SocialManagementModule_ProvideDiffCalculatorFactory(Provider<ContentsComparator> provider, Provider<EqualityComparator> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SocialManagementModule_ProvideDiffCalculatorFactory create(Provider<ContentsComparator> provider, Provider<EqualityComparator> provider2) {
        return new SocialManagementModule_ProvideDiffCalculatorFactory(provider, provider2);
    }

    public static DiffCalculator provideDiffCalculator(ContentsComparator contentsComparator, EqualityComparator equalityComparator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(SocialManagementModule.provideDiffCalculator(contentsComparator, equalityComparator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get(), this.b.get());
    }
}
