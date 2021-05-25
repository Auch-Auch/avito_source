package com.avito.android.extended_profile.adapter.category.category_advert.list;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class CategoryAdvertListItemPresenterImpl_Factory implements Factory<CategoryAdvertListItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public CategoryAdvertListItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static CategoryAdvertListItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new CategoryAdvertListItemPresenterImpl_Factory(provider);
    }

    public static CategoryAdvertListItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new CategoryAdvertListItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public CategoryAdvertListItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
