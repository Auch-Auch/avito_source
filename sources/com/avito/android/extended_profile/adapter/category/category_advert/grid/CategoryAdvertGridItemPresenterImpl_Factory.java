package com.avito.android.extended_profile.adapter.category.category_advert.grid;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class CategoryAdvertGridItemPresenterImpl_Factory implements Factory<CategoryAdvertGridItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public CategoryAdvertGridItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static CategoryAdvertGridItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new CategoryAdvertGridItemPresenterImpl_Factory(provider);
    }

    public static CategoryAdvertGridItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new CategoryAdvertGridItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public CategoryAdvertGridItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
