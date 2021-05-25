package com.avito.android.rating.details.di;

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
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.rating.details.RatingDetailsActivity;
import com.avito.android.rating.details.RatingDetailsActivity_MembersInjector;
import com.avito.android.rating.details.RatingDetailsConverter;
import com.avito.android.rating.details.RatingDetailsInteractor;
import com.avito.android.rating.details.RatingDetailsPresenter;
import com.avito.android.rating.details.RatingDetailsPresenterImpl;
import com.avito.android.rating.details.RatingDetailsPresenterImpl_Factory;
import com.avito.android.rating.details.ReviewReplyResultConverter;
import com.avito.android.rating.details.ReviewReplyResultConverterImpl_Factory;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.action.ActionItemPresenter;
import com.avito.android.rating.details.adapter.action.di.ActionItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.action.di.ActionItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.button.ButtonItemPresenter;
import com.avito.android.rating.details.adapter.button.di.ButtonItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.button.di.ButtonItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.comment.CommentItemPresenter;
import com.avito.android.rating.details.adapter.comment.di.CommentItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.comment.di.CommentItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.info.InfoItemPresenter;
import com.avito.android.rating.details.adapter.info.di.InfoItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.info.di.InfoItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.LoadingItemNextPageAction;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl;
import com.avito.android.rating.details.adapter.loading.LoadingItemPresenterImpl_Factory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory;
import com.avito.android.rating.details.adapter.rating.RatingItemPresenter;
import com.avito.android.rating.details.adapter.rating.di.RatingItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.rating.di.RatingItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.text.TextItemPresenter;
import com.avito.android.rating.details.adapter.text.di.TextItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.text.di.TextItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.adapter.user_profile_comment.UserProfileCommentItemPresenter;
import com.avito.android.rating.details.adapter.user_profile_comment.di.UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory;
import com.avito.android.rating.details.adapter.user_profile_comment.di.UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory;
import com.avito.android.rating.details.di.RatingDetailsComponent;
import com.avito.android.rating.di.RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.rating.review_details.upload.ReviewReplyProvider;
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
public final class DaggerRatingDetailsComponent implements RatingDetailsComponent {
    public Provider<ItemBinder> A;
    public Provider<AdapterPresenter> B;
    public Provider<CallableResponsiveItemPresenterRegistry> C;
    public Provider<ResponsiveAdapterPresenter> D;
    public Provider<RatingApi> E;
    public Provider<SchedulersFactory3> F;
    public Provider<String> G;
    public Provider<String> H;
    public Provider<RatingDetailsInteractor> I;
    public Provider<Resources> J;
    public Provider<ErrorFormatterImpl> K;
    public Provider<ErrorFormatter> L;
    public Provider<ReviewReplyResultConverter> M;
    public Provider<RatingDetailsConverter> N;
    public Provider<DialogRouter> O;
    public Provider<DialogPresenterImpl> P;
    public Provider<DialogPresenter> Q;
    public Provider<ReviewReplyProvider> R;
    public Provider<Analytics> S;
    public Provider<Kundle> T;
    public Provider<RatingDetailsPresenterImpl> U;
    public Provider<RatingDetailsPresenter> V;
    public final RatingDetailsDependencies a;
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<RatingDetailsItem>> c;
    public Provider<ActionItemPresenter> d;
    public Provider<ItemBlueprint<?, ?>> e;
    public Provider<CommentItemPresenter> f;
    public Provider<PublishRelay<TnsGalleryItemClickAction>> g;
    public Provider<Activity> h;
    public Provider<Features> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<UserProfileCommentItemPresenter> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<ErrorSnippetItemPresenter> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<RatingItemPresenter> o;
    public Provider<ItemBlueprint<?, ?>> p;
    public Provider<ButtonItemPresenter> q;
    public Provider<ItemBlueprint<?, ?>> r;
    public Provider<TextItemPresenter> s;
    public Provider<ItemBlueprint<?, ?>> t;
    public Provider<InfoItemPresenter> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<PublishRelay<LoadingItemNextPageAction>> w;
    public Provider<LoadingItemPresenterImpl> x;
    public Provider<ItemBlueprint<?, ?>> y;
    public Provider<Set<ItemBlueprint<?, ?>>> z;

