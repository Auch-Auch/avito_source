package com.avito.android.messenger.blacklist.mvi.di;

import android.content.res.Resources;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BlacklistFragmentModule_ProvideErrorFormatterFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Resources> a;

    public BlacklistFragmentModule_ProvideErrorFormatterFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static BlacklistFragmentModule_ProvideErrorFormatterFactory create(Provider<Resources> provider) {
        return new BlacklistFragmentModule_ProvideErrorFormatterFactory(provider);
    }

    public static Formatter<Throwable> provideErrorFormatter(Resources resources) {
        return (Formatter) Preconditions.checkNotNullFromProvides(BlacklistFragmentModule.INSTANCE.provideErrorFormatter(resources));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return provideErrorFormatter(this.a.get());
    }
}
