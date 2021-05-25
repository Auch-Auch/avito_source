package com.avito.android.messenger.conversation.create.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.channels.mvi.data.ChannelContextSerializer;
import com.avito.android.messenger.channels.mvi.data.ChannelPropertySerializer;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00070\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/avito/android/messenger/conversation/create/di/CreateChannelFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "messengerClient", "()Lru/avito/messenger/MessengerClient;", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "messengerDatabase", "()Lru/avito/android/persistence/messenger/MessengerDatabase;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "channelContextSerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "channelPropertySerializer", "()Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "messageBodySerializer", "()Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "channelSyncAgent", "()Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface CreateChannelFragmentDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @NotNull
    ChannelContextSerializer channelContextSerializer();

    @NotNull
    ChannelPropertySerializer channelPropertySerializer();

    @NotNull
    ChannelSyncAgent channelSyncAgent();

    @Override // com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessageBodySerializer messageBodySerializer();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies
    @NotNull
    MessengerClient<AvitoMessengerApi> messengerClient();

    @Override // com.avito.android.messenger.di.OpenErrorTrackerDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerDatabase messengerDatabase();
}
