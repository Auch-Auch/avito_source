package com.avito.android.fees.di;

import com.avito.android.fees.FeesInteractor;
import com.avito.android.fees.FeesPresenter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FeesActivityModule_ProvidePresenterFactory implements Factory<FeesPresenter> {
    public final FeesActivityModule a;
    public final Provider<FeesInteractor> b;
    public final Provider<SchedulersFactory> c;
    public final Provider<ErrorFormatter> d;

    public FeesActivityModule_ProvidePresenterFactory(FeesActivityModule feesActivityModule, Provider<FeesInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        this.a = feesActivityModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static FeesActivityModule_ProvidePresenterFactory create(FeesActivityModule feesActivityModule, Provider<FeesInteractor> provider, Provider<SchedulersFactory> provider2, Provider<ErrorFormatter> provider3) {
        return new FeesActivityModule_ProvidePresenterFactory(feesActivityModule, provider, provider2, provider3);
    }

    public static FeesPresenter providePresenter(FeesActivityModule feesActivityModule, FeesInteractor feesInteractor, SchedulersFactory schedulersFactory, ErrorFormatter errorFormatter) {
        return (FeesPresenter) Preconditions.checkNotNullFromProvides(feesActivityModule.providePresenter(feesInteractor, schedulersFactory, errorFormatter));
    }

    @Override // javax.inject.Provider
    public FeesPresenter get() {
        return providePresenter(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}
