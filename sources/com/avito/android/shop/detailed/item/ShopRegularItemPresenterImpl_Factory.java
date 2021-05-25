package com.avito.android.shop.detailed.item;

import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.shop.detailed.AwardsClickListener;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.util.Kundle;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ShopRegularItemPresenterImpl_Factory implements Factory<ShopRegularItemPresenterImpl> {
    public final Provider<SubscriptionsPresenter> a;
    public final Provider<CompositeSnackbarPresenter> b;
    public final Provider<ShopItemRatingPresenter> c;
    public final Provider<ShopHeaderListener> d;
    public final Provider<AwardsClickListener> e;
    public final Provider<ShopRegularResourceProvider> f;
    public final Provider<Kundle> g;

    public ShopRegularItemPresenterImpl_Factory(Provider<SubscriptionsPresenter> provider, Provider<CompositeSnackbarPresenter> provider2, Provider<ShopItemRatingPresenter> provider3, Provider<ShopHeaderListener> provider4, Provider<AwardsClickListener> provider5, Provider<ShopRegularResourceProvider> provider6, Provider<Kundle> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static ShopRegularItemPresenterImpl_Factory create(Provider<SubscriptionsPresenter> provider, Provider<CompositeSnackbarPresenter> provider2, Provider<ShopItemRatingPresenter> provider3, Provider<ShopHeaderListener> provider4, Provider<AwardsClickListener> provider5, Provider<ShopRegularResourceProvider> provider6, Provider<Kundle> provider7) {
        return new ShopRegularItemPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ShopRegularItemPresenterImpl newInstance(SubscriptionsPresenter subscriptionsPresenter, CompositeSnackbarPresenter compositeSnackbarPresenter, ShopItemRatingPresenter shopItemRatingPresenter, Lazy<ShopHeaderListener> lazy, Lazy<AwardsClickListener> lazy2, ShopRegularResourceProvider shopRegularResourceProvider, Kundle kundle) {
        return new ShopRegularItemPresenterImpl(subscriptionsPresenter, compositeSnackbarPresenter, shopItemRatingPresenter, lazy, lazy2, shopRegularResourceProvider, kundle);
    }

    @Override // javax.inject.Provider
    public ShopRegularItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), DoubleCheck.lazy(this.d), DoubleCheck.lazy(this.e), this.f.get(), this.g.get());
    }
}
