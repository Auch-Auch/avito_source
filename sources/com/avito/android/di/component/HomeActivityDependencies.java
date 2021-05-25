package com.avito.android.di.component;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.MessengerWorkFactory;
import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.AbTests;
import com.avito.android.ab_tests.DraftsOnStartPublishSheet;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.groups.InAppUpdateTestGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.Analytics;
import com.avito.android.bottom_navigation.ui.fragment.factory.TabFragmentFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.ui.UserProfileStatusDataProvider;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#H&¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H'¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H&¢\u0006\u0004\b+\u0010,J\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-H'¢\u0006\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/avito/android/di/component/HomeActivityDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "searchSubscriptionSyncRunner", "()Lcom/avito/android/search/subscriptions/sync/SearchSubscriptionSyncRunner;", "Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "userAdvertsInfoUpdateRunner", "()Lcom/avito/android/user_advert/UserAdvertsInfoUpdateRunner;", "Lcom/avito/android/MessengerWorkFactory;", "messengerWorkFactory", "()Lcom/avito/android/MessengerWorkFactory;", "Lcom/avito/android/ui/UserProfileStatusDataProvider;", "userProfileStatusDataProvider", "()Lcom/avito/android/ui/UserProfileStatusDataProvider;", "Lcom/avito/android/analytics/Analytics;", "analytics", "()Lcom/avito/android/analytics/Analytics;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "tabFragmentFactory", "()Lcom/avito/android/bottom_navigation/ui/fragment/factory/TabFragmentFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory3", "()Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "()Lcom/avito/android/util/BuildInfo;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/configs/UserAdvertsTabTestGroup;", "userAdvertsTabManuallyExposedTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/util/preferences/Preferences;", "abTestsPreferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "inAppUpdateTestGroup", "()Lcom/avito/android/ab_tests/groups/InAppUpdateTestGroup;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "draftsOnStartPublishSheet", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "serp_release"}, k = 1, mv = {1, 4, 2})
public interface HomeActivityDependencies extends ComponentDependencies {
    @AbTests
    @NotNull
    Preferences abTestsPreferences();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.blocked_ip.di.BlockedIpDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.info.di.InfoActivityDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies
    @NotNull
    Analytics analytics();

    @Override // com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.photo_picker.legacy.di.PhotoContentProviderDependencies, com.avito.android.push.UpdateInstanceIdDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    BuildInfo buildInfo();

    @DraftsOnStartPublishSheet
    @NotNull
    ManuallyExposedAbTestGroup<SimpleTestGroup> draftsOnStartPublishSheet();

    @Override // com.avito.android.publish.di.PublishDependencies, com.avito.android.vas_performance.di.applied_services.AppliedServicesDependencies, com.avito.android.basket_legacy.di.shared.BasketDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.authorization.account_manager.di.AvitoAuthenticatorDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.social.di.esia.EsiaAuthDependencies, com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    @NotNull
    Features features();

    @NotNull
    InAppUpdateTestGroup inAppUpdateTestGroup();

    @Override // com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    MessengerWorkFactory messengerWorkFactory();

    @Override // com.avito.android.di.component.StoriesDependencies, com.avito.android.shop.detailed.di.ShopDetailedDependencies, com.avito.android.publish.di.PublishDependencies, com.avito.android.publish.start_publish.di.StartPublishDependencies, com.avito.android.publish_limits_info.history.di.PublishLimitsHistoryDependencies, com.avito.android.rating.user_reviews.di.UserReviewsDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.profile_phones.landline_verification.di.LandlinePhoneVerificationDependencies, com.avito.android.profile_phones.confirm_phone.di.ConfirmPhoneDependencies, com.avito.android.profile_phones.phone_action.di.PhoneActionDependencies, com.avito.android.profile_phones.phones_list.actions.di.PhoneActionsDependencies
    @NotNull
    SchedulersFactory3 schedulersFactory3();

    @Override // com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.search.subscriptions.di.SearchSubscriptionDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    SearchSubscriptionSyncRunner searchSubscriptionSyncRunner();

    @Override // com.avito.android.developments_catalog.di.DevelopmentsCatalogDependencies, com.avito.android.auto_catalog.di.AutoCatalogDependencies, com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @NotNull
    TabFragmentFactory tabFragmentFactory();

    @Override // com.avito.android.notification_center.list.di.NotificationCenterListDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner();

    @NotNull
    SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup> userAdvertsTabManuallyExposedTestGroup();

    @NotNull
    UserProfileStatusDataProvider userProfileStatusDataProvider();
}
