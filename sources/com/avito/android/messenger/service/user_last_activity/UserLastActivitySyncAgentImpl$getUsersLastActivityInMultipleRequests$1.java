package com.avito.android.messenger.service.user_last_activity;

import io.reactivex.functions.BiConsumer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.UserLastActivity;
import t6.n.h;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\t\u001a\u00020\u00062\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00040\u0004H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "Lru/avito/messenger/api/entity/UserLastActivity;", "kotlin.jvm.PlatformType", "usersList", "", "newUsers", "", "accept", "(Ljava/util/List;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1<T1, T2> implements BiConsumer<List<UserLastActivity>, List<? extends UserLastActivity>> {
    public static final UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1 INSTANCE = new UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // io.reactivex.functions.BiConsumer
    public /* bridge */ /* synthetic */ void accept(List<UserLastActivity> list, List<? extends UserLastActivity> list2) {
        accept(list, (List<UserLastActivity>) list2);
    }

    public final void accept(List<UserLastActivity> list, List<UserLastActivity> list2) {
        Intrinsics.checkNotNullExpressionValue(list2, "newUsers");
        h.addAll(list, list2);
    }
}
