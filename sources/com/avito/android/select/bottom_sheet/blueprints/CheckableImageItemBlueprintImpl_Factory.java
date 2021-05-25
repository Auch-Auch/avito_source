package com.avito.android.select.bottom_sheet.blueprints;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckableImageItemBlueprintImpl_Factory implements Factory<CheckableImageItemBlueprintImpl> {
    public final Provider<CheckableItemPresenter> a;

    public CheckableImageItemBlueprintImpl_Factory(Provider<CheckableItemPresenter> provider) {
        this.a = provider;
    }

    public static CheckableImageItemBlueprintImpl_Factory create(Provider<CheckableItemPresenter> provider) {
        return new CheckableImageItemBlueprintImpl_Factory(provider);
    }

    public static CheckableImageItemBlueprintImpl newInstance(CheckableItemPresenter checkableItemPresenter) {
        return new CheckableImageItemBlueprintImpl(checkableItemPresenter);
    }

    @Override // javax.inject.Provider
    public CheckableImageItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
