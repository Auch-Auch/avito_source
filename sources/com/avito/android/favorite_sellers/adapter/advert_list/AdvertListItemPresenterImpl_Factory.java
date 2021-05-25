package com.avito.android.favorite_sellers.adapter.advert_list;

import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertListItemPresenterImpl_Factory implements Factory<AdvertListItemPresenterImpl> {
    public final Provider<Kundle> a;

    public AdvertListItemPresenterImpl_Factory(Provider<Kundle> provider) {
        this.a = provider;
    }

    public static AdvertListItemPresenterImpl_Factory create(Provider<Kundle> provider) {
        return new AdvertListItemPresenterImpl_Factory(provider);
    }

    public static AdvertListItemPresenterImpl newInstance(Kundle kundle) {
        return new AdvertListItemPresenterImpl(kundle);
    }

    @Override // javax.inject.Provider
    public AdvertListItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
