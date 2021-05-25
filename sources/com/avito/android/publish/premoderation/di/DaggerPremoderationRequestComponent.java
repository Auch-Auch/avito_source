package com.avito.android.publish.premoderation.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.premoderation.AdvertProactiveModerationInteractor;
import com.avito.android.publish.premoderation.PremoderationRequestFragment;
import com.avito.android.publish.premoderation.PremoderationRequestFragment_MembersInjector;
import com.avito.android.publish.premoderation.PremoderationRequestViewModelFactory;
import com.avito.android.publish.premoderation.di.PremoderationRequestComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerPremoderationRequestComponent implements PremoderationRequestComponent {
    public final PublishComponent a;
    public Provider<PublishApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<CategoryParametersConverter> d;
    public Provider<PublishAnalyticsDataProvider> e;
    public Provider<AdvertProactiveModerationInteractor> f;
    public Provider<Features> g;
    public Provider<PremoderationRequestViewModelFactory> h;
    public Provider<ProgressDialogRouter> i;
    public Provider<Analytics> j;
    public Provider<LoadingProgressOverlay> k;

    public static final class b implements PremoderationRequestComponent.Builder {
        public PublishComponent a;
        public PremoderationRequestModule b;
        public AdvertProactiveModerationModule c;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.premoderation.di.PremoderationRequestComponent.Builder
        public PremoderationRequestComponent.Builder advertProactiveModerationModule(AdvertProactiveModerationModule advertProactiveModerationModule) {
            this.c = (AdvertProactiveModerationModule) Preconditions.checkNotNull(advertProactiveModerationModule);
            return this;
        }

        @Override // com.avito.android.publish.premoderation.di.PremoderationRequestComponent.Builder
        public PremoderationRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            if (this.b == null) {
                this.b = new PremoderationRequestModule();
            }
            if (this.c == null) {
                this.c = new AdvertProactiveModerationModule();
            }
            return new DaggerPremoderationRequestComponent(this.b, this.c, new LoadingProgressOverlayModule(), this.a, null);
        }

        @Override // com.avito.android.publish.premoderation.di.PremoderationRequestComponent.Builder
        public PremoderationRequestComponent.Builder premoderationRequestModule(PremoderationRequestModule premoderationRequestModule) {
            this.b = (PremoderationRequestModule) Preconditions.checkNotNull(premoderationRequestModule);
            return this;
        }

        @Override // com.avito.android.publish.premoderation.di.PremoderationRequestComponent.Builder
        public PremoderationRequestComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final PublishComponent a;

        public c(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<CategoryParametersConverter> {
        public final PublishComponent a;

        public d(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CategoryParametersConverter get() {
            return (CategoryParametersConverter) Preconditions.checkNotNullFromComponent(this.a.categoryParametersConverter());
        }
    }

    public static class e implements Provider<Features> {
        public final PublishComponent a;

        public e(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class f implements Provider<ProgressDialogRouter> {
        public final PublishComponent a;

        public f(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProgressDialogRouter get() {
            return (ProgressDialogRouter) Preconditions.checkNotNullFromComponent(this.a.progressDialogRouter());
        }
    }

    public static class g implements Provider<PublishAnalyticsDataProvider> {
        public final PublishComponent a;

        public g(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishAnalyticsDataProvider get() {
            return (PublishAnalyticsDataProvider) Preconditions.checkNotNullFromComponent(this.a.publishAnalyticsDataProvider());
        }
    }

    public static class h implements Provider<PublishApi> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishApi get() {
            return (PublishApi) Preconditions.checkNotNullFromComponent(this.a.publishApi());
        }
    }

    public static class i implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerPremoderationRequestComponent(PremoderationRequestModule premoderationRequestModule, AdvertProactiveModerationModule advertProactiveModerationModule, LoadingProgressOverlayModule loadingProgressOverlayModule, PublishComponent publishComponent, a aVar) {
        this.a = publishComponent;
        h hVar = new h(publishComponent);
        this.b = hVar;
        i iVar = new i(publishComponent);
        this.c = iVar;
        d dVar = new d(publishComponent);
        this.d = dVar;
        g gVar = new g(publishComponent);
        this.e = gVar;
        Provider<AdvertProactiveModerationInteractor> provider = SingleCheck.provider(AdvertProactiveModerationModule_ProviderAdvertProactiveModerationInteractorFactory.create(advertProactiveModerationModule, hVar, iVar, dVar, gVar));
        this.f = provider;
        e eVar = new e(publishComponent);
        this.g = eVar;
        this.h = DoubleCheck.provider(PremoderationRequestModule_ProvidePremoderationRequestViewModelFactoryFactory.create(premoderationRequestModule, provider, eVar, this.c));
        f fVar = new f(publishComponent);
        this.i = fVar;
        c cVar = new c(publishComponent);
        this.j = cVar;
        this.k = DoubleCheck.provider(LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory.create(loadingProgressOverlayModule, fVar, cVar));
    }

    public static PremoderationRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.premoderation.di.PremoderationRequestComponent
    public void inject(PremoderationRequestFragment premoderationRequestFragment) {
        PremoderationRequestFragment_MembersInjector.injectViewModelFactory(premoderationRequestFragment, this.h.get());
        PremoderationRequestFragment_MembersInjector.injectLoadingProgress(premoderationRequestFragment, this.k.get());
        PremoderationRequestFragment_MembersInjector.injectDeepLinkIntentFactory(premoderationRequestFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PremoderationRequestFragment_MembersInjector.injectActivityIntentFactory(premoderationRequestFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
