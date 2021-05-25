package com.avito.android.shop.detailed.item;

import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopGoldItemPresenterImpl_Factory implements Factory<ShopGoldItemPresenterImpl> {
    public final Provider<SubscriptionsPresenter> a;
    public final Provider<CompositeSnackbarPresenter> b;
    public final Provider<ShopItemRatingPresenter> c;
    public final Provider<ShopHeaderListener> d;
    public final Provider<ShopGoldResourceProvider> e;
    public final Provider<Kundle> f;

    public ShopGoldItemPresenterImpl_Factory(Provider<SubscriptionsPresenter> provider, Provider<CompositeSnackbarPresenter> provider2, Provider<ShopItemRatingPresenter> provider3, Provider<ShopHeaderListener> provider4, Provider<ShopGoldResourceProvider> provider5, Provider<Kundle> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static ShopGoldItemPresenterImpl_Factory create(Provider<SubscriptionsPresenter> provider, Provider<CompositeSnackbarPresenter> provider2, Provider<ShopItemRatingPresenter> provider3, Provider<ShopHeaderListener> provider4, Provider<ShopGoldResourceProvider> provider5, Provider<Kundle> provider6) {
        return new ShopGoldItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ShopGoldItemPresenterImpl newInstance(SubscriptionsPresenter subscriptionsPresenter, CompositeSnackbarPresenter compositeSnackbarPresenter, ShopItemRatingPresenter shopItemRatingPresenter, Lazy<ShopHeaderListener> lazy, ShopGoldResourceProvider shopGoldResourceProvider, Kundle kundle) {
        return new ShopGoldItemPresenterImpl(subscriptionsPresenter, compositeSnackbarPresenter, shopItemRatingPresenter, lazy, shopGoldResourceProvider, kundle);
    }

    @Override // javax.inject.Provider
    public ShopGoldItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), this.e.get(), this.f.get());
    }
}
