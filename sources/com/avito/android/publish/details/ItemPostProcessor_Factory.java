package com.avito.android.publish.details;

import com.avito.android.publish.details.item_wrapper.ItemWrapperFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ItemPostProcessor_Factory implements Factory<ItemPostProcessor> {
    public final Provider<ItemWrapperFactory> a;

    public ItemPostProcessor_Factory(Provider<ItemWrapperFactory> provider) {
        this.a = provider;
    }

    public static ItemPostProcessor_Factory create(Provider<ItemWrapperFactory> provider) {
        return new ItemPostProcessor_Factory(provider);
    }

    public static ItemPostProcessor newInstance(ItemWrapperFactory itemWrapperFactory) {
        return new ItemPostProcessor(itemWrapperFactory);
    }

    @Override // javax.inject.Provider
    public ItemPostProcessor get() {
        return newInstance(this.a.get());
    }
}
