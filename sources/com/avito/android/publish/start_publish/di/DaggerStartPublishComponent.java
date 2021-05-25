package com.avito.android.publish.start_publish.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.publish.analytics.PublishEventTrackerImpl;
import com.avito.android.publish.di.PublishAnalyticModule_ProvideAnalyticsSerializerFactory;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.start_publish.StartPublishFragment;
import com.avito.android.publish.start_publish.StartPublishFragment_MembersInjector;
import com.avito.android.publish.start_publish.StartPublishInteractor;
import com.avito.android.publish.start_publish.StartPublishInteractorImpl;
import com.avito.android.publish.start_publish.StartPublishInteractorImpl_Factory;
import com.avito.android.publish.start_publish.StartPublishResourceProvider;
import com.avito.android.publish.start_publish.StartPublishResourceProviderImpl;
import com.avito.android.publish.start_publish.StartPublishResourceProviderImpl_Factory;
import com.avito.android.publish.start_publish.StartPublishViewModelFactory;
import com.avito.android.publish.start_publish.di.StartPublishComponent;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
public final class DaggerStartPublishComponent implements StartPublishComponent {
    public final StartPublishDependencies a;
    public Provider<SchedulersFactory3> b;
    public Provider<PublishDraftAvailabilityChecker> c;
    public Provider<PublishDraftWiper> d;
    public Provider<AddAdvertInteractor> e;
    public Provider<StartPublishInteractorImpl> f;
    public Provider<StartPublishInteractor> g;
    public Provider<Resources> h;
    public Provider<StartPublishResourceProviderImpl> i;
    public Provider<StartPublishResourceProvider> j;

    public static final class b implements StartPublishComponent.Builder {
        public StartPublishDependencies a;
        public Resources b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.start_publish.di.StartPublishComponent.Builder
        public StartPublishComponent build() {
            Preconditions.checkBuilderRequirement(this.a, StartPublishDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerStartPublishComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.publish.start_publish.di.StartPublishComponent.Builder
        public StartPublishComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.publish.start_publish.di.StartPublishComponent.Builder
        public StartPublishComponent.Builder startPublishDependencies(StartPublishDependencies startPublishDependencies) {
            this.a = (StartPublishDependencies) Preconditions.checkNotNull(startPublishDependencies);
            return this;
        }
    }

    public static class c implements Provider<AddAdvertInteractor> {
        public final StartPublishDependencies a;

        public c(StartPublishDependencies startPublishDependencies) {
            this.a = startPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AddAdvertInteractor get() {
            return (AddAdvertInteractor) Preconditions.checkNotNullFromComponent(this.a.addAdvertInteractor());
        }
    }

    public static class d implements Provider<PublishDraftAvailabilityChecker> {
        public final StartPublishDependencies a;

        public d(StartPublishDependencies startPublishDependencies) {
            this.a = startPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftAvailabilityChecker get() {
            return (PublishDraftAvailabilityChecker) Preconditions.checkNotNullFromComponent(this.a.publishDraftAvailabilityChecker());
        }
    }

    public static class e implements Provider<PublishDraftWiper> {
        public final StartPublishDependencies a;

        public e(StartPublishDependencies startPublishDependencies) {
            this.a = startPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishDraftWiper get() {
            return (PublishDraftWiper) Preconditions.checkNotNullFromComponent(this.a.publishDraftWiper());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final StartPublishDependencies a;

        public f(StartPublishDependencies startPublishDependencies) {
            this.a = startPublishDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerStartPublishComponent(StartPublishDependencies startPublishDependencies, Resources resources, a aVar) {
        this.a = startPublishDependencies;
        f fVar = new f(startPublishDependencies);
        this.b = fVar;
        d dVar = new d(startPublishDependencies);
        this.c = dVar;
        e eVar = new e(startPublishDependencies);
        this.d = eVar;
        c cVar = new c(startPublishDependencies);
        this.e = cVar;
        StartPublishInteractorImpl_Factory create = StartPublishInteractorImpl_Factory.create(fVar, dVar, eVar, cVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        StartPublishResourceProviderImpl_Factory create3 = StartPublishResourceProviderImpl_Factory.create(create2);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
    }

    public static StartPublishComponent.Builder builder() {
        return new b(null);
    }

    public final PublishEventTrackerImpl a() {
        return new PublishEventTrackerImpl((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()), (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserIdProvider()), PublishAnalyticModule_ProvideAnalyticsSerializerFactory.provideAnalyticsSerializer());
    }

    @Override // com.avito.android.publish.start_publish.di.StartPublishComponent
    public void inject(StartPublishFragment startPublishFragment) {
        StartPublishFragment_MembersInjector.injectViewModelFactory(startPublishFragment, new StartPublishViewModelFactory((AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), this.g.get(), (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider()), (PublishSessionIdGenerator) Preconditions.checkNotNullFromComponent(this.a.publishSessionIdGenerator()), this.j.get(), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), a()));
        StartPublishFragment_MembersInjector.injectIntentFactory(startPublishFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        StartPublishFragment_MembersInjector.injectDeepLinkIntentFactory(startPublishFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        StartPublishFragment_MembersInjector.injectAnalytics(startPublishFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        StartPublishFragment_MembersInjector.injectEventTracker(startPublishFragment, a());
    }
}
