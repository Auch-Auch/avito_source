package com.google.android.datatransport.runtime.backends;

import a2.j.b.a.c.l.d;
import a2.j.b.a.c.l.e;
import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MetadataBackendRegistry_Factory implements Factory<e> {
    public final Provider<Context> a;
    public final Provider<d> b;

    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<d> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MetadataBackendRegistry_Factory create(Provider<Context> provider, Provider<d> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    public static e newInstance(Context context, Object obj) {
        return new e(context, (d) obj);
    }

    @Override // javax.inject.Provider
    public e get() {
        return new e(this.a.get(), this.b.get());
    }
}
