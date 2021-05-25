package com.avito.android.messenger.map.sharing.di;

import android.content.Context;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SharingMapFragmentModule_ProvideErrorFormatterFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Context> a;

    public SharingMapFragmentModule_ProvideErrorFormatterFactory(Provider<Context> provider) {
        this.a = provider;
    }

    public static SharingMapFragmentModule_ProvideErrorFormatterFactory create(Provider<Context> provider) {
        return new SharingMapFragmentModule_ProvideErrorFormatterFactory(provider);
    }

    public static Formatter<Throwable> provideErrorFormatter(Context context) {
        return (Formatter) Preconditions.checkNotNullFromProvides(SharingMapFragmentModule.provideErrorFormatter(context));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return provideErrorFormatter(this.a.get());
    }
}
