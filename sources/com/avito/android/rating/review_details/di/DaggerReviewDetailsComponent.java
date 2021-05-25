package com.avito.android.rating.review_details.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.dialog.DialogPresenter;
import com.avito.android.dialog.DialogPresenterImpl;
import com.avito.android.dialog.DialogPresenterImpl_Factory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.rating.di.RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory;
import com.avito.android.rating.review_details.ReviewDetailsActivity;
import com.avito.android.rating.review_details.ReviewDetailsActivity_MembersInjector;
import com.avito.android.rating.review_details.ReviewDetailsPresenterImpl;
import com.avito.android.rating.review_details.di.ReviewDetailsComponent;
import com.avito.android.rating.review_details.reply.ReviewReplyPresenterImpl;
import com.avito.android.rating.review_details.upload.ReplyUploadPresenter;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
import com.avito.android.ratings.ReviewData;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerReviewDetailsComponent implements ReviewDetailsComponent {
    public final ReviewDetailsDependencies a;
    public final ReviewData b;
    public final Kundle c;
    public Provider<PublishRelay<TnsGalleryItemClickAction>> d = DoubleCheck.provider(RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory.create());
    public Provider<Activity> e;
    public Provider<DialogRouter> f;
    public Provider<DialogPresenterImpl> g;
    public Provider<DialogPresenter> h;
    public Provider<Resources> i;
    public Provider<ErrorFormatterImpl> j;
    public Provider<ErrorFormatter> k;
    public Provider<ErrorHelperImpl> l;
    public Provider<ErrorHelper> m;

    public static final class b implements ReviewDetailsComponent.Builder {
        public ReviewDetailsDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public Kundle e;
        public ReviewData f;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, ReviewDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.f, ReviewData.class);
            return new DaggerReviewDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder dependentOn(ReviewDetailsDependencies reviewDetailsDependencies) {
            this.a = (ReviewDetailsDependencies) Preconditions.checkNotNull(reviewDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder with(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder withDetails(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder withReply(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder with(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent.Builder
        public ReviewDetailsComponent.Builder with(ReviewData reviewData) {
            this.f = (ReviewData) Preconditions.checkNotNull(reviewData);
            return this;
        }
    }

    public DaggerReviewDetailsComponent(ReviewDetailsDependencies reviewDetailsDependencies, Activity activity, Resources resources, Kundle kundle, Kundle kundle2, ReviewData reviewData, a aVar) {
        this.a = reviewDetailsDependencies;
        this.b = reviewData;
        this.c = kundle2;
        Factory create = InstanceFactory.create(activity);
        this.e = create;
        Provider<DialogRouter> provider = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
        this.f = provider;
        DialogPresenterImpl_Factory create2 = DialogPresenterImpl_Factory.create(this.e, provider);
        this.g = create2;
        this.h = SingleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.i = create3;
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(create3);
        this.j = create4;
        Provider<ErrorFormatter> provider2 = SingleCheck.provider(create4);
        this.k = provider2;
        ErrorHelperImpl_Factory create5 = ErrorHelperImpl_Factory.create(provider2);
        this.l = create5;
        this.m = SingleCheck.provider(create5);
    }

    public static ReviewDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.review_details.di.ReviewDetailsComponent
    public void inject(ReviewDetailsActivity reviewDetailsActivity) {
        ReviewDetailsActivity_MembersInjector.injectDeepLinkIntentFactory(reviewDetailsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ReviewDetailsActivity_MembersInjector.injectPresenter(reviewDetailsActivity, new ReviewDetailsPresenterImpl(this.b, (ReplyUploadPresenter) Preconditions.checkNotNullFromComponent(this.a.reviewReplyInteractor()), (ReviewReplyProvider) Preconditions.checkNotNullFromComponent(this.a.reviewReplyProvider()), this.d.get(), this.h.get(), this.m.get(), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), this.c));
        ReviewDetailsActivity_MembersInjector.injectReplyPresenter(reviewDetailsActivity, new ReviewReplyPresenterImpl(this.b, (ReplyUploadPresenter) Preconditions.checkNotNullFromComponent(this.a.reviewReplyInteractor()), (ReviewReplyProvider) Preconditions.checkNotNullFromComponent(this.a.reviewReplyProvider()), this.h.get(), this.m.get(), this.c));
        ReviewDetailsActivity_MembersInjector.injectIntentFactory(reviewDetailsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ReviewDetailsActivity_MembersInjector.injectImageClicks(reviewDetailsActivity, this.d.get());
        ReviewDetailsActivity_MembersInjector.injectFeatures(reviewDetailsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
