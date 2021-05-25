package com.avito.android.bundles.vas_union.item.tabs;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TabsItemBlueprint_Factory implements Factory<TabsItemBlueprint> {
    public final Provider<TabsItemPresenter> a;

    public TabsItemBlueprint_Factory(Provider<TabsItemPresenter> provider) {
        this.a = provider;
    }

    public static TabsItemBlueprint_Factory create(Provider<TabsItemPresenter> provider) {
        return new TabsItemBlueprint_Factory(provider);
    }

    public static TabsItemBlueprint newInstance(TabsItemPresenter tabsItemPresenter) {
        return new TabsItemBlueprint(tabsItemPresenter);
    }

    @Override // javax.inject.Provider
    public TabsItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
