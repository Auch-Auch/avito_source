package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsNotLoadAdStubBlueprint_Factory implements Factory<RdsNotLoadAdStubBlueprint> {
    public final Provider<NotLoadAdStubPresenter> a;

    public RdsNotLoadAdStubBlueprint_Factory(Provider<NotLoadAdStubPresenter> provider) {
        this.a = provider;
    }

    public static RdsNotLoadAdStubBlueprint_Factory create(Provider<NotLoadAdStubPresenter> provider) {
        return new RdsNotLoadAdStubBlueprint_Factory(provider);
    }

    public static RdsNotLoadAdStubBlueprint newInstance(NotLoadAdStubPresenter notLoadAdStubPresenter) {
        return new RdsNotLoadAdStubBlueprint(notLoadAdStubPresenter);
    }

    @Override // javax.inject.Provider
    public RdsNotLoadAdStubBlueprint get() {
        return newInstance(this.a.get());
    }
}
