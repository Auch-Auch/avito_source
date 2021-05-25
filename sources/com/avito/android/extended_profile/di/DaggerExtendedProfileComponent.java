package com.avito.android.extended_profile.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert_core.contactbar.AdvertActionIconFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.ScreenTransferRecovery_Impl_Factory;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.extended_profile.ExtendedProfileContactsInteractor;
import com.avito.android.extended_profile.ExtendedProfileContactsInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileContactsInteractorImpl_Factory;
import com.avito.android.extended_profile.ExtendedProfileFragment;
import com.avito.android.extended_profile.ExtendedProfileFragment_MembersInjector;
import com.avito.android.extended_profile.ExtendedProfileInteractor;
import com.avito.android.extended_profile.ExtendedProfileInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileInteractorImpl_Factory;
import com.avito.android.extended_profile.ExtendedProfileResourceProvider;
import com.avito.android.extended_profile.ExtendedProfileResourceProviderImpl;
import com.avito.android.extended_profile.ExtendedProfileResourceProviderImpl_Factory;
import com.avito.android.extended_profile.ExtendedProfileSubscriptionInteractorImpl;
import com.avito.android.extended_profile.ExtendedProfileSubscriptionInteractorImpl_Factory;
import com.avito.android.extended_profile.ExtendedProfileViewModel;
import com.avito.android.extended_profile.ExtendedProfileViewModelFactory;
import com.avito.android.extended_profile.ExtendedProfileViewModelFactory_Factory;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup;
import com.avito.android.extended_profile.adapter.ExtendedProfileSpanLookup_Factory;
import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemBlueprint;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemPresenter;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemPresenterImpl;
import com.avito.android.extended_profile.adapter.badge_bar.BadgeBarItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.category.category_advert.di.CategoryAdvertItemModule_ProvideGalleryRatioFactory;
import com.avito.android.extended_profile.adapter.category.category_advert.di.CategoryAdvertItemModule_ProvideRecycledViewPoolFactory;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenterImpl;
import com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenterImpl;
import com.avito.android.extended_profile.adapter.category.category_advert.list.CategoryAdvertListItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemPresenterImpl;
import com.avito.android.extended_profile.adapter.category.category_button.CategoryButtonItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemBlueprint;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemPresenter;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemPresenterImpl;
import com.avito.android.extended_profile.adapter.category.category_header.CategoryHeaderItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemBlueprint;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemPresenter;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemPresenterImpl;
import com.avito.android.extended_profile.adapter.contact_bar.ContactBarItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.divider.DividerItemBlueprint;
import com.avito.android.extended_profile.adapter.divider.DividerItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.divider.DividerItemPresenter;
import com.avito.android.extended_profile.adapter.divider.DividerItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.error.ErrorItemBlueprint;
import com.avito.android.extended_profile.adapter.error.ErrorItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.error.ErrorItemPresenter;
import com.avito.android.extended_profile.adapter.error.ErrorItemPresenterImpl;
import com.avito.android.extended_profile.adapter.error.ErrorItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.gallery.GalleryItemBlueprint;
import com.avito.android.extended_profile.adapter.gallery.GalleryItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.gallery.GalleryItemPresenter;
import com.avito.android.extended_profile.adapter.gallery.GalleryItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.header.HeaderItemBlueprint;
import com.avito.android.extended_profile.adapter.header.HeaderItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.header.HeaderItemPresenter;
import com.avito.android.extended_profile.adapter.header.HeaderItemPresenterImpl;
import com.avito.android.extended_profile.adapter.header.HeaderItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.info.InfoItemBlueprint;
import com.avito.android.extended_profile.adapter.info.InfoItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.info.InfoItemPresenter;
import com.avito.android.extended_profile.adapter.info.InfoItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.progress.ProgressItemBlueprint;
import com.avito.android.extended_profile.adapter.progress.ProgressItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.progress.ProgressItemPresenter;
import com.avito.android.extended_profile.adapter.progress.ProgressItemPresenterImpl_Factory;
import com.avito.android.extended_profile.adapter.title.TitleItemBlueprint;
import com.avito.android.extended_profile.adapter.title.TitleItemBlueprint_Factory;
import com.avito.android.extended_profile.adapter.title.TitleItemPresenter;
import com.avito.android.extended_profile.adapter.title.TitleItemPresenterImpl_Factory;
import com.avito.android.extended_profile.di.ExtendedProfileComponent;
import com.avito.android.extended_profile.tracker.ExtendedProfileTracker;
import com.avito.android.extended_profile.tracker.ExtendedProfileTrackerImpl;
import com.avito.android.extended_profile.tracker.ExtendedProfileTrackerImpl_Factory;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerModule_ProvideNotificationManagerProviderFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.ExtendedPublicUserProfile;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl_Factory;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.remote.ExtendedProfileApi;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.serp.adapter.SerpAdvertConverter;
import com.avito.android.tns_gallery.TnsGalleryItemClickAction;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory;
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
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
public final class DaggerExtendedProfileComponent implements ExtendedProfileComponent {
    public Provider<ScreenTrackerFactory> A;
    public Provider<GalleryItemBlueprint> A0;
    public Provider<ScreenDiInjectTracker> B;
    public Provider<ItemBlueprint<?, ?>> B0;
    public Provider<ScreenInitTracker> C;
    public Provider<CategoryButtonItemPresenterImpl> C0;
    public Provider<ScreenFlowTrackerProvider> D;
    public Provider<CategoryButtonItemPresenter> D0;
    public Provider<ScreenTransferRecovery.Impl> E;
    public Provider<CategoryButtonItemBlueprint> E0;
    public Provider<ScreenTransferRecovery> F;
    public Provider<ItemBlueprint<?, ?>> F0;
    public Provider<ExtendedProfileTrackerImpl> G;
    public Provider<CategoryHeaderItemPresenterImpl> G0;
    public Provider<ExtendedProfileTracker> H;
    public Provider<CategoryHeaderItemPresenter> H0;
    public Provider<ExtendedProfileInteractorImpl> I;
    public Provider<CategoryHeaderItemBlueprint> I0;
    public Provider<ExtendedProfileInteractor> J;
    public Provider<ItemBlueprint<?, ?>> J0;
    public Provider<ExtendedProfileContactsInteractorImpl> K;
    public Provider<CategoryAdvertListItemPresenterImpl> K0;
    public Provider<ExtendedProfileContactsInteractor> L;
    public Provider<CategoryAdvertListItemPresenter> L0;
    public Provider<FavoriteAdvertsInteractor> M;
    public Provider<GalleryRatio> M0;
    public Provider<ViewedAdvertsEventInteractor> N;
    public Provider<RecyclerView.RecycledViewPool> N0;
    public Provider<ExtendedProfileResourceProviderImpl> O;
    public Provider<CategoryAdvertListItemBlueprint> O0;
    public Provider<ExtendedProfileResourceProvider> P;
    public Provider<ItemBlueprint<?, ?>> P0;
    public Provider<ErrorFormatterImpl> Q;
    public Provider<CategoryAdvertGridItemPresenterImpl> Q0;
    public Provider<ErrorFormatter> R;
    public Provider<CategoryAdvertGridItemPresenter> R0;
    public Provider<ErrorHelperImpl> S;
    public Provider<CategoryAdvertGridItemBlueprint> S0;
    public Provider<ErrorHelper> T;
    public Provider<ItemBlueprint<?, ?>> T0;
    public Provider<AdvertActionIconFactory> U;
    public Provider<ProgressItemPresenter> U0;
    public Provider<Analytics> V;
    public Provider<ProgressItemBlueprint> V0;
    public Provider<ExtendedProfileViewModelFactory> W;
    public Provider<ItemBlueprint<?, ?>> W0;
    public Provider<ViewModelProvider.Factory> X;
    public Provider<ErrorItemPresenterImpl> X0;
    public Provider<ExtendedProfileViewModel> Y;
    public Provider<ErrorItemPresenter> Y0;
    public Provider<CompositeSnackbarPresenter> Z;
    public Provider<ErrorItemBlueprint> Z0;
    public final ExtendedProfileDependencies a;
    public Provider<SubscriptionsPresenter> a0;
    public Provider<ItemBlueprint<?, ?>> a1;
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<HeaderItemPresenterImpl> b0;
    public Provider<Set<ItemBlueprint<?, ?>>> b1;
    public Provider<PublishRelay<ExtendedProfileItemAction>> c = DoubleCheck.provider(ExtendedProfileModule_ProvideActionRelayFactory.create());
    public Provider<HeaderItemPresenter> c0;
    public Provider<ItemBinder> c1;
    public Provider<Context> d;
    public Provider<HeaderItemBlueprint> d0;
    public Provider<AdapterPresenter> d1;
    public Provider<NotificationManagerCompat> e;
    public Provider<ItemBlueprint<?, ?>> e0;
    public Provider<DialogRouter> e1;
    public Provider<NotificationManagerProvider> f;
    public Provider<ContactBarItemPresenterImpl> f0;
    public Provider<Integer> f1;
    public Provider<FavoriteSellersRepository> g;
    public Provider<ContactBarItemPresenter> g0;
    public Provider<ExtendedProfileSpanLookup> g1;
    public Provider<AccountStateProvider> h;
    public Provider<ContactBarItemBlueprint> h0;
    public Provider<Resources> i;
    public Provider<ItemBlueprint<?, ?>> i0;
    public Provider<PublicProfileResourceProviderImpl> j;
    public Provider<DividerItemPresenter> j0;
    public Provider<SubscriptionsResourceProvider> k;
    public Provider<DividerItemBlueprint> k0;
    public Provider<FavoriteSellersApi> l;
    public Provider<ItemBlueprint<?, ?>> l0;
    public Provider<SchedulersFactory3> m;
    public Provider<TitleItemPresenter> m0;
    public Provider<ExtendedProfileSubscriptionInteractorImpl> n;
    public Provider<TitleItemBlueprint> n0;
    public Provider<SubscribeInteractor> o;
    public Provider<ItemBlueprint<?, ?>> o0;
    public Provider<Fragment> p;
    public Provider<InfoItemPresenter> p0;
    public Provider<String> q;
    public Provider<Boolean> q0;
    public Provider<ExtendedPublicUserProfile> r;
    public Provider<InfoItemBlueprint> r0;
    public Provider<String> s;
    public Provider<ItemBlueprint<?, ?>> s0;
    public Provider<ExtendedProfileApi> t;
    public Provider<BadgeBarItemPresenterImpl> t0;
    public Provider<PublicProfileApi> u;
    public Provider<BadgeBarItemPresenter> u0;
    public Provider<FavoritesSyncDao> v;
    public Provider<BadgeBarItemBlueprint> v0;
    public Provider<ViewedAdvertsDao> w;
    public Provider<ItemBlueprint<?, ?>> w0;
    public Provider<Features> x;
    public Provider<GalleryItemPresenter> x0;
    public Provider<SerpAdvertConverter> y;
    public Provider<PublishRelay<TnsGalleryItemClickAction>> y0;
    public Provider<TypedErrorThrowableConverter> z;
    public Provider<Activity> z0;

