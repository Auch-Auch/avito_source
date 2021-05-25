package com.avito.android.messenger.channels.mvi.presenter;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "Landroidx/lifecycle/LiveData;", "", "getUserBlockedStream", "()Landroidx/lifecycle/LiveData;", "userBlockedStream", "getShowLoginScreenStream", "showLoginScreenStream", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelsHeaderPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "", "", "component1", "()Z", "isConnecting", "copy", "(Z)Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "<init>", "(Z)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State b = new State(false);
        public final boolean a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State$Companion;", "", "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "getDEFAULT", "()Lcom/avito/android/messenger/channels/mvi/presenter/ChannelsHeaderPresenter$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            @NotNull
            public final State getDEFAULT() {
                return State.b;
            }

            public Companion(j jVar) {
            }
        }

        public State(boolean z) {
            this.a = z;
        }

        public static /* synthetic */ State copy$default(State state, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = state.a;
            }
            return state.copy(z);
        }

        public final boolean component1() {
            return this.a;
        }

        @NotNull
        public final State copy(boolean z) {
            return new State(z);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof State) && this.a == ((State) obj).a;
            }
            return true;
        }

        public int hashCode() {
            boolean z = this.a;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public final boolean isConnecting() {
            return this.a;
        }

        @NotNull
        public String toString() {
            return a.B(a.L("State(isConnecting="), this.a, ")");
        }
    }

    @NotNull
    LiveData<Unit> getShowLoginScreenStream();

    @NotNull
    LiveData<Unit> getUserBlockedStream();
}
