package com.avito.android.user_advert.di;

import android.app.Activity;
import android.app.Application;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.IdProviderImpl_Factory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTracker;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTrackerImpl;
import com.avito.android.advert_core.analytics.delivery.DeliveryEventTrackerImpl_Factory;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTracker;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTrackerImpl;
import com.avito.android.advert_core.analytics.sharing.AdvertSharingEventTrackerImpl_Factory;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgeItemConverterImpl_Factory;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenter;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenterImpl;
import com.avito.android.advert_core.car_market_price.badge.AdvertDetailsImvBadgePresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProvider;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProviderImpl;
import com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartResourceProviderImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenterImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionPresenterImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProvider;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceDescriptionResourceProviderImpl_Factory;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverter;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverterImpl;
import com.avito.android.advert_core.car_market_price.price_description.CarMarketPriceSwitchConverterImpl_Factory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepository;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepositoryImpl;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockRepositoryImpl_Factory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModel;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelFactory;
import com.avito.android.advert_core.delivery.AdvertDeliveryBlockViewModelFactory_Factory;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory;
import com.avito.android.advert_core.di.module.AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory;
import com.avito.android.advert_core.di.module.AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory;
import com.avito.android.advert_core.di.module.AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory;
import com.avito.android.advert_core.feature_teasers.common.CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory;
import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserPresenter;
import com.avito.android.advert_core.feature_teasers.common.CommonFeatureTeaserPresenter_Factory;
import com.avito.android.advert_core.feature_teasers.common.di.CommonFeatureTeaserModule_ProvideAdapterFactory;
import com.avito.android.advert_core.feature_teasers.common.di.CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogItemsAdapter;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemBlueprint;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemPresenter;
import com.avito.android.advert_core.feature_teasers.common.dialog.AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory;
import com.avito.android.advert_core.feature_teasers.common.dialog.CommonFeatureTeaserDialogFactory_Factory;
import com.avito.android.advert_core.feature_teasers.common.dialog.FeatureTeaserDialogFactory;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint;
import com.avito.android.advert_core.gap.AdvertDetailsGapBlueprint_Factory;
import com.avito.android.advert_core.gap.AdvertDetailsGapPresenterImpl_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealResourceProvider;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealResourceProvider_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractor;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractorImpl;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesInteractorImpl_Factory;
import com.avito.android.advert_core.safedeal.MyAdvertSafeDealServicesViewModel;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory;
import com.avito.android.advert_core.safedeal.MyAdvertSafedealServicesViewModelFactory_Factory;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory;
import com.avito.android.advert_core.safedeal.di.MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractor;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractorImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockAnalyticsInteractorImpl_Factory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractor;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractorImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockInteractorImpl_Factory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModel;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModelFactory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewModelFactory_Factory;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewResourceProvider;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewResourceProviderImpl;
import com.avito.android.advert_core.short_term_rent.AdvertStrBlockViewResourceProviderImpl_Factory;
import com.avito.android.advert_core.social.ShareModule_ProvideSocialPresenterFactory;
import com.avito.android.advert_core.social.SocialPresenter;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.bivrost.BivrostTutorialSessionStorage;
import com.avito.android.analytics.di.BivrostStatisticsModule_ProvideBivrostStorageFactory;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.app_rater.AppRaterInteractorImpl;
import com.avito.android.app_rater.AppRaterInteractorImpl_Factory;
import com.avito.android.app_rater.PrefAppRaterSessionStorage;
import com.avito.android.app_rater.PrefAppRaterSessionStorage_Factory;
import com.avito.android.booking.remote.BookingApi;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl;
import com.avito.android.date_time_formatter.DateTimeFormatterResourceProviderImpl_Factory;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
import com.avito.android.di.module.DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.permissions.PermissionStateProvider;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.PublishLimitsApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertDeliveryC2C;
import com.avito.android.remote.model.AdvertSellerShortTermRent;
import com.avito.android.remote.model.MyAdvertSafeDeal;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.shared_providers.SupportEmailResourceProvider;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl_Factory;
import com.avito.android.social.LiveJournalSocialManager;
import com.avito.android.social.LiveJournalSocialManagerImpl_Factory;
import com.avito.android.social.MailSocialManager;
import com.avito.android.social.MailSocialManagerImpl_Factory;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl_Factory;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.TwitterSocialManager;
import com.avito.android.social.TwitterSocialManagerImpl_Factory;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManagerImpl_Factory;
import com.avito.android.social.button.ShareSocialInfoProvider_Factory;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.user_advert.advert.AdvertAddressFormatter;
import com.avito.android.user_advert.advert.AdvertAddressFormatterImpl;
import com.avito.android.user_advert.advert.AdvertAddressFormatterImpl_Factory;
import com.avito.android.user_advert.advert.DetailsId;
import com.avito.android.user_advert.advert.MyAdvertDetailsActionMenuConverter;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivity;
import com.avito.android.user_advert.advert.MyAdvertDetailsActivity_MembersInjector;
import com.avito.android.user_advert.advert.MyAdvertDetailsConverter;
import com.avito.android.user_advert.advert.MyAdvertDetailsConverterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsConverterImpl_Factory;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractor;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractorImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsInteractorImpl_Factory;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenter;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsPresenterImpl_Factory;
import com.avito.android.user_advert.advert.MyAdvertDetailsResourceProvider;
import com.avito.android.user_advert.advert.MyAdvertDetailsResourceProviderImpl;
import com.avito.android.user_advert.advert.MyAdvertDetailsResourceProviderImpl_Factory;
import com.avito.android.user_advert.advert.MyAdvertStorage;
import com.avito.android.user_advert.advert.MyAdvertStorageImpl;
import com.avito.android.user_advert.advert.MyAdvertStorageImpl_Factory;
import com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractor;
import com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractorImpl;
import com.avito.android.user_advert.advert.MyDraftAdvertDetailsInteractorImpl_Factory;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockResourceProvider;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockResourceProvider_Factory;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModel;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModelFactory;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingBlockViewModelFactory_Factory;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingChangeStateInteractor;
import com.avito.android.user_advert.advert.autobooking_block.AutoBookingChangeStateInteractor_Factory;
import com.avito.android.user_advert.advert.autobooking_block.di.AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockResourceProvider;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockResourceProvider_Factory;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModel;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModelFactory;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishBlockViewModelFactory_Factory;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishChangeStateInteractor;
import com.avito.android.user_advert.advert.autopublish_block.AutoPublishChangeStateInteractor_Factory;
import com.avito.android.user_advert.advert.autopublish_block.di.AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenterImpl;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserPresenterImpl_Factory;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserResourceProvider;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserResourceProvider_Factory;
import com.avito.android.user_advert.advert.feature_teasers.MyAdvertDetailsFeatureTeaserViewFactory;
import com.avito.android.user_advert.advert.verification.VerificationItemConverter;
import com.avito.android.user_advert.advert.verification.VerificationItemConverterImpl;
import com.avito.android.user_advert.advert.verification.VerificationItemConverterImpl_Factory;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenter;
import com.avito.android.user_advert.contact.MyAdvertContactsPresenterImpl_Factory;
import com.avito.android.user_advert.di.MyAdvertDetailsComponent;
import com.avito.android.user_advert.limits_info.LimitsInfoInteractorImpl;
import com.avito.android.user_advert.limits_info.LimitsInfoInteractorImpl_Factory;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTracker;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTrackerImpl;
import com.avito.android.user_advert.tracker.MyAdvertDetailsTrackerImpl_Factory;
import com.avito.android.user_advert_api.remote.UserAdvertApi;
import com.avito.android.user_adverts_common.charity.CharityInteractorImpl;
import com.avito.android.user_adverts_common.charity.CharityInteractorImpl_Factory;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl_Factory;
import com.avito.android.user_adverts_common.safety.storage.PrefSafetyInfoSessionStorage;
import com.avito.android.user_adverts_common.safety.storage.PrefSafetyInfoSessionStorage_Factory;
import com.avito.android.util.ClipDataFactoryImpl_Factory;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.di.ClipboardModule_ProvideClipboardManager$android_releaseFactory;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.SimpleAdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import com.jakewharton.rxrelay3.Relay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerMyAdvertDetailsComponent implements MyAdvertDetailsComponent {
    public Provider<UserAdvertApi> A;
    public Provider<UserAdvertsCommonApi> A0;
    public Provider<DeliveryApi> A1;
    public Provider<TypedErrorThrowableConverter> B;
    public Provider<CurrentUserIdProvider> B0;
    public Provider<AdvertDeliveryBlockRepositoryImpl> B1;
    public Provider<Bundle> C;
    public Provider<CharityInteractorImpl> C0;
    public Provider<AdvertDeliveryBlockRepository> C1;
    public Provider<MyAdvertDetailsInteractorImpl> D;
    public Provider<PublishLimitsApi> D0;
    public Provider<AdvertDeliveryBlockViewModelFactory> D1;
    public Provider<MyAdvertDetailsInteractor> E;
    public Provider<LimitsInfoInteractorImpl> E0;
    public Provider<ViewModelProvider.Factory> E1;
    public Provider<PublishRelay<String>> F;
    public Provider<PermissionStorage> F0;
    public Provider<LifecycleOwner> F1;
    public Provider<MyDraftAdvertDetailsInteractorImpl> G;
    public Provider<PermissionStateProvider> G0;
    public Provider<AdvertDeliveryBlockViewModel> G1;
    public Provider<MyDraftAdvertDetailsInteractor> H;
    public Provider<MyAdvertStorageImpl> H0;
    public Provider<ShortTermRentApi> H1;
    public Provider<MyAdvertContactsPresenter> I = DoubleCheck.provider(MyAdvertContactsPresenterImpl_Factory.create());
    public Provider<MyAdvertStorage> I0;
    public Provider<AdvertStrBlockInteractorImpl> I1;
    public Provider<FacebookSocialManager> J = SingleCheck.provider(FacebookSocialManagerImpl_Factory.create());
    public Provider<PrefSafetyInfoSessionStorage> J0;
    public Provider<AdvertStrBlockInteractor> J1;
    public Provider<LiveJournalSocialManager> K = SingleCheck.provider(LiveJournalSocialManagerImpl_Factory.create());
    public Provider<SafetyInfoProviderImpl> K0;
    public Provider<AdvertStrBlockViewResourceProviderImpl> K1;
    public Provider<MailSocialManager> L = SingleCheck.provider(MailSocialManagerImpl_Factory.create());
    public Provider<PreferenceFactory> L0;
    public Provider<AdvertStrBlockViewResourceProvider> L1;
    public Provider<Context> M;
    public Provider<BivrostTutorialSessionStorage> M0;
    public Provider<AdvertStrBlockAnalyticsInteractorImpl> M1;
    public Provider<OdnoklassnikiSocialManagerImpl> N;
    public Provider<String> N0;
    public Provider<AdvertStrBlockAnalyticsInteractor> N1;
    public Provider<OdnoklassnikiSocialManager> O;
    public Provider<AdvertDetailsImvBadgePresenterImpl> O0;
    public Provider<AdvertStrBlockViewModelFactory> O1;
    public Provider<TwitterSocialManager> P;
    public Provider<AdvertDetailsImvBadgePresenter> P0;
    public Provider<ViewModelProvider.Factory> P1;
    public Provider<VkontakteSocialManagerImpl> Q;
    public Provider<AdvertDetailsImvBadgeItemConverter> Q0;
    public Provider<AdvertStrBlockViewModel> Q1;
    public Provider<VkontakteSocialManager> R;
    public Provider<CarMarketPriceChartResourceProviderImpl> R0;
    public Provider<SafeDealApi> R1;
    public Provider<SocialInfoProvider> S;
    public Provider<CarMarketPriceChartResourceProvider> S0;
    public Provider<MyAdvertSafeDealServicesInteractorImpl> S1;
    public Provider<SocialTypeToStringMapper> T;
    public Provider<AttributedTextFormatter> T0;
    public Provider<MyAdvertSafeDealServicesInteractor> T1;
    public Provider<SocialPresenter> U;
    public Provider<CarMarketPriceChartPresenterImpl> U0;
    public Provider<MyAdvertSafeDealResourceProvider> U1;
    public Provider<Application> V;
    public Provider<CarMarketPriceChartPresenter> V0;
    public Provider<MyAdvertSafedealServicesViewModelFactory> V1;
    public Provider<ClipboardManager> W;
    public Provider<CarMarketPriceDescriptionResourceProvider> W0;
    public Provider<MyAdvertSafeDealServicesViewModel> W1;
    public Provider<DeviceMetrics> X;
    public Provider<CarMarketPriceSwitchConverterImpl> X0;
    public Provider<ProfileInfoStorage> Y;
    public Provider<CarMarketPriceSwitchConverter> Y0;
    public Provider<SupportEmailResourceProvider> Z;
    public Provider<CarMarketPriceDescriptionPresenterImpl> Z0;
    public final MyAdvertDetailsDependencies a;
    public Provider<MyAdvertDetailsResourceProviderImpl> a0;
    public Provider<CarMarketPriceDescriptionPresenter> a1;
    public final Resources b;
    public Provider<MyAdvertDetailsResourceProvider> b0;
    public Provider<String> b1;
    public Provider<Analytics> c;
    public Provider<TimeSource> c0;
    public Provider<Kundle> c1;
    public Provider<AccountStateProvider> d;
    public Provider<DateTimeFormatterResourceProviderImpl> d0;
    public Provider<MyAdvertDetailsPresenterImpl> d1;
    public Provider<SchedulersFactory3> e;
    public Provider<Locale> e0;
    public Provider<MyAdvertDetailsPresenter> e1;
    public Provider<Features> f;
    public Provider<DateTimeFormatter> f0;
    public Provider<Activity> f1;
    public Provider<AdvertSharingEventTrackerImpl> g;
    public Provider<ErrorFormatterImpl> g0;
    public Provider<DialogRouter> g1;
    public Provider<AdvertSharingEventTracker> h;
    public Provider<ErrorFormatter> h0;
    public Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> h1;
    public Provider<DeliveryEventTrackerImpl> i;
    public Provider<PublishRelay<AdvertDeliveryC2C>> i0;
    public Provider<AdvertDetailsFeatureTeaserDialogTextItemBlueprint> i1;
    public Provider<DeliveryEventTracker> j;
    public Provider<PublishRelay<AdvertSellerShortTermRent>> j0;
    public Provider<AdvertDetailsGapBlueprint> j1;
    public Provider<DetailsId> k;
    public Provider<Relay<MyAdvertSafeDeal>> k0;
    public Provider<Set<ItemBlueprint<?, ?>>> k1;
    public Provider<Boolean> l;
    public Provider<Preferences> l0;
    public Provider<ItemBinder> l1;
    public Provider<Boolean> m;
    public Provider<PrefAppRaterSessionStorage> m0;
    public Provider<SimpleAdapterPresenter> m1;
    public Provider<Boolean> n;
    public Provider<AppRaterInteractorImpl> n0;
    public Provider<AdvertDetailsFeatureTeaserDialogItemsAdapter> n1;
    public Provider<Boolean> o;
    public Provider<ScreenTrackerFactory> o0;
    public Provider<CommonFeatureTeaserDialogFactory> o1;
    public Provider<Boolean> p;
    public Provider<TimerFactory> p0;
    public Provider<FeatureTeaserDialogFactory> p1;
    public Provider<String> q;
    public Provider<ScreenDiInjectTracker> q0;
    public Provider<AutoPublishChangeStateInteractor> q1;
    public Provider<Resources> r;
    public Provider<ScreenInitTracker> r0;
    public Provider<AutoPublishBlockResourceProvider> r1;
    public Provider<MyAdvertDetailsActionMenuConverter> s;
    public Provider<ScreenFlowTrackerProvider> s0;
    public Provider<AutoPublishBlockViewModelFactory> s1;
    public Provider<AdvertAddressFormatterImpl> t;
    public Provider<MyAdvertDetailsTrackerImpl> t0;
    public Provider<FragmentActivity> t1;
    public Provider<AdvertAddressFormatter> u;
    public Provider<MyAdvertDetailsTracker> u0;
    public Provider<AutoPublishBlockViewModel> u1;
    public Provider<HtmlRenderer> v;
    public Provider<MyAdvertDetailsFeatureTeaserResourceProvider> v0;
    public Provider<BookingApi> v1;
    public Provider<HtmlCleaner> w;
    public Provider<CommonFeatureTeaserPresenter> w0;
    public Provider<AutoBookingChangeStateInteractor> w1;
    public Provider<HtmlRenderOptions> x;
    public Provider<MyAdvertDetailsFeatureTeaserPresenterImpl> x0;
    public Provider<AutoBookingBlockResourceProvider> x1;
    public Provider<MyAdvertDetailsConverterImpl> y;
    public Provider<VerificationItemConverterImpl> y0;
    public Provider<AutoBookingBlockViewModelFactory> y1;
    public Provider<MyAdvertDetailsConverter> z;
    public Provider<VerificationItemConverter> z0;
    public Provider<AutoBookingBlockViewModel> z1;

    public static class a0 implements Provider<TimeSource> {
        public final MyAdvertDetailsDependencies a;

        public a0(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class b0 implements Provider<TimerFactory> {
        public final MyAdvertDetailsDependencies a;

        public b0(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final MyAdvertDetailsDependencies a;

        public c(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class c0 implements Provider<TypedErrorThrowableConverter> {
        public final MyAdvertDetailsDependencies a;

        public c0(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class d implements Provider<Analytics> {
        public final MyAdvertDetailsDependencies a;

        public d(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d0 implements Provider<UserAdvertApi> {
        public final MyAdvertDetailsDependencies a;

        public d0(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertApi get() {
            return (UserAdvertApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertApi());
        }
    }

    public static class e implements Provider<Application> {
        public final MyAdvertDetailsDependencies a;

        public e(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class e0 implements Provider<UserAdvertsCommonApi> {
        public final MyAdvertDetailsDependencies a;

        public e0(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsCommonApi get() {
            return (UserAdvertsCommonApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsCommonApi());
        }
    }

    public static class f implements Provider<BookingApi> {
        public final MyAdvertDetailsDependencies a;

        public f(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BookingApi get() {
            return (BookingApi) Preconditions.checkNotNullFromComponent(this.a.bookingApi());
        }
    }

    public static class g implements Provider<Context> {
        public final MyAdvertDetailsDependencies a;

        public g(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class h implements Provider<CurrentUserIdProvider> {
        public final MyAdvertDetailsDependencies a;

        public h(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CurrentUserIdProvider get() {
            return (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserProvider());
        }
    }

    public static class i implements Provider<DeliveryApi> {
        public final MyAdvertDetailsDependencies a;

        public i(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeliveryApi get() {
            return (DeliveryApi) Preconditions.checkNotNullFromComponent(this.a.deliveryApi());
        }
    }

    public static class j implements Provider<DeviceMetrics> {
        public final MyAdvertDetailsDependencies a;

        public j(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeviceMetrics get() {
            return (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics());
        }
    }

    public static class k implements Provider<PublishRelay<String>> {
        public final MyAdvertDetailsDependencies a;

        public k(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishRelay<String> get() {
            return (PublishRelay) Preconditions.checkNotNullFromComponent(this.a.draftSaveObservable());
        }
    }

    public static class l implements Provider<Features> {
        public final MyAdvertDetailsDependencies a;

        public l(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class m implements Provider<HtmlCleaner> {
        public final MyAdvertDetailsDependencies a;

        public m(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class n implements Provider<HtmlRenderer> {
        public final MyAdvertDetailsDependencies a;

        public n(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class o implements Provider<PublishLimitsApi> {
        public final MyAdvertDetailsDependencies a;

        public o(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishLimitsApi get() {
            return (PublishLimitsApi) Preconditions.checkNotNullFromComponent(this.a.limitsInfoApi());
        }
    }

    public static class p implements Provider<Locale> {
        public final MyAdvertDetailsDependencies a;

        public p(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class q implements Provider<PermissionStateProvider> {
        public final MyAdvertDetailsDependencies a;

        public q(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionStateProvider get() {
            return (PermissionStateProvider) Preconditions.checkNotNullFromComponent(this.a.permissionStateProvider());
        }
    }

    public static class r implements Provider<PermissionStorage> {
        public final MyAdvertDetailsDependencies a;

        public r(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PermissionStorage get() {
            return (PermissionStorage) Preconditions.checkNotNullFromComponent(this.a.permissionStorage());
        }
    }

    public static class s implements Provider<PreferenceFactory> {
        public final MyAdvertDetailsDependencies a;

        public s(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PreferenceFactory get() {
            return (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferenceFactory());
        }
    }

    public static class t implements Provider<Preferences> {
        public final MyAdvertDetailsDependencies a;

        public t(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class u implements Provider<ProfileInfoStorage> {
        public final MyAdvertDetailsDependencies a;

        public u(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileInfoStorage get() {
            return (ProfileInfoStorage) Preconditions.checkNotNullFromComponent(this.a.profileInfoStorage());
        }
    }

    public static class v implements Provider<SafeDealApi> {
        public final MyAdvertDetailsDependencies a;

        public v(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SafeDealApi get() {
            return (SafeDealApi) Preconditions.checkNotNullFromComponent(this.a.safeDealApi());
        }
    }

    public static class w implements Provider<SchedulersFactory3> {
        public final MyAdvertDetailsDependencies a;

        public w(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class x implements Provider<ScreenTrackerFactory> {
        public final MyAdvertDetailsDependencies a;

        public x(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class y implements Provider<ShortTermRentApi> {
        public final MyAdvertDetailsDependencies a;

        public y(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class z implements Provider<SocialTypeToStringMapper> {
        public final MyAdvertDetailsDependencies a;

        public z(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = myAdvertDetailsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SocialTypeToStringMapper get() {
            return (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper());
        }
    }

    public DaggerMyAdvertDetailsComponent(MyAdvertDetailsDependencies myAdvertDetailsDependencies, Resources resources, Activity activity, FragmentActivity fragmentActivity, LifecycleOwner lifecycleOwner, DetailsId detailsId, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str, String str2, Bundle bundle, Kundle kundle, a aVar) {
        this.a = myAdvertDetailsDependencies;
        this.b = resources;
        d dVar = new d(myAdvertDetailsDependencies);
        this.c = dVar;
        c cVar = new c(myAdvertDetailsDependencies);
        this.d = cVar;
        w wVar = new w(myAdvertDetailsDependencies);
        this.e = wVar;
        l lVar = new l(myAdvertDetailsDependencies);
        this.f = lVar;
        AdvertSharingEventTrackerImpl_Factory create = AdvertSharingEventTrackerImpl_Factory.create(dVar, cVar, wVar, lVar);
        this.g = create;
        this.h = SingleCheck.provider(create);
        DeliveryEventTrackerImpl_Factory create2 = DeliveryEventTrackerImpl_Factory.create(this.c);
        this.i = create2;
        this.j = SingleCheck.provider(create2);
        this.k = InstanceFactory.create(detailsId);
        this.l = InstanceFactory.create(bool);
        this.m = InstanceFactory.create(bool2);
        this.n = InstanceFactory.create(bool5);
        this.o = InstanceFactory.create(bool3);
        this.p = InstanceFactory.create(bool4);
        this.q = InstanceFactory.createNullable(str);
        Factory create3 = InstanceFactory.create(resources);
        this.r = create3;
        this.s = DoubleCheck.provider(BaseAdvertDetailsModule_MyAdvertDetailsActionMenuConverterFactory.create(create3));
        AdvertAddressFormatterImpl_Factory create4 = AdvertAddressFormatterImpl_Factory.create(this.r);
        this.t = create4;
        this.u = DoubleCheck.provider(create4);
        this.v = new n(myAdvertDetailsDependencies);
        this.w = new m(myAdvertDetailsDependencies);
        Provider<HtmlRenderOptions> provider = DoubleCheck.provider(BaseAdvertDetailsModule_ProvideHtmlRenderOptionsFactory.create(this.r));
        this.x = provider;
        MyAdvertDetailsConverterImpl_Factory create5 = MyAdvertDetailsConverterImpl_Factory.create(this.v, this.w, provider);
        this.y = create5;
        this.z = DoubleCheck.provider(create5);
        this.A = new d0(myAdvertDetailsDependencies);
        this.B = new c0(myAdvertDetailsDependencies);
        Factory createNullable = InstanceFactory.createNullable(bundle);
        this.C = createNullable;
        MyAdvertDetailsInteractorImpl_Factory create6 = MyAdvertDetailsInteractorImpl_Factory.create(this.A, this.e, this.B, this.f, createNullable);
        this.D = create6;
        this.E = DoubleCheck.provider(create6);
        k kVar = new k(myAdvertDetailsDependencies);
        this.F = kVar;
        MyDraftAdvertDetailsInteractorImpl_Factory create7 = MyDraftAdvertDetailsInteractorImpl_Factory.create(this.A, this.e, this.B, kVar);
        this.G = create7;
        this.H = DoubleCheck.provider(create7);
        g gVar = new g(myAdvertDetailsDependencies);
        this.M = gVar;
        OdnoklassnikiSocialManagerImpl_Factory create8 = OdnoklassnikiSocialManagerImpl_Factory.create(gVar);
        this.N = create8;
        this.O = SingleCheck.provider(create8);
        this.P = SingleCheck.provider(TwitterSocialManagerImpl_Factory.create());
        VkontakteSocialManagerImpl_Factory create9 = VkontakteSocialManagerImpl_Factory.create(this.M);
        this.Q = create9;
        this.R = SingleCheck.provider(create9);
        Provider<SocialInfoProvider> provider2 = SingleCheck.provider(ShareSocialInfoProvider_Factory.create());
        this.S = provider2;
        z zVar = new z(myAdvertDetailsDependencies);
        this.T = zVar;
        this.U = SingleCheck.provider(ShareModule_ProvideSocialPresenterFactory.create(this.J, this.K, this.L, this.O, this.P, this.R, provider2, this.c, zVar));
        e eVar = new e(myAdvertDetailsDependencies);
        this.V = eVar;
        this.W = ClipboardModule_ProvideClipboardManager$android_releaseFactory.create(eVar);
        j jVar = new j(myAdvertDetailsDependencies);
        this.X = jVar;
        u uVar = new u(myAdvertDetailsDependencies);
        this.Y = uVar;
        Provider<SupportEmailResourceProvider> provider3 = DoubleCheck.provider(BaseAdvertDetailsModule_ProvideSupportEmailResourceProviderFactory.create(this.r, jVar, uVar));
        this.Z = provider3;
        MyAdvertDetailsResourceProviderImpl_Factory create10 = MyAdvertDetailsResourceProviderImpl_Factory.create(this.r, provider3);
        this.a0 = create10;
        this.b0 = DoubleCheck.provider(create10);
        this.c0 = new a0(myAdvertDetailsDependencies);
        DateTimeFormatterResourceProviderImpl_Factory create11 = DateTimeFormatterResourceProviderImpl_Factory.create(this.r);
        this.d0 = create11;
        p pVar = new p(myAdvertDetailsDependencies);
        this.e0 = pVar;
        this.f0 = DateTimeFormatterModule_ProvideLowerCaseDateTimeFormatterFactory.create(this.c0, create11, pVar);
        ErrorFormatterImpl_Factory create12 = ErrorFormatterImpl_Factory.create(this.r);
        this.g0 = create12;
        this.h0 = DoubleCheck.provider(create12);
        this.i0 = SingleCheck.provider(AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockDataObservableFactory.create());
        this.j0 = SingleCheck.provider(AdvertStrBlockModule_ProvideSellerShortTermRentObservableFactory.create());
        this.k0 = SingleCheck.provider(MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesObservable$advert_core_releaseFactory.create());
        t tVar = new t(myAdvertDetailsDependencies);
        this.l0 = tVar;
        PrefAppRaterSessionStorage_Factory create13 = PrefAppRaterSessionStorage_Factory.create(tVar);
        this.m0 = create13;
        this.n0 = AppRaterInteractorImpl_Factory.create(create13);
        x xVar = new x(myAdvertDetailsDependencies);
        this.o0 = xVar;
        b0 b0Var = new b0(myAdvertDetailsDependencies);
        this.p0 = b0Var;
        this.q0 = DoubleCheck.provider(MyAdvertDetailsTrackerModule_ProvideScreenDiInjectTracker$user_advert_releaseFactory.create(xVar, b0Var));
        this.r0 = DoubleCheck.provider(MyAdvertDetailsTrackerModule_ProvideScreenInitTrackerFactory.create(this.o0, this.p0));
        Provider<ScreenFlowTrackerProvider> provider4 = DoubleCheck.provider(MyAdvertDetailsTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.o0, this.p0));
        this.s0 = provider4;
        MyAdvertDetailsTrackerImpl_Factory create14 = MyAdvertDetailsTrackerImpl_Factory.create(this.q0, this.r0, provider4);
        this.t0 = create14;
        this.u0 = DoubleCheck.provider(create14);
        MyAdvertDetailsFeatureTeaserResourceProvider_Factory create15 = MyAdvertDetailsFeatureTeaserResourceProvider_Factory.create(this.r);
        this.v0 = create15;
        CommonFeatureTeaserPresenter_Factory create16 = CommonFeatureTeaserPresenter_Factory.create(create15);
        this.w0 = create16;
        this.x0 = MyAdvertDetailsFeatureTeaserPresenterImpl_Factory.create(create16, CommonAdvertDetailsFeatureTeaserItemsAdapter_Factory.create());
        VerificationItemConverterImpl_Factory create17 = VerificationItemConverterImpl_Factory.create(this.f);
        this.y0 = create17;
        this.z0 = DoubleCheck.provider(create17);
        e0 e0Var = new e0(myAdvertDetailsDependencies);
        this.A0 = e0Var;
        h hVar = new h(myAdvertDetailsDependencies);
        this.B0 = hVar;
        this.C0 = CharityInteractorImpl_Factory.create(this.e, e0Var, hVar, this.c);
        o oVar = new o(myAdvertDetailsDependencies);
        this.D0 = oVar;
        this.E0 = LimitsInfoInteractorImpl_Factory.create(oVar, this.e);
        this.F0 = new r(myAdvertDetailsDependencies);
        this.G0 = new q(myAdvertDetailsDependencies);
        MyAdvertStorageImpl_Factory create18 = MyAdvertStorageImpl_Factory.create(this.l0);
        this.H0 = create18;
        this.I0 = DoubleCheck.provider(create18);
        PrefSafetyInfoSessionStorage_Factory create19 = PrefSafetyInfoSessionStorage_Factory.create(this.l0);
        this.J0 = create19;
        this.K0 = SafetyInfoProviderImpl_Factory.create(this.A0, this.e, create19, this.c0);
        s sVar = new s(myAdvertDetailsDependencies);
        this.L0 = sVar;
        this.M0 = DoubleCheck.provider(BivrostStatisticsModule_ProvideBivrostStorageFactory.create(this.V, sVar));
        MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory create20 = MyAdvertDetailsComponent_AdvertDetailsModule_ProvideAdvertIdFactory.create(this.k);
        this.N0 = create20;
        AdvertDetailsImvBadgePresenterImpl_Factory create21 = AdvertDetailsImvBadgePresenterImpl_Factory.create(create20, this.c);
        this.O0 = create21;
        this.P0 = DoubleCheck.provider(create21);
        this.Q0 = DoubleCheck.provider(AdvertDetailsImvBadgeItemConverterImpl_Factory.create());
        CarMarketPriceChartResourceProviderImpl_Factory create22 = CarMarketPriceChartResourceProviderImpl_Factory.create(this.r);
        this.R0 = create22;
        this.S0 = DoubleCheck.provider(create22);
        Provider<AttributedTextFormatter> provider5 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.T0 = provider5;
        CarMarketPriceChartPresenterImpl_Factory create23 = CarMarketPriceChartPresenterImpl_Factory.create(this.S0, provider5, this.X);
        this.U0 = create23;
        this.V0 = DoubleCheck.provider(create23);
        Provider<CarMarketPriceDescriptionResourceProvider> provider6 = DoubleCheck.provider(CarMarketPriceDescriptionResourceProviderImpl_Factory.create());
        this.W0 = provider6;
        CarMarketPriceSwitchConverterImpl_Factory create24 = CarMarketPriceSwitchConverterImpl_Factory.create(provider6);
        this.X0 = create24;
        Provider<CarMarketPriceSwitchConverter> provider7 = DoubleCheck.provider(create24);
        this.Y0 = provider7;
        CarMarketPriceDescriptionPresenterImpl_Factory create25 = CarMarketPriceDescriptionPresenterImpl_Factory.create(provider7);
        this.Z0 = create25;
        this.a1 = DoubleCheck.provider(create25);
        this.b1 = InstanceFactory.createNullable(str2);
        this.c1 = InstanceFactory.createNullable(kundle);
        MyAdvertDetailsPresenterImpl_Factory create26 = MyAdvertDetailsPresenterImpl_Factory.create(this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.e, this.s, this.u, this.z, this.E, this.H, this.I, this.U, this.c, this.W, ClipDataFactoryImpl_Factory.create(), this.f, this.b0, this.f0, this.h0, this.i0, this.j0, this.k0, this.n0, this.c0, this.u0, this.x0, this.z0, this.C0, this.E0, this.F0, this.G0, this.I0, this.K0, this.d, this.M0, this.P0, this.Q0, this.V0, this.a1, this.b1, this.c1);
        this.d1 = create26;
        this.e1 = DoubleCheck.provider(create26);
        Factory create27 = InstanceFactory.create(activity);
        this.f1 = create27;
        this.g1 = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create27));
        Provider<AdvertDetailsFeatureTeaserDialogTextItemPresenter> provider8 = SingleCheck.provider(AdvertDetailsFeatureTeaserDialogTextItemPresenter_Factory.create());
        this.h1 = provider8;
        this.i1 = AdvertDetailsFeatureTeaserDialogTextItemBlueprint_Factory.create(provider8, this.T0);
        this.j1 = AdvertDetailsGapBlueprint_Factory.create(AdvertDetailsGapPresenterImpl_Factory.create());
        SetFactory build = SetFactory.builder(2, 0).addProvider(this.i1).addProvider(this.j1).build();
        this.k1 = build;
        Provider<ItemBinder> provider9 = SingleCheck.provider(CommonFeatureTeaserModule_ProvideItemBinder$advert_core_releaseFactory.create(build));
        this.l1 = provider9;
        this.m1 = CommonFeatureTeaserModule_ProvideAdapterFactory.create(provider9);
        AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory create28 = AdvertDetailsFeatureTeaserDialogItemsAdapter_Factory.create(this.v0, IdProviderImpl_Factory.create());
        this.n1 = create28;
        CommonFeatureTeaserDialogFactory_Factory create29 = CommonFeatureTeaserDialogFactory_Factory.create(this.l1, this.m1, this.v0, create28);
        this.o1 = create29;
        this.p1 = SingleCheck.provider(create29);
        this.q1 = AutoPublishChangeStateInteractor_Factory.create(this.A);
        AutoPublishBlockResourceProvider_Factory create30 = AutoPublishBlockResourceProvider_Factory.create(this.r);
        this.r1 = create30;
        this.s1 = AutoPublishBlockViewModelFactory_Factory.create(this.N0, this.q1, this.e, this.B, create30);
        Factory create31 = InstanceFactory.create(fragmentActivity);
        this.t1 = create31;
        this.u1 = SingleCheck.provider(AutoPublishBlockModule_ProvideAdvertDeliveryBlockViewModelFactory.create(this.s1, create31));
        f fVar = new f(myAdvertDetailsDependencies);
        this.v1 = fVar;
        this.w1 = AutoBookingChangeStateInteractor_Factory.create(fVar);
        AutoBookingBlockResourceProvider_Factory create32 = AutoBookingBlockResourceProvider_Factory.create(this.r);
        this.x1 = create32;
        AutoBookingBlockViewModelFactory_Factory create33 = AutoBookingBlockViewModelFactory_Factory.create(this.N0, this.w1, this.e, this.B, create32);
        this.y1 = create33;
        this.z1 = SingleCheck.provider(AutoBookingBlockModule_ProvideAdvertDeliveryBlockViewModelFactory.create(create33, this.t1));
        i iVar = new i(myAdvertDetailsDependencies);
        this.A1 = iVar;
        AdvertDeliveryBlockRepositoryImpl_Factory create34 = AdvertDeliveryBlockRepositoryImpl_Factory.create(this.N0, iVar, this.e, this.B, this.i0);
        this.B1 = create34;
        Provider<AdvertDeliveryBlockRepository> provider10 = SingleCheck.provider(create34);
        this.C1 = provider10;
        AdvertDeliveryBlockViewModelFactory_Factory create35 = AdvertDeliveryBlockViewModelFactory_Factory.create(provider10, this.e, this.T0);
        this.D1 = create35;
        this.E1 = SingleCheck.provider(create35);
        Factory create36 = InstanceFactory.create(lifecycleOwner);
        this.F1 = create36;
        this.G1 = SingleCheck.provider(AdvertDeliveryBlockModule_ProvideAdvertDeliveryBlockViewModelFactory.create(this.E1, create36));
        y yVar = new y(myAdvertDetailsDependencies);
        this.H1 = yVar;
        AdvertStrBlockInteractorImpl_Factory create37 = AdvertStrBlockInteractorImpl_Factory.create(this.N0, yVar, this.e, this.B);
        this.I1 = create37;
        this.J1 = SingleCheck.provider(create37);
        AdvertStrBlockViewResourceProviderImpl_Factory create38 = AdvertStrBlockViewResourceProviderImpl_Factory.create(this.r);
        this.K1 = create38;
        this.L1 = SingleCheck.provider(create38);
        AdvertStrBlockAnalyticsInteractorImpl_Factory create39 = AdvertStrBlockAnalyticsInteractorImpl_Factory.create(this.N0, this.Y, this.c);
        this.M1 = create39;
        Provider<AdvertStrBlockAnalyticsInteractor> provider11 = SingleCheck.provider(create39);
        this.N1 = provider11;
        AdvertStrBlockViewModelFactory_Factory create40 = AdvertStrBlockViewModelFactory_Factory.create(this.J1, this.e, this.T0, this.L1, provider11, this.j0);
        this.O1 = create40;
        Provider<ViewModelProvider.Factory> provider12 = SingleCheck.provider(create40);
        this.P1 = provider12;
        this.Q1 = SingleCheck.provider(AdvertStrBlockModule_ProvideAdvertStrBlockViewModelFactory.create(provider12, this.t1));
        v vVar = new v(myAdvertDetailsDependencies);
        this.R1 = vVar;
        MyAdvertSafeDealServicesInteractorImpl_Factory create41 = MyAdvertSafeDealServicesInteractorImpl_Factory.create(this.N0, vVar, this.B, this.e);
        this.S1 = create41;
        this.T1 = SingleCheck.provider(create41);
        MyAdvertSafeDealResourceProvider_Factory create42 = MyAdvertSafeDealResourceProvider_Factory.create(this.r);
        this.U1 = create42;
        MyAdvertSafedealServicesViewModelFactory_Factory create43 = MyAdvertSafedealServicesViewModelFactory_Factory.create(this.T1, this.e, create42, this.k0);
        this.V1 = create43;
        this.W1 = SingleCheck.provider(MyAdvertSafeDealServicesModule_ProvideMyAdvertSafeDealServicesViewModel$advert_core_releaseFactory.create(this.F1, create43));
    }

    public static MyAdvertDetailsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public AutoBookingBlockViewModel getAutoBookingBlockViewModel() {
        return this.z1.get();
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public AutoPublishBlockViewModel getAutoPublishBlockViewModel() {
        return this.u1.get();
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public AdvertDeliveryBlockViewModel getDeliveryBlockViewModel() {
        return this.G1.get();
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public MyAdvertSafeDealServicesViewModel getSafeDealServicesViewModel() {
        return this.W1.get();
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public AdvertStrBlockViewModel getStrBlockViewModel() {
        return this.Q1.get();
    }

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent
    public void inject(MyAdvertDetailsActivity myAdvertDetailsActivity) {
        MyAdvertDetailsActivity_MembersInjector.injectAnalytics(myAdvertDetailsActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        MyAdvertDetailsActivity_MembersInjector.injectEventTracker(myAdvertDetailsActivity, this.h.get());
        MyAdvertDetailsActivity_MembersInjector.injectDeliveryEventTracker(myAdvertDetailsActivity, this.j.get());
        MyAdvertDetailsActivity_MembersInjector.injectDeepLinkIntentFactory(myAdvertDetailsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        MyAdvertDetailsActivity_MembersInjector.injectDeepLinkFactory(myAdvertDetailsActivity, (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory()));
        MyAdvertDetailsActivity_MembersInjector.injectPresenter(myAdvertDetailsActivity, this.e1.get());
        MyAdvertDetailsActivity_MembersInjector.injectContactsPresenter(myAdvertDetailsActivity, this.I.get());
        MyAdvertDetailsActivity_MembersInjector.injectImplicitIntentFactory(myAdvertDetailsActivity, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        MyAdvertDetailsActivity_MembersInjector.injectActivityIntentFactory(myAdvertDetailsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        MyAdvertDetailsActivity_MembersInjector.injectSocialPresenter(myAdvertDetailsActivity, this.U.get());
        MyAdvertDetailsActivity_MembersInjector.injectInteractor(myAdvertDetailsActivity, this.E.get());
        MyAdvertDetailsActivity_MembersInjector.injectFeatures(myAdvertDetailsActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        MyAdvertDetailsActivity_MembersInjector.injectAttributedTextFormatter(myAdvertDetailsActivity, this.T0.get());
        MyAdvertDetailsActivity_MembersInjector.injectDialogRouter(myAdvertDetailsActivity, this.g1.get());
        MyAdvertDetailsActivity_MembersInjector.injectSocialTypeToStringMapper(myAdvertDetailsActivity, (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper()));
        MyAdvertDetailsActivity_MembersInjector.injectTracker(myAdvertDetailsActivity, this.u0.get());
        MyAdvertDetailsActivity_MembersInjector.injectFeatureTeasersViewFactory(myAdvertDetailsActivity, new MyAdvertDetailsFeatureTeaserViewFactory(new MyAdvertDetailsFeatureTeaserResourceProvider(this.b), this.p1.get()));
        MyAdvertDetailsActivity_MembersInjector.injectImvBadgePresenter(myAdvertDetailsActivity, this.P0.get());
        MyAdvertDetailsActivity_MembersInjector.injectImvChartPresenter(myAdvertDetailsActivity, this.V0.get());
    }

    public static final class b implements MyAdvertDetailsComponent.Builder {
        public MyAdvertDetailsDependencies a;
        public Resources b;
        public Activity c;
        public FragmentActivity d;
        public LifecycleOwner e;
        public DetailsId f;
        public Boolean g;
        public Boolean h;
        public Boolean i;
        public Boolean j;
        public Boolean k;
        public String l;
        public String m;
        public Bundle n;
        public Kundle o;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent.Builder, com.avito.android.user_advert.di.DetailsComponentBuilder
        /* renamed from: build */
        public MyAdvertDetailsComponent mo95build() {
            Preconditions.checkBuilderRequirement(this.a, MyAdvertDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, FragmentActivity.class);
            Preconditions.checkBuilderRequirement(this.e, LifecycleOwner.class);
            Preconditions.checkBuilderRequirement(this.f, DetailsId.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.i, Boolean.class);
            Preconditions.checkBuilderRequirement(this.j, Boolean.class);
            Preconditions.checkBuilderRequirement(this.k, Boolean.class);
            return new DaggerMyAdvertDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, null);
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> dependentOn(MyAdvertDetailsDependencies myAdvertDetailsDependencies) {
            this.a = (MyAdvertDetailsDependencies) Preconditions.checkNotNull(myAdvertDetailsDependencies);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withActivity(Activity activity) {
            this.c = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withDetailsId(DetailsId detailsId) {
            this.f = (DetailsId) Preconditions.checkNotNull(detailsId);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withErrorMessage(String str) {
            this.l = str;
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withFragmentActivity(FragmentActivity fragmentActivity) {
            this.d = (FragmentActivity) Preconditions.checkNotNull(fragmentActivity);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withInteractorState(Bundle bundle) {
            this.n = bundle;
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withIsNewAdvert(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.e = (LifecycleOwner) Preconditions.checkNotNull(lifecycleOwner);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withPresenterState(Kundle kundle) {
            this.o = kundle;
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withRestoreAdvert(boolean z) {
            this.k = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withShouldFinishAfterActivation(boolean z) {
            this.j = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withShouldOpenActivateDialog(boolean z) {
            this.g = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withShouldOpenUserAdverts(boolean z) {
            this.i = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        /* Return type fixed from 'com.avito.android.user_advert.di.DetailsComponentBuilder' to match base method */
        @Override // com.avito.android.user_advert.di.DetailsComponentBuilder
        public DetailsComponentBuilder<MyAdvertDetailsComponent> withStatusMessage(String str) {
            this.m = str;
            return this;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.avito.android.user_advert.di.MyAdvertDetailsComponent.Builder, com.avito.android.user_advert.di.DetailsComponentBuilder
        /* renamed from: build  reason: collision with other method in class */
        public MyAdvertDetailsComponent mo95build() {
            Preconditions.checkBuilderRequirement(this.a, MyAdvertDetailsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Activity.class);
            Preconditions.checkBuilderRequirement(this.d, FragmentActivity.class);
            Preconditions.checkBuilderRequirement(this.e, LifecycleOwner.class);
            Preconditions.checkBuilderRequirement(this.f, DetailsId.class);
            Preconditions.checkBuilderRequirement(this.g, Boolean.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.i, Boolean.class);
            Preconditions.checkBuilderRequirement(this.j, Boolean.class);
            Preconditions.checkBuilderRequirement(this.k, Boolean.class);
            return new DaggerMyAdvertDetailsComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, null);
        }
    }
}
