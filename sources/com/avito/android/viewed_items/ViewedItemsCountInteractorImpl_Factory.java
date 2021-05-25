package com.avito.android.viewed_items;

import com.avito.android.favorites.remote.ViewedItemsApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedItemsCountInteractorImpl_Factory implements Factory<ViewedItemsCountInteractorImpl> {
    public final Provider<ViewedItemsApi> a;
    public final Provider<SchedulersFactory3> b;

    public ViewedItemsCountInteractorImpl_Factory(Provider<ViewedItemsApi> provider, Provider<SchedulersFactory3> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ViewedItemsCountInteractorImpl_Factory create(Provider<ViewedItemsApi> provider, Provider<SchedulersFactory3> provider2) {
        return new ViewedItemsCountInteractorImpl_Factory(provider, provider2);
    }

    public static ViewedItemsCountInteractorImpl newInstance(ViewedItemsApi viewedItemsApi, SchedulersFactory3 schedulersFactory3) {
        return new ViewedItemsCountInteractorImpl(viewedItemsApi, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ViewedItemsCountInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
