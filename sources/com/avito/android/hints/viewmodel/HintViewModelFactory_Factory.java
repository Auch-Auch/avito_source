package com.avito.android.hints.viewmodel;

import com.avito.android.hints.repository.HintsConverter;
import com.avito.android.hints.repository.HintsRepository;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HintViewModelFactory_Factory implements Factory<HintViewModelFactory> {
    public final Provider<String> a;
    public final Provider<HintsRepository> b;
    public final Provider<HintsConverter> c;

    public HintViewModelFactory_Factory(Provider<String> provider, Provider<HintsRepository> provider2, Provider<HintsConverter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static HintViewModelFactory_Factory create(Provider<String> provider, Provider<HintsRepository> provider2, Provider<HintsConverter> provider3) {
        return new HintViewModelFactory_Factory(provider, provider2, provider3);
    }

    public static HintViewModelFactory newInstance(String str, HintsRepository hintsRepository, HintsConverter hintsConverter) {
        return new HintViewModelFactory(str, hintsRepository, hintsConverter);
    }

    @Override // javax.inject.Provider
    public HintViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
