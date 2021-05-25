package com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions;

import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.conversation.mvi.platform_actions.legacy.context_actions.ContextActionsPresenter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;)Lcom/avito/android/messenger/conversation/mvi/platform_actions/legacy/context_actions/ContextActionsPresenter$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ContextActionsPresenterImpl$scheduleMethodCall$1 extends Lambda implements Function1<ContextActionsPresenter.State, ContextActionsPresenter.State> {
    public final /* synthetic */ ContextActionsPresenterImpl a;
    public final /* synthetic */ MutatorSingle b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContextActionsPresenterImpl$scheduleMethodCall$1(ContextActionsPresenterImpl contextActionsPresenterImpl, MutatorSingle mutatorSingle) {
        super(1);
        this.a = contextActionsPresenterImpl;
        this.b = mutatorSingle;
    }

    @NotNull
    public final ContextActionsPresenter.State invoke(@NotNull ContextActionsPresenter.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        this.a.getMutatorsRelay().accept(this.b);
        if (!(state instanceof ContextActionsPresenter.State.Visible)) {
            return state;
        }
        ContextActionsPresenter.State.Visible visible = (ContextActionsPresenter.State.Visible) state;
        return true != visible.isActionInProgress() ? ContextActionsPresenter.State.Visible.copy$default(visible, null, null, null, null, null, true, null, 95, null) : state;
    }
}
