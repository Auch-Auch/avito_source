package com.avito.android.messenger.service.user_last_activity;

import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.event.ChatTypingEvent;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\b\b\u0002\u0010\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"KeyT", "", "EventT", "OutT", "event", "apply", "(Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/util/Observables$transformByKey$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$subscribeToBackendNotifications$$inlined$transformByKey$1<T, R> implements Function<ChatTypingEvent, String> {
    @Override // io.reactivex.functions.Function
    @Nullable
    public final String apply(@NotNull ChatTypingEvent chatTypingEvent) {
        Intrinsics.checkNotNullParameter(chatTypingEvent, "event");
        return chatTypingEvent.getFromId();
    }
}
