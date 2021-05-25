package com.avito.android.messenger.channels.mvi.data;

import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Function3;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.ChannelEntity;
import ru.avito.android.persistence.messenger.MessageEntity;
import ru.avito.android.persistence.messenger.UserEntity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u000b\u0010\u000b\u001a\u00028\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0000\"\b\b\u0002\u0010\u0003*\u00020\u0000\"\b\b\u0003\u0010\u0004*\u00020\u00002\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0002H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"", "T1", "T2", "T3", "R", "t1", "t2", "t3", "apply", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/avito/android/util/Observables$observableCombineLatest$3", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelRepoImpl$getChannelsAndDraftsStartingFromTimestamp$1$toListOfChannelsObservable$$inlined$observableCombineLatest$1<T1, T2, T3, R> implements Function3<T1, T2, T3, R> {
    public final /* synthetic */ ChannelRepoImpl a;
    public final /* synthetic */ List b;

    public ChannelRepoImpl$getChannelsAndDraftsStartingFromTimestamp$1$toListOfChannelsObservable$$inlined$observableCombineLatest$1(ChannelRepoImpl channelRepoImpl, List list) {
        this.a = channelRepoImpl;
        this.b = list;
    }

    @Override // io.reactivex.functions.Function3
    @NotNull
    public final R apply(@NotNull T1 t1, @NotNull T2 t2, @NotNull T3 t3) {
        Channel channel;
        Intrinsics.checkNotNullParameter(t1, "t1");
        Intrinsics.checkNotNullParameter(t2, "t2");
        Intrinsics.checkNotNullParameter(t3, "t3");
        T3 t32 = t3;
        T2 t22 = t2;
        T1 t12 = t1;
        ChannelRepoImpl channelRepoImpl = this.a;
        List<ChannelEntity> list = this.b;
        R r = (R) new ArrayList();
        for (ChannelEntity channelEntity : list) {
            List<UserEntity> list2 = (List) t12.get(channelEntity.getChannelId());
            if (list2 != null) {
                ChannelEntityConverter channelEntityConverter = channelRepoImpl.f;
                List list3 = (List) t22.get(channelEntity.getChannelId());
                if (list3 == null) {
                    list3 = CollectionsKt__CollectionsKt.emptyList();
                }
                channel = channelEntityConverter.toChannel(channelEntity, list2, list3, (MessageEntity) t32.get(channelEntity.getChannelId()));
            } else {
                channel = null;
            }
            if (channel != null) {
                r.add(channel);
            }
        }
        return r;
    }
}
