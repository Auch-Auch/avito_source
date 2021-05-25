package com.avito.android.messenger.service.user_last_activity;

import a2.b.a.a.a;
import com.avito.android.util.Logs;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.UserLastActivity;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "error", "", "Lru/avito/messenger/api/entity/UserLastActivity;", "kotlin.jvm.PlatformType", "apply", "(Ljava/lang/Throwable;)Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$2<T, R> implements Function<Throwable, List<UserLastActivity>> {
    public final /* synthetic */ UserLastActivitySyncAgentImpl a;
    public final /* synthetic */ Collection b;

    public UserLastActivitySyncAgentImpl$getUsersLastActivityInMultipleRequests$2(UserLastActivitySyncAgentImpl userLastActivitySyncAgentImpl, Collection collection) {
        this.a = userLastActivitySyncAgentImpl;
        this.b = collection;
    }

    public final List<UserLastActivity> apply(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "error");
        String str = this.a.getTAG();
        StringBuilder L = a.L("getUsersLastActivityInMultipleRequests(userIds = ");
        L.append(this.b);
        L.append(") error!");
        Logs.error(str, L.toString(), th);
        return new ArrayList();
    }
}
