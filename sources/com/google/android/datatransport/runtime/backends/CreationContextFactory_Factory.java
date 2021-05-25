package com.google.android.datatransport.runtime.backends;

import a2.j.b.a.c.l.d;
import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CreationContextFactory_Factory implements Factory<d> {
    public final Provider<Context> a;
    public final Provider<Clock> b;
    public final Provider<Clock> c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static CreationContextFactory_Factory create(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static d newInstance(Context context, Clock clock, Clock clock2) {
        return new d(context, clock, clock2);
    }

    @Override // javax.inject.Provider
    public d get() {
        return new d(this.a.get(), this.b.get(), this.c.get());
    }
}
