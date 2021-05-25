package com.avito.android.rating.user_review_details.di;

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
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.user_review_details.UserReviewDetailsActivity;
import com.avito.android.rating.user_review_details.UserReviewDetailsActivity_MembersInjector;
import com.avito.android.rating.user_review_details.UserReviewDetailsInteractorImpl;
import com.avito.android.rating.user_review_details.UserReviewDetailsPresenterImpl;
import com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.user_review.UserReviewData;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerUserReviewDetailsComponent implements UserReviewDetailsComponent {
    public final UserReviewDetailsDependencies a;
    public final UserReviewData b;
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

    public static final class b implements UserReviewDetailsComponent.Builder {
        public UserReviewDetailsDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public UserReviewData e;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserReviewDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, UserReviewData.class);
            return new DaggerUserReviewDetailsComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent.Builder dependentOn(UserReviewDetailsDependencies userReviewDetailsDependencies) {
            this.a = (UserReviewDetailsDependencies) Preconditions.checkNotNull(userReviewDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent.Builder with(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent.Builder with(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent.Builder with(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent.Builder
        public UserReviewDetailsComponent.Builder with(UserReviewData userReviewData) {
            this.e = (UserReviewData) Preconditions.checkNotNull(userReviewData);
            return this;
        }
    }

    public DaggerUserReviewDetailsComponent(UserReviewDetailsDependencies userReviewDetailsDependencies, Activity activity, Resources resources, Kundle kundle, UserReviewData userReviewData, a aVar) {
        this.a = userReviewDetailsDependencies;
        this.b = userReviewData;
        this.c = kundle;
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

    public static UserReviewDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.user_review_details.di.UserReviewDetailsComponent
    public void inject(UserReviewDetailsActivity userReviewDetailsActivity) {
        UserReviewDetailsActivity_MembersInjector.injectDeepLinkIntentFactory(userReviewDetailsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserReviewDetailsActivity_MembersInjector.injectPresenter(userReviewDetailsActivity, new UserReviewDetailsPresenterImpl(this.b, new UserReviewDetailsInteractorImpl((RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi()), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3())), this.d.get(), this.h.get(), this.m.get(), (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), this.c));
        UserReviewDetailsActivity_MembersInjector.injectFeatures(userReviewDetailsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        UserReviewDetailsActivity_MembersInjector.injectIntentFactory(userReviewDetailsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserReviewDetailsActivity_MembersInjector.injectImageClicks(userReviewDetailsActivity, this.d.get());
    }
}
