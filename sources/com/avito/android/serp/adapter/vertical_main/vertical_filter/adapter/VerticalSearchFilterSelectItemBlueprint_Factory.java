package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterSelectItemBlueprint_Factory implements Factory<VerticalSearchFilterSelectItemBlueprint> {
    public final Provider<VerticalSearchFilterItemPresenter> a;

    public VerticalSearchFilterSelectItemBlueprint_Factory(Provider<VerticalSearchFilterItemPresenter> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterSelectItemBlueprint_Factory create(Provider<VerticalSearchFilterItemPresenter> provider) {
        return new VerticalSearchFilterSelectItemBlueprint_Factory(provider);
    }

    public static VerticalSearchFilterSelectItemBlueprint newInstance(VerticalSearchFilterItemPresenter verticalSearchFilterItemPresenter) {
        return new VerticalSearchFilterSelectItemBlueprint(verticalSearchFilterItemPresenter);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
