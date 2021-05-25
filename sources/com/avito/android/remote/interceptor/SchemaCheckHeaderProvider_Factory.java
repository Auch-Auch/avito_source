package com.avito.android.remote.interceptor;

import com.avito.android.Features;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SchemaCheckHeaderProvider_Factory implements Factory<SchemaCheckHeaderProvider> {
    public final Provider<Features> a;
    public final Provider<BuildInfo> b;

    public SchemaCheckHeaderProvider_Factory(Provider<Features> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SchemaCheckHeaderProvider_Factory create(Provider<Features> provider, Provider<BuildInfo> provider2) {
        return new SchemaCheckHeaderProvider_Factory(provider, provider2);
    }

    public static SchemaCheckHeaderProvider newInstance(Features features, BuildInfo buildInfo) {
        return new SchemaCheckHeaderProvider(features, buildInfo);
    }

    @Override // javax.inject.Provider
    public SchemaCheckHeaderProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
