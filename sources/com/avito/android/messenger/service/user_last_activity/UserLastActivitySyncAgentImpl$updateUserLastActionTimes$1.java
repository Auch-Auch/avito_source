package com.avito.android.messenger.service.user_last_activity;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.UserIdAndLastActionTime;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.entity.UserLastActivity;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001aB\u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u0000 \u0005* \u0012\u001a\b\u0001\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00000\u0000\u0018\u00010\u00030\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "userIdsToPoll", "Lio/reactivex/SingleSource;", "Lru/avito/android/persistence/messenger/UserIdAndLastActionTime;", "kotlin.jvm.PlatformType", "apply", "(Ljava/util/List;)Lio/reactivex/SingleSource;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$updateUserLastActionTimes$1<T, R> implements Function<List<? extends String>, SingleSource<? extends List<? extends UserIdAndLastActionTime>>> {
    public final /* synthetic */ UserLastActivitySyncAgentImpl a;

    public UserLastActivitySyncAgentImpl$updateUserLastActionTimes$1(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl) {
        this.a = userLastActivitySyncAgentImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public /* bridge */ /* synthetic */ SingleSource<? extends List<? extends UserIdAndLastActionTime>> apply(List<? extends String> list) {
        return apply((List<String>) list);
    }

    public final SingleSource<? extends List<UserIdAndLastActionTime>> apply(@NotNull List<String> list) {
        Single<List<UserLastActivity>> single;
        Intrinsics.checkNotNullParameter(list, "userIdsToPoll");
        UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl = this.a;
        MessengerClient messengerClient = userLastActivitySyncAgentImpl.s;
        if (!list.isEmpty()) {
            if (list.size() <= 100) {
                single = messengerClient.getUserLastActivity(CollectionsKt___CollectionsKt.toList(list)).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInSingleRequest$1(userLastActivitySyncAgentImpl, list));
                Intrinsics.checkNotNullExpressionValue(single, "getUserLastActivity(user…emptyList()\n            }");
            } else {
                List<T> chunked = CollectionsKt___CollectionsKt.chunked(list, 100);
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(chunked, 10));
                for (T t : chunked) {
                    arrayList.add(messengerClient.getUserLastActivity(t));
                }
                single = Single.merge(arrayList).collectInto(new ArrayList(), UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$1.INSTANCE).timeout(15, TimeUnit.SECONDS).observeOn(userLastActivitySyncAgentImpl.getSchedulerForReducibles()).onErrorReturn(new UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$2(userLastActivitySyncAgentImpl, list));
                Intrinsics.checkNotNullExpressionValue(single, "Single.merge(getUsersSin…bleListOf()\n            }");
            }
            Single<R> map = single.map(new UserLastActivitySyncAgentImpl$getLastActionTimesByUserId$1(userLastActivitySyncAgentImpl));
            Intrinsics.checkNotNullExpressionValue(map, "if (userIds.size <= MAX_…onTime)\n                }");
            return map;
        }
        Single just = Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just, "Single.just(emptyList())");
        return just;
    }
}
