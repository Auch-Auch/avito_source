package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.model.User;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "", "Lru/avito/android/persistence/messenger/UserEntity;", "userEntity", "Lcom/avito/android/remote/model/User;", "toUser", "(Lru/avito/android/persistence/messenger/UserEntity;)Lcom/avito/android/remote/model/User;", "", "localUserId", "channelId", "user", "toUserEntity", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/User;)Lru/avito/android/persistence/messenger/UserEntity;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface UserEntityConverter {
    @NotNull
    User toUser(@NotNull UserEntity userEntity);

    @NotNull
    UserEntity toUserEntity(@NotNull String str, @NotNull String str2, @NotNull User user);
}
