package com.avito.android.advert.item.booking;

import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertBookingBlueprint_Factory implements Factory<AdvertBookingBlueprint> {
    public final Provider<AdvertBookingPresenter> a;
    public final Provider<AttributedTextFormatter> b;

    public AdvertBookingBlueprint_Factory(Provider<AdvertBookingPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static AdvertBookingBlueprint_Factory create(Provider<AdvertBookingPresenter> provider, Provider<AttributedTextFormatter> provider2) {
        return new AdvertBookingBlueprint_Factory(provider, provider2);
    }

    public static AdvertBookingBlueprint newInstance(AdvertBookingPresenter advertBookingPresenter, AttributedTextFormatter attributedTextFormatter) {
        return new AdvertBookingBlueprint(advertBookingPresenter, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public AdvertBookingBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
