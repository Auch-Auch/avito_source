package com.avito.android.rating.publish.deal_proofs.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.photo_picker.legacy.PhotoInteractor;
import com.avito.android.photo_picker.legacy.service.UploadingInteractor;
import com.avito.android.photo_view.ImageListInteractor;
import com.avito.android.photo_view.ImageListPresenter;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.deal_proofs.DealProofsFragment;
import com.avito.android.rating.publish.deal_proofs.DealProofsFragment_MembersInjector;
import com.avito.android.rating.publish.deal_proofs.DealProofsPresenterImpl;
import com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerDealProofsComponent implements DealProofsComponent {
    public final StepListener a;
    public final RatingPublishData b;
    public final RatingPublishViewData c;
    public final DealProofsDependencies d;
    public Provider<SchedulersFactory> e;
    public Provider<Activity> f;
    public Provider<BuildInfo> g;
    public Provider<PhotoInteractor> h;
    public Provider<String> i;
    public Provider<ImageListInteractor> j;
    public Provider<UploadingInteractor> k;
    public Provider<ImageListPresenter> l;

    public static final class b implements DealProofsComponent.Builder {
        public DealProofsDependencies a;
        public Activity b;
        public Resources c;
        public StepListener d;
        public String e;
        public RatingPublishData f;
        public RatingPublishViewData g;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, DealProofsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, StepListener.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.g, RatingPublishViewData.class);
            return new DaggerDealProofsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, null);
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder dependentOn(DealProofsDependencies dealProofsDependencies) {
            this.a = (DealProofsDependencies) Preconditions.checkNotNull(dealProofsDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(StepListener stepListener) {
            this.d = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(RatingPublishData ratingPublishData) {
            this.f = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent.Builder
        public DealProofsComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.g = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }
    }

    public static class c implements Provider<BuildInfo> {
        public final DealProofsDependencies a;

        public c(DealProofsDependencies dealProofsDependencies) {
            this.a = dealProofsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BuildInfo get() {
            return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final DealProofsDependencies a;

        public d(DealProofsDependencies dealProofsDependencies) {
            this.a = dealProofsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public DaggerDealProofsComponent(DealProofsDependencies dealProofsDependencies, Activity activity, Resources resources, StepListener stepListener, String str, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, a aVar) {
        this.a = stepListener;
        this.b = ratingPublishData;
        this.c = ratingPublishViewData;
        this.d = dealProofsDependencies;
        this.e = new d(dealProofsDependencies);
        Factory create = InstanceFactory.create(activity);
        this.f = create;
        c cVar = new c(dealProofsDependencies);
        this.g = cVar;
        this.h = DoubleCheck.provider(DealProofsModule_ProvidePhotoInteractor$rating_releaseFactory.create(create, cVar));
        Factory create2 = InstanceFactory.create(str);
        this.i = create2;
        this.j = DoubleCheck.provider(DealProofsModule_ProvideImageListInteractor$rating_releaseFactory.create(this.e, this.h, create2));
        Provider<UploadingInteractor> provider = DoubleCheck.provider(DealProofsModule_ProvideUploadingInteractor$rating_releaseFactory.create(this.f, this.i));
        this.k = provider;
        this.l = DoubleCheck.provider(DealProofsModule_ProvideImageListPresenter$rating_releaseFactory.create(this.j, provider, this.e));
    }

    public static DealProofsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.deal_proofs.di.DealProofsComponent
    public void inject(DealProofsFragment dealProofsFragment) {
        DealProofsFragment_MembersInjector.injectPresenter(dealProofsFragment, new DealProofsPresenterImpl(this.a, this.l.get(), this.b, this.c));
        DealProofsFragment_MembersInjector.injectAnalytics(dealProofsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.d.analytics()));
        DealProofsFragment_MembersInjector.injectImageListPresenter(dealProofsFragment, this.l.get());
        DealProofsFragment_MembersInjector.injectStepListener(dealProofsFragment, this.a);
        DealProofsFragment_MembersInjector.injectRatingData(dealProofsFragment, this.b);
        DealProofsFragment_MembersInjector.injectIntentFactory(dealProofsFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.d.activityIntentFactory()));
    }
}
