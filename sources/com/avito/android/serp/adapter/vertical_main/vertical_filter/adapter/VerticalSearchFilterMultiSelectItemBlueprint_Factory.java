package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterMultiSelectItemBlueprint_Factory implements Factory<VerticalSearchFilterMultiSelectItemBlueprint> {
    public final Provider<VerticalSearchFilterItemPresenter> a;

    public VerticalSearchFilterMultiSelectItemBlueprint_Factory(Provider<VerticalSearchFilterItemPresenter> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterMultiSelectItemBlueprint_Factory create(Provider<VerticalSearchFilterItemPresenter> provider) {
        return new VerticalSearchFilterMultiSelectItemBlueprint_Factory(provider);
    }

    public static VerticalSearchFilterMultiSelectItemBlueprint newInstance(VerticalSearchFilterItemPresenter verticalSearchFilterItemPresenter) {
        return new VerticalSearchFilterMultiSelectItemBlueprint(verticalSearchFilterItemPresenter);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterMultiSelectItemBlueprint get() {
        return newInstance(this.a.get());
    }
}
