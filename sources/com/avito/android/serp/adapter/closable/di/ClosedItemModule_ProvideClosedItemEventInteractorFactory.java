package com.avito.android.serp.adapter.closable.di;

import com.avito.android.serp.adapter.closable.ClosedItemEventInteractor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class ClosedItemModule_ProvideClosedItemEventInteractorFactory implements Factory<ClosedItemEventInteractor> {

    public static final class a {
        public static final ClosedItemModule_ProvideClosedItemEventInteractorFactory a = new ClosedItemModule_ProvideClosedItemEventInteractorFactory();
    }

    public static ClosedItemModule_ProvideClosedItemEventInteractorFactory create() {
        return a.a;
    }

    public static ClosedItemEventInteractor provideClosedItemEventInteractor() {
        return (ClosedItemEventInteractor) Preconditions.checkNotNullFromProvides(ClosedItemModule.provideClosedItemEventInteractor());
    }

    @Override // javax.inject.Provider
    public ClosedItemEventInteractor get() {
        return provideClosedItemEventInteractor();
    }
}
