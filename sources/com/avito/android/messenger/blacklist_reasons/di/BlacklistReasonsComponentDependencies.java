package com.avito.android.messenger.blacklist_reasons.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsProvider;
import com.avito.android.messenger.blacklist_reasons.BlockUserInteractor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/di/BlacklistReasonsComponentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", "messengerClient", "()Lru/avito/messenger/MessengerClient;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "blacklistReasonsProvider", "()Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsProvider;", "Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "blockUserInteractor", "()Lcom/avito/android/messenger/blacklist_reasons/BlockUserInteractor;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface BlacklistReasonsComponentDependencies extends CoreComponentDependencies {
    @NotNull
    BlacklistReasonsProvider blacklistReasonsProvider();

    @Override // com.avito.android.messenger.channels.mvi.di.ChannelsDependencies
    @NotNull
    BlockUserInteractor blockUserInteractor();

    @Override // com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.conversation.create.di.CreateChannelFragmentDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.support.di.SupportChatFormDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.feedback_adverts.di.FeedbackAdvertsDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies
    @NotNull
    MessengerClient<AvitoMessengerApi> messengerClient();
}
