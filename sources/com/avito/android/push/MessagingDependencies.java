package com.avito.android.push;

import android.app.Application;
import com.avito.android.Features;
import com.avito.android.NotificationWorkFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.preferences.TokenStorage;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.service.SafeServiceStarter;
import com.avito.android.util.preferences.Preferences;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/avito/android/push/MessagingDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "()Landroid/app/Application;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/google/gson/Gson;", "gson", "()Lcom/google/gson/Gson;", "Lcom/avito/android/preferences/TokenStorage;", "instanceIdStorage", "()Lcom/avito/android/preferences/TokenStorage;", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "()Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/service/SafeServiceStarter;", "safeServiceStarter", "()Lcom/avito/android/service/SafeServiceStarter;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/NotificationWorkFactory;", "notificationWorkFactory", "()Lcom/avito/android/NotificationWorkFactory;", "Lcom/avito/android/push/CallPushHandler;", "callPushHandler", "()Lcom/avito/android/push/CallPushHandler;", "push_release"}, k = 1, mv = {1, 4, 2})
public interface MessagingDependencies extends ComponentDependencies {
    @Override // com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.push.UpdateInstanceIdDependencies
    @NotNull
    Application application();

    @NotNull
    CallPushHandler callPushHandler();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.social.di.esia.EsiaAuthDependencies, com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    @NotNull
    Features features();

    @NotNull
    Gson gson();

    @NotNull
    TokenStorage instanceIdStorage();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @NotNull
    NotificationWorkFactory notificationWorkFactory();

    @Override // com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies
    @NotNull
    PushTokenProvider pushTokenProvider();

    @NotNull
    SafeServiceStarter safeServiceStarter();
}
