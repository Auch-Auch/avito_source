package com.avito.android.serp.adapter.closable.di;

import com.avito.android.serp.adapter.closable.ClosedItemEventInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemPresenter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClosedItemModule_ProvideViewedAdvertsPresenterFactory implements Factory<ClosedItemPresenter> {
    public final Provider<ClosedItemEventInteractor> a;
    public final Provider<SchedulersFactory3> b;

    public ClosedItemModule_ProvideViewedAdvertsPresenterFactory(Provider<ClosedItemEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ClosedItemModule_ProvideViewedAdvertsPresenterFactory create(Provider<ClosedItemEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        return new ClosedItemModule_ProvideViewedAdvertsPresenterFactory(provider, provider2);
    }

    public static ClosedItemPresenter provideViewedAdvertsPresenter(ClosedItemEventInteractor closedItemEventInteractor, SchedulersFactory3 schedulersFactory3) {
        return (ClosedItemPresenter) Preconditions.checkNotNullFromProvides(ClosedItemModule.provideViewedAdvertsPresenter(closedItemEventInteractor, schedulersFactory3));
    }

    @Override // javax.inject.Provider
    public ClosedItemPresenter get() {
        return provideViewedAdvertsPresenter(this.a.get(), this.b.get());
    }
}
