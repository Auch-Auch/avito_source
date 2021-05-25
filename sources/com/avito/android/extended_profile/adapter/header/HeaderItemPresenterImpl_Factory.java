package com.avito.android.extended_profile.adapter.header;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class HeaderItemPresenterImpl_Factory implements Factory<HeaderItemPresenterImpl> {
    public final Provider<Consumer<ExtendedProfileItemAction>> a;
    public final Provider<SubscriptionsPresenter> b;
    public final Provider<CompositeSnackbarPresenter> c;

    public HeaderItemPresenterImpl_Factory(Provider<Consumer<ExtendedProfileItemAction>> provider, Provider<SubscriptionsPresenter> provider2, Provider<CompositeSnackbarPresenter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static HeaderItemPresenterImpl_Factory create(Provider<Consumer<ExtendedProfileItemAction>> provider, Provider<SubscriptionsPresenter> provider2, Provider<CompositeSnackbarPresenter> provider3) {
        return new HeaderItemPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static HeaderItemPresenterImpl newInstance(Consumer<ExtendedProfileItemAction> consumer, SubscriptionsPresenter subscriptionsPresenter, CompositeSnackbarPresenter compositeSnackbarPresenter) {
        return new HeaderItemPresenterImpl(consumer, subscriptionsPresenter, compositeSnackbarPresenter);
    }

    @Override // javax.inject.Provider
    public HeaderItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
