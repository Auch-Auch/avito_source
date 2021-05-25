package com.avito.android.publish.edit_advert_request.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.progress_overlay.LoadingProgressOverlay;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl;
import com.avito.android.progress_overlay.LoadingProgressOverlayImpl_Factory;
import com.avito.android.progress_overlay.ProgressDialogRouter;
import com.avito.android.publish.di.PublishComponent;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestFragment_MembersInjector;
import com.avito.android.publish.edit_advert_request.EditAdvertRequestViewModelFactory;
import com.avito.android.publish.edit_advert_request.data.EditAdvertCloudDataSource;
import com.avito.android.publish.edit_advert_request.data.EditAdvertCloudDataSource_Factory;
import com.avito.android.publish.edit_advert_request.data.EditAdvertDataSource;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepository;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepositoryImpl;
import com.avito.android.publish.edit_advert_request.data.EditAdvertRepositoryImpl_Factory;
import com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerEditAdvertRequestComponent implements EditAdvertRequestComponent {
    public final PublishComponent a;
    public Provider<PublishApi> b;
    public Provider<Features> c;
    public Provider<EditAdvertCloudDataSource> d;
    public Provider<EditAdvertDataSource> e;
    public Provider<CategoryParametersConverter> f;
    public Provider<PublishAnalyticsDataProvider> g;
    public Provider<EditAdvertRepositoryImpl> h;
    public Provider<EditAdvertRepository> i;
    public Provider<Analytics> j;
    public Provider<ProgressDialogRouter> k;
    public Provider<LoadingProgressOverlayImpl> l;
    public Provider<LoadingProgressOverlay> m;

    public static final class b implements EditAdvertRequestComponent.Builder {
        public PublishComponent a;
        public Resources b;

        public b(a aVar) {
        }

        @Override // com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent.Builder
        public EditAdvertRequestComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublishComponent.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerEditAdvertRequestComponent(this.a, this.b, null);
        }

        @Override // com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent.Builder
        public EditAdvertRequestComponent.Builder publishComponent(PublishComponent publishComponent) {
            this.a = (PublishComponent) Preconditions.checkNotNull(publishComponent);
            return this;
        }

        @Override // com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent.Builder
        public EditAdvertRequestComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
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

    public DaggerEditAdvertRequestComponent(PublishComponent publishComponent, Resources resources, a aVar) {
        this.a = publishComponent;
        h hVar = new h(publishComponent);
        this.b = hVar;
        e eVar = new e(publishComponent);
        this.c = eVar;
        EditAdvertCloudDataSource_Factory create = EditAdvertCloudDataSource_Factory.create(hVar, eVar);
        this.d = create;
        Provider<EditAdvertDataSource> provider = DoubleCheck.provider(create);
        this.e = provider;
        d dVar = new d(publishComponent);
        this.f = dVar;
        g gVar = new g(publishComponent);
        this.g = gVar;
        EditAdvertRepositoryImpl_Factory create2 = EditAdvertRepositoryImpl_Factory.create(provider, dVar, gVar);
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        c cVar = new c(publishComponent);
        this.j = cVar;
        f fVar = new f(publishComponent);
        this.k = fVar;
        LoadingProgressOverlayImpl_Factory create3 = LoadingProgressOverlayImpl_Factory.create(cVar, fVar);
        this.l = create3;
        this.m = DoubleCheck.provider(create3);
    }

    public static EditAdvertRequestComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.publish.edit_advert_request.di.EditAdvertRequestComponent
    public void inject(EditAdvertRequestFragment editAdvertRequestFragment) {
        EditAdvertRequestFragment_MembersInjector.injectViewModelFactory(editAdvertRequestFragment, new EditAdvertRequestViewModelFactory(this.i.get(), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (Features) Preconditions.checkNotNullFromComponent(this.a.features())));
        EditAdvertRequestFragment_MembersInjector.injectLoadingProgress(editAdvertRequestFragment, this.m.get());
        EditAdvertRequestFragment_MembersInjector.injectIntentFactory(editAdvertRequestFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        EditAdvertRequestFragment_MembersInjector.injectDeepLinkIntentFactory(editAdvertRequestFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        EditAdvertRequestFragment_MembersInjector.injectDialogRouter(editAdvertRequestFragment, (DialogRouter) Preconditions.checkNotNullFromComponent(this.a.dialogRouter()));
    }
}
