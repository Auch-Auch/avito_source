package com.avito.android.help_center.di;

import android.webkit.CookieManager;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl_Factory;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.di.CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.help_center.HelpCenterFragment;
import com.avito.android.help_center.HelpCenterFragment_MembersInjector;
import com.avito.android.help_center.HelpCenterJSInterface;
import com.avito.android.help_center.HelpCenterJSInterfaceImpl_Factory;
import com.avito.android.help_center.HelpCenterPresenter;
import com.avito.android.help_center.HelpCenterPresenterImpl;
import com.avito.android.help_center.HelpCenterPresenterImpl_Factory;
import com.avito.android.help_center.HelpCenterPresenterState;
import com.avito.android.help_center.HelpCenterUrlInterceptor;
import com.avito.android.help_center.HelpCenterUrlInterceptorImpl;
import com.avito.android.help_center.HelpCenterUrlInterceptorImpl_Factory;
import com.avito.android.help_center.HelpCenterUrlProvider;
import com.avito.android.help_center.HelpCenterUrlProviderImpl;
import com.avito.android.help_center.HelpCenterUrlProviderImpl_Factory;
import com.avito.android.help_center.di.HelpCenterComponent;
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
public final class DaggerHelpCenterComponent implements HelpCenterComponent {
    public final HelpCenterComponentDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<CookieManager> c = DoubleCheck.provider(HelpCenterModule_ProvideCookieManager$help_center_releaseFactory.create());
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
    public Provider<HelpCenterPresenterState> u;
    public Provider<HelpCenterPresenterImpl> v;
    public Provider<HelpCenterPresenter> w;

    public static final class b implements HelpCenterComponent.Builder {
        public HelpCenterComponentDependencies a;
        public String b;
        public HelpCenterPresenterState c;

        public b(a aVar) {
        }

        @Override // com.avito.android.help_center.di.HelpCenterComponent.Builder
        public HelpCenterComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HelpCenterComponentDependencies.class);
            return new DaggerHelpCenterComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.help_center.di.HelpCenterComponent.Builder
        public HelpCenterComponent.Builder dependencies(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = (HelpCenterComponentDependencies) Preconditions.checkNotNull(helpCenterComponentDependencies);
            return this;
        }

        @Override // com.avito.android.help_center.di.HelpCenterComponent.Builder
        public HelpCenterComponent.Builder state(HelpCenterPresenterState helpCenterPresenterState) {
            this.c = helpCenterPresenterState;
            return this;
        }

        @Override // com.avito.android.help_center.di.HelpCenterComponent.Builder
        public HelpCenterComponent.Builder url(String str) {
            this.b = str;
            return this;
        }
    }

    public static class c implements Provider<DateHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public c(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DateHeaderProvider get() {
            return (DateHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.dateHeaderProvider());
        }
    }

    public static class d implements Provider<DeviceIdHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public d(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceIdHeaderProvider get() {
            return (DeviceIdHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdHeaderProvider());
        }
    }

    public static class e implements Provider<Features> {
        public final HelpCenterComponentDependencies a;

        public e(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<GeoHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public f(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoHeaderProvider get() {
            return (GeoHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.geoHeaderProvider());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final HelpCenterComponentDependencies a;

        public g(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<ServerTimeSource> {
        public final HelpCenterComponentDependencies a;

        public h(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public static class i implements Provider<SessionHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public i(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionHeaderProvider get() {
            return (SessionHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.sessionHeaderProvider());
        }
    }

    public static class j implements Provider<SupportFeaturesHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public j(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SupportFeaturesHeaderProvider get() {
            return (SupportFeaturesHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.supportFeaturesHeaderProvider());
        }
    }

    public static class k implements Provider<UserAgentHeaderProvider> {
        public final HelpCenterComponentDependencies a;

        public k(HelpCenterComponentDependencies helpCenterComponentDependencies) {
            this.a = helpCenterComponentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentHeaderProvider get() {
            return (UserAgentHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentHeaderProvider());
        }
    }

    public DaggerHelpCenterComponent(HelpCenterComponentDependencies helpCenterComponentDependencies, String str, HelpCenterPresenterState helpCenterPresenterState, a aVar) {
        this.a = helpCenterComponentDependencies;
        this.b = new g(helpCenterComponentDependencies);
        this.d = new f(helpCenterComponentDependencies);
        this.e = new i(helpCenterComponentDependencies);
        this.f = new c(helpCenterComponentDependencies);
        this.g = new d(helpCenterComponentDependencies);
        this.h = new j(helpCenterComponentDependencies);
        this.i = new k(helpCenterComponentDependencies);
        h hVar = new h(helpCenterComponentDependencies);
        this.j = hVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(hVar);
        this.k = create;
        Provider<CookieExpiredTime> provider = SingleCheck.provider(create);
        this.l = provider;
        this.m = SingleCheck.provider(CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory.create(this.d, this.e, this.f, this.g, this.h, this.i, provider));
        this.n = DoubleCheck.provider(HelpCenterJSInterfaceImpl_Factory.create());
        e eVar = new e(helpCenterComponentDependencies);
        this.o = eVar;
        HelpCenterUrlProviderImpl_Factory create2 = HelpCenterUrlProviderImpl_Factory.create(eVar);
        this.p = create2;
        Provider<HelpCenterUrlProvider> provider2 = DoubleCheck.provider(create2);
        this.q = provider2;
        HelpCenterUrlInterceptorImpl_Factory create3 = HelpCenterUrlInterceptorImpl_Factory.create(provider2);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = InstanceFactory.createNullable(str);
        Factory createNullable = InstanceFactory.createNullable(helpCenterPresenterState);
        this.u = createNullable;
        HelpCenterPresenterImpl_Factory create4 = HelpCenterPresenterImpl_Factory.create(this.b, this.c, this.m, this.n, this.s, this.q, this.t, createNullable);
        this.v = create4;
        this.w = DoubleCheck.provider(create4);
    }

    public static HelpCenterComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.help_center.di.HelpCenterComponent
    public void inject(HelpCenterFragment helpCenterFragment) {
        HelpCenterFragment_MembersInjector.injectPresenter(helpCenterFragment, this.w.get());
        HelpCenterFragment_MembersInjector.injectImplicitIntentFactory(helpCenterFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        HelpCenterFragment_MembersInjector.injectDeeplinkIntentFactory(helpCenterFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        HelpCenterFragment_MembersInjector.injectDeeplinkFactory(helpCenterFragment, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkFactory()));
        HelpCenterFragment_MembersInjector.injectAnalytics(helpCenterFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
