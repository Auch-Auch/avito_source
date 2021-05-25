package com.avito.android.service_subscription.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.service_subscription.ServiceSubscriptionInteractor;
import com.avito.android.service_subscription.di.SubscriptionFragmentComponent;
import com.avito.android.service_subscription.lf_packages.LfPackagesFragment;
import com.avito.android.service_subscription.lf_packages.LfPackagesFragment_MembersInjector;
import com.avito.android.service_subscription.lf_packages.LfPackagesInteractorImpl;
import com.avito.android.service_subscription.lf_packages.LfPackagesInteractorImpl_Factory;
import com.avito.android.service_subscription.remote.ServiceSubscriptionApi;
import com.avito.android.service_subscription.subscription_new.ColorParser;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionFragment;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionFragment_MembersInjector;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionInteractorImpl;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionInteractorImpl_Factory;
import com.avito.android.service_subscription.subscription_new.ServiceSubscriptionPresenter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerSubscriptionFragmentComponent implements SubscriptionFragmentComponent {
    public final SubscriptionFragmentDependencies a;
    public Provider<ServiceSubscriptionApi> b;
    public Provider<TypedErrorThrowableConverter> c;
    public Provider<SchedulersFactory> d;
    public Provider<Features> e;
    public Provider<ServiceSubscriptionInteractorImpl> f;
    public Provider<ServiceSubscriptionInteractor> g;
    public Provider<Context> h;
    public Provider<ColorParser> i;
    public Provider<Kundle> j;
    public Provider<ServiceSubscriptionPresenter> k;
    public Provider<LfPackagesInteractorImpl> l;
    public Provider<ServiceSubscriptionInteractor> m;
    public Provider<ServiceSubscriptionPresenter> n;

    public static final class b implements SubscriptionFragmentComponent.Builder {
        public SubscriptionFragmentDependencies a;
        public Resources b;
        public Kundle c;
        public Context d;

        public b(a aVar) {
        }

        @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent.Builder
        public SubscriptionFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SubscriptionFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, Context.class);
            return new DaggerSubscriptionFragmentComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent.Builder
        public SubscriptionFragmentComponent.Builder dependentOn(SubscriptionFragmentDependencies subscriptionFragmentDependencies) {
            this.a = (SubscriptionFragmentDependencies) Preconditions.checkNotNull(subscriptionFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent.Builder
        public SubscriptionFragmentComponent.Builder withContext(Context context) {
            this.d = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent.Builder
        public SubscriptionFragmentComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent.Builder
        public SubscriptionFragmentComponent.Builder withState(Kundle kundle) {
            this.c = kundle;
            return this;
        }
    }

    public static class c implements Provider<Features> {
        public final SubscriptionFragmentDependencies a;

        public c(SubscriptionFragmentDependencies subscriptionFragmentDependencies) {
            this.a = subscriptionFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final SubscriptionFragmentDependencies a;

        public d(SubscriptionFragmentDependencies subscriptionFragmentDependencies) {
            this.a = subscriptionFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<ServiceSubscriptionApi> {
        public final SubscriptionFragmentDependencies a;

        public e(SubscriptionFragmentDependencies subscriptionFragmentDependencies) {
            this.a = subscriptionFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ServiceSubscriptionApi get() {
            return (ServiceSubscriptionApi) Preconditions.checkNotNullFromComponent(this.a.serviceSubscriptionApi());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final SubscriptionFragmentDependencies a;

        public f(SubscriptionFragmentDependencies subscriptionFragmentDependencies) {
            this.a = subscriptionFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerSubscriptionFragmentComponent(SubscriptionFragmentDependencies subscriptionFragmentDependencies, Resources resources, Kundle kundle, Context context, a aVar) {
        this.a = subscriptionFragmentDependencies;
        e eVar = new e(subscriptionFragmentDependencies);
        this.b = eVar;
        f fVar = new f(subscriptionFragmentDependencies);
        this.c = fVar;
        d dVar = new d(subscriptionFragmentDependencies);
        this.d = dVar;
        c cVar = new c(subscriptionFragmentDependencies);
        this.e = cVar;
        ServiceSubscriptionInteractorImpl_Factory create = ServiceSubscriptionInteractorImpl_Factory.create(eVar, fVar, dVar, cVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(context);
        this.h = create2;
        this.i = DoubleCheck.provider(SubscriptionFragmentModule_ProvideColorParserFactory.create(create2));
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.j = createNullable;
        this.k = DoubleCheck.provider(SubscriptionFragmentModule_ProvideSubscriptionPresenterFactory.create(this.g, this.d, this.i, createNullable));
        LfPackagesInteractorImpl_Factory create3 = LfPackagesInteractorImpl_Factory.create(this.b, this.c, this.d);
        this.l = create3;
        Provider<ServiceSubscriptionInteractor> provider = DoubleCheck.provider(create3);
        this.m = provider;
        this.n = DoubleCheck.provider(SubscriptionFragmentModule_ProvideLfPackagesPresenterFactory.create(provider, this.d, this.i, this.j));
    }

    public static SubscriptionFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent
    public void inject(ServiceSubscriptionFragment serviceSubscriptionFragment) {
        ServiceSubscriptionFragment_MembersInjector.injectPresenter(serviceSubscriptionFragment, this.k.get());
        ServiceSubscriptionFragment_MembersInjector.injectAnalytics(serviceSubscriptionFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }

    @Override // com.avito.android.service_subscription.di.SubscriptionFragmentComponent
    public void inject(LfPackagesFragment lfPackagesFragment) {
        LfPackagesFragment_MembersInjector.injectPresenter(lfPackagesFragment, this.n.get());
        LfPackagesFragment_MembersInjector.injectAnalytics(lfPackagesFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
    }
}
