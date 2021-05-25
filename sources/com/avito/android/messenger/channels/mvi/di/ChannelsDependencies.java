package com.avito.android.messenger.channels.mvi.di;

import android.content.SharedPreferences;
import com.avito.android.MessengerWorkFactory;
import com.avito.android.ab_tests.MessengerSearchIconTest;
import com.avito.android.ab_tests.groups.AdCascadesInChannelsTestGroup;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.cart_fab.CartFabDependencies;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.serp.ad.MyTargetImageBgProvider;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.preferences.PreferenceFactory;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u001a\u0010\u0006\u001a\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\u00050\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H'¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H&¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020908H&¢\u0006\u0004\b:\u0010;J\u0015\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<H&¢\u0006\u0004\b>\u0010?J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@08H&¢\u0006\u0004\bA\u0010;J\u000f\u0010C\u001a\u00020BH&¢\u0006\u0004\bC\u0010D¨\u0006E"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/di/ChannelsDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/cart_fab/CartFabDependencies;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "messengerClient", "()Lru/avito/messenger/MessengerClient;", "Lcom/avito/android/MessengerWorkFactory;", "messengerWorkFactory", "()Lcom/avito/android/MessengerWorkFactory;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "notificationManagerProvider", "()Lcom/avito/android/notification_manager_provider/NotificationManagerProvider;", "Landroid/content/SharedPreferences;", "sharedPreferences", "()Landroid/content/SharedPreferences;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "messengerDatabase", "()Lru/avito/android/persistence/messenger/MessengerDatabase;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "messageBodySerializer", "()Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "channelContextSerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "channelPropertySerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "()Lcom/avito/android/messenger/MessengerEntityConverter;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "messengerSearchIconTestGroup", "()Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelsSyncAgent", "()Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "userLastActivitySyncAgent", "()Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "Lcom/avito/android/util/preferences/PreferenceFactory;", "preferenceFactory", "()Lcom/avito/android/util/preferences/PreferenceFactory;", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/AdCascadesInChannelsTestGroup;", "adCascadesInChannelsTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChannelGroup", "Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "myTargetImageBgProvider", "()Lcom/avito/android/serp/ad/MyTargetImageBgProvider;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsDependencies extends CoreComponentDependencies, CartFabDependencies {
    @NotNull
    SingleManuallyExposedAbTestGroup<AdCascadesInChannelsTestGroup> adCascadesInChannelsTestGroup();

    @NotNull
    BlockUserInteractor blockUserInteractor();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies
    @NotNull
    ChannelContextSerializer channelContextSerializer();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies
    @NotNull
    ChannelPropertySerializer channelPropertySerializer();

    @NotNull
    ChannelSyncAgent channelsSyncAgent();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessageBodySerializer messageBodySerializer();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies
    @NotNull
    MessengerClient<AvitoMessengerApi> messengerClient();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerDatabase messengerDatabase();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerEntityConverter messengerEntityConverter();

    @NotNull
    ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabsTestGroup();

    @MessengerSearchIconTest
    @NotNull
    SimpleTestGroup messengerSearchIconTestGroup();

    @Override // com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    MessengerWorkFactory messengerWorkFactory();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    MyTargetImageBgProvider myTargetImageBgProvider();

    @Override // com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    NotificationManagerProvider notificationManagerProvider();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.user_stats.di.UserStatsDependencies
    @NotNull
    PreferenceFactory preferenceFactory();

    @NotNull
    SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChannelGroup();

    @NotNull
    SharedPreferences sharedPreferences();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies
    @NotNull
    TreeStateIdGenerator treeStateIdGenerator();

    @NotNull
    UserLastActivitySyncAgent userLastActivitySyncAgent();
}
