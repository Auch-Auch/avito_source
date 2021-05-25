package com.avito.android.messenger.search.di;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsSearchModule_ProvideErrorFormatterFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Resources> a;

    public ChannelsSearchModule_ProvideErrorFormatterFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ChannelsSearchModule_ProvideErrorFormatterFactory create(Provider<Resources> provider) {
        return new ChannelsSearchModule_ProvideErrorFormatterFactory(provider);
    }

    public static Formatter<Throwable> provideErrorFormatter(Resources resources) {
        return (Formatter) Preconditions.checkNotNullFromProvides(ChannelsSearchModule.provideErrorFormatter(resources));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return provideErrorFormatter(this.a.get());
    }
}