    public static final class b implements ExtendedProfileComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.extended_profile.di.ExtendedProfileComponent.Factory
        public ExtendedProfileComponent create(String str, ExtendedPublicUserProfile extendedPublicUserProfile, String str2, TreeClickStreamParent treeClickStreamParent, Activity activity, Fragment fragment, Resources resources, ExtendedProfileDependencies extendedProfileDependencies) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(extendedPublicUserProfile);
            Preconditions.checkNotNull(activity);
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(extendedProfileDependencies);
            return new DaggerExtendedProfileComponent(new NotificationManagerModule(), extendedProfileDependencies, str, extendedPublicUserProfile, str2, treeClickStreamParent, activity, fragment, resources, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final ExtendedProfileDependencies a;

        public c(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final ExtendedProfileDependencies a;

        public d(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Context> {
        public final ExtendedProfileDependencies a;

        public e(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class f implements Provider<ExtendedProfileApi> {
        public final ExtendedProfileDependencies a;

        public f(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExtendedProfileApi get() {
            return (ExtendedProfileApi) Preconditions.checkNotNullFromComponent(this.a.extendedProfileApi());
        }
    }

    public static class g implements Provider<FavoriteAdvertsInteractor> {
        public final ExtendedProfileDependencies a;

        public g(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class h implements Provider<FavoriteSellersApi> {
        public final ExtendedProfileDependencies a;

        public h(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class i implements Provider<FavoriteSellersRepository> {
        public final ExtendedProfileDependencies a;

        public i(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersRepository get() {
            return (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository());
        }
    }

    public static class j implements Provider<FavoritesSyncDao> {
        public final ExtendedProfileDependencies a;

        public j(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class k implements Provider<Features> {
        public final ExtendedProfileDependencies a;

        public k(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class l implements Provider<PublicProfileApi> {
        public final ExtendedProfileDependencies a;

        public l(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublicProfileApi get() {
            return (PublicProfileApi) Preconditions.checkNotNullFromComponent(this.a.publicProfileApi());
        }
    }

    public static class m implements Provider<SchedulersFactory3> {
        public final ExtendedProfileDependencies a;

        public m(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class n implements Provider<ScreenTrackerFactory> {
        public final ExtendedProfileDependencies a;

        public n(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class o implements Provider<TypedErrorThrowableConverter> {
        public final ExtendedProfileDependencies a;

        public o(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class p implements Provider<ViewedAdvertsDao> {
        public final ExtendedProfileDependencies a;

        public p(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsDao get() {
            return (ViewedAdvertsDao) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsDao());
        }
    }

    public static class q implements Provider<ViewedAdvertsEventInteractor> {
        public final ExtendedProfileDependencies a;

        public q(ExtendedProfileDependencies extendedProfileDependencies) {
            this.a = extendedProfileDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ViewedAdvertsEventInteractor get() {
            return (ViewedAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.viewedAdvertsEventInteractor());
        }
    }

    public DaggerExtendedProfileComponent(NotificationManagerModule notificationManagerModule, ExtendedProfileDependencies extendedProfileDependencies, String str, ExtendedPublicUserProfile extendedPublicUserProfile, String str2, TreeClickStreamParent treeClickStreamParent, Activity activity, Fragment fragment, Resources resources, a aVar) {
        this.a = extendedProfileDependencies;
        e eVar = new e(extendedProfileDependencies);
        this.d = eVar;
        Provider<NotificationManagerCompat> provider = DoubleCheck.provider(ExtendedProfileModule_ProvideNotificationManagerFactory.create(eVar));
        this.e = provider;
        this.f = NotificationManagerModule_ProvideNotificationManagerProviderFactory.create(notificationManagerModule, provider);
        this.g = new i(extendedProfileDependencies);
        this.h = new c(extendedProfileDependencies);
        Factory create = InstanceFactory.create(resources);
        this.i = create;
        PublicProfileResourceProviderImpl_Factory create2 = PublicProfileResourceProviderImpl_Factory.create(create);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        h hVar = new h(extendedProfileDependencies);
        this.l = hVar;
        m mVar = new m(extendedProfileDependencies);
        this.m = mVar;
        ExtendedProfileSubscriptionInteractorImpl_Factory create3 = ExtendedProfileSubscriptionInteractorImpl_Factory.create(hVar, this.f, mVar);
        this.n = create3;
        this.o = DoubleCheck.provider(create3);
        this.p = InstanceFactory.create(fragment);
        this.q = InstanceFactory.create(str);
        this.r = InstanceFactory.create(extendedPublicUserProfile);
        this.s = InstanceFactory.createNullable(str2);
        this.t = new f(extendedProfileDependencies);
        this.u = new l(extendedProfileDependencies);
        this.v = new j(extendedProfileDependencies);
        this.w = new p(extendedProfileDependencies);
        k kVar = new k(extendedProfileDependencies);
        this.x = kVar;
        this.y = SingleCheck.provider(ExtendedProfileModule_ProvideAdvertConverterFactory.create(this.i, kVar));
        this.z = new o(extendedProfileDependencies);
        n nVar = new n(extendedProfileDependencies);
        this.A = nVar;
        this.B = DoubleCheck.provider(ExtendedProfileTrackerModule_ProvidesScreenDiInjectTracker$extended_profile_releaseFactory.create(nVar, TimerFactory_Factory.create()));
        this.C = DoubleCheck.provider(ExtendedProfileTrackerModule_ProvidesScreenInitTrackerFactory.create(this.A, TimerFactory_Factory.create()));
        this.D = DoubleCheck.provider(ExtendedProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.A, TimerFactory_Factory.create()));
        ScreenTransferRecovery_Impl_Factory create4 = ScreenTransferRecovery_Impl_Factory.create(this.A, TimerFactory_Factory.create());
        this.E = create4;
        Provider<ScreenTransferRecovery> provider2 = DoubleCheck.provider(create4);
        this.F = provider2;
        ExtendedProfileTrackerImpl_Factory create5 = ExtendedProfileTrackerImpl_Factory.create(this.B, this.C, this.D, provider2);
        this.G = create5;
        Provider<ExtendedProfileTracker> provider3 = DoubleCheck.provider(create5);
        this.H = provider3;
        ExtendedProfileInteractorImpl_Factory create6 = ExtendedProfileInteractorImpl_Factory.create(this.t, this.u, this.v, this.w, this.m, this.y, this.z, provider3);
        this.I = create6;
        this.J = DoubleCheck.provider(create6);
        ExtendedProfileContactsInteractorImpl_Factory create7 = ExtendedProfileContactsInteractorImpl_Factory.create(this.t, this.m);
        this.K = create7;
        this.L = DoubleCheck.provider(create7);
        this.M = new g(extendedProfileDependencies);
        this.N = new q(extendedProfileDependencies);
        ExtendedProfileResourceProviderImpl_Factory create8 = ExtendedProfileResourceProviderImpl_Factory.create(this.i);
        this.O = create8;
        this.P = DoubleCheck.provider(create8);
        ErrorFormatterImpl_Factory create9 = ErrorFormatterImpl_Factory.create(this.i);
        this.Q = create9;
        Provider<ErrorFormatter> provider4 = SingleCheck.provider(create9);
        this.R = provider4;
        ErrorHelperImpl_Factory create10 = ErrorHelperImpl_Factory.create(provider4);
        this.S = create10;
        this.T = SingleCheck.provider(create10);
        Provider<AdvertActionIconFactory> provider5 = DoubleCheck.provider(ExtendedProfileModule_ProvideAdvertActionIconFactory$extended_profile_releaseFactory.create(this.d));
        this.U = provider5;
        d dVar = new d(extendedProfileDependencies);
        this.V = dVar;
        ExtendedProfileViewModelFactory_Factory create11 = ExtendedProfileViewModelFactory_Factory.create(this.q, this.r, this.s, this.J, this.L, this.M, this.g, this.N, this.h, this.P, this.m, this.T, provider5, this.H, dVar);
        this.W = create11;
        Provider<ViewModelProvider.Factory> provider6 = DoubleCheck.provider(create11);
        this.X = provider6;
        this.Y = DoubleCheck.provider(ExtendedProfileModule_ProvideViewModelFactory.create(this.p, provider6));
        Provider<CompositeSnackbarPresenter> provider7 = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        this.Z = provider7;
        Provider<SubscriptionsPresenter> provider8 = DoubleCheck.provider(ExtendedProfileModule_ProvideSubscriptionsPresenterFactory.create(this.f, this.g, this.h, this.k, this.o, this.Y, this.T, this.V, this.m, provider7, this.x));
        this.a0 = provider8;
        HeaderItemPresenterImpl_Factory create12 = HeaderItemPresenterImpl_Factory.create(this.c, provider8, this.Z);
        this.b0 = create12;
        Provider<HeaderItemPresenter> provider9 = DoubleCheck.provider(create12);
        this.c0 = provider9;
        HeaderItemBlueprint_Factory create13 = HeaderItemBlueprint_Factory.create(provider9);
        this.d0 = create13;
        this.e0 = DoubleCheck.provider(create13);
        ContactBarItemPresenterImpl_Factory create14 = ContactBarItemPresenterImpl_Factory.create(this.c);
        this.f0 = create14;
        Provider<ContactBarItemPresenter> provider10 = DoubleCheck.provider(create14);
        this.g0 = provider10;
        ContactBarItemBlueprint_Factory create15 = ContactBarItemBlueprint_Factory.create(provider10, this.x);
        this.h0 = create15;
        this.i0 = DoubleCheck.provider(create15);
        Provider<DividerItemPresenter> provider11 = DoubleCheck.provider(DividerItemPresenterImpl_Factory.create());
        this.j0 = provider11;
        DividerItemBlueprint_Factory create16 = DividerItemBlueprint_Factory.create(provider11);
        this.k0 = create16;
        this.l0 = DoubleCheck.provider(create16);
        Provider<TitleItemPresenter> provider12 = DoubleCheck.provider(TitleItemPresenterImpl_Factory.create());
        this.m0 = provider12;
        TitleItemBlueprint_Factory create17 = TitleItemBlueprint_Factory.create(provider12);
        this.n0 = create17;
        this.o0 = DoubleCheck.provider(create17);
        this.p0 = DoubleCheck.provider(InfoItemPresenterImpl_Factory.create());
        Provider<Boolean> provider13 = DoubleCheck.provider(ExtendedProfileModule_ProvideIsTabletFactory.create(this.i));
        this.q0 = provider13;
        InfoItemBlueprint_Factory create18 = InfoItemBlueprint_Factory.create(this.p0, provider13);
        this.r0 = create18;
        this.s0 = DoubleCheck.provider(create18);
        BadgeBarItemPresenterImpl_Factory create19 = BadgeBarItemPresenterImpl_Factory.create(this.c);
        this.t0 = create19;
        Provider<BadgeBarItemPresenter> provider14 = DoubleCheck.provider(create19);
        this.u0 = provider14;
        BadgeBarItemBlueprint_Factory create20 = BadgeBarItemBlueprint_Factory.create(provider14);
        this.v0 = create20;
        this.w0 = DoubleCheck.provider(create20);
        this.x0 = DoubleCheck.provider(GalleryItemPresenterImpl_Factory.create());
        this.y0 = DoubleCheck.provider(ExtendedProfileModule_ProvideCommentGalleryClicksStream$extended_profile_releaseFactory.create());
        Factory create21 = InstanceFactory.create(activity);
        this.z0 = create21;
        GalleryItemBlueprint_Factory create22 = GalleryItemBlueprint_Factory.create(this.x0, this.y0, create21, this.x);
        this.A0 = create22;
        this.B0 = DoubleCheck.provider(create22);
        CategoryButtonItemPresenterImpl_Factory create23 = CategoryButtonItemPresenterImpl_Factory.create(this.c);
        this.C0 = create23;
        Provider<CategoryButtonItemPresenter> provider15 = DoubleCheck.provider(create23);
        this.D0 = provider15;
        CategoryButtonItemBlueprint_Factory create24 = CategoryButtonItemBlueprint_Factory.create(provider15, this.q0);
        this.E0 = create24;
        this.F0 = DoubleCheck.provider(create24);
        CategoryHeaderItemPresenterImpl_Factory create25 = CategoryHeaderItemPresenterImpl_Factory.create(this.c);
        this.G0 = create25;
        Provider<CategoryHeaderItemPresenter> provider16 = DoubleCheck.provider(create25);
        this.H0 = provider16;
        CategoryHeaderItemBlueprint_Factory create26 = CategoryHeaderItemBlueprint_Factory.create(provider16);
        this.I0 = create26;
        this.J0 = DoubleCheck.provider(create26);
        CategoryAdvertListItemPresenterImpl_Factory create27 = CategoryAdvertListItemPresenterImpl_Factory.create(this.c);
        this.K0 = create27;
        this.L0 = DoubleCheck.provider(create27);
        this.M0 = DoubleCheck.provider(CategoryAdvertItemModule_ProvideGalleryRatioFactory.create());
        Provider<RecyclerView.RecycledViewPool> provider17 = DoubleCheck.provider(CategoryAdvertItemModule_ProvideRecycledViewPoolFactory.create());
        this.N0 = provider17;
        CategoryAdvertListItemBlueprint_Factory create28 = CategoryAdvertListItemBlueprint_Factory.create(this.L0, this.M0, provider17, this.q0);
        this.O0 = create28;
        this.P0 = DoubleCheck.provider(create28);
        CategoryAdvertGridItemPresenterImpl_Factory create29 = CategoryAdvertGridItemPresenterImpl_Factory.create(this.c);
        this.Q0 = create29;
        Provider<CategoryAdvertGridItemPresenter> provider18 = DoubleCheck.provider(create29);
        this.R0 = provider18;
        CategoryAdvertGridItemBlueprint_Factory create30 = CategoryAdvertGridItemBlueprint_Factory.create(provider18, this.q0);
        this.S0 = create30;
        this.T0 = DoubleCheck.provider(create30);
        Provider<ProgressItemPresenter> provider19 = DoubleCheck.provider(ProgressItemPresenterImpl_Factory.create());
        this.U0 = provider19;
        ProgressItemBlueprint_Factory create31 = ProgressItemBlueprint_Factory.create(provider19);
        this.V0 = create31;
        this.W0 = DoubleCheck.provider(create31);
        ErrorItemPresenterImpl_Factory create32 = ErrorItemPresenterImpl_Factory.create(this.c);
        this.X0 = create32;
        Provider<ErrorItemPresenter> provider20 = DoubleCheck.provider(create32);
        this.Y0 = provider20;
        ErrorItemBlueprint_Factory create33 = ErrorItemBlueprint_Factory.create(provider20);
        this.Z0 = create33;
        this.a1 = DoubleCheck.provider(create33);
        SetFactory build = SetFactory.builder(13, 1).addCollectionProvider(this.b).addProvider(this.e0).addProvider(this.i0).addProvider(this.l0).addProvider(this.o0).addProvider(this.s0).addProvider(this.w0).addProvider(this.B0).addProvider(this.F0).addProvider(this.J0).addProvider(this.P0).addProvider(this.T0).addProvider(this.W0).addProvider(this.a1).build();
        this.b1 = build;
        Provider<ItemBinder> provider21 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.c1 = provider21;
        this.d1 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider21));
        this.e1 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(this.z0));
        Provider<Integer> provider22 = DoubleCheck.provider(ExtendedProfileModule_ProvideAdvertsColumnCountFactory.create(this.i));
        this.f1 = provider22;
        this.g1 = ExtendedProfileSpanLookup_Factory.create(provider22);
    }

    public static ExtendedProfileComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.extended_profile.di.ExtendedProfileComponent
    public void inject(ExtendedProfileFragment extendedProfileFragment) {
        ExtendedProfileFragment_MembersInjector.injectIntentFactory(extendedProfileFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ExtendedProfileFragment_MembersInjector.injectDeepLinkIntentFactory(extendedProfileFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ExtendedProfileFragment_MembersInjector.injectImplicitIntentFactory(extendedProfileFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        ExtendedProfileFragment_MembersInjector.injectAdapterPresenter(extendedProfileFragment, this.d1.get());
        ExtendedProfileFragment_MembersInjector.injectSnackbarPresenter(extendedProfileFragment, this.Z.get());
        ExtendedProfileFragment_MembersInjector.injectItemBinder(extendedProfileFragment, this.c1.get());
        ExtendedProfileFragment_MembersInjector.injectViewModel(extendedProfileFragment, this.Y.get());
        ExtendedProfileFragment_MembersInjector.injectClicks(extendedProfileFragment, this.c.get());
        ExtendedProfileFragment_MembersInjector.injectGalleryClicks(extendedProfileFragment, this.y0.get());
        ExtendedProfileFragment_MembersInjector.injectSubscriptionsPresenter(extendedProfileFragment, this.a0.get());
        ExtendedProfileFragment_MembersInjector.injectFeatures(extendedProfileFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        ExtendedProfileFragment_MembersInjector.injectPhoneFormatter(extendedProfileFragment, PhoneNumberFormatterModule_ProvidePhoneNumberFormatterWithCountryCodeFactory.providePhoneNumberFormatterWithCountryCode());
        ExtendedProfileFragment_MembersInjector.injectDialogRouter(extendedProfileFragment, this.e1.get());
        ExtendedProfileFragment_MembersInjector.injectSchedulersFactory3(extendedProfileFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        ExtendedProfileFragment_MembersInjector.injectIsTablet(extendedProfileFragment, this.q0.get().booleanValue());
        ExtendedProfileFragment_MembersInjector.injectColumnCount(extendedProfileFragment, this.f1.get().intValue());
        ExtendedProfileFragment_MembersInjector.injectSpanLookup(extendedProfileFragment, DoubleCheck.lazy(this.g1));
    }
}
