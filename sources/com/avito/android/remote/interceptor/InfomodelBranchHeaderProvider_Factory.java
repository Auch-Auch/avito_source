package com.avito.android.remote.interceptor;

import com.avito.android.Features;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfomodelBranchHeaderProvider_Factory implements Factory<InfomodelBranchHeaderProvider> {
    public final Provider<Features> a;
    public final Provider<BuildInfo> b;

    public InfomodelBranchHeaderProvider_Factory(Provider<Features> provider, Provider<BuildInfo> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InfomodelBranchHeaderProvider_Factory create(Provider<Features> provider, Provider<BuildInfo> provider2) {
        return new InfomodelBranchHeaderProvider_Factory(provider, provider2);
    }

    public static InfomodelBranchHeaderProvider newInstance(Features features, BuildInfo buildInfo) {
        return new InfomodelBranchHeaderProvider(features, buildInfo);
    }

    @Override // javax.inject.Provider
    public InfomodelBranchHeaderProvider get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
