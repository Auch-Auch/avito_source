package com.avito.android.session_refresh;

import com.avito.android.Features;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class RequestParamsInterceptorImpl_Factory implements Factory<RequestParamsInterceptorImpl> {
    public final Provider<BuildInfo> a;
    public final Provider<Features> b;

    public RequestParamsInterceptorImpl_Factory(Provider<BuildInfo> provider, Provider<Features> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static RequestParamsInterceptorImpl_Factory create(Provider<BuildInfo> provider, Provider<Features> provider2) {
        return new RequestParamsInterceptorImpl_Factory(provider, provider2);
    }

    public static RequestParamsInterceptorImpl newInstance(BuildInfo buildInfo, Features features) {
        return new RequestParamsInterceptorImpl(buildInfo, features);
    }

    @Override // javax.inject.Provider
    public RequestParamsInterceptorImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}
