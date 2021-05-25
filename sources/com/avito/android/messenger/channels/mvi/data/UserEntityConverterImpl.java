package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.User;
import com.avito.android.remote.model.messenger.PublicProfile;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverterImpl;", "Lcom/avito/android/messenger/channels/mvi/data/UserEntityConverter;", "Lru/avito/android/persistence/messenger/UserEntity;", "userEntity", "Lcom/avito/android/remote/model/User;", "toUser", "(Lru/avito/android/persistence/messenger/UserEntity;)Lcom/avito/android/remote/model/User;", "", "localUserId", "channelId", "user", "toUserEntity", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/User;)Lru/avito/android/persistence/messenger/UserEntity;", "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;", "channelPropertySerializer", "<init>", "(Lcom/avito/android/messenger/channels/mvi/data/ChannelPropertySerializer;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UserEntityConverterImpl implements UserEntityConverter {
    public final ChannelPropertySerializer a;

    @Inject
    public UserEntityConverterImpl(@NotNull ChannelPropertySerializer channelPropertySerializer) {
        Intrinsics.checkNotNullParameter(channelPropertySerializer, "channelPropertySerializer");
        this.a = channelPropertySerializer;
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserEntityConverter
    @NotNull
    public User toUser(@NotNull UserEntity userEntity) {
        Intrinsics.checkNotNullParameter(userEntity, "userEntity");
        String userId = userEntity.getUserId();
        String name = userEntity.getName();
        Long lastActionTime = userEntity.getLastActionTime();
        Long timeDiff = userEntity.getTimeDiff();
        String jsonPublicProfile = userEntity.getJsonPublicProfile();
        return new User(userId, name, lastActionTime, timeDiff, jsonPublicProfile != null ? (PublicProfile) this.a.deserialize(PublicProfile.class, jsonPublicProfile) : null);
    }

    @Override // com.avito.android.messenger.channels.mvi.data.UserEntityConverter
    @NotNull
    public UserEntity toUserEntity(@NotNull String str, @NotNull String str2, @NotNull User user) {
        Intrinsics.checkNotNullParameter(str, "localUserId");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(user, "user");
        String id = user.getId();
        String name = user.getName();
        Long lastActionTime = user.getLastActionTime();
        Long timeDiff = user.getTimeDiff();
        PublicProfile publicProfile = user.getPublicProfile();
        return new UserEntity(str, id, str2, name, lastActionTime, timeDiff, publicProfile != null ? this.a.serialize(PublicProfile.class, publicProfile) : null);
    }
}
