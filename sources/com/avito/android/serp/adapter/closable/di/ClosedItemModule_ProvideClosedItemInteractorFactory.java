package com.avito.android.serp.adapter.closable.di;

import com.avito.android.serp.adapter.closable.ClosedItemEventInteractor;
import com.avito.android.serp.adapter.closable.ClosedItemInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ClosedItemModule_ProvideClosedItemInteractorFactory implements Factory<ClosedItemInteractor> {
    public final Provider<ClosedItemEventInteractor> a;

    public ClosedItemModule_ProvideClosedItemInteractorFactory(Provider<ClosedItemEventInteractor> provider) {
        this.a = provider;
    }

    public static ClosedItemModule_ProvideClosedItemInteractorFactory create(Provider<ClosedItemEventInteractor> provider) {
        return new ClosedItemModule_ProvideClosedItemInteractorFactory(provider);
    }

    public static ClosedItemInteractor provideClosedItemInteractor(ClosedItemEventInteractor closedItemEventInteractor) {
        return (ClosedItemInteractor) Preconditions.checkNotNullFromProvides(ClosedItemModule.provideClosedItemInteractor(closedItemEventInteractor));
    }

    @Override // javax.inject.Provider
    public ClosedItemInteractor get() {
        return provideClosedItemInteractor(this.a.get());
    }
}
