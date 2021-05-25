package com.avito.android.user_stats.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AppFeatures;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.app.task.ApplicationStartupTasksRegistry;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.user_stats.UserStatsFragment;
import com.avito.android.user_stats.UserStatsFragment_MembersInjector;
import com.avito.android.user_stats.UserStatsInteractor;
import com.avito.android.user_stats.UserStatsInteractorImpl;
import com.avito.android.user_stats.UserStatsInteractorImpl_Factory;
import com.avito.android.user_stats.UserStatsResourcesProvider;
import com.avito.android.user_stats.UserStatsResourcesProviderImpl;
import com.avito.android.user_stats.UserStatsResourcesProviderImpl_Factory;
import com.avito.android.user_stats.UserStatsViewModel;
import com.avito.android.user_stats.UserStatsViewModelFactory;
import com.avito.android.user_stats.UserStatsViewModelFactory_Factory;
import com.avito.android.user_stats.di.UserStatsComponent;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorageImpl;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorageImpl_Factory;
import com.avito.android.user_stats.tab.ActiveMonthIndexHolder;
import com.avito.android.user_stats.tab.UserStatsProvider;
import com.avito.android.user_stats.tab.UserStatsTabItemConverter;
import com.avito.android.user_stats.tab.UserStatsTabItemConverterImpl_Factory;
import com.avito.android.user_stats.tracker.UserStatsTracker;
import com.avito.android.user_stats.tracker.UserStatsTrackerImpl;
import com.avito.android.user_stats.tracker.UserStatsTrackerImpl_Factory;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.user_stats.UserStatsApi;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerUserStatsComponent implements UserStatsComponent {
    public Provider<UserStatsTracker> A;
    public Provider<UserStatsViewModelFactory> B;
    public Provider<UserStatsViewModel> C;
    public final UserStatsDependencies a;
    public final Resources b;
    public Provider<Fragment> c;
    public Provider<ViewModelStoreOwner> d;
    public Provider<SavedStateRegistryOwner> e = DoubleCheck.provider(this.c);
    public Provider<UserStatsApi> f;
    public Provider<SchedulersFactory3> g;
    public Provider<Application> h;
    public Provider<PreferenceFactory> i;
    public Provider<Preferences> j;
    public Provider<SmbStatsTooltipSessionStorageImpl> k;
    public Provider<SmbStatsTooltipSessionStorage> l;
    public Provider<UserStatsInteractorImpl> m;
    public Provider<UserStatsInteractor> n;
    public Provider<TypedErrorThrowableConverter> o;
    public Provider<Resources> p;
    public Provider<UserStatsResourcesProviderImpl> q;
    public Provider<UserStatsResourcesProvider> r;
    public Provider<UserStatsTabItemConverter> s;
    public Provider<Analytics> t;
    public Provider<ScreenTrackerFactory> u;
    public Provider<TimerFactory> v;
    public Provider<ScreenDiInjectTracker> w;
    public Provider<ScreenInitTracker> x;
    public Provider<ScreenFlowTrackerProvider> y;
    public Provider<UserStatsTrackerImpl> z;

    public static final class b implements UserStatsComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.user_stats.di.UserStatsComponent.Factory
        public UserStatsComponent create(Fragment fragment, Resources resources, UserStatsDependencies userStatsDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(userStatsDependencies);
            return new DaggerUserStatsComponent(userStatsDependencies, fragment, resources, null);
        }
    }

    public static class c implements Provider<Analytics> {
        public final UserStatsDependencies a;

        public c(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<Application> {
        public final UserStatsDependencies a;

        public d(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e implements Provider<PreferenceFactory> {
        public final UserStatsDependencies a;

        public e(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PreferenceFactory get() {
            return (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferenceFactory());
        }
    }

    public static class f implements Provider<SchedulersFactory3> {
        public final UserStatsDependencies a;

        public f(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class g implements Provider<ScreenTrackerFactory> {
        public final UserStatsDependencies a;

        public g(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class h implements Provider<TimerFactory> {
        public final UserStatsDependencies a;

        public h(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class i implements Provider<TypedErrorThrowableConverter> {
        public final UserStatsDependencies a;

        public i(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class j implements Provider<UserStatsApi> {
        public final UserStatsDependencies a;

        public j(UserStatsDependencies userStatsDependencies) {
            this.a = userStatsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserStatsApi get() {
            return (UserStatsApi) Preconditions.checkNotNullFromComponent(this.a.userStatsApi());
        }
    }

    public DaggerUserStatsComponent(UserStatsDependencies userStatsDependencies, Fragment fragment, Resources resources, a aVar) {
        this.a = userStatsDependencies;
        this.b = resources;
        Factory create = InstanceFactory.create(fragment);
        this.c = create;
        this.d = DoubleCheck.provider(create);
        this.f = new j(userStatsDependencies);
        this.g = new f(userStatsDependencies);
        d dVar = new d(userStatsDependencies);
        this.h = dVar;
        e eVar = new e(userStatsDependencies);
        this.i = eVar;
        UserStatsStorageModule_ProvideEditorPreferencesFactory create2 = UserStatsStorageModule_ProvideEditorPreferencesFactory.create(dVar, eVar);
        this.j = create2;
        SmbStatsTooltipSessionStorageImpl_Factory create3 = SmbStatsTooltipSessionStorageImpl_Factory.create(create2);
        this.k = create3;
        Provider<SmbStatsTooltipSessionStorage> provider = DoubleCheck.provider(create3);
        this.l = provider;
        UserStatsInteractorImpl_Factory create4 = UserStatsInteractorImpl_Factory.create(this.f, this.g, provider);
        this.m = create4;
        this.n = DoubleCheck.provider(create4);
        this.o = new i(userStatsDependencies);
        Factory create5 = InstanceFactory.create(resources);
        this.p = create5;
        UserStatsResourcesProviderImpl_Factory create6 = UserStatsResourcesProviderImpl_Factory.create(create5);
        this.q = create6;
        this.r = DoubleCheck.provider(create6);
        this.s = DoubleCheck.provider(UserStatsTabItemConverterImpl_Factory.create());
        this.t = new c(userStatsDependencies);
        g gVar = new g(userStatsDependencies);
        this.u = gVar;
        h hVar = new h(userStatsDependencies);
        this.v = hVar;
        this.w = DoubleCheck.provider(UserStatsTrackerModule_ProvideScreenDiInjectTrackerFactory.create(gVar, hVar));
        this.x = DoubleCheck.provider(UserStatsTrackerModule_ProvideScreenInitTrackerFactory.create(this.u, this.v));
        Provider<ScreenFlowTrackerProvider> provider2 = DoubleCheck.provider(UserStatsTrackerModule_ProvideScreenFlowTrackerProviderFactory.create(this.u, this.v));
        this.y = provider2;
        UserStatsTrackerImpl_Factory create7 = UserStatsTrackerImpl_Factory.create(this.w, this.x, provider2);
        this.z = create7;
        Provider<UserStatsTracker> provider3 = DoubleCheck.provider(create7);
        this.A = provider3;
        UserStatsViewModelFactory_Factory create8 = UserStatsViewModelFactory_Factory.create(this.e, this.n, this.g, this.o, this.r, this.s, this.t, provider3);
        this.B = create8;
        this.C = DoubleCheck.provider(UserStatsModule_ProvideUserStatsFactory.create(this.d, create8));
    }

    public static UserStatsComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public ActiveMonthIndexHolder activeMonthIndexHolder() {
        return this.C.get();
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies, com.avito.android.rating.publish.select_rating.di.SelectRatingDependencies, com.avito.android.rating.publish.review_input.di.ReviewInputDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.user_favorites.di.UserFavoritesDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.blocked_ip.di.BlockedIpDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    public ActivityIntentFactory activityIntentFactory() {
        return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.ui.activity.BaseActivityComponentDependencies, com.avito.android.cart_fab.CartFabDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.buyer_info.di.BuyerInfoDependencies, com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies, com.avito.android.rating.publish.deal_stage.di.DealStageDependencies, com.avito.android.rating.publish.select_rating.di.SelectRatingDependencies, com.avito.android.rating.publish.review_input.di.ReviewInputDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_contacts.di.UserContactsDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.theme_settings.di.ThemeSettingsDependencies, com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.publish.drafts.di.PublishDraftsDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.di.CoreComponentDependencies
    public AppFeatures appFeatures() {
        return (AppFeatures) Preconditions.checkNotNullFromComponent(this.a.appFeatures());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.favorite_sellers.service.di.FavoriteSellerServiceDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies
    public Application application() {
        return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    public BuildInfo buildInfo() {
        return (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.social.di.SocialActivityDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies
    public Context context() {
        return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public DeepLinkIntentFactory deepLinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.advert.specifications.di.SpecificationsDependencies, com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies
    public DeviceMetrics deviceMetrics() {
        return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.ui.activity.BaseActivityComponentDependencies, com.avito.android.cart_fab.CartFabDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_advert.advert.service.di.UserAdvertServiceDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.favorites.di.FavoriteAdvertsServiceDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.social.di.esia.EsiaAuthDependencies, com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.blocked_ip.di.BlockedIpDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.item_map.di.ItemMapDependencies
    public ImplicitIntentFactory implicitIntentFactory() {
        return (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory());
    }

    @Override // com.avito.android.user_stats.di.UserStatsComponent
    public void inject(UserStatsFragment userStatsFragment) {
        UserStatsFragment_MembersInjector.injectAnalytics(userStatsFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserStatsFragment_MembersInjector.injectViewModel(userStatsFragment, this.C.get());
        UserStatsFragment_MembersInjector.injectUserStatsTracker(userStatsFragment, this.A.get());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies
    public RandomKeyProvider randomKeyProvider() {
        return (RandomKeyProvider) Preconditions.checkNotNullFromComponent(this.a.randomKeyProvider());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public Resources resources() {
        return this.b;
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.rating.publish.deal_proofs.di.DealProofsDependencies, com.avito.android.user_favorites.di.UserFavoritesDependencies, com.avito.android.notification_center.landing.share.NotificationCenterLandingShareDependencies, com.avito.android.fees.di.PackageFeeComponentDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.user_adverts.items_search.di.ProfileItemsSearchDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.di.CoreComponentDependencies, com.avito.android.rating.publish.select_advert.di.SelectAdvertDependencies, com.avito.android.rating.publish.buyer_info.di.BuyerInfoDependencies, com.avito.android.rating.publish.deal_stage.di.DealStageDependencies, com.avito.android.rating.publish.select_rating.di.SelectRatingDependencies, com.avito.android.rating.publish.review_input.di.ReviewInputDependencies, com.avito.android.rating.publish.di.RatingPublishDependencies, com.avito.android.rating.user_contacts.di.UserContactsDependencies, com.avito.android.rating.user_review_details.di.UserReviewDetailsDependencies, com.avito.android.user_favorites.di.UserFavoritesDependencies, com.avito.android.grouping_adverts.di.GroupingAdvertsDependencies, com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies, com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentDependencies, com.avito.android.di.component.HomeActivityDependencies, com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies
    public SchedulersFactory3 schedulersFactory3() {
        return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public ScreenTrackerFactory screenTrackerFactory() {
        return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
    }

    @Override // com.avito.android.di.CoreComponentDependencies
    public ApplicationStartupTasksRegistry startupTasksRegistry() {
        return (ApplicationStartupTasksRegistry) Preconditions.checkNotNullFromComponent(this.a.startupTasksRegistry());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public TimerFactory timerFactory() {
        return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public UserStatsApi userStatsApi() {
        return (UserStatsApi) Preconditions.checkNotNullFromComponent(this.a.userStatsApi());
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public UserStatsProvider userStatsProvider() {
        return this.C.get();
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public UserStatsResourcesProvider userStatsResourcesProvider() {
        return this.r.get();
    }

    @Override // com.avito.android.user_stats.di.UserStatsTabDependencies
    public UserStatsViewModel userStatsViewModel() {
        return this.C.get();
    }
}
