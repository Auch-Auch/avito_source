package ru.avito.messenger.api.entity.context;

import com.avito.android.remote.model.messenger.PlatformSupport;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lru/avito/messenger/api/entity/context/ChannelContextActions;", "", "Lcom/avito/android/remote/model/messenger/PlatformSupport;", "getPlatformSupport", "()Lcom/avito/android/remote/model/messenger/PlatformSupport;", PlatformActions.PLATFORM_SUPPORT, "", "getVersion", "()Ljava/lang/Long;", "version", "", "getMessageId", "()Ljava/lang/String;", "messageId", "models_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelContextActions {
    @Nullable
    String getMessageId();

    @Nullable
    PlatformSupport getPlatformSupport();

    @Nullable
    Long getVersion();
}
