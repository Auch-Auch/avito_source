package com.avito.android.messenger.di;

import com.avito.android.ServiceIntentFactory;
import com.avito.android.ab_tests.groups.MessengerFolderTabsTestGroup;
import com.avito.android.ab_tests.groups.PublishReviewFromChatChannelGroup;
import com.avito.android.ab_tests.models.ManuallyExposedAbTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.NetworkTypeProvider;
import com.avito.android.calls.remote.CallsApi;
import com.avito.android.calls_shared.AppCallsUsageTracker;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.MessageLocalIdGenerator;
import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.TextToChunkConverter;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.adapter.GoogleApiKey;
import com.avito.android.messenger.conversation.adapter.YandexApiKey;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.send.MessengerPhotoStorage;
import com.avito.android.messenger.conversation.mvi.sync.MessageSyncAgent;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgent;
import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import com.avito.android.permissions.PermissionChecker;
import com.avito.android.permissions.PermissionStorage;
import com.avito.android.rating.remote.RatingApi;
import com.avito.android.remote.DeliveryApi;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.safedeal.remote.SafeDealApi;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.PrivatePhotosStorage;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.shared_image_files_storage.SharedPhotosStorage;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.MessengerConnection;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.config.MessengerConfigProvider;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H&¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H&¢\u0006\u0004\b-\u0010.J\u000f\u00100\u001a\u00020/H&¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H&¢\u0006\u0004\b3\u00104J\u000f\u00106\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\b\u0012\u0004\u0012\u00020908H&¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u00020<H&¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H&¢\u0006\u0004\b@\u0010AJ\u000f\u0010C\u001a\u00020BH&¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH&¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH&¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020KH&¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH&¢\u0006\u0004\bO\u0010PJ\u000f\u0010R\u001a\u00020QH&¢\u0006\u0004\bR\u0010SJ\u000f\u0010U\u001a\u00020TH&¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH&¢\u0006\u0004\bX\u0010YJ\u000f\u0010[\u001a\u00020ZH&¢\u0006\u0004\b[\u0010\\J\u000f\u0010^\u001a\u00020]H&¢\u0006\u0004\b^\u0010_J\u000f\u0010a\u001a\u00020`H&¢\u0006\u0004\ba\u0010bJ\u000f\u0010d\u001a\u00020cH&¢\u0006\u0004\bd\u0010eJ\u000f\u0010g\u001a\u00020fH&¢\u0006\u0004\bg\u0010hJ\u000f\u0010j\u001a\u00020iH&¢\u0006\u0004\bj\u0010kJ\u0015\u0010n\u001a\b\u0012\u0004\u0012\u00020m0lH&¢\u0006\u0004\bn\u0010oJ\u0015\u0010r\u001a\b\u0012\u0004\u0012\u00020q0pH&¢\u0006\u0004\br\u0010sJ\u000f\u0010u\u001a\u00020tH&¢\u0006\u0004\bu\u0010vJ\u000f\u0010x\u001a\u00020wH&¢\u0006\u0004\bx\u0010yJ\u000f\u0010{\u001a\u00020zH&¢\u0006\u0004\b{\u0010|J\u000f\u0010~\u001a\u00020}H&¢\u0006\u0004\b~\u0010J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001J\u0013\u0010\u0001\u001a\u00030\u0001H&¢\u0006\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/messenger/di/ChannelActivityDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "blacklistReasonsProvider", "()Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "()Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "channelContextSerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "channelPropertySerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "connectivityProvider", "()Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "()Lcom/avito/android/deep_linking/DeepLinkFactory;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "Lcom/avito/android/remote/DeliveryApi;", "deliveryApi", "()Lcom/avito/android/remote/DeliveryApi;", "Lcom/avito/android/safedeal/remote/SafeDealApi;", "safeDealApi", "()Lcom/avito/android/safedeal/remote/SafeDealApi;", "Lcom/avito/android/rating/remote/RatingApi;", "ratingApi", "()Lcom/avito/android/rating/remote/RatingApi;", "Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "googleApiKey", "()Lcom/avito/android/messenger/conversation/adapter/GoogleApiKey;", "Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "yandexApiKey", "()Lcom/avito/android/messenger/conversation/adapter/YandexApiKey;", "Ljava/util/Locale;", "locale", "()Ljava/util/Locale;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "messageBodySerializer", "()Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lcom/avito/android/messenger/MessageLocalIdGenerator;", "messageLocalIdGenerator", "()Lcom/avito/android/messenger/MessageLocalIdGenerator;", "Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "messageSyncAgent", "()Lcom/avito/android/messenger/conversation/mvi/sync/MessageSyncAgent;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "messengerClient", "()Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/MessengerConnection;", "messengerConnection", "()Lru/avito/messenger/MessengerConnection;", "Lcom/avito/android/messenger/MessengerEntityConverter;", "messengerEntityConverter", "()Lcom/avito/android/messenger/MessengerEntityConverter;", "Lcom/avito/android/messenger/TextToChunkConverter;", "textToChunkConverter", "()Lcom/avito/android/messenger/TextToChunkConverter;", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "messengerDatabase", "()Lru/avito/android/persistence/messenger/MessengerDatabase;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "Lcom/avito/android/ServiceIntentFactory;", "serviceIntentFactory", "()Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/remote/ShortTermRentApi;", "shortTermRentApi", "()Lcom/avito/android/remote/ShortTermRentApi;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "typedErrorThrowableConverter", "()Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "userLastActivitySyncAgent", "()Lcom/avito/android/messenger/service/user_last_activity/UserLastActivitySyncAgent;", "Lru/avito/messenger/config/MessengerConfigProvider;", "messengerConfigProvider", "()Lru/avito/messenger/config/MessengerConfigProvider;", "Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "messengerPhotoStorage", "()Lcom/avito/android/messenger/conversation/mvi/send/MessengerPhotoStorage;", "Lcom/avito/android/calls/remote/CallsApi;", "callsApi", "()Lcom/avito/android/calls/remote/CallsApi;", "Lcom/avito/android/calls_shared/CallUuidProvider;", "callUuidProvider", "()Lcom/avito/android/calls_shared/CallUuidProvider;", "Lcom/avito/android/analytics/NetworkTypeProvider;", "networkTypeProvider", "()Lcom/avito/android/analytics/NetworkTypeProvider;", "Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "appCallUsageTracker", "()Lcom/avito/android/calls_shared/AppCallsUsageTracker;", "Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/MessengerFolderTabsTestGroup;", "messengerFolderTabsTestGroup", "()Lcom/avito/android/ab_tests/models/ManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/PublishReviewFromChatChannelGroup;", "publishReviewFromChannelTestGroup", "()Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/util/PrivatePhotosStorage;", "privatePhotosStorage", "()Lcom/avito/android/util/PrivatePhotosStorage;", "Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "sharedPhotosStorage", "()Lcom/avito/android/util/shared_image_files_storage/SharedPhotosStorage;", "Lcom/avito/android/permissions/PermissionChecker;", "permissionChecker", "()Lcom/avito/android/permissions/PermissionChecker;", "Lcom/avito/android/permissions/PermissionStorage;", "permissionStorage", "()Lcom/avito/android/permissions/PermissionStorage;", "Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "fileStorageHelper", "()Lcom/avito/android/messenger/conversation/mvi/file_attachment/FileStorageHelper;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "messengerFileUploadCanceller", "()Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadCanceller;", "Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "missingUsersSyncAgent", "()Lcom/avito/android/messenger/conversation/mvi/sync/MissingUsersSyncAgent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelActivityDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies
    @NotNull
    AppCallsUsageTracker appCallUsageTracker();

    @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponentDependencies
    @NotNull
    BlacklistReasonsProvider blacklistReasonsProvider();

    @Override // com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies
    @NotNull
    BlockUserInteractor blockUserInteractor();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    CallUuidProvider callUuidProvider();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.in_app_calls.di.SendCallLogsDependencies
    @NotNull
    CallsApi callsApi();

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies
    @NotNull
    ChannelContextSerializer channelContextSerializer();

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies
    @NotNull
    ChannelPropertySerializer channelPropertySerializer();

    @Override // com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies
    @NotNull
    ChannelSyncAgent channelSyncAgent();

    @Override // com.avito.android.photo_gallery.di.GalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    ConnectivityProvider connectivityProvider();

    @Override // com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies
    @NotNull
    DeepLinkFactory deepLinkFactory();

    @Override // com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.analytics.di.ClickStreamDeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.user_subscribers.di.UserSubscribersDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.advert_core.dialog.di.DialogDeepLinkActivityDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies, com.avito.android.profile_phones.add_phone.di.AddPhoneDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.profile.tfa.settings.di.TfaSettingsDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies, com.avito.android.screen_opener.di.ProfileScreenResolverFragmentDependencies
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    DeliveryApi deliveryApi();

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies
    @NotNull
    FileStorageHelper fileStorageHelper();

    @NotNull
    GoogleApiKey googleApiKey();

    @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    Locale locale();

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessageBodySerializer messageBodySerializer();

    @NotNull
    MessageLocalIdGenerator messageLocalIdGenerator();

    @NotNull
    MessageSyncAgent messageSyncAgent();

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.blacklist_reasons.di.BlacklistReasonsComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies
    @NotNull
    MessengerClient<AvitoMessengerApi> messengerClient();

    @NotNull
    MessengerConfigProvider messengerConfigProvider();

    @NotNull
    MessengerConnection messengerConnection();

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerDatabase messengerDatabase();

    @Override // com.avito.android.messenger.di.IncompleteMessageLoaderDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerEntityConverter messengerEntityConverter();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerFileUploadCanceller messengerFileUploadCanceller();

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies
    @NotNull
    ManuallyExposedAbTestGroup<MessengerFolderTabsTestGroup> messengerFolderTabsTestGroup();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerPhotoStorage messengerPhotoStorage();

    @NotNull
    MissingUsersSyncAgent missingUsersSyncAgent();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies
    @NotNull
    NetworkTypeProvider networkTypeProvider();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies
    @NotNull
    PermissionChecker permissionChecker();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies
    @NotNull
    PermissionStorage permissionStorage();

    @Override // com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.di.ClickStreamSendDependencies, com.avito.android.settings.di.SettingsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @Override // com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    PrivatePhotosStorage privatePhotosStorage();

    @NotNull
    SingleManuallyExposedAbTestGroup<PublishReviewFromChatChannelGroup> publishReviewFromChannelTestGroup();

    @Override // com.avito.android.rating.review_details.di.ReviewDetailsDependencies
    @NotNull
    RatingApi ratingApi();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies
    @NotNull
    SafeDealApi safeDealApi();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.cpo_program.di.AutotekaCpoProgramDependencies, com.avito.android.advert.closed.di.ClosedAdvertDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies
    @NotNull
    ServiceIntentFactory serviceIntentFactory();

    @Override // com.avito.android.photo_wizard.di.WizardImageUploadDependencies
    @NotNull
    SharedPhotosStorage sharedPhotosStorage();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.consultation_form.di.ConsultationFormDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies
    @NotNull
    ShortTermRentApi shortTermRentApi();

    @NotNull
    TextToChunkConverter textToChunkConverter();

    @Override // com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @Override // com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.notes.di.AdvertDetailsNoteDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.payment.lib.di.PaymentLibraryDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.soa_stat.di.SoaStatProfileSettingsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.safedeal.profile_settings.di.ProfileDeliverySettingsDependencies, com.avito.android.profile.sessions.list.di.SessionsListDependencies, com.avito.android.profile.sessions.social_logout.di.SessionsSocialLogoutDependencies, com.avito.android.authorization.login_protection.di.LoginProtectionPhoneListDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.orders.di.component.OrdersDependencies, com.avito.android.booking.di.BookingInfoDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.user_stats.di.UserStatsDependencies, com.avito.android.verification.di.VerificationsListDependencies, com.avito.android.verification.di.VerificationStatusDependencies, com.avito.android.verification.di.VerificationActionDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies
    @NotNull
    TypedErrorThrowableConverter typedErrorThrowableConverter();

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies
    @NotNull
    UserLastActivitySyncAgent userLastActivitySyncAgent();

    @NotNull
    YandexApiKey yandexApiKey();
}
