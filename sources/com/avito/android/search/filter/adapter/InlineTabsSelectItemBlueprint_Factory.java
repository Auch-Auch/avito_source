package com.avito.android.search.filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineTabsSelectItemBlueprint_Factory implements Factory<InlineTabsSelectItemBlueprint> {
    public final Provider<InlineTabsSelectItemPresenter> a;

    public InlineTabsSelectItemBlueprint_Factory(Provider<InlineTabsSelectItemPresenter> provider) {
        this.a = provider;
    }

    public static InlineTabsSelectItemBlueprint_Factory create(Provider<InlineTabsSelectItemPresenter> provider) {
        return new InlineTabsSelectItemBlueprint_Factory(provider);
    }

    public static InlineTabsSelectItemBlueprint newInstance(InlineTabsSelectItemPresenter inlineTabsSelectItemPresenter) {
        return new InlineTabsSelectItemBlueprint(inlineTabsSelectItemPresenter);
    }

    @Override // javax.inject.Provider
    public InlineTabsSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
