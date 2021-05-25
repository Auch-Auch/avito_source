package com.avito.android.viewed_items;

import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.remote.ViewedItemsApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ViewedItemsInteractorImpl_Factory implements Factory<ViewedItemsInteractorImpl> {
    public final Provider<ViewedItemsApi> a;
    public final Provider<FavoriteAdvertItemConverter> b;
    public final Provider<TypedErrorThrowableConverter> c;
    public final Provider<SchedulersFactory3> d;

    public ViewedItemsInteractorImpl_Factory(Provider<ViewedItemsApi> provider, Provider<FavoriteAdvertItemConverter> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static ViewedItemsInteractorImpl_Factory create(Provider<ViewedItemsApi> provider, Provider<FavoriteAdvertItemConverter> provider2, Provider<TypedErrorThrowableConverter> provider3, Provider<SchedulersFactory3> provider4) {
        return new ViewedItemsInteractorImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static ViewedItemsInteractorImpl newInstance(ViewedItemsApi viewedItemsApi, FavoriteAdvertItemConverter favoriteAdvertItemConverter, TypedErrorThrowableConverter typedErrorThrowableConverter, SchedulersFactory3 schedulersFactory3) {
        return new ViewedItemsInteractorImpl(viewedItemsApi, favoriteAdvertItemConverter, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public ViewedItemsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
