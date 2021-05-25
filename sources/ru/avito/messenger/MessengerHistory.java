package ru.avito.messenger;

import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.ChatMessage;
import ru.avito.messenger.api.entity.Image;
import ru.avito.messenger.api.entity.body.item.BodyItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001JG\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H&¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n0\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00190\u00180\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u001c\u0010\u001dJ+\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\nH&¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lru/avito/messenger/MessengerHistory;", "", "", "channelId", "", "before", "after", "", "limit", "Lio/reactivex/Single;", "", "Lru/avito/messenger/api/entity/ChatMessage;", "history", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;)Lio/reactivex/Single;", "timestamp", "", "markChannelAsRead", "(Ljava/lang/String;J)Lio/reactivex/Single;", "itemIds", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "getBodyItems", "(Ljava/util/List;)Lio/reactivex/Single;", "", "imageIds", "", "Lru/avito/messenger/api/entity/Image;", "getBodyImages", "(Ljava/util/Collection;)Lio/reactivex/Single;", "clearChat", "(Ljava/lang/String;)Lio/reactivex/Single;", "messageIds", "markMessagesAsRead", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerHistory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single history$default(MessengerHistory messengerHistory, String str, Long l, Long l2, Integer num, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    l = null;
                }
                if ((i & 4) != 0) {
                    l2 = null;
                }
                if ((i & 8) != 0) {
                    num = null;
                }
                return messengerHistory.history(str, l, l2, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: history");
        }
    }

    @NotNull
    Single<String> clearChat(@NotNull String str);

    @NotNull
    Single<Map<String, Image>> getBodyImages(@NotNull Collection<String> collection);

    @NotNull
    Single<List<BodyItem>> getBodyItems(@NotNull List<String> list);

    @NotNull
    Single<List<ChatMessage>> history(@NotNull String str, @Nullable Long l, @Nullable Long l2, @Nullable Integer num);

    @NotNull
    Single<Unit> markChannelAsRead(@NotNull String str, long j);

    @NotNull
    Single<Unit> markMessagesAsRead(@NotNull String str, @NotNull List<String> list);
}
