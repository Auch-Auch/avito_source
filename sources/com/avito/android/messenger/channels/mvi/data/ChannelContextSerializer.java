package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.model.messenger.context.ChannelContext;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/data/ChannelContextSerializer;", "", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "context", "", "serialize", "(Lcom/avito/android/remote/model/messenger/context/ChannelContext;)Ljava/lang/String;", "serializeType", "type", "jsonBody", "deserialize", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelContextSerializer {
    @NotNull
    ChannelContext deserialize(@NotNull String str, @NotNull String str2);

    @NotNull
    String serialize(@NotNull ChannelContext channelContext);

    @NotNull
    String serializeType(@NotNull ChannelContext channelContext);
}
