package com.avito.android.advert_core.discount;

import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDiscountDetailsDialogPresenterImpl_Factory implements Factory<AdvertDiscountDetailsDialogPresenterImpl> {
    public final Provider<AdapterPresenter> a;
    public final Provider<AdvertDiscountItemConverter> b;

    public AdvertDiscountDetailsDialogPresenterImpl_Factory(Provider<AdapterPresenter> provider, Provider<AdvertDiscountItemConverter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDiscountDetailsDialogPresenterImpl_Factory create(Provider<AdapterPresenter> provider, Provider<AdvertDiscountItemConverter> provider2) {
        return new AdvertDiscountDetailsDialogPresenterImpl_Factory(provider, provider2);
    }

    public static AdvertDiscountDetailsDialogPresenterImpl newInstance(AdapterPresenter adapterPresenter, AdvertDiscountItemConverter advertDiscountItemConverter) {
        return new AdvertDiscountDetailsDialogPresenterImpl(adapterPresenter, advertDiscountItemConverter);
    }

    @Override // javax.inject.Provider
    public AdvertDiscountDetailsDialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
