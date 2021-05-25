package com.avito.android.basket.paid_services.di;

import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.remote.CheckoutApi;
import com.avito.android.tariff.TariffDependencies;
import com.avito.android.vas.remote.VasApi;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket/paid_services/di/PaidServicesDependencies;", "Lcom/avito/android/tariff/TariffDependencies;", "Lcom/avito/android/remote/CheckoutApi;", "checkoutApi", "()Lcom/avito/android/remote/CheckoutApi;", "Lcom/avito/android/vas/remote/VasApi;", "vasApi", "()Lcom/avito/android/vas/remote/VasApi;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "basket_release"}, k = 1, mv = {1, 4, 2})
public interface PaidServicesDependencies extends TariffDependencies {
    @NotNull
    CheckoutApi checkoutApi();

    @Override // com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.public_profile.di.PublicProfileFragmentDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies
    @NotNull
    VasApi vasApi();
}
