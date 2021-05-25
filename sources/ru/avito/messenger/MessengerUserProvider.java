package ru.avito.messenger;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.ChannelUser;
import ru.avito.messenger.api.entity.UserLastActivity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/avito/messenger/MessengerUserProvider;", "", "", "", "userIds", "Lio/reactivex/Single;", "Lru/avito/messenger/api/entity/UserLastActivity;", "getUserLastActivity", "(Ljava/util/List;)Lio/reactivex/Single;", "channelId", "Lru/avito/messenger/api/entity/ChannelUser;", "getUsers", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Single;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerUserProvider {
    @NotNull
    Single<List<UserLastActivity>> getUserLastActivity(@NotNull List<String> list);

    @NotNull
    Single<List<ChannelUser>> getUsers(@NotNull String str, @NotNull List<String> list);
}
