package com.avito.android.certificate_pinning.di;

import com.avito.android.Features;
import com.avito.android.certificate_pinning.UnsafeNetworkActivity;
import com.avito.android.certificate_pinning.UnsafeNetworkActivity_MembersInjector;
import com.avito.android.certificate_pinning.UnsafeNetworkInteractor;
import com.avito.android.certificate_pinning.UnsafeNetworkInteractorImpl;
import com.avito.android.certificate_pinning.UnsafeNetworkInteractorImpl_Factory;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenter;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenterImpl;
import com.avito.android.certificate_pinning.UnsafeNetworkPresenterImpl_Factory;
import com.avito.android.certificate_pinning.di.UnsafeNetworkComponent;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.remote.interceptor.UserAgentInterceptor;
import com.avito.android.remote.interceptor.UserAgentInterceptor_Factory;
import com.avito.android.session_refresh.RequestParamsInterceptorImpl;
import com.avito.android.session_refresh.RequestParamsInterceptorImpl_Factory;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import java.util.Set;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
public final class DaggerUnsafeNetworkComponent implements UnsafeNetworkComponent {
    public final UnsafeNetworkDependencies a;
    public Provider<Features> b;
    public Provider<CertificatePinningInterceptor> c;
    public Provider<Interceptor> d;
    public Provider<BuildInfo> e;
    public Provider<RequestParamsInterceptorImpl> f;
    public Provider<Interceptor> g;
    public Provider<UserAgentHeaderProvider> h;
    public Provider<UserAgentInterceptor> i;
    public Provider<Interceptor> j;
    public Provider<Set<Interceptor>> k;
    public Provider<SchedulersFactory> l;
    public Provider<OkHttpClient> m;
    public Provider<UnsafeNetworkInteractorImpl> n;
    public Provider<UnsafeNetworkInteractor> o;
    public Provider<Kundle> p;
    public Provider<UnsafeNetworkPresenterImpl> q;
    public Provider<UnsafeNetworkPresenter> r;

    public static final class b implements UnsafeNetworkComponent.Builder {
        public UnsafeNetworkDependencies a;
        public Kundle b;
        public Boolean c;

        public b(a aVar) {
        }

        @Override // com.avito.android.certificate_pinning.di.UnsafeNetworkComponent.Builder
        public UnsafeNetworkComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UnsafeNetworkDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Boolean.class);
            return new DaggerUnsafeNetworkComponent(this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.certificate_pinning.di.UnsafeNetworkComponent.Builder
        public UnsafeNetworkComponent.Builder dependentOn(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = (UnsafeNetworkDependencies) Preconditions.checkNotNull(unsafeNetworkDependencies);
            return this;
        }

        @Override // com.avito.android.certificate_pinning.di.UnsafeNetworkComponent.Builder
        public UnsafeNetworkComponent.Builder withPresenterState(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.certificate_pinning.di.UnsafeNetworkComponent.Builder
        public UnsafeNetworkComponent.Builder withShowErrorScreen(boolean z) {
            this.c = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public static class c implements Provider<BuildInfo> {
        public final UnsafeNetworkDependencies a;

        public c(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class d implements Provider<CertificatePinningInterceptor> {
        public final UnsafeNetworkDependencies a;

        public d(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CertificatePinningInterceptor get() {
            return (CertificatePinningInterceptor) Preconditions.checkNotNullFromComponent(this.a.certificatePinningInterceptor());
        }
    }

    public static class e implements Provider<Features> {
        public final UnsafeNetworkDependencies a;

        public e(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<OkHttpClient> {
        public final UnsafeNetworkDependencies a;

        public f(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public OkHttpClient get() {
            return (OkHttpClient) Preconditions.checkNotNullFromComponent(this.a.okHttpClient());
        }
    }

    public static class g implements Provider<SchedulersFactory> {
        public final UnsafeNetworkDependencies a;

        public g(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class h implements Provider<UserAgentHeaderProvider> {
        public final UnsafeNetworkDependencies a;

        public h(UnsafeNetworkDependencies unsafeNetworkDependencies) {
            this.a = unsafeNetworkDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAgentHeaderProvider get() {
            return (UserAgentHeaderProvider) Preconditions.checkNotNullFromComponent(this.a.userAgentHeaderProvider());
        }
    }

    public DaggerUnsafeNetworkComponent(UnsafeNetworkDependencies unsafeNetworkDependencies, Kundle kundle, Boolean bool, a aVar) {
        this.a = unsafeNetworkDependencies;
        this.b = new e(unsafeNetworkDependencies);
        d dVar = new d(unsafeNetworkDependencies);
        this.c = dVar;
        this.d = DoubleCheck.provider(dVar);
        c cVar = new c(unsafeNetworkDependencies);
        this.e = cVar;
        RequestParamsInterceptorImpl_Factory create = RequestParamsInterceptorImpl_Factory.create(cVar, this.b);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        h hVar = new h(unsafeNetworkDependencies);
        this.h = hVar;
        UserAgentInterceptor_Factory create2 = UserAgentInterceptor_Factory.create(hVar);
        this.i = create2;
        this.j = DoubleCheck.provider(create2);
        SetFactory build = SetFactory.builder(3, 0).addProvider(this.d).addProvider(this.g).addProvider(this.j).build();
        this.k = build;
        g gVar = new g(unsafeNetworkDependencies);
        this.l = gVar;
        f fVar = new f(unsafeNetworkDependencies);
        this.m = fVar;
        UnsafeNetworkInteractorImpl_Factory create3 = UnsafeNetworkInteractorImpl_Factory.create(this.b, build, gVar, fVar);
        this.n = create3;
        this.o = DoubleCheck.provider(create3);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.p = createNullable;
        UnsafeNetworkPresenterImpl_Factory create4 = UnsafeNetworkPresenterImpl_Factory.create(this.o, this.l, createNullable);
        this.q = create4;
        this.r = DoubleCheck.provider(create4);
    }

    public static UnsafeNetworkComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.certificate_pinning.di.UnsafeNetworkComponent
    public void inject(UnsafeNetworkActivity unsafeNetworkActivity) {
        UnsafeNetworkActivity_MembersInjector.injectIntentFactory(unsafeNetworkActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        UnsafeNetworkActivity_MembersInjector.injectPresenter(unsafeNetworkActivity, this.r.get());
    }
}
