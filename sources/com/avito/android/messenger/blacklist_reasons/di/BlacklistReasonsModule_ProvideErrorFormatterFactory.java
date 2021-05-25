package com.avito.android.messenger.blacklist_reasons.di;

import androidx.fragment.app.Fragment;
import com.avito.android.util.Formatter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class BlacklistReasonsModule_ProvideErrorFormatterFactory implements Factory<Formatter<Throwable>> {
    public final Provider<Fragment> a;

    public BlacklistReasonsModule_ProvideErrorFormatterFactory(Provider<Fragment> provider) {
        this.a = provider;
    }

    public static BlacklistReasonsModule_ProvideErrorFormatterFactory create(Provider<Fragment> provider) {
        return new BlacklistReasonsModule_ProvideErrorFormatterFactory(provider);
    }

    public static Formatter<Throwable> provideErrorFormatter(Fragment fragment) {
        return (Formatter) Preconditions.checkNotNullFromProvides(BlacklistReasonsModule.provideErrorFormatter(fragment));
    }

    @Override // javax.inject.Provider
    public Formatter<Throwable> get() {
        return provideErrorFormatter(this.a.get());
    }
}
