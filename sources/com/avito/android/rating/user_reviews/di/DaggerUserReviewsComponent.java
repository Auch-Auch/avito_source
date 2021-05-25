package com.avito.android.rating.user_reviews.di;

import android.app.Activity;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.details.ReviewReplyResultConverter;
import com.avito.android.rating.details.ReviewReplyResultConverterImpl_Factory;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenter;
import com.avito.android.rating.details.adapter.user_profile_comment.di.UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.user_profile_comment.di.UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.di.RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.user_reviews.ItemToReviewDataConverter;
import com.avito.android.rating.user_reviews.ItemToReviewDataConverterImpl_Factory;
import com.avito.android.rating.user_reviews.ReviewItemConverter;
import com.avito.android.rating.user_reviews.ReviewItemConverterImpl;
import com.avito.android.rating.user_reviews.ReviewItemConverterImpl_Factory;
import com.avito.android.rating.user_reviews.UserReviewsActivity;
import com.avito.android.rating.user_reviews.UserReviewsActivity_MembersInjector;
import com.avito.android.rating.user_reviews.UserReviewsInteractor;
import com.avito.android.rating.user_reviews.UserReviewsInteractorImpl;
import com.avito.android.rating.user_reviews.UserReviewsInteractorImpl_Factory;
import com.avito.android.rating.user_reviews.UserReviewsPresenter;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl;
import com.avito.android.rating.user_reviews.UserReviewsPresenterImpl_Factory;
import com.avito.android.rating.user_reviews.adapter.placeholder.PlaceholderItemPresenter;
import com.avito.android.rating.user_reviews.adapter.placeholder.di.PlaceholderItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.user_reviews.adapter.placeholder.di.PlaceholderItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.user_reviews.di.UserReviewsComponent;
import com.avito.android.recycler.responsive.CallableResponsiveItemPresenterRegistry;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerUserReviewsComponent implements UserReviewsComponent {
    public Provider<ReviewItemConverter> A;
    public Provider<Resources> B;
    public Provider<ErrorFormatterImpl> C;
    public Provider<ErrorFormatter> D;
    public Provider<ErrorHelperImpl> E;
    public Provider<ErrorHelper> F;
    public Provider<ItemToReviewDataConverter> G;
    public Provider<Analytics> H;
    public Provider<Kundle> I;
    public Provider<UserReviewsPresenterImpl> J;
    public Provider<UserReviewsPresenter> K;
    public Provider<DialogRouter> L;
    public final UserReviewsDependencies a;
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<RatingDetailsItem>> c;
    public Provider<UserProfileCommentItemPresenter> d;
    public Provider<PublishRelay<TnsGalleryItemClickAction>> e;
    public Provider<Activity> f;
    public Provider<Features> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<ErrorSnippetItemPresenter> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<PlaceholderItemPresenter> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<PublishRelay<LoadingItemNextPageAction>> m;
    public Provider<LoadingItemPresenterImpl> n;
    public Provider<ItemBlueprint<?, ?>> o;
    public Provider<Set<ItemBlueprint<?, ?>>> p;
    public Provider<ItemBinder> q;
    public Provider<AdapterPresenter> r;
    public Provider<CallableResponsiveItemPresenterRegistry> s;
    public Provider<ResponsiveAdapterPresenter> t;
    public Provider<RatingApi> u;
    public Provider<SchedulersFactory3> v;
    public Provider<UserReviewsInteractorImpl> w;
    public Provider<UserReviewsInteractor> x;
    public Provider<ReviewReplyResultConverter> y;
    public Provider<ReviewItemConverterImpl> z;

    public static final class b implements UserReviewsComponent.Builder {
        public UserReviewsDependencies a;
        public Resources b;
        public Activity c;
        public Kundle d;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent.Builder
        public UserReviewsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, UserReviewsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerUserReviewsComponent(this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent.Builder
        public UserReviewsComponent.Builder dependentOn(UserReviewsDependencies userReviewsDependencies) {
            this.a = (UserReviewsDependencies) Preconditions.checkNotNull(userReviewsDependencies);
            return this;
        }

        @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent.Builder
        public UserReviewsComponent.Builder with(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent.Builder
        public UserReviewsComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent.Builder
        public UserReviewsComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final UserReviewsDependencies a;

        public c(UserReviewsDependencies userReviewsDependencies) {
            this.a = userReviewsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final UserReviewsDependencies a;

        public d(UserReviewsDependencies userReviewsDependencies) {
            this.a = userReviewsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<RatingApi> {
        public final UserReviewsDependencies a;

        public e(UserReviewsDependencies userReviewsDependencies) {
            this.a = userReviewsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RatingApi get() {
            return (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final UserReviewsDependencies a;

        public f(UserReviewsDependencies userReviewsDependencies) {
            this.a = userReviewsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerUserReviewsComponent(UserReviewsDependencies userReviewsDependencies, Resources resources, Activity activity, Kundle kundle, a aVar) {
        this.a = userReviewsDependencies;
        Provider<PublishRelay<RatingDetailsItem>> provider = DoubleCheck.provider(UserReviewsModule_ProvideRatingDetailsItemStream$rating_releaseFactory.create());
        this.c = provider;
        this.d = DoubleCheck.provider(UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory.create(provider));
        this.e = DoubleCheck.provider(RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory.create());
        Factory create = InstanceFactory.create(activity);
        this.f = create;
        d dVar = new d(userReviewsDependencies);
        this.g = dVar;
        this.h = DoubleCheck.provider(UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory.create(this.d, this.e, create, dVar));
        Provider<ErrorSnippetItemPresenter> provider2 = DoubleCheck.provider(ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory.create(this.c));
        this.i = provider2;
        this.j = DoubleCheck.provider(ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory.create(provider2));
        Provider<PlaceholderItemPresenter> provider3 = DoubleCheck.provider(PlaceholderItemModule_ProvidePresenter$rating_releaseFactory.create());
        this.k = provider3;
        this.l = DoubleCheck.provider(PlaceholderItemModule_ProvideBlueprint$rating_releaseFactory.create(provider3));
        Provider<PublishRelay<LoadingItemNextPageAction>> provider4 = DoubleCheck.provider(LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory.create());
        this.m = provider4;
        LoadingItemPresenterImpl_Factory create2 = LoadingItemPresenterImpl_Factory.create(provider4);
        this.n = create2;
        this.o = DoubleCheck.provider(LoadingItemModule_ProvideBlueprint$rating_releaseFactory.create(create2));
        SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.b).addProvider(this.h).addProvider(this.j).addProvider(this.l).addProvider(this.o).build();
        this.p = build;
        Provider<ItemBinder> provider5 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.q = provider5;
        this.r = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider5));
        Provider<CallableResponsiveItemPresenterRegistry> provider6 = DoubleCheck.provider(UserReviewsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory.create());
        this.s = provider6;
        this.t = DoubleCheck.provider(UserReviewsModule_ProvideAdapterPresenter$rating_releaseFactory.create(this.r, provider6));
        e eVar = new e(userReviewsDependencies);
        this.u = eVar;
        f fVar = new f(userReviewsDependencies);
        this.v = fVar;
        UserReviewsInteractorImpl_Factory create3 = UserReviewsInteractorImpl_Factory.create(eVar, fVar);
        this.w = create3;
        this.x = DoubleCheck.provider(create3);
        Provider<ReviewReplyResultConverter> provider7 = DoubleCheck.provider(ReviewReplyResultConverterImpl_Factory.create());
        this.y = provider7;
        ReviewItemConverterImpl_Factory create4 = ReviewItemConverterImpl_Factory.create(provider7);
        this.z = create4;
        this.A = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(resources);
        this.B = create5;
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(create5);
        this.C = create6;
        Provider<ErrorFormatter> provider8 = SingleCheck.provider(create6);
        this.D = provider8;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider8);
        this.E = create7;
        this.F = SingleCheck.provider(create7);
        this.G = DoubleCheck.provider(ItemToReviewDataConverterImpl_Factory.create());
        this.H = new c(userReviewsDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.I = createNullable;
        UserReviewsPresenterImpl_Factory create8 = UserReviewsPresenterImpl_Factory.create(this.x, this.r, this.c, this.e, this.A, this.v, this.F, this.G, this.H, this.m, createNullable);
        this.J = create8;
        this.K = DoubleCheck.provider(create8);
        this.L = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.f));
    }

    public static UserReviewsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.user_reviews.di.UserReviewsComponent
    public void inject(UserReviewsActivity userReviewsActivity) {
        UserReviewsActivity_MembersInjector.injectIntentFactory(userReviewsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserReviewsActivity_MembersInjector.injectDeepLinkIntentFactory(userReviewsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserReviewsActivity_MembersInjector.injectAdapterPresenter(userReviewsActivity, this.t.get());
        UserReviewsActivity_MembersInjector.injectItemBinder(userReviewsActivity, this.q.get());
        UserReviewsActivity_MembersInjector.injectPresenter(userReviewsActivity, this.K.get());
        UserReviewsActivity_MembersInjector.injectDialogRouter(userReviewsActivity, this.L.get());
        UserReviewsActivity_MembersInjector.injectAnalytics(userReviewsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserReviewsActivity_MembersInjector.injectFeatures(userReviewsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}
