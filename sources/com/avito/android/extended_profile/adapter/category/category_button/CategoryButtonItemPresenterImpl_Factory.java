package com.avito.android.extended_profile.adapter.category.category_button;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class CategoryButtonItemPresenterImpl_Factory implements Factory<CategoryButtonItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;

    public CategoryButtonItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        this.a = provider;
    }

    public static CategoryButtonItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider) {
        return new CategoryButtonItemPresenterImpl_Factory(provider);
    }

    public static CategoryButtonItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer) {
        return new CategoryButtonItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public CategoryButtonItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
