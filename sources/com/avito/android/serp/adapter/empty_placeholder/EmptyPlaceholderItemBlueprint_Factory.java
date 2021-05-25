package com.avito.android.serp.adapter.empty_placeholder;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptyPlaceholderItemBlueprint_Factory implements Factory<EmptyPlaceholderItemBlueprint> {
    public final Provider<EmptyPlaceholderItemPresenter> a;

    public EmptyPlaceholderItemBlueprint_Factory(Provider<EmptyPlaceholderItemPresenter> provider) {
        this.a = provider;
    }

    public static EmptyPlaceholderItemBlueprint_Factory create(Provider<EmptyPlaceholderItemPresenter> provider) {
        return new EmptyPlaceholderItemBlueprint_Factory(provider);
    }

    public static EmptyPlaceholderItemBlueprint newInstance(EmptyPlaceholderItemPresenter emptyPlaceholderItemPresenter) {
        return new EmptyPlaceholderItemBlueprint(emptyPlaceholderItemPresenter);
    }

    @Override // javax.inject.Provider
    public EmptyPlaceholderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
