package com.avito.android.serp.adapter.vertical_main.vertical_filter.item;

import com.avito.android.analytics.Analytics;
import com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class VerticalFilterItemPresenterImpl_Factory implements Factory<VerticalFilterItemPresenterImpl> {
    public final Provider<VerticalFilterPresenter> a;
    public final Provider<Analytics> b;

    public VerticalFilterItemPresenterImpl_Factory(Provider<VerticalFilterPresenter> provider, Provider<Analytics> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static VerticalFilterItemPresenterImpl_Factory create(Provider<VerticalFilterPresenter> provider, Provider<Analytics> provider2) {
        return new VerticalFilterItemPresenterImpl_Factory(provider, provider2);
    }

    public static VerticalFilterItemPresenterImpl newInstance(VerticalFilterPresenter verticalFilterPresenter, Analytics analytics) {
        return new VerticalFilterItemPresenterImpl(verticalFilterPresenter, analytics);
    }

    @Override // javax.inject.Provider
    public VerticalFilterItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
