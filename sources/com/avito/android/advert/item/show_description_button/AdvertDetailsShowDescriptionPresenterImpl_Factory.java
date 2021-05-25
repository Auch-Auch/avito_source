package com.avito.android.advert.item.show_description_button;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsShowDescriptionPresenterImpl_Factory implements Factory<AdvertDetailsShowDescriptionPresenterImpl> {
    public final Provider<ShowDescriptionClickListener> a;

    public AdvertDetailsShowDescriptionPresenterImpl_Factory(Provider<ShowDescriptionClickListener> provider) {
        this.a = provider;
    }

    public static AdvertDetailsShowDescriptionPresenterImpl_Factory create(Provider<ShowDescriptionClickListener> provider) {
        return new AdvertDetailsShowDescriptionPresenterImpl_Factory(provider);
    }

    public static AdvertDetailsShowDescriptionPresenterImpl newInstance(ShowDescriptionClickListener showDescriptionClickListener) {
        return new AdvertDetailsShowDescriptionPresenterImpl(showDescriptionClickListener);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsShowDescriptionPresenterImpl get() {
        return newInstance(this.a.get());
    }
}
