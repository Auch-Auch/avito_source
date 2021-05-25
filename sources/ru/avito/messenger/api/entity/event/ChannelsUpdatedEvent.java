package ru.avito.messenger.api.entity.event;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lru/avito/messenger/api/entity/event/ChannelsUpdatedEvent;", "", "", "", "Lru/avito/messenger/api/entity/event/ChannelUpdate;", ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS, "Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsUpdatedEvent {
    @SerializedName(ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS)
    @JvmField
    @NotNull
    public final Map<String, ChannelUpdate> channels;

    public ChannelsUpdatedEvent(@NotNull Map<String, ChannelUpdate> map) {
        Intrinsics.checkNotNullParameter(map, ScreenPublicConstsKt.CONTENT_TYPE_CHANNELS);
        this.channels = map;
    }
}
