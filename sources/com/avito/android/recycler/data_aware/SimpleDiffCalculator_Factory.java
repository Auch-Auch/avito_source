package com.avito.android.recycler.data_aware;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SimpleDiffCalculator_Factory implements Factory<SimpleDiffCalculator> {
    public final Provider<ContentsComparator> a;
    public final Provider<EqualityComparator> b;
    public final Provider<Boolean> c;
    public final Provider<ChangePayloadCreator> d;

    public SimpleDiffCalculator_Factory(Provider<ContentsComparator> provider, Provider<EqualityComparator> provider2, Provider<Boolean> provider3, Provider<ChangePayloadCreator> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static SimpleDiffCalculator_Factory create(Provider<ContentsComparator> provider, Provider<EqualityComparator> provider2, Provider<Boolean> provider3, Provider<ChangePayloadCreator> provider4) {
        return new SimpleDiffCalculator_Factory(provider, provider2, provider3, provider4);
    }

    public static SimpleDiffCalculator newInstance(ContentsComparator contentsComparator, EqualityComparator equalityComparator, boolean z, ChangePayloadCreator changePayloadCreator) {
        return new SimpleDiffCalculator(contentsComparator, equalityComparator, z, changePayloadCreator);
    }

    @Override // javax.inject.Provider
    public SimpleDiffCalculator get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get().booleanValue(), this.d.get());
    }
}
