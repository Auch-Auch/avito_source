package com.avito.android.extended_profile.adapter.category.category_header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class CategoryHeaderItemPresenterImpl_Factory implements Factory<CategoryHeaderItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public CategoryHeaderItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static CategoryHeaderItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new CategoryHeaderItemPresenterImpl_Factory(provider);
    }

    public static CategoryHeaderItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new CategoryHeaderItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public CategoryHeaderItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
