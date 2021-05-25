package com.avito.android.messenger.channels.mvi.sync;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0010\b\u001a*\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000 \u0004*\u0014\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00018\u00008\u0000\u0018\u00010\u00030\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "", "it", "Lio/reactivex/SingleSource;", "kotlin.jvm.PlatformType", "apply", "(Lkotlin/Unit;)Lio/reactivex/SingleSource;", "com/avito/android/util/Completables$flatMapSingle$1", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl$syncLatestChats$1$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1<T, R> implements Function<Unit, SingleSource<? extends T>> {
    public final /* synthetic */ ChannelSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ SortedSet e;
    public final /* synthetic */ SortedSet f;

    public ChannelSyncAgentImpl$syncLatestChats$1$syncPartialPageOfChatsFromServerWithDb$$inlined$flatMapSingle$1(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list, int i, SortedSet sortedSet, SortedSet sortedSet2) {
        this.a = channelSyncAgentImpl;
        this.b = str;
        this.c = list;
        this.d = i;
        this.e = sortedSet;
        this.f = sortedSet2;
    }

    public final SingleSource<? extends T> apply(@NotNull Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "it");
        return ChannelSyncAgentImpl.access$getOldestSyncedChatTimestamp(this.a, this.b, this.c, this.d, this.e, this.f);
    }
}
