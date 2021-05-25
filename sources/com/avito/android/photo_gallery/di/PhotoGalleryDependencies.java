package com.avito.android.photo_gallery.di;

import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.AdvertContactApplyWithoutChat;
import com.avito.android.ab_tests.AdvertDetailsNoCallFeedback;
import com.avito.android.ab_tests.AntiFraudCheckList;
import com.avito.android.ab_tests.JobApplicationProgressBar;
import com.avito.android.ab_tests.JustDialSellerPhoneTestGroup;
import com.avito.android.ab_tests.SendEmployersPhoneOnCallToSellerButtonClickInResumes;
import com.avito.android.ab_tests.configs.AntiFraudCheckListTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;
import com.avito.android.ab_tests.groups.AdvertDetailsNoCallFeedbackTestGroup;
import com.avito.android.ab_tests.groups.SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithControl2;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.AbTestGroup;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.teaser.TeaserObserver;
import com.avito.android.advert_details.remote.AdvertDetailsApi;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.job.JobApi;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.profile.ProfileInfoStorage;
import com.avito.android.remote.AsyncPhoneApi;
import com.avito.android.util.preferences.Preferences;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H'¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H&¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H&¢\u0006\u0004\b1\u00102J\u000f\u00104\u001a\u000203H&¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\b\u0012\u0004\u0012\u00020706H'¢\u0006\u0004\b8\u00109J\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:H'¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\b\u0012\u0004\u0012\u00020>0&H'¢\u0006\u0004\b?\u0010)J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@06H&¢\u0006\u0004\bA\u00109J\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020B0:H'¢\u0006\u0004\bC\u0010=J\u000f\u0010E\u001a\u00020DH&¢\u0006\u0004\bE\u0010FJ\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020H0GH'¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020KH&¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH&¢\u0006\u0004\bO\u0010P¨\u0006Q"}, d2 = {"Lcom/avito/android/photo_gallery/di/PhotoGalleryDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "abTestsConfigProvider", "()Lcom/avito/android/ab_tests/AbTestsConfigProvider;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lru/avito/messenger/api/AvitoMessengerApi;", "avitoMessengerApi", "()Lru/avito/messenger/api/AvitoMessengerApi;", "Lcom/avito/android/remote/AsyncPhoneApi;", "asyncPhoneApi", "()Lcom/avito/android/remote/AsyncPhoneApi;", "Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "advertDetailsApi", "()Lcom/avito/android/advert_details/remote/AdvertDetailsApi;", "Lcom/avito/android/job/JobApi;", "jobApi", "()Lcom/avito/android/job/JobApi;", "Lcom/avito/android/profile/ProfileInfoStorage;", "profileInfoStorage", "()Lcom/avito/android/profile/ProfileInfoStorage;", "Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "screenTrackerFactory", "()Lcom/avito/android/analytics/screens/tracker/ScreenTrackerFactory;", "Lcom/avito/android/analytics/screens/TimerFactory;", "timerFactory", "()Lcom/avito/android/analytics/screens/TimerFactory;", "Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithControl2;", "justDialSellerPhoneTestGroup", "()Lcom/avito/android/ab_tests/models/AbTestGroup;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "()Lcom/avito/android/calls/remote/CallsApi;", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "()Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "()Lcom/avito/android/calls_shared/CallUuidProvider;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdvertDetailsNoCallFeedbackTestGroup;", "advertDetailsNoCallFeedbackTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", "advertContactApplyWithoutChatTestGroup", "()Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup;", "sendEmployersPhoneOnCallToSellerButtonClickInResumes", "Lcom/avito/android/ab_tests/groups/AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup;", "advertDetailsMarketplaceNoPurchaseFeedbackTestGroup", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "jobApplicationProgressBarTestGroup", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/AntiFraudCheckListTestGroup;", "antiFraudCheckListTest", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/advert_core/teaser/TeaserObserver;", "teaserObserver", "()Lcom/avito/android/advert_core/teaser/TeaserObserver;", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoGalleryDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies
    @NotNull
    AbTestsConfigProvider abTestsConfigProvider();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @AdvertContactApplyWithoutChat
    @NotNull
    ExposedAbTestGroup<SimpleTestGroupWithNone> advertContactApplyWithoutChatTestGroup();

    @Override // com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert.badge_details.di.BadgeDetailsDependencies, com.avito.android.advert.consultation_form.di.ConsultationFormDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AdvertDetailsApi advertDetailsApi();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsMarketplaceNoPurchaseFeedbackTestGroup> advertDetailsMarketplaceNoPurchaseFeedbackTestGroup();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @AdvertDetailsNoCallFeedback
    @NotNull
    ManuallyExposedAbTestGroup<AdvertDetailsNoCallFeedbackTestGroup> advertDetailsNoCallFeedbackTestGroup();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @AntiFraudCheckList
    @NotNull
    SingleManuallyExposedAbTestGroup<AntiFraudCheckListTestGroup> antiFraudCheckListTest();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    AppCallsUsageTracker appCallUsageTracker();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies
    @NotNull
    AsyncPhoneApi asyncPhoneApi();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    AvitoMessengerApi avitoMessengerApi();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallUuidProvider callUuidProvider();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.in_app_calls.di.SendCallLogsDependencies
    @NotNull
    CallsApi callsApi();

    @Override // com.avito.android.analytics.di.ClickStreamDeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    JobApi jobApi();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @JobApplicationProgressBar
    @NotNull
    ExposedAbTestGroup<SimpleTestGroup> jobApplicationProgressBarTestGroup();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @JustDialSellerPhoneTestGroup
    @NotNull
    AbTestGroup<SimpleTestGroupWithControl2> justDialSellerPhoneTestGroup();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies
    @NotNull
    PermissionChecker permissionChecker();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.di.ClickStreamSendDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    ProfileInfoStorage profileInfoStorage();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    ScreenTrackerFactory screenTrackerFactory();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @SendEmployersPhoneOnCallToSellerButtonClickInResumes
    @NotNull
    AbTestGroup<SendEmployersPhoneOnCallToSellerButtonClickInResumesTestGroup> sendEmployersPhoneOnCallToSellerButtonClickInResumes();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    TeaserObserver teaserObserver();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    TimerFactory timerFactory();

    @Override // com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();
}
