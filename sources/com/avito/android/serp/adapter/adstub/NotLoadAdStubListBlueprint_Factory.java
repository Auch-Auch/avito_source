package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotLoadAdStubListBlueprint_Factory implements Factory<NotLoadAdStubListBlueprint> {
    public final Provider<NotLoadAdStubPresenter> a;

    public NotLoadAdStubListBlueprint_Factory(Provider<NotLoadAdStubPresenter> provider) {
        this.a = provider;
    }

    public static NotLoadAdStubListBlueprint_Factory create(Provider<NotLoadAdStubPresenter> provider) {
        return new NotLoadAdStubListBlueprint_Factory(provider);
    }

    public static NotLoadAdStubListBlueprint newInstance(NotLoadAdStubPresenter notLoadAdStubPresenter) {
        return new NotLoadAdStubListBlueprint(notLoadAdStubPresenter);
    }

    @Override // javax.inject.Provider
    public NotLoadAdStubListBlueprint get() {
        return newInstance(this.a.get());
    }
}
