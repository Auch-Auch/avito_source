package com.avito.android.user_advert.soa_with_price.blueprint;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CloseReasonItemBlueprintImpl_Factory implements Factory<CloseReasonItemBlueprintImpl> {
    public final Provider<CloseReasonItemPresenter> a;

    public CloseReasonItemBlueprintImpl_Factory(Provider<CloseReasonItemPresenter> provider) {
        this.a = provider;
    }

    public static CloseReasonItemBlueprintImpl_Factory create(Provider<CloseReasonItemPresenter> provider) {
        return new CloseReasonItemBlueprintImpl_Factory(provider);
    }

    public static CloseReasonItemBlueprintImpl newInstance(CloseReasonItemPresenter closeReasonItemPresenter) {
        return new CloseReasonItemBlueprintImpl(closeReasonItemPresenter);
    }

    @Override // javax.inject.Provider
    public CloseReasonItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}
