package com.avito.android.messenger.channels.mvi.sync;

import a2.b.a.a.a;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgent;
import io.reactivex.Completable;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a*\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005 \u0006*\u0014\u0012\u000e\b\u0001\u0012\n \u0006*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\u00040\u00042\u0010\u0010\u0003\u001a\f\u0012\b\u0012\u00060\u0001j\u0002`\u00020\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Larrow/core/Option;", "", "Lcom/avito/android/messenger/channels/mvi/sync/Timestamp;", "oldestSyncedChatTimestamp", "Lio/reactivex/SingleSource;", "Lcom/avito/android/messenger/channels/mvi/sync/ChannelSyncAgent$SyncChatsResult;", "kotlin.jvm.PlatformType", "apply", "(Larrow/core/Option;)Lio/reactivex/SingleSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1<T, R> implements Function<Option<? extends Long>, SingleSource<? extends ChannelSyncAgent.SyncChatsResult>> {
    public final /* synthetic */ ChannelSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ SortedSet c;
    public final /* synthetic */ SortedSet d;

    public ChannelSyncAgentImpl$syncEmptyPageOfChatsFromServerWithDb$1(ChannelSyncAgentImpl channelSyncAgentImpl, String str, SortedSet sortedSet, SortedSet sortedSet2) {
        this.a = channelSyncAgentImpl;
        this.b = str;
        this.c = sortedSet;
        this.d = sortedSet2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends ChannelSyncAgent.SyncChatsResult> apply(Option<? extends Long> option) {
        return apply((Option<Long>) option);
    }

    public final SingleSource<? extends ChannelSyncAgent.SyncChatsResult> apply(@NotNull Option<Long> option) {
        Intrinsics.checkNotNullParameter(option, "oldestSyncedChatTimestamp");
        ChannelSyncAgentImpl channelSyncAgentImpl = this.a;
        String str = this.b;
        SortedSet sortedSet = this.c;
        SortedSet sortedSet2 = this.d;
        Completable K1 = a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.deleteNonEmptyChannelsOlderThanTimestamp(str, ((Number) OptionKt.getOrElse(option, ChannelSyncAgentImpl$deleteOlderDeprecatedChats$1.INSTANCE)).longValue(), sortedSet, sortedSet2), "channelRepo.deleteNonEmp…schedulers.computation())");
        StringBuilder sb = new StringBuilder();
        sb.append(" -> deleteOlderDeprecatedChats(userId = ");
        sb.append(str);
        sb.append(", oldestSyncedChatTimestamp = ");
        sb.append(option);
        sb.append(", tags = ");
        return channelSyncAgentImpl.log(K1, a.z(sb, sortedSet, ", excludeTags = ", sortedSet2, ')')).toSingleDefault(new ChannelSyncAgent.SyncChatsResult(option, false));
    }
}
