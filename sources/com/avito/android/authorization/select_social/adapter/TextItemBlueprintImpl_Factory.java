package com.avito.android.authorization.select_social.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TextItemBlueprintImpl_Factory implements Factory<TextItemBlueprintImpl> {
    public final Provider<TextItemPresenter> a;

    public TextItemBlueprintImpl_Factory(Provider<TextItemPresenter> provider) {
        this.a = provider;
    }

    public static TextItemBlueprintImpl_Factory create(Provider<TextItemPresenter> provider) {
        return new TextItemBlueprintImpl_Factory(provider);
    }

    public static TextItemBlueprintImpl newInstance(TextItemPresenter textItemPresenter) {
        return new TextItemBlueprintImpl(textItemPresenter);
    }

    @Override // javax.inject.Provider
    public TextItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
