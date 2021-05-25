package com.avito.android.delivery.suggest.konveyor.suggest;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SuggestBlueprint_Factory implements Factory<SuggestBlueprint> {
    public final Provider<SuggestItemPresenter> a;

    public SuggestBlueprint_Factory(Provider<SuggestItemPresenter> provider) {
        this.a = provider;
    }

    public static SuggestBlueprint_Factory create(Provider<SuggestItemPresenter> provider) {
        return new SuggestBlueprint_Factory(provider);
    }

    public static SuggestBlueprint newInstance(SuggestItemPresenter suggestItemPresenter) {
        return new SuggestBlueprint(suggestItemPresenter);
    }

    @Override // javax.inject.Provider
    public SuggestBlueprint get() {
        return newInstance(this.a.get());
    }
}
