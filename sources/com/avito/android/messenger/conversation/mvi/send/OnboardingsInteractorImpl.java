package com.avito.android.messenger.conversation.mvi.send;

import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.q;
import t6.n.r;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0014\u0015B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0004\b\u0011\u0010\u0012B\u0019\b\u0017\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "onboarding", "", "hide", "(Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;)V", "Lcom/avito/android/util/preferences/Preferences;", "p", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/preferences/Preferences;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/preferences/Preferences;)V", "GetStatesFromPrefsMutator", "HideMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OnboardingsInteractorImpl extends BaseMviEntityWithReducerQueue<OnboardingsInteractor.State> implements OnboardingsInteractor {
    public final Preferences p;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl$GetStatesFromPrefsMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class GetStatesFromPrefsMutator extends Mutator<OnboardingsInteractor.State> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public GetStatesFromPrefsMutator() {
            super(null, null, 3, null);
        }

        @NotNull
        public OnboardingsInteractor.State invoke(@NotNull OnboardingsInteractor.State state) {
            Intrinsics.checkNotNullParameter(state, "oldState");
            Onboarding[] values = Onboarding.values();
            ArrayList<Pair> arrayList = new ArrayList(1);
            for (Onboarding onboarding : values) {
                arrayList.add(TuplesKt.to(onboarding, OnboardingState.values()[OnboardingsInteractorImpl.this.p.getInt(onboarding.getStateKey(), 0)]));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(arrayList, 10)), 16));
            for (Pair pair : arrayList) {
                linkedHashMap.put(pair.getFirst(), pair.getSecond());
            }
            return new OnboardingsInteractor.State(linkedHashMap);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl$HideMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "oldState", "invoke", "(Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;)Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractor$State;", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "d", "Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "onboarding", "<init>", "(Lcom/avito/android/messenger/conversation/mvi/send/OnboardingsInteractorImpl;Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class HideMutator extends Mutator<OnboardingsInteractor.State> {
        public final Onboarding d;
        public final /* synthetic */ OnboardingsInteractorImpl e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                OnboardingState.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public HideMutator(@NotNull OnboardingsInteractorImpl onboardingsInteractorImpl, Onboarding onboarding) {
            super(null, "onboarding = " + onboarding, 1, null);
            Intrinsics.checkNotNullParameter(onboarding, "onboarding");
            this.e = onboardingsInteractorImpl;
            this.d = onboarding;
        }

        @NotNull
        public OnboardingsInteractor.State invoke(@NotNull OnboardingsInteractor.State state) {
            int ordinal;
            Intrinsics.checkNotNullParameter(state, "oldState");
            OnboardingState onboardingState = state.getOnboardingStates().get(this.d);
            if (onboardingState == null || (ordinal = onboardingState.ordinal()) == 0) {
                Onboarding onboarding = this.d;
                Preferences preferences = this.e.p;
                String stateKey = onboarding.getStateKey();
                OnboardingState onboardingState2 = OnboardingState.HIDDEN;
                preferences.putInt(stateKey, 1);
                return state.copy(r.plus(state.getOnboardingStates(), TuplesKt.to(this.d, onboardingState2)));
            } else if (ordinal == 1) {
                return state;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnboardingsInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Preferences preferences, @NotNull ReducerQueue<OnboardingsInteractor.State> reducerQueue) {
        super("OnboardingsInteractor", OnboardingsInteractor.State.Companion.getDEFAULT(), schedulersFactory, null, reducerQueue, null, null, null, 232, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.p = preferences;
        reducerQueue.plusAssign(new GetStatesFromPrefsMutator());
    }

    @Override // com.avito.android.messenger.conversation.mvi.send.OnboardingsInteractor
    public void hide(@NotNull Onboarding onboarding) {
        Intrinsics.checkNotNullParameter(onboarding, "onboarding");
        getReducerQueue().plusAssign(new HideMutator(this, onboarding));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public OnboardingsInteractorImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull Preferences preferences) {
        this(schedulersFactory, preferences, new SimpleReducerQueue(schedulersFactory.io(), null, 2, null));
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(preferences, "preferences");
    }
}
