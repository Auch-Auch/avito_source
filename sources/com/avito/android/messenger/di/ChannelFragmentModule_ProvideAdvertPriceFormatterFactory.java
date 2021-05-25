package com.avito.android.messenger.di;

import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class ChannelFragmentModule_ProvideAdvertPriceFormatterFactory implements Factory<Formatter<AdvertPrice>> {
    public final ChannelFragmentModule a;
    public final Provider<Locale> b;

    public ChannelFragmentModule_ProvideAdvertPriceFormatterFactory(ChannelFragmentModule channelFragmentModule, Provider<Locale> provider) {
        this.a = channelFragmentModule;
        this.b = provider;
    }

    public static ChannelFragmentModule_ProvideAdvertPriceFormatterFactory create(ChannelFragmentModule channelFragmentModule, Provider<Locale> provider) {
        return new ChannelFragmentModule_ProvideAdvertPriceFormatterFactory(channelFragmentModule, provider);
    }

    public static Formatter<AdvertPrice> provideAdvertPriceFormatter(ChannelFragmentModule channelFragmentModule, Locale locale) {
        return (Formatter) Preconditions.checkNotNullFromProvides(channelFragmentModule.provideAdvertPriceFormatter(locale));
    }

    @Override // javax.inject.Provider
    public Formatter<AdvertPrice> get() {
        return provideAdvertPriceFormatter(this.a, this.b.get());
    }
}
