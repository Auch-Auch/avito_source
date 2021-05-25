package com.avito.android.messenger.channels.mvi.sync;

import arrow.core.Option;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Larrow/core/Option;", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "oldestSyncedChatTimestamp", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3<T, R> implements Function<Option<? extends Long>, ChannelSyncAgent.SyncChatsResult> {
    public static final ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3 INSTANCE = new ChannelSyncAgentImpl$syncFullPageOfChatsFromServerWithDb$3();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ ChannelSyncAgent.SyncChatsResult apply(Option<? extends Long> option) {
        return apply((Option<Long>) option);
    }

    public final ChannelSyncAgent.SyncChatsResult apply(@NotNull Option<Long> option) {
        Intrinsics.checkNotNullParameter(option, "oldestSyncedChatTimestamp");
        return new ChannelSyncAgent.SyncChatsResult(option, true);
    }
}
