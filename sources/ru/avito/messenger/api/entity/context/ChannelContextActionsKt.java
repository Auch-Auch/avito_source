package ru.avito.messenger.api.entity.context;

import com.avito.android.remote.model.messenger.PlatformSupport;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0018\u0010\u0002\u001a\u00020\u0001*\u00020\u00008Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lru/avito/messenger/api/entity/context/ChannelContextActions;", "", "isSupported", "(Lru/avito/messenger/api/entity/context/ChannelContextActions;)Z", "models_release"}, k = 2, mv = {1, 4, 2})
public final class ChannelContextActionsKt {
    public static final boolean isSupported(@NotNull ChannelContextActions channelContextActions) {
        List<String> platforms;
        Intrinsics.checkNotNullParameter(channelContextActions, "$this$isSupported");
        PlatformSupport platformSupport = channelContextActions.getPlatformSupport();
        if (platformSupport == null || (platforms = platformSupport.getPlatforms()) == null) {
            return true;
        }
        return platforms.contains("android");
    }
}
