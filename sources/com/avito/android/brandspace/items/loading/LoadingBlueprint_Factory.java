package com.avito.android.brandspace.items.loading;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class LoadingBlueprint_Factory implements Factory<LoadingBlueprint> {
    public final Provider<LoadingPresenter> a;

    public LoadingBlueprint_Factory(Provider<LoadingPresenter> provider) {
        this.a = provider;
    }

    public static LoadingBlueprint_Factory create(Provider<LoadingPresenter> provider) {
        return new LoadingBlueprint_Factory(provider);
    }

    public static LoadingBlueprint newInstance(LoadingPresenter loadingPresenter) {
        return new LoadingBlueprint(loadingPresenter);
    }

    @Override // javax.inject.Provider
    public LoadingBlueprint get() {
        return newInstance(this.a.get());
    }
}
