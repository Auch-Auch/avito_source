package com.avito.android.grouping_adverts;

import com.avito.konveyor.ItemBinder;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GroupingAdvertsItemsFilterImpl_Factory implements Factory<GroupingAdvertsItemsFilterImpl> {
    public final Provider<ItemBinder> a;

    public GroupingAdvertsItemsFilterImpl_Factory(Provider<ItemBinder> provider) {
        this.a = provider;
    }

    public static GroupingAdvertsItemsFilterImpl_Factory create(Provider<ItemBinder> provider) {
        return new GroupingAdvertsItemsFilterImpl_Factory(provider);
    }

    public static GroupingAdvertsItemsFilterImpl newInstance(ItemBinder itemBinder) {
        return new GroupingAdvertsItemsFilterImpl(itemBinder);
    }

    @Override // javax.inject.Provider
    public GroupingAdvertsItemsFilterImpl get() {
        return newInstance(this.a.get());
    }
}
