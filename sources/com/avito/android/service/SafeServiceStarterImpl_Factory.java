package com.avito.android.service;

import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SafeServiceStarterImpl_Factory implements Factory<SafeServiceStarterImpl> {
    public final Provider<BuildInfo> a;

    public SafeServiceStarterImpl_Factory(Provider<BuildInfo> provider) {
        this.a = provider;
    }

    public static SafeServiceStarterImpl_Factory create(Provider<BuildInfo> provider) {
        return new SafeServiceStarterImpl_Factory(provider);
    }

    public static SafeServiceStarterImpl newInstance(BuildInfo buildInfo) {
        return new SafeServiceStarterImpl(buildInfo);
    }

    @Override // javax.inject.Provider
    public SafeServiceStarterImpl get() {
        return newInstance(this.a.get());
    }
}
