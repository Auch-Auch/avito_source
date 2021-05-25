package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class NotLoadAdRichStubBlueprint_Factory implements Factory<NotLoadAdRichStubBlueprint> {
    public final Provider<NotLoadAdStubPresenter> a;

    public NotLoadAdRichStubBlueprint_Factory(Provider<NotLoadAdStubPresenter> provider) {
        this.a = provider;
    }

    public static NotLoadAdRichStubBlueprint_Factory create(Provider<NotLoadAdStubPresenter> provider) {
        return new NotLoadAdRichStubBlueprint_Factory(provider);
    }

    public static NotLoadAdRichStubBlueprint newInstance(NotLoadAdStubPresenter notLoadAdStubPresenter) {
        return new NotLoadAdRichStubBlueprint(notLoadAdStubPresenter);
    }

    @Override // javax.inject.Provider
    public NotLoadAdRichStubBlueprint get() {
        return newInstance(this.a.get());
    }
}
