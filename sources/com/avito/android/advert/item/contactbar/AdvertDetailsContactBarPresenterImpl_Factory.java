package com.avito.android.advert.item.contactbar;

import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsContactBarPresenterImpl_Factory implements Factory<AdvertDetailsContactBarPresenterImpl> {
    public final Provider<AdvertContactsPresenter> a;

    public AdvertDetailsContactBarPresenterImpl_Factory(Provider<AdvertContactsPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsContactBarPresenterImpl_Factory create(Provider<AdvertContactsPresenter> provider) {
        return new AdvertDetailsContactBarPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsContactBarPresenterImpl newInstance(AdvertContactsPresenter advertContactsPresenter) {
        return new AdvertDetailsContactBarPresenterImpl(advertContactsPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsContactBarPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
