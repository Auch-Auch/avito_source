package com.avito.android.rating.publish.buyer_info.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.analytics.Analytics;
import com.avito.android.rating.publish.RatingPublishViewData;
import com.avito.android.rating.publish.StepListener;
import com.avito.android.rating.publish.buyer_info.BuyerInfoFragment;
import com.avito.android.rating.publish.buyer_info.BuyerInfoFragment_MembersInjector;
import com.avito.android.rating.publish.buyer_info.BuyerInfoPresenterImpl;
import com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent;
import com.avito.android.ratings.RatingPublishData;
import com.avito.android.util.Kundle;
import dagger.internal.Preconditions;
public final class DaggerBuyerInfoComponent implements BuyerInfoComponent {
    public final StepListener a;
    public final RatingPublishData b;
    public final RatingPublishViewData c;
    public final Kundle d;
    public final BuyerInfoDependencies e;

    public static final class b implements BuyerInfoComponent.Builder {
        public BuyerInfoDependencies a;
        public Kundle b;
        public Activity c;
        public Resources d;
        public StepListener e;
        public RatingPublishData f;
        public RatingPublishViewData g;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent build() {
            Preconditions.checkBuilderRequirement(this.a, BuyerInfoDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, StepListener.class);
            Preconditions.checkBuilderRequirement(this.f, RatingPublishData.class);
            Preconditions.checkBuilderRequirement(this.g, RatingPublishViewData.class);
            return new DaggerBuyerInfoComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder dependentOn(BuyerInfoDependencies buyerInfoDependencies) {
            this.a = (BuyerInfoDependencies) Preconditions.checkNotNull(buyerInfoDependencies);
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(Kundle kundle) {
            this.b = kundle;
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(StepListener stepListener) {
            this.e = (StepListener) Preconditions.checkNotNull(stepListener);
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(RatingPublishData ratingPublishData) {
            this.f = (RatingPublishData) Preconditions.checkNotNull(ratingPublishData);
            return this;
        }

        @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent.Builder
        public BuyerInfoComponent.Builder with(RatingPublishViewData ratingPublishViewData) {
            this.g = (RatingPublishViewData) Preconditions.checkNotNull(ratingPublishViewData);
            return this;
        }
    }

    public DaggerBuyerInfoComponent(BuyerInfoDependencies buyerInfoDependencies, Kundle kundle, Activity activity, Resources resources, StepListener stepListener, RatingPublishData ratingPublishData, RatingPublishViewData ratingPublishViewData) {
        this.a = stepListener;
        this.b = ratingPublishData;
        this.c = ratingPublishViewData;
        this.d = kundle;
        this.e = buyerInfoDependencies;
    }

    public static BuyerInfoComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.publish.buyer_info.di.BuyerInfoComponent
    public void inject(BuyerInfoFragment buyerInfoFragment) {
        BuyerInfoFragment_MembersInjector.injectPresenter(buyerInfoFragment, new BuyerInfoPresenterImpl(this.a, this.b, this.c, this.d));
        BuyerInfoFragment_MembersInjector.injectAnalytics(buyerInfoFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.e.analytics()));
        BuyerInfoFragment_MembersInjector.injectStepListener(buyerInfoFragment, this.a);
        BuyerInfoFragment_MembersInjector.injectRatingViewData(buyerInfoFragment, this.c);
        BuyerInfoFragment_MembersInjector.injectRatingData(buyerInfoFragment, this.b);
    }
}
