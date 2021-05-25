package com.avito.android.messenger.channels.mvi.data;

import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessageEntity;
import t6.n.q;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\b\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001 \u0005*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lru/avito/android/persistence/messenger/MessageEntity;", "messages", "", "", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelRepoImpl$getLastMessagesByChannelId$1<T, R> implements Function<List<? extends MessageEntity>, Map<String, ? extends MessageEntity>> {
    public static final ChannelRepoImpl$getLastMessagesByChannelId$1 INSTANCE = new ChannelRepoImpl$getLastMessagesByChannelId$1();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Map<String, ? extends MessageEntity> apply(List<? extends MessageEntity> list) {
        return apply((List<MessageEntity>) list);
    }

    public final Map<String, MessageEntity> apply(@NotNull List<MessageEntity> list) {
        Intrinsics.checkNotNullParameter(list, "messages");
        LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(list, 10)), 16));
        for (T t : list) {
            linkedHashMap.put(t.getChannelId(), t);
        }
        return linkedHashMap;
    }
}
