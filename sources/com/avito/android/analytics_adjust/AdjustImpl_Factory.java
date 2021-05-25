package com.avito.android.analytics_adjust;

import android.app.Application;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdjustImpl_Factory implements Factory<AdjustImpl> {
    public final Provider<Application> a;
    public final Provider<BuildInfo> b;
    public final Provider<String> c;
    public final Provider<String> d;
    public final Provider<String> e;

    public AdjustImpl_Factory(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static AdjustImpl_Factory create(Provider<Application> provider, Provider<BuildInfo> provider2, Provider<String> provider3, Provider<String> provider4, Provider<String> provider5) {
        return new AdjustImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static AdjustImpl newInstance(Application application, BuildInfo buildInfo, String str, String str2, String str3) {
        return new AdjustImpl(application, buildInfo, str, str2, str3);
    }

    @Override // javax.inject.Provider
    public AdjustImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
