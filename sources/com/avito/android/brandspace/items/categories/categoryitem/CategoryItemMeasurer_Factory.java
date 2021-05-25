package com.avito.android.brandspace.items.categories.categoryitem;

import com.avito.android.brandspace.items.categories.categoryitem.CategoryItemView;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoryItemMeasurer_Factory implements Factory<CategoryItemMeasurer> {
    public final Provider<CategoryItemView.Measurer> a;

    public CategoryItemMeasurer_Factory(Provider<CategoryItemView.Measurer> provider) {
        this.a = provider;
    }

    public static CategoryItemMeasurer_Factory create(Provider<CategoryItemView.Measurer> provider) {
        return new CategoryItemMeasurer_Factory(provider);
    }

    public static CategoryItemMeasurer newInstance(Lazy<CategoryItemView.Measurer> lazy) {
        return new CategoryItemMeasurer(lazy);
    }

    @Override // javax.inject.Provider
    public CategoryItemMeasurer get() {
        return newInstance(DoubleCheck.lazy(this.a));
    }
}
