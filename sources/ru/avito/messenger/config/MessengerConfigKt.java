package ru.avito.messenger.config;

import com.avito.android.remote.model.messenger.MessengerTimestamp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.internal.ConstantsKt;
import ru.avito.messenger.internal.entity.messenger.ServerConfig;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/internal/entity/messenger/ServerConfig;", "Lru/avito/messenger/config/MessengerConfig;", "toMessengerConfig", "(Lru/avito/messenger/internal/entity/messenger/ServerConfig;)Lru/avito/messenger/config/MessengerConfig;", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class MessengerConfigKt {
    @NotNull
    public static final MessengerConfig toMessengerConfig(@NotNull ServerConfig serverConfig) {
        Intrinsics.checkNotNullParameter(serverConfig, "$this$toMessengerConfig");
        Long timeToModifyMessage = serverConfig.getTimeToModifyMessage();
        return new MessengerConfig(timeToModifyMessage != null ? timeToModifyMessage.longValue() : MessengerTimestamp.fromMillis(ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS));
    }
}
