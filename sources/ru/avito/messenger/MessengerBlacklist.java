package ru.avito.messenger;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.BlockedUser;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00052\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ;\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lru/avito/messenger/MessengerBlacklist;", "", "", "offset", "limit", "Lio/reactivex/Single;", "", "Lru/avito/messenger/api/entity/BlockedUser;", "getBlacklist", "(ILjava/lang/Integer;)Lio/reactivex/Single;", "", ChannelContext.Item.USER_ID, "", "removeFromBlacklist", "(Ljava/lang/String;)Lio/reactivex/Single;", "channelId", "itemId", "", "reasonId", "", "addToBlacklist", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerBlacklist {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Single addToBlacklist$default(MessengerBlacklist messengerBlacklist, String str, String str2, String str3, Long l, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    l = null;
                }
                return messengerBlacklist.addToBlacklist(str, str2, str3, l);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addToBlacklist");
        }

        public static /* synthetic */ Single getBlacklist$default(MessengerBlacklist messengerBlacklist, int i, Integer num, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    num = null;
                }
                return messengerBlacklist.getBlacklist(i, num);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBlacklist");
        }
    }

    @NotNull
    Single<Unit> addToBlacklist(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable Long l);

    @NotNull
    Single<List<BlockedUser>> getBlacklist(int i, @Nullable Integer num);

    @NotNull
    Single<Boolean> removeFromBlacklist(@NotNull String str);
}
