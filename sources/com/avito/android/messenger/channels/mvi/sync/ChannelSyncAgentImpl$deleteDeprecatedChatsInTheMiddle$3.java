package com.avito.android.messenger.channels.mvi.sync;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "chatIdsFromDb", "Lio/reactivex/CompletableSource;", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Lio/reactivex/CompletableSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3<T, R> implements Function<List<? extends String>, CompletableSource> {
    public final /* synthetic */ ChannelSyncAgentImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ List c;

    public ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3(ChannelSyncAgentImpl channelSyncAgentImpl, String str, List list) {
        this.a = channelSyncAgentImpl;
        this.b = str;
        this.c = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ CompletableSource apply(List<? extends String> list) {
        return apply((List<String>) list);
    }

    public final CompletableSource apply(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "chatIdsFromDb");
        ChannelSyncAgentImpl channelSyncAgentImpl = this.a;
        String str = this.b;
        List list2 = this.c;
        List<T> sortedWith = CollectionsKt___CollectionsKt.sortedWith(list2, new Comparator<T>() { // from class: com.avito.android.messenger.channels.mvi.sync.ChannelSyncAgentImpl$deleteDeprecatedChatsInTheMiddle$3$deleteChatsThatDoNotMatchTheOnesOnServerFromDb$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(Long.valueOf(t2.getUpdated()), Long.valueOf(t.getUpdated()));
            }
        });
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(sortedWith, 10));
        for (T t : sortedWith) {
            arrayList.add(t.getChannelId());
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (T t2 : list) {
            if (!Intrinsics.areEqual(t2, (String) arrayList.get(i))) {
                arrayList2.add(t2);
            } else if (i < arrayList.size() - 1) {
                i++;
            }
        }
        Completable K1 = a2.b.a.a.a.K1(channelSyncAgentImpl, channelSyncAgentImpl.g.deleteChannelsById(str, arrayList2), "channelRepo.deleteChanne…schedulers.computation())");
        StringBuilder R = a2.b.a.a.a.R(" -> deleteChatsThatDoNotMatchTheOnesOnServerFromDb(userId = ", str, ", chatIdsFromDb = (");
        R.append(list.size());
        R.append(")[...], chatsFromServer = (");
        R.append(list2.size());
        R.append(")[...])");
        return channelSyncAgentImpl.log(K1, R.toString());
    }
}
