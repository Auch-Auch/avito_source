package com.avito.android.autodeal_details.di;

import android.webkit.CookieManager;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.autodeal_details.AutoDealDetailsActivity;
import com.avito.android.autodeal_details.AutoDealDetailsActivity_MembersInjector;
import com.avito.android.autodeal_details.AutoDealDetailsInterceptor;
import com.avito.android.autodeal_details.AutoDealDetailsInterceptorImpl_Factory;
import com.avito.android.autodeal_details.AutoDealDetailsJSInterface;
import com.avito.android.autodeal_details.AutoDealDetailsJSInterfaceImpl_Factory;
import com.avito.android.autodeal_details.AutoDealDetailsViewModel;
import com.avito.android.autodeal_details.AutoDealDetailsViewModelFactory;
import com.avito.android.autodeal_details.AutoDealDetailsViewModelFactory_Factory;
import com.avito.android.autodeal_details.di.AutoDealDetailsComponent;
import com.avito.android.cookie_provider.CookieExpiredTime;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl;
import com.avito.android.cookie_provider.CookieExpiredTimeImpl_Factory;
import com.avito.android.cookie_provider.CookieProvider;
import com.avito.android.cookie_provider.di.CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory;
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
public final class DaggerAutoDealDetailsComponent implements AutoDealDetailsComponent {
    public final AutoDealDetailsDependencies a;
    public Provider<String> b;
    public Provider<AutoDealDetailsJSInterface> c = DoubleCheck.provider(AutoDealDetailsJSInterfaceImpl_Factory.create());
    public Provider<SchedulersFactory> d;
    public Provider<GeoHeaderProvider> e;
    public Provider<SessionHeaderProvider> f;
    public Provider<DateHeaderProvider> g;
    public Provider<DeviceIdHeaderProvider> h;
    public Provider<SupportFeaturesHeaderProvider> i;
    public Provider<UserAgentHeaderProvider> j;
    public Provider<ServerTimeSource> k;
    public Provider<CookieExpiredTimeImpl> l;
    public Provider<CookieExpiredTime> m;
    public Provider<CookieProvider> n;
    public Provider<CookieManager> o;
    public Provider<AutoDealDetailsViewModelFactory> p;
    public Provider<ViewModelProvider.Factory> q;
    public Provider<FragmentActivity> r;
    public Provider<AutoDealDetailsViewModel> s;
    public Provider<AutoDealDetailsInterceptor> t;

    public static final class b implements AutoDealDetailsComponent.Builder {
        public AutoDealDetailsDependencies a;
        public FragmentActivity b;
        public String c;

        public b(a aVar) {
        }

        @Override // com.avito.android.autodeal_details.di.AutoDealDetailsComponent.Builder
        public AutoDealDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AutoDealDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, FragmentActivity.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            return new DaggerAutoDealDetailsComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.autodeal_details.di.AutoDealDetailsComponent.Builder
        public AutoDealDetailsComponent.Builder dependentOn(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = (AutoDealDetailsDependencies) Preconditions.checkNotNull(autoDealDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.autodeal_details.di.AutoDealDetailsComponent.Builder
        public AutoDealDetailsComponent.Builder withFragmentActivity(FragmentActivity fragmentActivity) {
            this.b = (FragmentActivity) Preconditions.checkNotNull(fragmentActivity);
            return this;
        }

        @Override // com.avito.android.autodeal_details.di.AutoDealDetailsComponent.Builder
        public AutoDealDetailsComponent.Builder withUrl(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    public static class c implements Provider<DateHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public c(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DateHeaderProvider get() {
            return (DateHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.dateHeaderProvider());
        }
    }

    public static class d implements Provider<DeviceIdHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public d(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceIdHeaderProvider get() {
            return (DeviceIdHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.deviceIdHeaderProvider());
        }
    }

    public static class e implements Provider<GeoHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public e(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public GeoHeaderProvider get() {
            return (GeoHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.geoHeaderProvider());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final AutoDealDetailsDependencies a;

        public f(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class g implements Provider<ServerTimeSource> {
        public final AutoDealDetailsDependencies a;

        public g(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServerTimeSource get() {
            return (ServerTimeSource) Preconditions.checkNotNullFromComponent(this.a.serverTimeSource());
        }
    }

    public static class h implements Provider<SessionHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public h(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SessionHeaderProvider get() {
            return (SessionHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.sessionHeaderProvider());
        }
    }

    public static class i implements Provider<SupportFeaturesHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public i(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SupportFeaturesHeaderProvider get() {
            return (SupportFeaturesHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.supportFeaturesHeaderProvider());
        }
    }

    public static class j implements Provider<UserAgentHeaderProvider> {
        public final AutoDealDetailsDependencies a;

        public j(AutoDealDetailsDependencies autoDealDetailsDependencies) {
            this.a = autoDealDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentHeaderProvider get() {
            return (UserAgentHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentHeaderProvider());
        }
    }

    public DaggerAutoDealDetailsComponent(AutoDealDetailsDependencies autoDealDetailsDependencies, FragmentActivity fragmentActivity, String str, a aVar) {
        this.a = autoDealDetailsDependencies;
        this.b = InstanceFactory.create(str);
        this.d = new f(autoDealDetailsDependencies);
        this.e = new e(autoDealDetailsDependencies);
        this.f = new h(autoDealDetailsDependencies);
        this.g = new c(autoDealDetailsDependencies);
        this.h = new d(autoDealDetailsDependencies);
        this.i = new i(autoDealDetailsDependencies);
        this.j = new j(autoDealDetailsDependencies);
        g gVar = new g(autoDealDetailsDependencies);
        this.k = gVar;
        CookieExpiredTimeImpl_Factory create = CookieExpiredTimeImpl_Factory.create(gVar);
        this.l = create;
        Provider<CookieExpiredTime> provider = SingleCheck.provider(create);
        this.m = provider;
        this.n = SingleCheck.provider(CookieProviderModule_ProvideCookieProvider$cookie_provider_releaseFactory.create(this.e, this.f, this.g, this.h, this.i, this.j, provider));
        Provider<CookieManager> provider2 = DoubleCheck.provider(AutoDealDetailsModule_ProvideCookieManagerFactory.create());
        this.o = provider2;
        AutoDealDetailsViewModelFactory_Factory create2 = AutoDealDetailsViewModelFactory_Factory.create(this.b, this.c, this.d, this.n, provider2);
        this.p = create2;
        this.q = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(fragmentActivity);
        this.r = create3;
        this.s = DoubleCheck.provider(AutoDealDetailsModule_ProvideAutoDealDetailsViewModelFactory.create(this.q, create3));
        this.t = DoubleCheck.provider(AutoDealDetailsInterceptorImpl_Factory.create());
    }

    public static AutoDealDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.autodeal_details.di.AutoDealDetailsComponent
    public void inject(AutoDealDetailsActivity autoDealDetailsActivity) {
        AutoDealDetailsActivity_MembersInjector.injectViewModel(autoDealDetailsActivity, this.s.get());
        AutoDealDetailsActivity_MembersInjector.injectAnalytics(autoDealDetailsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AutoDealDetailsActivity_MembersInjector.injectSchedulers(autoDealDetailsActivity, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
        AutoDealDetailsActivity_MembersInjector.injectJsInterface(autoDealDetailsActivity, this.c.get());
        AutoDealDetailsActivity_MembersInjector.injectAutoDealDetailsInterceptor(autoDealDetailsActivity, this.t.get());
        AutoDealDetailsActivity_MembersInjector.injectImplicitIntentFactory(autoDealDetailsActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
    }
}
