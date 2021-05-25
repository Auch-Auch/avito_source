package com.avito.android.vas_performance.di.applied_services;

import com.avito.android.Features;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.vas.remote.VasApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/vas_performance/di/applied_services/AppliedServicesDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deeplinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/vas/remote/VasApi;", "vasApi", "()Lcom/avito/android/vas/remote/VasApi;", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public interface AppliedServicesDependencies extends ComponentDependencies {
    @Override // com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.deep_linking.di.AppShortcutsDeepLinkDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.bundles.vas_union.di.VasUnionDependencies, com.avito.android.job.cv_packages.di.CvPackagesDependencies
    @NotNull
    DeepLinkIntentFactory deeplinkIntentFactory();

    @Override // com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.social.di.esia.EsiaAuthDependencies, com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    @NotNull
    Features features();

    @Override // com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    SchedulersFactory schedulersFactory();

    @Override // com.avito.android.basket_legacy.di.shared.BasketDependencies
    @NotNull
    VasApi vasApi();
}
