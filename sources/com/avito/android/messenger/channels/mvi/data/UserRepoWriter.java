package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Completable;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.UserIdAndLastActionTime;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/UserRepoWriter;", "", "", "Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "userIdAndLastActionTimes", "Lio/reactivex/Completable;", "updateUserLastActionTimes", "(Ljava/util/Collection;)Lio/reactivex/Completable;", "", ChannelContext.Item.USER_ID, "", "lastActionTime", "timeDiff", "updateUserLastActionTime", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Lio/reactivex/Completable;", "channelId", "", "Lcom/avito/android/remote/model/User;", "users", "insertUsers", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface UserRepoWriter {
    @NotNull
    Completable insertUsers(@NotNull String str, @NotNull String str2, @NotNull List<User> list);

    @NotNull
    Completable updateUserLastActionTime(@NotNull String str, @Nullable Long l, @Nullable Long l2);

    @NotNull
    Completable updateUserLastActionTimes(@NotNull Collection<UserIdAndLastActionTime> collection);
}
