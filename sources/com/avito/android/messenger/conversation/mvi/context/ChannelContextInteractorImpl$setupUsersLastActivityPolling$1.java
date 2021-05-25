package com.avito.android.messenger.conversation.mvi.context;

import com.avito.android.messenger.conversation.mvi.context.ChannelContextInteractor;
import io.reactivex.functions.Function;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;", "state", "", "", "kotlin.jvm.PlatformType", "apply", "(Lcom/avito/android/messenger/conversation/mvi/context/ChannelContextInteractor$State;)Ljava/util/Set;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelContextInteractorImpl$setupUsersLastActivityPolling$1<T, R> implements Function<ChannelContextInteractor.State, Set<? extends String>> {
    public final /* synthetic */ ChannelContextInteractorImpl a;

    public ChannelContextInteractorImpl$setupUsersLastActivityPolling$1(ChannelContextInteractorImpl channelContextInteractorImpl) {
        this.a = channelContextInteractorImpl;
    }

    public final Set<String> apply(@NotNull ChannelContextInteractor.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return ChannelContextInteractorImpl.access$getInterlocutorIds$p(this.a, state);
    }
}
