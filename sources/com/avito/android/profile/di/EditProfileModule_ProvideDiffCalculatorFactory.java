package com.avito.android.profile.di;

import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditProfileModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<ContentsComparator> a;

    public EditProfileModule_ProvideDiffCalculatorFactory(Provider<ContentsComparator> provider) {
        this.a = provider;
    }

    public static EditProfileModule_ProvideDiffCalculatorFactory create(Provider<ContentsComparator> provider) {
        return new EditProfileModule_ProvideDiffCalculatorFactory(provider);
    }

    public static DiffCalculator provideDiffCalculator(ContentsComparator contentsComparator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(EditProfileModule.provideDiffCalculator(contentsComparator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get());
    }
}
