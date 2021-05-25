package com.avito.android.messenger.channels.mvi.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelTag;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0003\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00050\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "Lru/avito/android/persistence/messenger/ChannelTag;", "p1", "", "", "", "invoke", "(Ljava/util/List;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final /* synthetic */ class ChannelRepoImpl$getTagsByChannelId$1 extends FunctionReferenceImpl implements Function1<List<? extends ChannelTag>, Map<String, ? extends List<ChannelTag>>> {
    public ChannelRepoImpl$getTagsByChannelId$1(ChannelRepoImpl channelRepoImpl) {
        super(1, channelRepoImpl, ChannelRepoImpl.class, "toTagsMap", "toTagsMap(Ljava/util/List;)Ljava/util/Map;", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Map<String, ? extends List<ChannelTag>> invoke(List<? extends ChannelTag> list) {
        return invoke((List<ChannelTag>) list);
    }

    @NotNull
    public final Map<String, List<ChannelTag>> invoke(@NotNull List<ChannelTag> list) {
        Intrinsics.checkNotNullParameter(list, "p1");
        ChannelRepoImpl channelRepoImpl = (ChannelRepoImpl) this.receiver;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T t : list) {
            List list2 = (List) linkedHashMap.get(t.getChannelId());
            if (list2 != null) {
                list2.add(t);
            } else {
                linkedHashMap.put(t.getChannelId(), CollectionsKt__CollectionsKt.mutableListOf(t));
            }
        }
        return linkedHashMap;
    }
}
