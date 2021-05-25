package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter;

import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalSearchFilterItemPresenterImpl_Factory implements Factory<VerticalSearchFilterItemPresenterImpl> {
    public final Provider<VerticalFilterPresenter> a;

    public VerticalSearchFilterItemPresenterImpl_Factory(Provider<VerticalFilterPresenter> provider) {
        this.a = provider;
    }

    public static VerticalSearchFilterItemPresenterImpl_Factory create(Provider<VerticalFilterPresenter> provider) {
        return new VerticalSearchFilterItemPresenterImpl_Factory(provider);
    }

    public static VerticalSearchFilterItemPresenterImpl newInstance(VerticalFilterPresenter verticalFilterPresenter) {
        return new VerticalSearchFilterItemPresenterImpl(verticalFilterPresenter);
    }

    @Override // javax.inject.Provider
    public VerticalSearchFilterItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
