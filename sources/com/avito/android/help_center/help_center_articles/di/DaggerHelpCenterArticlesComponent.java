package com.avito.android.help_center.help_center_articles.di;

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
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivity_MembersInjector;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenter;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenterImpl;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesPresenterImpl_Factory;
import com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent;
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
public final class DaggerHelpCenterArticlesComponent implements HelpCenterArticlesComponent {
    public final HelpCenterArticlesDependencies a;
    public Provider<SchedulersFactory> b;
    public Provider<CookieManager> c = DoubleCheck.provider(HelpCenterArticlesModule_ProvideCookieManager$help_center_releaseFactory.create());
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
    public Provider<String> w;
    public Provider<HelpCenterArticlesPresenterImpl> x;
    public Provider<HelpCenterArticlesPresenter> y;

    public static final class b implements HelpCenterArticlesComponent.Builder {
        public HelpCenterArticlesDependencies a;
        public String b;
        public String c;
        public String d;
        public String e;

        public b(a aVar) {
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent.Builder advertisementId(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent.Builder articleId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent build() {
            Preconditions.checkBuilderRequirement(this.a, HelpCenterArticlesDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            return new DaggerHelpCenterArticlesComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent.Builder contextId(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent.Builder dependencies(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = (HelpCenterArticlesDependencies) Preconditions.checkNotNull(helpCenterArticlesDependencies);
            return this;
        }

        @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent.Builder
        public HelpCenterArticlesComponent.Builder theme(String str) {
            this.c = str;
            return this;
        }
    }

    public static class c implements Provider<DateHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public c(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DateHeaderProvider get() {
            return (DateHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.dateHeaderProvider());
        }
    }

    public static class d implements Provider<DeviceIdHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public d(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceIdHeaderProvider get() {
            return (DeviceIdHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdHeaderProvider());
        }
    }

    public static class e implements Provider<Features> {
        public final HelpCenterArticlesDependencies a;

        public e(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<GeoHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public f(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoHeaderProvider get() {
            return (GeoHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.geoHeaderProvider());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final HelpCenterArticlesDependencies a;

        public g(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<ServerTimeSource> {
        public final HelpCenterArticlesDependencies a;

        public h(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public static class i implements Provider<SessionHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public i(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionHeaderProvider get() {
            return (SessionHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.sessionHeaderProvider());
        }
    }

    public static class j implements Provider<SupportFeaturesHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public j(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SupportFeaturesHeaderProvider get() {
            return (SupportFeaturesHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.supportFeaturesHeaderProvider());
        }
    }

    public static class k implements Provider<UserAgentHeaderProvider> {
        public final HelpCenterArticlesDependencies a;

        public k(HelpCenterArticlesDependencies helpCenterArticlesDependencies) {
            this.a = helpCenterArticlesDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentHeaderProvider get() {
            return (UserAgentHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentHeaderProvider());
        }
    }

    public DaggerHelpCenterArticlesComponent(HelpCenterArticlesDependencies helpCenterArticlesDependencies, String str, String str2, String str3, String str4, a aVar) {
        this.a = helpCenterArticlesDependencies;
        this.b = new g(helpCenterArticlesDependencies);
        this.d = new f(helpCenterArticlesDependencies);
        this.e = new i(helpCenterArticlesDependencies);
        this.f = new c(helpCenterArticlesDependencies);
        this.g = new d(helpCenterArticlesDependencies);
        this.h = new j(helpCenterArticlesDependencies);
        this.i = new k(helpCenterArticlesDependencies);
        h hVar = new h(helpCenterArticlesDependencies);
        this.j = hVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(hVar);
        this.k = create;
        Provider<CookieExpiredTime> provider = SingleCheck.provider(create);
        this.l = provider;
        this.m = SingleCheck.provider(CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory.create(this.d, this.e, this.f, this.g, this.h, this.i, provider));
        this.n = DoubleCheck.provider(HelpCenterJSInterfaceImpl_Factory.create());
        e eVar = new e(helpCenterArticlesDependencies);
        this.o = eVar;
        HelpCenterUrlProviderImpl_Factory create2 = HelpCenterUrlProviderImpl_Factory.create(eVar);
        this.p = create2;
        Provider<HelpCenterUrlProvider> provider2 = DoubleCheck.provider(create2);
        this.q = provider2;
        HelpCenterUrlInterceptorImpl_Factory create3 = HelpCenterUrlInterceptorImpl_Factory.create(provider2);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = InstanceFactory.create(str);
        this.u = InstanceFactory.createNullable(str2);
        this.v = InstanceFactory.createNullable(str3);
        Factory createNullable = InstanceFactory.createNullable(str4);
        this.w = createNullable;
        HelpCenterArticlesPresenterImpl_Factory create4 = HelpCenterArticlesPresenterImpl_Factory.create(this.b, this.c, this.m, this.n, this.q, this.s, this.t, this.u, this.v, createNullable);
        this.x = create4;
        this.y = DoubleCheck.provider(create4);
    }

    public static HelpCenterArticlesComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.help_center.help_center_articles.di.HelpCenterArticlesComponent
    public void inject(HelpCenterArticlesActivity helpCenterArticlesActivity) {
        HelpCenterArticlesActivity_MembersInjector.injectPresenter(helpCenterArticlesActivity, this.y.get());
        HelpCenterArticlesActivity_MembersInjector.injectImplicitIntentFactory(helpCenterArticlesActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        HelpCenterArticlesActivity_MembersInjector.injectAnalytics(helpCenterArticlesActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
