package com.avito.android.user_adverts.tab_screens.advert_list.loading;

import com.avito.android.user_adverts.tab_screens.advert_list.UserAdvertItemAction;
import dagger.internal.Factory;
import io.reactivex.functions.Consumer;
import javax.inject.Provider;
public final class LoadingItemPresenterImpl_Factory implements Factory<LoadingItemPresenterImpl> {
    public final Provider<Consumer<UserAdvertItemAction>> a;

    public LoadingItemPresenterImpl_Factory(Provider<Consumer<UserAdvertItemAction>> provider) {
        this.a = provider;
    }

    public static LoadingItemPresenterImpl_Factory create(Provider<Consumer<UserAdvertItemAction>> provider) {
        return new LoadingItemPresenterImpl_Factory(provider);
    }

    public static LoadingItemPresenterImpl newInstance(Consumer<UserAdvertItemAction> consumer) {
        return new LoadingItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public LoadingItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
