package com.avito.android.advert_core.discount;

import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDiscountDetailsDialogImpl_Factory implements Factory<AdvertDiscountDetailsDialogImpl> {
    public final Provider<SimpleRecyclerAdapter> a;
    public final Provider<AdvertDiscountDetailsDialogPresenter> b;

    public AdvertDiscountDetailsDialogImpl_Factory(Provider<SimpleRecyclerAdapter> provider, Provider<AdvertDiscountDetailsDialogPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertDiscountDetailsDialogImpl_Factory create(Provider<SimpleRecyclerAdapter> provider, Provider<AdvertDiscountDetailsDialogPresenter> provider2) {
        return new AdvertDiscountDetailsDialogImpl_Factory(provider, provider2);
    }

    public static AdvertDiscountDetailsDialogImpl newInstance(SimpleRecyclerAdapter simpleRecyclerAdapter, AdvertDiscountDetailsDialogPresenter advertDiscountDetailsDialogPresenter) {
        return new AdvertDiscountDetailsDialogImpl(simpleRecyclerAdapter, advertDiscountDetailsDialogPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDiscountDetailsDialogImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
