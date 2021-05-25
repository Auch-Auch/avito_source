package com.avito.android.messenger.support;

import a2.b.a.a.a;
import androidx.lifecycle.LiveData;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "text", "", "sendClicked", "(Ljava/lang/CharSequence;)V", "Landroidx/lifecycle/LiveData;", "", "getErrorStream", "()Landroidx/lifecycle/LiveData;", "errorStream", "SendingState", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SupportChatFormPresenter extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "", "<init>", "()V", "Idle", "InProgress", "Success", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$Idle;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$InProgress;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$Success;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class SendingState {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$Idle;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Idle extends SendingState {
            @NotNull
            public static final Idle INSTANCE = new Idle();

            public Idle() {
                super(null);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$InProgress;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "", AuthSource.SEND_ABUSE, "J", "getId", "()J", "id", "<init>", "(J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class InProgress extends SendingState {
            public final long a;

            public InProgress(long j) {
                super(null);
                this.a = j;
            }

            public final long getId() {
                return this.a;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState$Success;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "channelId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends SendingState {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "channelId");
                this.a = str;
            }

            @NotNull
            public final String getChannelId() {
                return this.a;
            }
        }

        public SendingState() {
        }

        public SendingState(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "component1", "()Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "sendingState", "copy", "(Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;)Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;", "getSendingState", "<init>", "(Lcom/avito/android/messenger/support/SupportChatFormPresenter$SendingState;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State b = new State(SendingState.Idle.INSTANCE);
        @NotNull
        public final SendingState a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenter$State$Companion;", "", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "getDEFAULT", "()Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
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

        public State(@NotNull SendingState sendingState) {
            Intrinsics.checkNotNullParameter(sendingState, "sendingState");
            this.a = sendingState;
        }

        public static /* synthetic */ State copy$default(State state, SendingState sendingState, int i, Object obj) {
            if ((i & 1) != 0) {
                sendingState = state.a;
            }
            return state.copy(sendingState);
        }

        @NotNull
        public final SendingState component1() {
            return this.a;
        }

        @NotNull
        public final State copy(@NotNull SendingState sendingState) {
            Intrinsics.checkNotNullParameter(sendingState, "sendingState");
            return new State(sendingState);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof State) && Intrinsics.areEqual(this.a, ((State) obj).a);
            }
            return true;
        }

        @NotNull
        public final SendingState getSendingState() {
            return this.a;
        }

        public int hashCode() {
            SendingState sendingState = this.a;
            if (sendingState != null) {
                return sendingState.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(sendingState=");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    LiveData<String> getErrorStream();

    void sendClicked(@NotNull CharSequence charSequence);
}
