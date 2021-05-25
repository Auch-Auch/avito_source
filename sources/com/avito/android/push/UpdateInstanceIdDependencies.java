package com.avito.android.push;

import android.app.Application;
import com.adjust.sdk.sig.BuildConfig;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics_adjust.Adjust;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.preferences.MutableTokenStorage;
import com.avito.android.push.provider.PushTokenProvider;
import com.avito.android.remote.NotificationsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.firebase.iid.FirebaseInstanceId;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/avito/android/push/UpdateInstanceIdDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/analytics_adjust/Adjust;", BuildConfig.FLAVOR, "()Lcom/avito/android/analytics_adjust/Adjust;", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "()Landroid/app/Application;", "Lcom/avito/android/preferences/MutableTokenStorage;", "mutableInstanceIdStorage", "()Lcom/avito/android/preferences/MutableTokenStorage;", "Lcom/avito/android/remote/NotificationsApi;", "notificationsApi", "()Lcom/avito/android/remote/NotificationsApi;", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "()Lcom/avito/android/util/SchedulersFactory;", "Lcom/google/firebase/iid/FirebaseInstanceId;", "firebaseInstanceId", "()Lcom/google/firebase/iid/FirebaseInstanceId;", "Lcom/avito/android/push/provider/PushTokenProvider;", "pushTokenProvider", "()Lcom/avito/android/push/provider/PushTokenProvider;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "()Lcom/avito/android/util/BuildInfo;", "push_release"}, k = 1, mv = {1, 4, 2})
public interface UpdateInstanceIdDependencies extends ComponentDependencies {
    @NotNull
    Adjust adjust();

    @Override // com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    Analytics analytics();

    @NotNull
    Application application();

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    BuildInfo buildInfo();

    @NotNull
    FirebaseInstanceId firebaseInstanceId();

    @NotNull
    MutableTokenStorage mutableInstanceIdStorage();

    @NotNull
    NotificationsApi notificationsApi();

    @Override // com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies
    @NotNull
    PushTokenProvider pushTokenProvider();

    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    SchedulersFactory schedulersFactory();
}
