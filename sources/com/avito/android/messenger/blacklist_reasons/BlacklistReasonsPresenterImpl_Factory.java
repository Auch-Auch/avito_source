package com.avito.android.messenger.blacklist_reasons;

import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BlacklistReasonsPresenterImpl_Factory implements Factory<BlacklistReasonsPresenterImpl> {
    public final Provider<BlockUserInteractor> a;
    public final Provider<BlacklistReasonsProvider> b;
    public final Provider<Formatter<Throwable>> c;
    public final Provider<SchedulersFactory> d;

    public BlacklistReasonsPresenterImpl_Factory(Provider<BlockUserInteractor> provider, Provider<BlacklistReasonsProvider> provider2, Provider<Formatter<Throwable>> provider3, Provider<SchedulersFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static BlacklistReasonsPresenterImpl_Factory create(Provider<BlockUserInteractor> provider, Provider<BlacklistReasonsProvider> provider2, Provider<Formatter<Throwable>> provider3, Provider<SchedulersFactory> provider4) {
        return new BlacklistReasonsPresenterImpl_Factory(provider, provider2, provider3, provider4);
    }

    public static BlacklistReasonsPresenterImpl newInstance(BlockUserInteractor blockUserInteractor, BlacklistReasonsProvider blacklistReasonsProvider, Formatter<Throwable> formatter, SchedulersFactory schedulersFactory) {
        return new BlacklistReasonsPresenterImpl(blockUserInteractor, blacklistReasonsProvider, formatter, schedulersFactory);
    }

    @Override // javax.inject.Provider
    public BlacklistReasonsPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get());
    }
}