    public static final class b implements RatingDetailsComponent.Builder {
        public RatingDetailsDependencies a;
        public Resources b;
        public Activity c;
        public String d;
        public String e;
        public Kundle f;

        public b(a aVar) {
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, RatingDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            return new DaggerRatingDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder dependentOn(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = (RatingDetailsDependencies) Preconditions.checkNotNull(ratingDetailsDependencies);
            return this;
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder with(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder withPresenterState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder withShopId(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder withUserKey(String str) {
            this.d = str;
            return this;
        }

        @Override // com.avito.android.rating.details.di.RatingDetailsComponent.Builder
        public RatingDetailsComponent.Builder with(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final RatingDetailsDependencies a;

        public c(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = ratingDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Features> {
        public final RatingDetailsDependencies a;

        public d(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = ratingDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class e implements Provider<RatingApi> {
        public final RatingDetailsDependencies a;

        public e(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = ratingDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public RatingApi get() {
            return (RatingApi) Preconditions.checkNotNullFromComponent(this.a.ratingApi());
        }
    }

    public static class f implements Provider<ReviewReplyProvider> {
        public final RatingDetailsDependencies a;

        public f(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = ratingDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ReviewReplyProvider get() {
            return (ReviewReplyProvider) Preconditions.checkNotNullFromComponent(this.a.reviewReplyProvider());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final RatingDetailsDependencies a;

        public g(RatingDetailsDependencies ratingDetailsDependencies) {
            this.a = ratingDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerRatingDetailsComponent(RatingDetailsDependencies ratingDetailsDependencies, Resources resources, Activity activity, String str, String str2, Kundle kundle, a aVar) {
        this.a = ratingDetailsDependencies;
        Provider<PublishRelay<RatingDetailsItem>> provider = DoubleCheck.provider(RatingDetailsModule_ProvideItemClicksStream$rating_releaseFactory.create());
        this.c = provider;
        Provider<ActionItemPresenter> provider2 = DoubleCheck.provider(ActionItemModule_ProvidePresenter$rating_releaseFactory.create(provider));
        this.d = provider2;
        this.e = DoubleCheck.provider(ActionItemModule_ProvideBlueprint$rating_releaseFactory.create(provider2));
        this.f = DoubleCheck.provider(CommentItemModule_ProvidePresenter$rating_releaseFactory.create());
        this.g = DoubleCheck.provider(RatingsTnsGalleryClicksModule_ProvidesTnsImageGalleryClicksRelayFactory.create());
        Factory create = InstanceFactory.create(activity);
        this.h = create;
        d dVar = new d(ratingDetailsDependencies);
        this.i = dVar;
        this.j = DoubleCheck.provider(CommentItemModule_ProvideBlueprint$rating_releaseFactory.create(this.f, this.g, create, dVar));
        Provider<UserProfileCommentItemPresenter> provider3 = DoubleCheck.provider(UserProfileCommentItemModule_ProvidePresenter$rating_releaseFactory.create(this.c));
        this.k = provider3;
        this.l = DoubleCheck.provider(UserProfileCommentItemModule_ProvideBlueprint$rating_releaseFactory.create(provider3, this.g, this.h, this.i));
        Provider<ErrorSnippetItemPresenter> provider4 = DoubleCheck.provider(ErrorSnippetItemModule_ProvidePresenter$rating_releaseFactory.create(this.c));
        this.m = provider4;
        this.n = DoubleCheck.provider(ErrorSnippetItemModule_ProvideBlueprint$rating_releaseFactory.create(provider4));
        Provider<RatingItemPresenter> provider5 = DoubleCheck.provider(RatingItemModule_ProvidePresenter$rating_releaseFactory.create());
        this.o = provider5;
        this.p = DoubleCheck.provider(RatingItemModule_ProvideBlueprint$rating_releaseFactory.create(provider5));
        Provider<ButtonItemPresenter> provider6 = DoubleCheck.provider(ButtonItemModule_ProvidePresenter$rating_releaseFactory.create(this.c));
        this.q = provider6;
        this.r = DoubleCheck.provider(ButtonItemModule_ProvideBlueprint$rating_releaseFactory.create(provider6));
        Provider<TextItemPresenter> provider7 = DoubleCheck.provider(TextItemModule_ProvidePresenter$rating_releaseFactory.create());
        this.s = provider7;
        this.t = DoubleCheck.provider(TextItemModule_ProvideBlueprint$rating_releaseFactory.create(provider7));
        Provider<InfoItemPresenter> provider8 = DoubleCheck.provider(InfoItemModule_ProvidePresenter$rating_releaseFactory.create(this.c));
        this.u = provider8;
        this.v = DoubleCheck.provider(InfoItemModule_ProvideBlueprint$rating_releaseFactory.create(provider8));
        Provider<PublishRelay<LoadingItemNextPageAction>> provider9 = DoubleCheck.provider(LoadingItemModule_ProvideLoadingItemShownAction$rating_releaseFactory.create());
        this.w = provider9;
        LoadingItemPresenterImpl_Factory create2 = LoadingItemPresenterImpl_Factory.create(provider9);
        this.x = create2;
        this.y = DoubleCheck.provider(LoadingItemModule_ProvideBlueprint$rating_releaseFactory.create(create2));
        SetFactory build = SetFactory.builder(9, 1).addCollectionProvider(this.b).addProvider(this.e).addProvider(this.j).addProvider(this.l).addProvider(this.n).addProvider(this.p).addProvider(this.r).addProvider(this.t).addProvider(this.v).addProvider(this.y).build();
        this.z = build;
        Provider<ItemBinder> provider10 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.A = provider10;
        this.B = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider10));
        Provider<CallableResponsiveItemPresenterRegistry> provider11 = DoubleCheck.provider(RatingDetailsModule_ProvideResponsiveItemPresenterRegistry$rating_releaseFactory.create());
        this.C = provider11;
        this.D = DoubleCheck.provider(RatingDetailsModule_ProvideAdapterPresenter$rating_releaseFactory.create(this.B, provider11));
        this.E = new e(ratingDetailsDependencies);
        this.F = new g(ratingDetailsDependencies);
        this.G = InstanceFactory.createNullable(str);
        Factory createNullable = InstanceFactory.createNullable(str2);
        this.H = createNullable;
        this.I = DoubleCheck.provider(RatingDetailsModule_ProvideInteractor$rating_releaseFactory.create(this.E, this.F, this.i, this.G, createNullable));
        Factory create3 = InstanceFactory.create(resources);
        this.J = create3;
        ErrorFormatterImpl_Factory create4 = ErrorFormatterImpl_Factory.create(create3);
        this.K = create4;
        this.L = DoubleCheck.provider(create4);
        Provider<ReviewReplyResultConverter> provider12 = DoubleCheck.provider(ReviewReplyResultConverterImpl_Factory.create());
        this.M = provider12;
        this.N = DoubleCheck.provider(RatingDetailsModule_ProvideRatingDetailsConverter$rating_releaseFactory.create(this.G, this.H, this.i, provider12));
        Provider<DialogRouter> provider13 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.h));
        this.O = provider13;
        DialogPresenterImpl_Factory create5 = DialogPresenterImpl_Factory.create(this.h, provider13);
        this.P = create5;
        this.Q = SingleCheck.provider(create5);
        this.R = new f(ratingDetailsDependencies);
        this.S = new c(ratingDetailsDependencies);
        Factory createNullable2 = InstanceFactory.createNullable(kundle);
        this.T = createNullable2;
        RatingDetailsPresenterImpl_Factory create6 = RatingDetailsPresenterImpl_Factory.create(this.I, this.B, this.F, this.c, this.g, this.L, this.N, this.Q, this.R, this.i, this.S, this.w, createNullable2);
        this.U = create6;
        this.V = DoubleCheck.provider(create6);
    }

    public static RatingDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.rating.details.di.RatingDetailsComponent
    public void inject(RatingDetailsActivity ratingDetailsActivity) {
        RatingDetailsActivity_MembersInjector.injectAdapterPresenter(ratingDetailsActivity, this.D.get());
        RatingDetailsActivity_MembersInjector.injectItemBinder(ratingDetailsActivity, this.A.get());
        RatingDetailsActivity_MembersInjector.injectPresenter(ratingDetailsActivity, this.V.get());
        RatingDetailsActivity_MembersInjector.injectDeepLinkIntentFactory(ratingDetailsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        RatingDetailsActivity_MembersInjector.injectFeatures(ratingDetailsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        RatingDetailsActivity_MembersInjector.injectAnalytics(ratingDetailsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        RatingDetailsActivity_MembersInjector.injectIntentFactory(ratingDetailsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}
