package com.avito.android.messenger.conversation.mvi.context;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lru/avito/messenger/MessengerState;", "connectionState", "", "kotlin.jvm.PlatformType", "apply", "(Lru/avito/messenger/MessengerState;)Ljava/lang/Boolean;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$subscribeToConnectingStateChanges$1<T, R> implements Function<MessengerState, Boolean> {
    public static final ChannelContextInteractorImpl$subscribeToConnectingStateChanges$1 INSTANCE = new ChannelContextInteractorImpl$subscribeToConnectingStateChanges$1();

    public final Boolean apply(@NotNull MessengerState messengerState) {
        Intrinsics.checkNotNullParameter(messengerState, "connectionState");
        return Boolean.valueOf(messengerState instanceof MessengerState.Connecting);
    }
}
