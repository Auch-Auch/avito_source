package com.avito.android.advert.viewed;

import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedAdvertsPresenterImpl_Factory implements Factory<ViewedAdvertsPresenterImpl> {
    public final Provider<ViewedAdvertsEventInteractor> a;
    public final Provider<SchedulersFactory3> b;

    public ViewedAdvertsPresenterImpl_Factory(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ViewedAdvertsPresenterImpl_Factory create(Provider<ViewedAdvertsEventInteractor> provider, Provider<SchedulersFactory3> provider2) {
        return new ViewedAdvertsPresenterImpl_Factory(provider, provider2);
    }

    public static ViewedAdvertsPresenterImpl newInstance(ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, SchedulersFactory3 schedulersFactory3) {
        return new ViewedAdvertsPresenterImpl(viewedAdvertsEventInteractor, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ViewedAdvertsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
