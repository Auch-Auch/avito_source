package com.avito.android.cart.summary.konveyor.decoration;

import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class HeaderItemDecoration_Factory implements Factory<HeaderItemDecoration> {
    public final Provider<ItemBinder> a;

    public HeaderItemDecoration_Factory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static HeaderItemDecoration_Factory create(Provider<ItemBinder> provider) {
        return new HeaderItemDecoration_Factory(provider);
    }

    public static HeaderItemDecoration newInstance(ItemBinder itemBinder) {
        return new HeaderItemDecoration(itemBinder);
    }

    @Override // javax.inject.Provider
    public HeaderItemDecoration get() {
        return newInstance(this.a.get());
    }
}
