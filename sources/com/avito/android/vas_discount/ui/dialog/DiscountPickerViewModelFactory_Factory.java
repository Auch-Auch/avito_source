package com.avito.android.vas_discount.ui.dialog;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.model.DiscountResponse;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas_discount.business.DiscountToItemConverter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class DiscountPickerViewModelFactory_Factory implements Factory<DiscountPickerViewModelFactory> {
    public final Provider<DiscountResponse> a;
    public final Provider<DiscountToItemConverter> b;
    public final Provider<DeepLinkIntentFactory> c;
    public final Provider<SchedulersFactory> d;

    public DiscountPickerViewModelFactory_Factory(Provider<DiscountResponse> provider, Provider<DiscountToItemConverter> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static DiscountPickerViewModelFactory_Factory create(Provider<DiscountResponse> provider, Provider<DiscountToItemConverter> provider2, Provider<DeepLinkIntentFactory> provider3, Provider<SchedulersFactory> provider4) {
        return new DiscountPickerViewModelFactory_Factory(provider, provider2, provider3, provider4);
    }

    public static DiscountPickerViewModelFactory newInstance(DiscountResponse discountResponse, DiscountToItemConverter discountToItemConverter, DeepLinkIntentFactory deepLinkIntentFactory, SchedulersFactory schedulersFactory) {
        return new DiscountPickerViewModelFactory(discountResponse, discountToItemConverter, deepLinkIntentFactory, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public DiscountPickerViewModelFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
