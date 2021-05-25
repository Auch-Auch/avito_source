package com.avito.android.favorite_sellers.adapter.seller;

import com.avito.android.favorite_sellers.action.FavoriteSellersItemAction;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class SellerItemPresenterImpl_Factory implements Factory<SellerItemPresenterImpl> {
    public final Provider<Consumer<FavoriteSellersItemAction>> a;
    public final Provider<NotificationManagerProvider> b;

    public SellerItemPresenterImpl_Factory(Provider<Consumer<FavoriteSellersItemAction>> provider, Provider<NotificationManagerProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SellerItemPresenterImpl_Factory create(Provider<Consumer<FavoriteSellersItemAction>> provider, Provider<NotificationManagerProvider> provider2) {
        return new SellerItemPresenterImpl_Factory(provider, provider2);
    }

    public static SellerItemPresenterImpl newInstance(Consumer<FavoriteSellersItemAction> consumer, NotificationManagerProvider notificationManagerProvider) {
        return new SellerItemPresenterImpl(consumer, notificationManagerProvider);
    }

    @Override // javax.inject.Provider
    public SellerItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
