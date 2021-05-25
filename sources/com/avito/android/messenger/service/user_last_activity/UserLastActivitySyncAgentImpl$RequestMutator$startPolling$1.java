package com.avito.android.messenger.service.user_last_activity;

import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgentImpl;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "accept", "(Ljava/lang/Long;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class UserLastActivitySyncAgentImpl$RequestMutator$startPolling$1<T> implements Consumer<Long> {
    public final /* synthetic */ UserLastActivitySyncAgentImpl.RequestMutator a;

    public UserLastActivitySyncAgentImpl$RequestMutator$startPolling$1(UserLastActivitySyncAgentImpl.RequestMutator requestMutator) {
        this.a = requestMutator;
    }

    public final void accept(Long l) {
        this.a.f.getReducerQueue().plusAssign(new UserLastActivitySyncAgentImpl.PollAction());
    }
}
