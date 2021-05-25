package com.avito.android.payment.di.component;

import com.avito.android.app.external.ApplicationInfoProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.payment.google_pay.GooglePayInteractor;
import com.avito.android.payment.google_pay.GooglePayRequestBuilder;
import com.avito.android.payment.remote.PaymentApi;
import com.avito.android.server_time.TimeSource;
import com.google.android.gms.wallet.PaymentsClient;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/payment/di/component/PaymentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/payment/remote/PaymentApi;", "paymentApi", "()Lcom/avito/android/payment/remote/PaymentApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deeplinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Ljava/util/Locale;", "provideLocale", "()Ljava/util/Locale;", "Lcom/avito/android/app/external/ApplicationInfoProvider;", "applicationInfoProvider", "()Lcom/avito/android/app/external/ApplicationInfoProvider;", "Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "googlePayInteractor", "()Lcom/avito/android/payment/google_pay/GooglePayInteractor;", "Lcom/google/android/gms/wallet/PaymentsClient;", "paymentsClient", "()Lcom/google/android/gms/wallet/PaymentsClient;", "Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "googlePayRequest", "()Lcom/avito/android/payment/google_pay/GooglePayRequestBuilder;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "htmlCleaner", "()Lcom/avito/android/html_formatter/HtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlNodeFactory;", "htmlNodeFactory", "()Lcom/avito/android/html_formatter/HtmlNodeFactory;", "Lcom/avito/android/html_formatter/HtmlRenderer;", "htmlRenderer", "()Lcom/avito/android/html_formatter/HtmlRenderer;", "payment_release"}, k = 1, mv = {1, 4, 2})
public interface PaymentDependencies extends CoreComponentDependencies {
    @NotNull
    ApplicationInfoProvider applicationInfoProvider();

    @Override // com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies
    @NotNull
    DeepLinkFactory deeplinkFactory();

    @Override // com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.vas_discount.di.DiscountDependencies, com.avito.android.advert_stats.di.AdvertStatsDependencies, com.avito.android.tariff.TariffDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.bundles.vas_union.di.VasUnionDependencies, com.avito.android.job.cv_packages.di.CvPackagesDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    GooglePayInteractor googlePayInteractor();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    GooglePayRequestBuilder googlePayRequest();

    @Override // com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlCleaner htmlCleaner();

    @Override // com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlNodeFactory htmlNodeFactory();

    @Override // com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrSellerCalendarParametersDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierOrderUpdateDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierSummaryDependencies
    @NotNull
    HtmlRenderer htmlRenderer();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    PaymentApi paymentApi();

    @Override // com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    PaymentsClient paymentsClient();

    @NotNull
    Locale provideLocale();

    @Override // com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.notification_center.landing.recommends.di.NotificationCenterLandingRecommendsDependencies, com.avito.android.notification_center.landing.unified.di.NotificationCenterLandingUnifiedDependencies, com.avito.android.express_cv.di.ExpressCvDependencies, com.avito.android.geo.di.GeoDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();
}
