package com.avito.android.rating.publish.select_rating.di;

import android.app.Activity;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.select_rating.SelectRatingFragment;
import com.avito.android.rating.publish.select_rating.SelectRatingFragment_MembersInjector;
import com.avito.android.rating.publish.select_rating.SelectRatingPresenterImpl;
import com.avito.android.rating.publish.select_rating.di.SelectRatingComponent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import dagger.internal.Preconditions;
public final class DaggerSelectRatingComponent implements SelectRatingComponent {
    public final SelectRatingDependencies a;
    public final StepListener b;
    public final RatingPublishData c;
    public final RatingPublishViewData d;
    public final Kundle e;

    public static final class b implements SelectRatingComponent.Builder {
        public SelectRatingDependencies a;
        public Kundle b;
        public Activity c;
        public StepListener d;
        public RatingPublishData e;
        public RatingPublishViewData f;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SelectRatingDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, StepListener.class);
            Preconditions.checkBuilderRequirement(this.e, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.f, RatingPublishViewData.class);
            return new DaggerSelectRatingComponent(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder dependentOn(SelectRatingDependencies selectRatingDependencies) {
            this.a = (SelectRatingDependencies) Preconditions.checkNotNull(selectRatingDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder with(StepListener stepListener) {
            this.d = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder with(RatingPublishData ratingPublishData) {
            this.e = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent.Builder
        public SelectRatingComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.f = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }
    }

    public DaggerSelectRatingComponent(SelectRatingDependencies selectRatingDependencies, Kundle kundle, Activity activity, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData) {
        this.a = selectRatingDependencies;
        this.b = stepListener;
        this.c = ratingPublishData;
        this.d = ratingPublishViewData;
        this.e = kundle;
    }

    public static SelectRatingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.select_rating.di.SelectRatingComponent
    public void inject(SelectRatingFragment selectRatingFragment) {
        SelectRatingFragment_MembersInjector.injectIntentFactory(selectRatingFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SelectRatingFragment_MembersInjector.injectDeepLinkIntentFactory(selectRatingFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        SelectRatingFragment_MembersInjector.injectPresenter(selectRatingFragment, new SelectRatingPresenterImpl(this.b, this.c, this.d, this.e));
        SelectRatingFragment_MembersInjector.injectAnalytics(selectRatingFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SelectRatingFragment_MembersInjector.injectStepListener(selectRatingFragment, this.b);
        SelectRatingFragment_MembersInjector.injectRatingViewData(selectRatingFragment, this.d);
        SelectRatingFragment_MembersInjector.injectRatingData(selectRatingFragment, this.c);
    }
}
