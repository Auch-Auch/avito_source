package com.avito.android.tariff.edit_info.item.tabs;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TabsItemBlueprint_Factory implements Factory<TabsItemBlueprint> {
    public final Provider<TabsItemPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public TabsItemBlueprint_Factory(Provider<TabsItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TabsItemBlueprint_Factory create(Provider<TabsItemPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new TabsItemBlueprint_Factory(provider, provider2);
    }

    public static TabsItemBlueprint newInstance(TabsItemPresenter tabsItemPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new TabsItemBlueprint(tabsItemPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public TabsItemBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
