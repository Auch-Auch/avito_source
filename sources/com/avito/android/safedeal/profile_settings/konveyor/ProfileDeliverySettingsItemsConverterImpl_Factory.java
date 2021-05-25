package com.avito.android.safedeal.profile_settings.konveyor;

import android.content.Context;
import com.avito.android.util.text.AttributedTextFormatter;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ProfileDeliverySettingsItemsConverterImpl_Factory implements Factory<ProfileDeliverySettingsItemsConverterImpl> {
    public final Provider<Context> a;
    public final Provider<AttributedTextFormatter> b;

    public ProfileDeliverySettingsItemsConverterImpl_Factory(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static ProfileDeliverySettingsItemsConverterImpl_Factory create(Provider<Context> provider, Provider<AttributedTextFormatter> provider2) {
        return new ProfileDeliverySettingsItemsConverterImpl_Factory(provider, provider2);
    }

    public static ProfileDeliverySettingsItemsConverterImpl newInstance(Context context, AttributedTextFormatter attributedTextFormatter) {
        return new ProfileDeliverySettingsItemsConverterImpl(context, attributedTextFormatter);
    }

    @Override // javax.inject.Provider
    public ProfileDeliverySettingsItemsConverterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
