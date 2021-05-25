package com.avito.android.publish.start_publish.blueprint;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryShortcutItemBlueprintImpl_Factory implements Factory<CategoryShortcutItemBlueprintImpl> {
    public final Provider<CategoryShortcutItemPresenter> a;

    public CategoryShortcutItemBlueprintImpl_Factory(Provider<CategoryShortcutItemPresenter> provider) {
        this.a = provider;
    }

    public static CategoryShortcutItemBlueprintImpl_Factory create(Provider<CategoryShortcutItemPresenter> provider) {
        return new CategoryShortcutItemBlueprintImpl_Factory(provider);
    }

    public static CategoryShortcutItemBlueprintImpl newInstance(CategoryShortcutItemPresenter categoryShortcutItemPresenter) {
        return new CategoryShortcutItemBlueprintImpl(categoryShortcutItemPresenter);
    }

    @Override // javax.inject.Provider
    public CategoryShortcutItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
