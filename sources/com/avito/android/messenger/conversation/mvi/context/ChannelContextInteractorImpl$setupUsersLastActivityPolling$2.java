package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.service.user_last_activity.UserLastActivitySyncAgent;
import io.reactivex.functions.Consumer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "kotlin.jvm.PlatformType", "interlocutorIds", "", "accept", "(Ljava/util/Set;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$setupUsersLastActivityPolling$2<T> implements Consumer<Set<? extends String>> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$setupUsersLastActivityPolling$2(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Set<? extends String> set) {
        accept((Set<String>) set);
    }

    public final void accept(Set<String> set) {
        UserLastActivitySyncAgent userLastActivitySyncAgent = this.a.z;
        String str = this.a.v;
        Intrinsics.checkNotNullExpressionValue(set, "interlocutorIds");
        userLastActivitySyncAgent.requestUsers(str, set);
    }
}
