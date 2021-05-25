package com.avito.android.help_center.help_center_request.di;

import android.webkit.CookieManager;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl_Factory;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.di.CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterJSInterfaceImpl_Factory;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlInterceptorImpl;
import com.avito.android.help_center.HelpCenterUrlInterceptorImpl_Factory;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.help_center.HelpCenterUrlProviderImpl;
import com.avito.android.help_center.HelpCenterUrlProviderImpl_Factory;
import com.avito.android.help_center.help_center_request.HelpCenterRequestFragment;
import com.avito.android.help_center.help_center_request.HelpCenterRequestFragment_MembersInjector;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenter;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenterImpl;
import com.avito.android.help_center.help_center_request.HelpCenterRequestPresenterImpl_Factory;
import com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent;
import com.avito.android.remote.SupportFeaturesHeaderProvider;
import com.avito.android.remote.interceptor.DateHeaderProvider;
import com.avito.android.remote.interceptor.DeviceIdHeaderProvider;
import com.avito.android.remote.interceptor.GeoHeaderProvider;
import com.avito.android.remote.interceptor.SessionHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerHelpCenterRequestComponent implements HelpCenterRequestComponent {
    public final HelpCenterRequestDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<CookieManager> c = DoubleCheck.provider(HelpCenterRequestModule_ProvideCookieManager$help_center_releaseFactory.create());
    public Provider<GeoHeaderProvider> d;
    public Provider<SessionHeaderProvider> e;
    public Provider<DateHeaderProvider> f;
    public Provider<DeviceIdHeaderProvider> g;
    public Provider<SupportFeaturesHeaderProvider> h;
    public Provider<UserAgentHeaderProvider> i;
    public Provider<ServerTimeSource> j;
    public Provider<CookieExpiredTimeImpl> k;
    public Provider<CookieExpiredTime> l;
    public Provider<CookieProvider> m;
    public Provider<HelpCenterJSInterface> n;
    public Provider<Features> o;
    public Provider<HelpCenterUrlProviderImpl> p;
    public Provider<HelpCenterUrlProvider> q;
    public Provider<HelpCenterUrlInterceptorImpl> r;
    public Provider<HelpCenterUrlInterceptor> s;
    public Provider<String> t;
    public Provider<String> u;
    public Provider<String> v;
    public Provider<HelpCenterRequestPresenterImpl> w;
    public Provider<HelpCenterRequestPresenter> x;

    public static final class b implements HelpCenterRequestComponent.Builder {
        public HelpCenterRequestDependencies a;
        public String b;
        public String c;
        public String d;

        public b(a aVar) {
        }

        @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent.Builder
        public HelpCenterRequestComponent.Builder advertisementId(String str) {
            this.c = str;
            return this;
        }

        @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent.Builder
        public HelpCenterRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HelpCenterRequestDependencies.class);
            return new DaggerHelpCenterRequestComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent.Builder
        public HelpCenterRequestComponent.Builder contextId(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent.Builder
        public HelpCenterRequestComponent.Builder dependencies(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = (HelpCenterRequestDependencies) Preconditions.checkNotNull(helpCenterRequestDependencies);
            return this;
        }

        @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent.Builder
        public HelpCenterRequestComponent.Builder theme(String str) {
            this.b = str;
            return this;
        }
    }

    public static class c implements Provider<DateHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public c(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DateHeaderProvider get() {
            return (DateHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.dateHeaderProvider());
        }
    }

    public static class d implements Provider<DeviceIdHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public d(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceIdHeaderProvider get() {
            return (DeviceIdHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdHeaderProvider());
        }
    }

    public static class e implements Provider<Features> {
        public final HelpCenterRequestDependencies a;

        public e(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<GeoHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public f(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoHeaderProvider get() {
            return (GeoHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.geoHeaderProvider());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final HelpCenterRequestDependencies a;

        public g(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<ServerTimeSource> {
        public final HelpCenterRequestDependencies a;

        public h(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public static class i implements Provider<SessionHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public i(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionHeaderProvider get() {
            return (SessionHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.sessionHeaderProvider());
        }
    }

    public static class j implements Provider<SupportFeaturesHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public j(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SupportFeaturesHeaderProvider get() {
            return (SupportFeaturesHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.supportFeaturesHeaderProvider());
        }
    }

    public static class k implements Provider<UserAgentHeaderProvider> {
        public final HelpCenterRequestDependencies a;

        public k(HelpCenterRequestDependencies helpCenterRequestDependencies) {
            this.a = helpCenterRequestDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentHeaderProvider get() {
            return (UserAgentHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentHeaderProvider());
        }
    }

    public DaggerHelpCenterRequestComponent(HelpCenterRequestDependencies helpCenterRequestDependencies, String str, String str2, String str3, a aVar) {
        this.a = helpCenterRequestDependencies;
        this.b = new g(helpCenterRequestDependencies);
        this.d = new f(helpCenterRequestDependencies);
        this.e = new i(helpCenterRequestDependencies);
        this.f = new c(helpCenterRequestDependencies);
        this.g = new d(helpCenterRequestDependencies);
        this.h = new j(helpCenterRequestDependencies);
        this.i = new k(helpCenterRequestDependencies);
        h hVar = new h(helpCenterRequestDependencies);
        this.j = hVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(hVar);
        this.k = create;
        Provider<CookieExpiredTime> provider = SingleCheck.provider(create);
        this.l = provider;
        this.m = SingleCheck.provider(CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory.create(this.d, this.e, this.f, this.g, this.h, this.i, provider));
        this.n = DoubleCheck.provider(HelpCenterJSInterfaceImpl_Factory.create());
        e eVar = new e(helpCenterRequestDependencies);
        this.o = eVar;
        HelpCenterUrlProviderImpl_Factory create2 = HelpCenterUrlProviderImpl_Factory.create(eVar);
        this.p = create2;
        Provider<HelpCenterUrlProvider> provider2 = DoubleCheck.provider(create2);
        this.q = provider2;
        HelpCenterUrlInterceptorImpl_Factory create3 = HelpCenterUrlInterceptorImpl_Factory.create(provider2);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = InstanceFactory.createNullable(str);
        this.u = InstanceFactory.createNullable(str2);
        Factory createNullable = InstanceFactory.createNullable(str3);
        this.v = createNullable;
        HelpCenterRequestPresenterImpl_Factory create4 = HelpCenterRequestPresenterImpl_Factory.create(this.b, this.c, this.m, this.n, this.q, this.s, this.t, this.u, createNullable);
        this.w = create4;
        this.x = DoubleCheck.provider(create4);
    }

    public static HelpCenterRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.help_center.help_center_request.di.HelpCenterRequestComponent
    public void inject(HelpCenterRequestFragment helpCenterRequestFragment) {
        HelpCenterRequestFragment_MembersInjector.injectPresenter(helpCenterRequestFragment, this.x.get());
        HelpCenterRequestFragment_MembersInjector.injectImplicitIntentFactory(helpCenterRequestFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        HelpCenterRequestFragment_MembersInjector.injectAnalytics(helpCenterRequestFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
