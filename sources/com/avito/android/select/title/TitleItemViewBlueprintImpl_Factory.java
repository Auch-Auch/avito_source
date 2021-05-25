package com.avito.android.select.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TitleItemViewBlueprintImpl_Factory implements Factory<TitleItemViewBlueprintImpl> {
    public final Provider<TitleItemPresenter> a;

    public TitleItemViewBlueprintImpl_Factory(Provider<TitleItemPresenter> provider) {
        this.a = provider;
    }

    public static TitleItemViewBlueprintImpl_Factory create(Provider<TitleItemPresenter> provider) {
        return new TitleItemViewBlueprintImpl_Factory(provider);
    }

    public static TitleItemViewBlueprintImpl newInstance(TitleItemPresenter titleItemPresenter) {
        return new TitleItemViewBlueprintImpl(titleItemPresenter);
    }

    @Override // javax.inject.Provider
    public TitleItemViewBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
