package com.avito.android.serp.adapter.empty_search;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptySearchItemBlueprint_Factory implements Factory<EmptySearchItemBlueprint> {
    public final Provider<EmptySearchItemPresenter> a;

    public EmptySearchItemBlueprint_Factory(Provider<EmptySearchItemPresenter> provider) {
        this.a = provider;
    }

    public static EmptySearchItemBlueprint_Factory create(Provider<EmptySearchItemPresenter> provider) {
        return new EmptySearchItemBlueprint_Factory(provider);
    }

    public static EmptySearchItemBlueprint newInstance(EmptySearchItemPresenter emptySearchItemPresenter) {
        return new EmptySearchItemBlueprint(emptySearchItemPresenter);
    }

    @Override // javax.inject.Provider
    public EmptySearchItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
