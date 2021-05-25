package com.avito.android.messenger.channels.mvi.sync;

import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "", "chatIds", "", "test", "(Ljava/util/List;)Z", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2<T> implements Predicate<List<? extends String>> {
    public static final ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2 INSTANCE = new ChannelSyncAgentImpl$getNonEmptyChatIdsFromDb$2();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Predicate
    public /* bridge */ /* synthetic */ boolean test(List<? extends String> list) {
        return test((List<String>) list);
    }

    public final boolean test(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "chatIds");
        return !list.isEmpty();
    }
}
