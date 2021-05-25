package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotLoadAdStubGridBlueprint_Factory implements Factory<NotLoadAdStubGridBlueprint> {
    public final Provider<NotLoadAdStubPresenter> a;

    public NotLoadAdStubGridBlueprint_Factory(Provider<NotLoadAdStubPresenter> provider) {
        this.a = provider;
    }

    public static NotLoadAdStubGridBlueprint_Factory create(Provider<NotLoadAdStubPresenter> provider) {
        return new NotLoadAdStubGridBlueprint_Factory(provider);
    }

    public static NotLoadAdStubGridBlueprint newInstance(NotLoadAdStubPresenter notLoadAdStubPresenter) {
        return new NotLoadAdStubGridBlueprint(notLoadAdStubPresenter);
    }

    @Override // javax.inject.Provider
    public NotLoadAdStubGridBlueprint get() {
        return newInstance(this.a.get());
    }
}
