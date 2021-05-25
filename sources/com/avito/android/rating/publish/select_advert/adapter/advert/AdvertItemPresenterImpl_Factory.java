package com.avito.android.rating.publish.select_advert.adapter.advert;

import com.avito.android.rating.publish.select_advert.adapter.SelectAdvertAction;
import dagger.internal.Factory;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Provider;
public final class AdvertItemPresenterImpl_Factory implements Factory<AdvertItemPresenterImpl> {
    public final Provider<Consumer<SelectAdvertAction>> a;

    public AdvertItemPresenterImpl_Factory(Provider<Consumer<SelectAdvertAction>> provider) {
        this.a = provider;
    }

    public static AdvertItemPresenterImpl_Factory create(Provider<Consumer<SelectAdvertAction>> provider) {
        return new AdvertItemPresenterImpl_Factory(provider);
    }

    public static AdvertItemPresenterImpl newInstance(Consumer<SelectAdvertAction> consumer) {
        return new AdvertItemPresenterImpl(consumer);
    }

    @Override // javax.inject.Provider
    public AdvertItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
