package com.avito.android.messenger.channels.mvi.di;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class ChannelsModule_ProvideErrorFormatterFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Resources> a;

    public ChannelsModule_ProvideErrorFormatterFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static ChannelsModule_ProvideErrorFormatterFactory create(Provider<Resources> provider) {
        return new ChannelsModule_ProvideErrorFormatterFactory(provider);
    }

    public static Formatter<Throwable> provideErrorFormatter(Resources resources) {
        return (Formatter) Preconditions.checkNotNullFromProvides(ChannelsModule.INSTANCE.provideErrorFormatter(resources));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return provideErrorFormatter(this.a.get());
    }
}
