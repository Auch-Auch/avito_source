package com.avito.android.messenger.blacklist.mvi;

import com.avito.android.Features;
import com.avito.android.date_time_formatter.BlacklistDateFormatter;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BlacklistPresenterImpl_Factory implements Factory<BlacklistPresenterImpl> {
    public final Provider<SchedulersFactory> a;
    public final Provider<Features> b;
    public final Provider<BlacklistInteractor> c;
    public final Provider<BlacklistDateFormatter> d;
    public final Provider<Formatter<Throwable>> e;

    public BlacklistPresenterImpl_Factory(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<BlacklistInteractor> provider3, Provider<BlacklistDateFormatter> provider4, Provider<Formatter<Throwable>> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static BlacklistPresenterImpl_Factory create(Provider<SchedulersFactory> provider, Provider<Features> provider2, Provider<BlacklistInteractor> provider3, Provider<BlacklistDateFormatter> provider4, Provider<Formatter<Throwable>> provider5) {
        return new BlacklistPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static BlacklistPresenterImpl newInstance(SchedulersFactory schedulersFactory, Features features, BlacklistInteractor blacklistInteractor, BlacklistDateFormatter blacklistDateFormatter, Formatter<Throwable> formatter) {
        return new BlacklistPresenterImpl(schedulersFactory, features, blacklistInteractor, blacklistDateFormatter, formatter);
    }

    @Override // javax.inject.Provider
    public BlacklistPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
