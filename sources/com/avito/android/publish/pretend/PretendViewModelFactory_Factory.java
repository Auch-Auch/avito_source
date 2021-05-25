package com.avito.android.publish.pretend;

import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PretendViewModelFactory_Factory implements Factory<PretendViewModelFactory> {
    public final Provider<SchedulersFactory> a;
    public final Provider<PretendInteractor> b;

    public PretendViewModelFactory_Factory(Provider<SchedulersFactory> provider, Provider<PretendInteractor> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static PretendViewModelFactory_Factory create(Provider<SchedulersFactory> provider, Provider<PretendInteractor> provider2) {
        return new PretendViewModelFactory_Factory(provider, provider2);
    }

    public static PretendViewModelFactory newInstance(SchedulersFactory schedulersFactory, PretendInteractor pretendInteractor) {
        return new PretendViewModelFactory(schedulersFactory, pretendInteractor);
    }

    @Override // javax.inject.Provider
    public PretendViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
