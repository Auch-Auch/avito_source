package com.avito.android.select.bottom_sheet.blueprints;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CheckableItemBlueprintImpl_Factory implements Factory<CheckableItemBlueprintImpl> {
    public final Provider<CheckableItemPresenter> a;

    public CheckableItemBlueprintImpl_Factory(Provider<CheckableItemPresenter> provider) {
        this.a = provider;
    }

    public static CheckableItemBlueprintImpl_Factory create(Provider<CheckableItemPresenter> provider) {
        return new CheckableItemBlueprintImpl_Factory(provider);
    }

    public static CheckableItemBlueprintImpl newInstance(CheckableItemPresenter checkableItemPresenter) {
        return new CheckableItemBlueprintImpl(checkableItemPresenter);
    }

    @Override // javax.inject.Provider
    public CheckableItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
