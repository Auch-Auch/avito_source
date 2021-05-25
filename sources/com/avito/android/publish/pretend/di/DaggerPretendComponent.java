package com.avito.android.publish.pretend.di;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule;
import com.avito.android.progress_overlay.LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.pretend.PretendFragment;
import com.avito.android.publish.pretend.PretendFragment_MembersInjector;
import com.avito.android.publish.pretend.PretendInteractor;
import com.avito.android.publish.pretend.PretendInteractorImpl;
import com.avito.android.publish.pretend.PretendInteractorImpl_Factory;
import com.avito.android.publish.pretend.PretendViewModelFactory;
import com.avito.android.publish.pretend.di.PretendComponent;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validate_advert.remote.ValidateAdvertApi;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPretendComponent implements PretendComponent {
    public final PublishComponent a;
    public Provider<ProgressDialogRouter> b;
    public Provider<Analytics> c;
    public Provider<LoadingProgressOverlay> d;
    public Provider<ValidateAdvertApi> e;
    public Provider<SchedulersFactory> f;
    public Provider<CategoryParametersConverter> g;
    public Provider<PublishAnalyticsDataProvider> h;
    public Provider<Features> i;
    public Provider<PretendInteractorImpl> j;
    public Provider<PretendInteractor> k;

    public static final class b implements PretendComponent.Builder {
        public PublishComponent a;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.pretend.di.PretendComponent.Builder
        public PretendComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            return new DaggerPretendComponent(new LoadingProgressOverlayModule(), this.a, null);
        }

        @Override // com.avito.android.publish.pretend.di.PretendComponent.Builder
        public PretendComponent.Builder publishComponent(PublishComponent publishComponent) {
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

    public static class h implements Provider<SchedulersFactory> {
        public final PublishComponent a;

        public h(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<ValidateAdvertApi> {
        public final PublishComponent a;

        public i(PublishComponent publishComponent) {
            this.a = publishComponent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ValidateAdvertApi get() {
            return (ValidateAdvertApi) Preconditions.checkNotNullFromComponent(this.a.validateAdvertApi());
        }
    }

    public DaggerPretendComponent(LoadingProgressOverlayModule loadingProgressOverlayModule, PublishComponent publishComponent, a aVar) {
        this.a = publishComponent;
        f fVar = new f(publishComponent);
        this.b = fVar;
        c cVar = new c(publishComponent);
        this.c = cVar;
        this.d = DoubleCheck.provider(LoadingProgressOverlayModule_ProvideLoadingProgressOverlayFactory.create(loadingProgressOverlayModule, fVar, cVar));
        i iVar = new i(publishComponent);
        this.e = iVar;
        h hVar = new h(publishComponent);
        this.f = hVar;
        d dVar = new d(publishComponent);
        this.g = dVar;
        g gVar = new g(publishComponent);
        this.h = gVar;
        e eVar = new e(publishComponent);
        this.i = eVar;
        PretendInteractorImpl_Factory create = PretendInteractorImpl_Factory.create(iVar, hVar, dVar, gVar, eVar);
        this.j = create;
        this.k = DoubleCheck.provider(create);
    }

    public static PretendComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.pretend.di.PretendComponent
    public void inject(PretendFragment pretendFragment) {
        PretendFragment_MembersInjector.injectLoadingProgress(pretendFragment, this.d.get());
        PretendFragment_MembersInjector.injectViewModelFactory(pretendFragment, new PretendViewModelFactory((SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), this.k.get()));
    }
}
