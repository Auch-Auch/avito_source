package com.avito.android.tariff.edit_info.di;

import com.avito.android.recycler.data_aware.ChangePayloadCreator;
import com.avito.android.recycler.data_aware.ContentsComparator;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.recycler.data_aware.EqualityComparator;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class EditInfoModule_ProvideDiffCalculatorFactory implements Factory<DiffCalculator> {
    public final Provider<EqualityComparator> a;
    public final Provider<ContentsComparator> b;
    public final Provider<ChangePayloadCreator> c;

    public EditInfoModule_ProvideDiffCalculatorFactory(Provider<EqualityComparator> provider, Provider<ContentsComparator> provider2, Provider<ChangePayloadCreator> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static EditInfoModule_ProvideDiffCalculatorFactory create(Provider<EqualityComparator> provider, Provider<ContentsComparator> provider2, Provider<ChangePayloadCreator> provider3) {
        return new EditInfoModule_ProvideDiffCalculatorFactory(provider, provider2, provider3);
    }

    public static DiffCalculator provideDiffCalculator(EqualityComparator equalityComparator, ContentsComparator contentsComparator, ChangePayloadCreator changePayloadCreator) {
        return (DiffCalculator) Preconditions.checkNotNullFromProvides(EditInfoModule.provideDiffCalculator(equalityComparator, contentsComparator, changePayloadCreator));
    }

    @Override // javax.inject.Provider
    public DiffCalculator get() {
        return provideDiffCalculator(this.a.get(), this.b.get(), this.c.get());
    }
}
