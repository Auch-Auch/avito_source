package com.avito.android.messenger.connection_indicator;

import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerState;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;)Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class ConnectionErrorIndicatorPresenter$toMutator$1 extends Lambda implements Function1<ConnectionErrorIndicatorView.State, ConnectionErrorIndicatorView.State> {
    public final /* synthetic */ ConnectionErrorIndicatorPresenter a;
    public final /* synthetic */ MessengerState b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionErrorIndicatorPresenter$toMutator$1(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter, MessengerState messengerState) {
        super(1);
        this.a = connectionErrorIndicatorPresenter;
        this.b = messengerState;
    }

    @NotNull
    public final ConnectionErrorIndicatorView.State invoke(@NotNull ConnectionErrorIndicatorView.State state) {
        Intrinsics.checkNotNullParameter(state, "oldState");
        MessengerState messengerState = this.b;
        if (messengerState instanceof MessengerState.Connected) {
            if (state instanceof ConnectionErrorIndicatorView.State.Shown) {
                return ConnectionErrorIndicatorView.State.Hidden.INSTANCE;
            }
            if (state instanceof ConnectionErrorIndicatorView.State.Hidden) {
                return (ConnectionErrorIndicatorView.State.Hidden) state;
            }
            throw new NoWhenBranchMatchedException();
        } else if (messengerState instanceof MessengerState.Connecting) {
            if (state instanceof ConnectionErrorIndicatorView.State.Shown.Error) {
                return ConnectionErrorIndicatorPresenter.access$getConnectingState$p(this.a);
            }
            if ((state instanceof ConnectionErrorIndicatorView.State.Hidden) || (state instanceof ConnectionErrorIndicatorView.State.Shown.InProgress)) {
                return state;
            }
            throw new NoWhenBranchMatchedException();
        } else if (!(messengerState instanceof MessengerState.Disconnected)) {
            throw new NoWhenBranchMatchedException();
        } else if ((state instanceof ConnectionErrorIndicatorView.State.Shown.InProgress) || (state instanceof ConnectionErrorIndicatorView.State.Hidden)) {
            return ConnectionErrorIndicatorPresenter.access$getDisconnectedState$p(this.a);
        } else {
            if (state instanceof ConnectionErrorIndicatorView.State.Shown.Error) {
                return state;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
