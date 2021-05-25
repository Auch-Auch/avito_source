package com.avito.android.publish.new_advert.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper;
import com.avito.android.publish.analytics.PublishEventTrackerImpl;
import com.avito.android.publish.analytics.PublishEventTrackerImpl_Factory;
import com.avito.android.publish.di.NewAdvertDependencies;
import com.avito.android.publish.di.PublishAnalyticModule_ProvideAnalyticsSerializerFactory;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.new_advert.NewAdvertFragment;
import com.avito.android.publish.new_advert.NewAdvertFragment_MembersInjector;
import com.avito.android.publish.new_advert.NewAdvertPresenter;
import com.avito.android.publish.new_advert.di.NewAdvertComponent;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class DaggerNewAdvertComponent implements NewAdvertComponent {
    public final NewAdvertDependencies a;
    public Provider<AccountStateProvider> b;
    public Provider<AddAdvertInteractor> c;
    public Provider<PublishAnalyticsDataProvider> d;
    public Provider<SchedulersFactory3> e;
    public Provider<Analytics> f;
    public Provider<CurrentUserIdProvider> g;
    public Provider<PublishEventTrackerImpl> h;
    public Provider<FloatingAddAdvertAnalyticsWrapper> i;
    public Provider<PublishDraftAvailabilityChecker> j;
    public Provider<PublishDraftWiper> k;
    public Provider<SchedulersFactory> l;
    public Provider<BuildInfo> m;
    public Provider<PublishSessionIdGenerator> n;
    public Provider<NewAdvertPresenter> o;

    public static final class b implements NewAdvertComponent.Builder {
        public NewAdvertDependencies a;
        public NewAdvertModule b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.new_advert.di.NewAdvertComponent.Builder
        public NewAdvertComponent build() {
            Preconditions.checkBuilderRequirement(this.a, NewAdvertDependencies.class);
            if (this.b == null) {
                this.b = new NewAdvertModule();
            }
            return new DaggerNewAdvertComponent(this.b, this.a, null);
        }

        @Override // com.avito.android.publish.new_advert.di.NewAdvertComponent.Builder
        public NewAdvertComponent.Builder newAdvertDependencies(NewAdvertDependencies newAdvertDependencies) {
            this.a = (NewAdvertDependencies) Preconditions.checkNotNull(newAdvertDependencies);
            return this;
        }

        @Override // com.avito.android.publish.new_advert.di.NewAdvertComponent.Builder
        public NewAdvertComponent.Builder newAdvertModule(NewAdvertModule newAdvertModule) {
            this.b = (NewAdvertModule) Preconditions.checkNotNull(newAdvertModule);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final NewAdvertDependencies a;

        public c(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<AddAdvertInteractor> {
        public final NewAdvertDependencies a;

        public d(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AddAdvertInteractor get() {
            return (AddAdvertInteractor) Preconditions.checkNotNullFromComponent(this.a.addAdvertInteractor());
        }
    }

    public static class e implements Provider<Analytics> {
        public final NewAdvertDependencies a;

        public e(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<PublishAnalyticsDataProvider> {
        public final NewAdvertDependencies a;

        public f(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.analyticsDataProvider());
        }
    }

    public static class g implements Provider<BuildInfo> {
        public final NewAdvertDependencies a;

        public g(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class h implements Provider<CurrentUserIdProvider> {
        public final NewAdvertDependencies a;

        public h(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CurrentUserIdProvider get() {
            return (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserIdProvider());
        }
    }

    public static class i implements Provider<PublishDraftAvailabilityChecker> {
        public final NewAdvertDependencies a;

        public i(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftAvailabilityChecker get() {
            return (PublishDraftAvailabilityChecker) Preconditions.checkNotNullFromComponent(this.a.publishDraftAvailabilityChecker());
        }
    }

    public static class j implements Provider<PublishDraftWiper> {
        public final NewAdvertDependencies a;

        public j(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class k implements Provider<SchedulersFactory3> {
        public final NewAdvertDependencies a;

        public k(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class l implements Provider<SchedulersFactory> {
        public final NewAdvertDependencies a;

        public l(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class m implements Provider<PublishSessionIdGenerator> {
        public final NewAdvertDependencies a;

        public m(NewAdvertDependencies newAdvertDependencies) {
            this.a = newAdvertDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishSessionIdGenerator get() {
            return (PublishSessionIdGenerator) Preconditions.checkNotNullFromComponent(this.a.sessionGenerator());
        }
    }

    public DaggerNewAdvertComponent(NewAdvertModule newAdvertModule, NewAdvertDependencies newAdvertDependencies, a aVar) {
        this.a = newAdvertDependencies;
        this.b = new c(newAdvertDependencies);
        this.c = new d(newAdvertDependencies);
        f fVar = new f(newAdvertDependencies);
        this.d = fVar;
        this.e = new k(newAdvertDependencies);
        e eVar = new e(newAdvertDependencies);
        this.f = eVar;
        h hVar = new h(newAdvertDependencies);
        this.g = hVar;
        PublishEventTrackerImpl_Factory create = PublishEventTrackerImpl_Factory.create(eVar, fVar, hVar, PublishAnalyticModule_ProvideAnalyticsSerializerFactory.create());
        this.h = create;
        this.i = DoubleCheck.provider(NewAdvertModule_ProvideFloatingAddAdvertAnalyticsWrapperFactory.create(newAdvertModule, this.b, this.c, this.d, this.e, create, this.f));
        i iVar = new i(newAdvertDependencies);
        this.j = iVar;
        j jVar = new j(newAdvertDependencies);
        this.k = jVar;
        l lVar = new l(newAdvertDependencies);
        this.l = lVar;
        g gVar = new g(newAdvertDependencies);
        this.m = gVar;
        m mVar = new m(newAdvertDependencies);
        this.n = mVar;
        this.o = DoubleCheck.provider(NewAdvertModule_ProvideNewAdvertPresenterFactory.create(newAdvertModule, iVar, jVar, lVar, gVar, this.d, mVar));
    }

    public static NewAdvertComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.new_advert.di.NewAdvertComponent
    public void inject(NewAdvertFragment newAdvertFragment) {
        NewAdvertFragment_MembersInjector.injectDeepLinkIntentFactory(newAdvertFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        NewAdvertFragment_MembersInjector.injectFloatingAddAdvertWrapper(newAdvertFragment, this.i.get());
        NewAdvertFragment_MembersInjector.injectIntentFactory(newAdvertFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        NewAdvertFragment_MembersInjector.injectPresenter(newAdvertFragment, this.o.get());
        NewAdvertFragment_MembersInjector.injectSchedulers(newAdvertFragment, (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()));
    }
}
