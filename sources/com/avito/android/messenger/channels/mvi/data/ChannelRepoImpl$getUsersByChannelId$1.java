package com.avito.android.messenger.channels.mvi.data;

import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\b\u0004\u0010\t\u001a.\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lru/avito/android/persistence/messenger/UserEntity;", "users", "", "", "", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelRepoImpl$getUsersByChannelId$1<T, R> implements Function<List<? extends UserEntity>, Map<String, ? extends List<UserEntity>>> {
    public final /* synthetic */ ChannelRepoImpl a;

    public ChannelRepoImpl$getUsersByChannelId$1(ChannelRepoImpl channelRepoImpl) {
        this.a = channelRepoImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ Map<String, ? extends List<UserEntity>> apply(List<? extends UserEntity> list) {
        return apply((List<UserEntity>) list);
    }

    public final Map<String, List<UserEntity>> apply(@NotNull List<UserEntity> list) {
        Intrinsics.checkNotNullParameter(list, "users");
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
