package com.avito.android.messenger.conversation.mvi.send;

import a2.b.a.a.a;
import com.avito.android.messenger.channels.mvi.common.MviEntity;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/MviEntity;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "onboarding", "", "hide", "(Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;)V", "State", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OnboardingsInteractor extends MviEntity<State> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "", "", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingState;", "component1", "()Ljava/util/Map;", "onboardingStates", "copy", "(Ljava/util/Map;)Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getOnboardingStates", "<init>", "(Ljava/util/Map;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final State b = new State(r.emptyMap());
        @NotNull
        public final Map<Onboarding, OnboardingState> a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State$Companion;", "", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", MessengerShareContentUtility.PREVIEW_DEFAULT, "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "getDEFAULT", "()Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
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

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<com.avito.android.messenger.conversation.mvi.send.Onboarding, ? extends com.avito.android.messenger.conversation.mvi.send.OnboardingState> */
        /* JADX WARN: Multi-variable type inference failed */
        public State(@NotNull Map<Onboarding, ? extends OnboardingState> map) {
            Intrinsics.checkNotNullParameter(map, "onboardingStates");
            this.a = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = state.a;
            }
            return state.copy(map);
        }

        @NotNull
        public final Map<Onboarding, OnboardingState> component1() {
            return this.a;
        }

        @NotNull
        public final State copy(@NotNull Map<Onboarding, ? extends OnboardingState> map) {
            Intrinsics.checkNotNullParameter(map, "onboardingStates");
            return new State(map);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof State) && Intrinsics.areEqual(this.a, ((State) obj).a);
            }
            return true;
        }

        @NotNull
        public final Map<Onboarding, OnboardingState> getOnboardingStates() {
            return this.a;
        }

        public int hashCode() {
            Map<Onboarding, OnboardingState> map = this.a;
            if (map != null) {
                return map.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            return a.x(a.L("State(onboardingStates="), this.a, ")");
        }
    }

    void hide(@NotNull Onboarding onboarding);
}
