package com.avito.android.analytics.grafana;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class GraphitePrefixImpl_Factory implements Factory<GraphitePrefixImpl> {
    public final Provider<BuildInfo> a;

    public GraphitePrefixImpl_Factory(Provider<BuildInfo> provider) {
        this.a = provider;
    }

    public static GraphitePrefixImpl_Factory create(Provider<BuildInfo> provider) {
        return new GraphitePrefixImpl_Factory(provider);
    }

    public static GraphitePrefixImpl newInstance(BuildInfo buildInfo) {
        return new GraphitePrefixImpl(buildInfo);
    }

    @Override // javax.inject.Provider
    public GraphitePrefixImpl get() {
        return newInstance(this.a.get());
    }
}
