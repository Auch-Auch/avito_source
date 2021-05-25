package com.avito.android.messenger.connection_indicator;

import android.content.res.Resources;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntityWithMutatorsRelay;
import com.avito.android.messenger.channels.mvi.common.v2.Mutator;
import com.avito.android.messenger.channels.mvi.common.v2.MutatorSingle;
import com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerConnection;
import ru.avito.messenger.MessengerState;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\n\u001a\u00020\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u00020\u00028B@\u0002X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\tR\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v2/BaseMviEntityWithMutatorsRelay;", "Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "", "onCleared", "()V", "n", "Lkotlin/Lazy;", "getConnectingState", "()Lcom/avito/android/messenger/connection_indicator/ConnectionErrorIndicatorView$State;", "connectingState", "Landroid/content/res/Resources;", "p", "Landroid/content/res/Resources;", "resources", "Lru/avito/messenger/MessengerConnection;", VKApiConst.Q, "Lru/avito/messenger/MessengerConnection;", "connection", "o", "getDisconnectedState", "disconnectedState", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/disposables/CompositeDisposable;", "backendNotificationSubscriptions", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Landroid/content/res/Resources;Lru/avito/messenger/MessengerConnection;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ConnectionErrorIndicatorPresenter extends BaseMviEntityWithMutatorsRelay<ConnectionErrorIndicatorView.State> {
    public final CompositeDisposable m = new CompositeDisposable();
    public final Lazy n = c.lazy(new a(this));
    public final Lazy o = c.lazy(new b(this));
    public final Resources p;
    public final MessengerConnection q;

    public static final class a extends Lambda implements Function0<ConnectionErrorIndicatorView.State.Shown.InProgress> {
        public final /* synthetic */ ConnectionErrorIndicatorPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
            super(0);
            this.a = connectionErrorIndicatorPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ConnectionErrorIndicatorView.State.Shown.InProgress invoke() {
            String string = this.a.p.getString(R.string.messenger_connecting);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.messenger_connecting)");
            return new ConnectionErrorIndicatorView.State.Shown.InProgress(string);
        }
    }

    public static final class b extends Lambda implements Function0<ConnectionErrorIndicatorView.State.Shown.Error> {
        public final /* synthetic */ ConnectionErrorIndicatorPresenter a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
            super(0);
            this.a = connectionErrorIndicatorPresenter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ConnectionErrorIndicatorView.State.Shown.Error invoke() {
            String string = this.a.p.getString(R.string.messenger_could_not_connect);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…senger_could_not_connect)");
            String string2 = this.a.p.getString(R.string.messenger_once_again);
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.messenger_once_again)");
            return new ConnectionErrorIndicatorView.State.Shown.Error(string, string2, new ConnectionErrorIndicatorPresenter$disconnectedState$2$1(this));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConnectionErrorIndicatorPresenter(@NotNull Resources resources, @NotNull MessengerConnection messengerConnection, @NotNull SchedulersFactory schedulersFactory) {
        super("ConnectionErrorIndicatorPresenter", ConnectionErrorIndicatorView.State.Hidden.INSTANCE, schedulersFactory, null, 8, null);
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(messengerConnection, "connection");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.p = resources;
        this.q = messengerConnection;
        Disposable subscribe = this.q.state().observeOn(getSchedulers().io()).subscribe(new Consumer<MessengerState>() { // from class: com.avito.android.messenger.connection_indicator.ConnectionErrorIndicatorPresenter$subscribeToBackendNotifications$1
            /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.jakewharton.rxrelay2.Relay */
            /* JADX WARN: Multi-variable type inference failed */
            public final void accept(MessengerState messengerState) {
                Relay access$getMutatorsRelay$p = ConnectionErrorIndicatorPresenter.access$getMutatorsRelay$p(ConnectionErrorIndicatorPresenter.this);
                ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter = ConnectionErrorIndicatorPresenter.this;
                Intrinsics.checkNotNullExpressionValue(messengerState, "connectionState");
                Mutator mutator = new Mutator("ConnectionStateMutator(" + messengerState + ')', new ConnectionErrorIndicatorPresenter$toMutator$1(connectionErrorIndicatorPresenter, messengerState));
                access$getMutatorsRelay$p.accept(new MutatorSingle(mutator.getName(), new ConnectionErrorIndicatorPresenter$subscribeToBackendNotifications$1$$special$$inlined$plusAssign$1(mutator)));
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "connection.state()\n     …toMutator()\n            }");
        DisposableKt.addTo(subscribe, this.m);
    }

    public static final Mutator access$forceConnectingMutator(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        Objects.requireNonNull(connectionErrorIndicatorPresenter);
        return new Mutator("ForceConnectingMutator", new ConnectionErrorIndicatorPresenter$forceConnectingMutator$1(connectionErrorIndicatorPresenter));
    }

    public static final ConnectionErrorIndicatorView.State access$getConnectingState$p(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        return (ConnectionErrorIndicatorView.State) connectionErrorIndicatorPresenter.n.getValue();
    }

    public static final ConnectionErrorIndicatorView.State access$getDisconnectedState$p(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        return (ConnectionErrorIndicatorView.State) connectionErrorIndicatorPresenter.o.getValue();
    }

    public static final MutatorSingle access$performReconnectMutator(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter) {
        Objects.requireNonNull(connectionErrorIndicatorPresenter);
        return new MutatorSingle("PerformReconnectMutator", new ConnectionErrorIndicatorPresenter$performReconnectMutator$1(connectionErrorIndicatorPresenter));
    }

    public static final Mutator access$toMutator(ConnectionErrorIndicatorPresenter connectionErrorIndicatorPresenter, MessengerState messengerState) {
        Objects.requireNonNull(connectionErrorIndicatorPresenter);
        return new Mutator("ConnectionStateMutator(" + messengerState + ')', new ConnectionErrorIndicatorPresenter$toMutator$1(connectionErrorIndicatorPresenter, messengerState));
    }

    @Override // com.avito.android.messenger.channels.mvi.common.v2.BaseMviEntity, androidx.lifecycle.ViewModel
    public void onCleared() {
        this.m.dispose();
        super.onCleared();
    }
}
