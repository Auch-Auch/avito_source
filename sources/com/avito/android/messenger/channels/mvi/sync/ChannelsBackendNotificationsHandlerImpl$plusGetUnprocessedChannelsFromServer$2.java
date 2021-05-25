package com.avito.android.messenger.channels.mvi.sync;

import com.avito.android.remote.model.messenger.Channel;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005 \u0002*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00042*\u0010\u0003\u001a&\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0012\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "kotlin.jvm.PlatformType", "downloadedChannels", "", "Lcom/avito/android/remote/model/messenger/Channel;", "apply", "([Ljava/lang/Object;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelsBackendNotificationsHandlerImpl$plusGetUnprocessedChannelsFromServer$2<T, R> implements Function<Object[], List<? extends Channel>> {
    public final /* synthetic */ List a;

    public ChannelsBackendNotificationsHandlerImpl$plusGetUnprocessedChannelsFromServer$2(List list) {
        this.a = list;
    }

    public final List<Channel> apply(@NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "downloadedChannels");
        List list = this.a;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(obj);
        }
        return CollectionsKt___CollectionsKt.plus((Collection) list, (Iterable) arrayList);
    }
}
