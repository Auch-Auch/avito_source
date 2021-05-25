package com.avito.android.messenger.channels.mvi.presenter;

import com.avito.android.messenger.channels.mvi.view.ChannelListItem;
import com.avito.android.messenger.channels.mvi.view.PinnedSupportChatItem;
import com.avito.android.remote.model.messenger.Channel;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.DraftEntity;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Ja\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH&¢\u0006\u0004\b\u000e\u0010\u000fJa\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH&¢\u0006\u0004\b\u000e\u0010\u0012JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00130\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H&¢\u0006\u0004\b\u000e\u0010\u0014J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0002*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00130\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsListDataConverter;", "", "", "Lru/avito/messenger/api/entity/Channel;", "", "currentUserId", "", "typingChannelIds", "", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "lastMessagesFromDb", "Lru/avito/android/persistence/messenger/DraftEntity;", "drafts", "Lcom/avito/android/messenger/channels/mvi/view/ChannelListItem;", "convertToListItems", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "", "Lcom/avito/android/remote/model/messenger/Channel;", "(Ljava/util/Collection;Ljava/lang/String;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "Lkotlin/Pair;", "(Ljava/util/List;Ljava/lang/String;Ljava/util/Set;)Ljava/util/List;", "Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem;", "convertToPinnedSupportChatItems", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsListDataConverter {
    @NotNull
    List<ChannelListItem> convertToListItems(@NotNull Collection<Channel> collection, @NotNull String str, @NotNull Set<String> set, @NotNull Map<String, LocalMessage> map, @NotNull Map<String, DraftEntity> map2);

    @NotNull
    List<ChannelListItem> convertToListItems(@NotNull List<Pair<Channel, DraftEntity>> list, @NotNull String str, @NotNull Set<String> set);

    @NotNull
    List<ChannelListItem> convertToListItems(@NotNull List<ru.avito.messenger.api.entity.Channel> list, @NotNull String str, @NotNull Set<String> set, @NotNull Map<String, LocalMessage> map, @NotNull Map<String, DraftEntity> map2);

    @NotNull
    List<PinnedSupportChatItem> convertToPinnedSupportChatItems(@NotNull List<Pair<Channel, DraftEntity>> list, @NotNull String str);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List convertToListItems$default(ChannelsListDataConverter channelsListDataConverter, List list, String str, Set set, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 8) != 0) {
                    map2 = r.emptyMap();
                }
                return channelsListDataConverter.convertToListItems((List<ru.avito.messenger.api.entity.Channel>) list, str, (Set<String>) set, (Map<String, LocalMessage>) map, (Map<String, DraftEntity>) map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertToListItems");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.avito.android.messenger.channels.mvi.presenter.ChannelsListDataConverter */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List convertToListItems$default(ChannelsListDataConverter channelsListDataConverter, Collection collection, String str, Set set, Map map, Map map2, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = r.emptyMap();
                }
                if ((i & 8) != 0) {
                    map2 = r.emptyMap();
                }
                return channelsListDataConverter.convertToListItems(collection, str, set, map, map2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: convertToListItems");
        }
    }
}
