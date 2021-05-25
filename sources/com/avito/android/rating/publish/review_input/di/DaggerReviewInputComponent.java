package com.avito.android.rating.publish.review_input.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.review_input.ReviewInputFragment;
import com.avito.android.rating.publish.review_input.ReviewInputFragment_MembersInjector;
import com.avito.android.rating.publish.review_input.ReviewInputPresenterImpl;
import com.avito.android.rating.publish.review_input.di.ReviewInputComponent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.remote.model.publish.NextStagePayload;
import com.avito.android.util.Kundle;
import dagger.internal.Preconditions;
public final class DaggerReviewInputComponent implements ReviewInputComponent {
    public final ReviewInputDependencies a;
    public final StepListener b;
    public final RatingPublishData c;
    public final RatingPublishViewData d;
    public final NextStagePayload e;
    public final Kundle f;

    public static final class b implements ReviewInputComponent.Builder {
        public ReviewInputDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public StepListener e;
        public RatingPublishData f;
        public RatingPublishViewData g;
        public NextStagePayload h;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ReviewInputDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, StepListener.class);
            Preconditions.checkBuilderRequirement(this.f, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.g, RatingPublishViewData.class);
            return new DaggerReviewInputComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder dependentOn(ReviewInputDependencies reviewInputDependencies) {
            this.a = (ReviewInputDependencies) Preconditions.checkNotNull(reviewInputDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(StepListener stepListener) {
            this.e = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(RatingPublishData ratingPublishData) {
            this.f = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.g = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }

        @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent.Builder
        public ReviewInputComponent.Builder with(NextStagePayload nextStagePayload) {
            this.h = nextStagePayload;
            return this;
        }
    }

    public DaggerReviewInputComponent(ReviewInputDependencies reviewInputDependencies, Kundle kundle, Activity activity, Resources resources, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData, NextStagePayload nextStagePayload) {
        this.a = reviewInputDependencies;
        this.b = stepListener;
        this.c = ratingPublishData;
        this.d = ratingPublishViewData;
        this.e = nextStagePayload;
        this.f = kundle;
    }

    public static ReviewInputComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.review_input.di.ReviewInputComponent
    public void inject(ReviewInputFragment reviewInputFragment) {
        ReviewInputFragment_MembersInjector.injectIntentFactory(reviewInputFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ReviewInputFragment_MembersInjector.injectPresenter(reviewInputFragment, new ReviewInputPresenterImpl(this.b, this.c, this.d, this.e, this.f));
        ReviewInputFragment_MembersInjector.injectAnalytics(reviewInputFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ReviewInputFragment_MembersInjector.injectStepListener(reviewInputFragment, this.b);
        ReviewInputFragment_MembersInjector.injectRatingViewData(reviewInputFragment, this.d);
        ReviewInputFragment_MembersInjector.injectRatingData(reviewInputFragment, this.c);
    }
}
