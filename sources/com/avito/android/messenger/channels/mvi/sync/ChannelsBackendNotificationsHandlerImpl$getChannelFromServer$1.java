package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.messenger.MessengerEntityConverter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.Channel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lru/avito/messenger/api/entity/Channel;", "p1", "Lcom/avito/android/remote/model/messenger/Channel;", "invoke", "(Lru/avito/messenger/api/entity/Channel;)Lcom/avito/android/remote/model/messenger/Channel;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1 extends FunctionReferenceImpl implements Function1<Channel, com.avito.android.remote.model.messenger.Channel> {
    public ChannelsBackendNotificationsHandlerImpl$getChannelFromServer$1(MessengerEntityConverter messengerEntityConverter) {
        super(1, messengerEntityConverter, MessengerEntityConverter.class, "convertChannel", "convertChannel(Lru/avito/messenger/api/entity/Channel;)Lcom/avito/android/remote/model/messenger/Channel;", 0);
    }

    @NotNull
    public final com.avito.android.remote.model.messenger.Channel invoke(@NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "p1");
        return ((MessengerEntityConverter) this.receiver).convertChannel(channel);
    }
}
