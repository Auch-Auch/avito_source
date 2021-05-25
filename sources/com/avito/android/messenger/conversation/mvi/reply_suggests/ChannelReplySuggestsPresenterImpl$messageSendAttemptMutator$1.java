package com.avito.android.messenger.conversation.mvi.reply_suggests;

import com.avito.android.messenger.conversation.mvi.reply_suggests.ChannelReplySuggestsView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;)Lcom/avito/android/messenger/conversation/mvi/reply_suggests/ChannelReplySuggestsView$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1 extends Lambda implements Function1<ChannelReplySuggestsView.State, ChannelReplySuggestsView.State> {
    public static final ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1 INSTANCE = new ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1();

    public ChannelReplySuggestsPresenterImpl$messageSendAttemptMutator$1() {
        super(1);
    }

    @NotNull
    public final ChannelReplySuggestsView.State invoke(@NotNull ChannelReplySuggestsView.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Empty.INSTANCE)) {
            return ChannelReplySuggestsView.State.Closed.INSTANCE;
        }
        if (state instanceof ChannelReplySuggestsView.State.Visible) {
            return ChannelReplySuggestsView.State.Closed.INSTANCE;
        }
        if (Intrinsics.areEqual(state, ChannelReplySuggestsView.State.Closed.INSTANCE)) {
            return state;
        }
        throw new NoWhenBranchMatchedException();
    }
}
