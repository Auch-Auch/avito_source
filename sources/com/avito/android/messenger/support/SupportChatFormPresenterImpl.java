package com.avito.android.messenger.support;

import a2.a.a.o1.h.b;
import a2.a.a.o1.h.c;
import com.avito.android.messenger.channels.mvi.common.v4.BaseMviEntityWithReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible;
import com.avito.android.messenger.channels.mvi.common.v4.Mutator;
import com.avito.android.messenger.channels.mvi.common.v4.MutatorSingle;
import com.avito.android.messenger.channels.mvi.common.v4.ReducerQueue;
import com.avito.android.messenger.channels.mvi.common.v4.Reducible;
import com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker;
import com.avito.android.messenger.channels.mvi.common.v4.SimpleReducerQueue;
import com.avito.android.messenger.support.SupportChatFormPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import com.avito.android.util.rx3.InteropKt;
import com.avito.android.util.rx3.Singles;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Single;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002$%B;\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u001f¢\u0006\u0004\b!\u0010\"B/\b\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b!\u0010#J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter;", "Lcom/avito/android/messenger/channels/mvi/common/v4/BaseMviEntityWithReducerQueue;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "text", "", "sendClicked", "(Ljava/lang/CharSequence;)V", "", VKApiConst.Q, "I", "problemId", "Lcom/avito/android/messenger/support/SupportChatFormInteractor;", "r", "Lcom/avito/android/messenger/support/SupportChatFormInteractor;", "interactor", "Lcom/avito/android/util/Formatter;", "", "s", "Lcom/avito/android/util/Formatter;", "errorFormatter", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "", "p", "Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "getErrorStream", "()Lcom/avito/android/util/architecture_components/SingleLiveEvent;", "errorStream", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;", "reducerQueue", "<init>", "(ILcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/support/SupportChatFormInteractor;Lcom/avito/android/util/Formatter;Lcom/avito/android/messenger/channels/mvi/common/v4/ReducerQueue;)V", "(ILcom/avito/android/util/SchedulersFactory;Lcom/avito/android/messenger/support/SupportChatFormInteractor;Lcom/avito/android/util/Formatter;)V", "CancelChecker", "SendClickedComposite", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChatFormPresenterImpl extends BaseMviEntityWithReducerQueue<SupportChatFormPresenter.State> implements SupportChatFormPresenter {
    @NotNull
    public final SingleLiveEvent<String> p;
    public final int q;
    public final SupportChatFormInteractor r;
    public final Formatter<Throwable> s;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$CancelChecker;", "Lcom/avito/android/messenger/channels/mvi/common/v4/ShouldCancelChecker;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "aShouldCancelB", "(Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;)Z", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CancelChecker implements ShouldCancelChecker<SupportChatFormPresenter.State> {
        @NotNull
        public static final CancelChecker INSTANCE = new CancelChecker();

        @Override // com.avito.android.messenger.channels.mvi.common.v4.ShouldCancelChecker
        public boolean aShouldCancelB(@NotNull Reducible<SupportChatFormPresenter.State> reducible, @NotNull Reducible<SupportChatFormPresenter.State> reducible2) {
            Intrinsics.checkNotNullParameter(reducible, AuthSource.SEND_ABUSE);
            Intrinsics.checkNotNullParameter(reducible2, AuthSource.BOOKING_ORDER);
            if (reducible instanceof SendClickedComposite.SetInProgressMutator) {
                if (reducible2 instanceof SendClickedComposite.SetInProgressMutator) {
                    if (((SendClickedComposite.SetInProgressMutator) reducible).getId() > ((SendClickedComposite.SetInProgressMutator) reducible2).getId()) {
                        return true;
                    }
                } else if ((reducible2 instanceof SendClickedComposite.StartSupportChatMutator) && ((SendClickedComposite.SetInProgressMutator) reducible).getId() > ((SendClickedComposite.StartSupportChatMutator) reducible2).getId()) {
                    return true;
                }
            } else if (reducible instanceof SendClickedComposite.StartSupportChatMutator) {
                if (reducible2 instanceof SendClickedComposite.SetInProgressMutator) {
                    if (((SendClickedComposite.StartSupportChatMutator) reducible).getId() > ((SendClickedComposite.SetInProgressMutator) reducible2).getId()) {
                        return true;
                    }
                } else if ((reducible2 instanceof SendClickedComposite.StartSupportChatMutator) && ((SendClickedComposite.StartSupportChatMutator) reducible).getId() > ((SendClickedComposite.StartSupportChatMutator) reducible2).getId()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0006\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR.\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r0\f0\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$SendClickedComposite;", "Lcom/avito/android/messenger/channels/mvi/common/v4/CompositeReducible;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "f", "J", "id", "", "e", "Ljava/lang/CharSequence;", "text", "Lkotlin/Function0;", "", "Lcom/avito/android/messenger/channels/mvi/common/v4/Reducible;", "d", "Lkotlin/jvm/functions/Function0;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "block", "<init>", "(Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl;Ljava/lang/CharSequence;J)V", "SetInProgressMutator", "StartSupportChatMutator", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public final class SendClickedComposite extends CompositeReducible<SupportChatFormPresenter.State> {
        @NotNull
        public final Function0<List<Reducible<SupportChatFormPresenter.State>>> d = new a(this);
        public final CharSequence e;
        public final long f;
        public final /* synthetic */ SupportChatFormPresenterImpl g;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$SendClickedComposite$SetInProgressMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/Mutator;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "d", "J", "getId", "()J", "id", "<init>", "(Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$SendClickedComposite;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class SetInProgressMutator extends Mutator<SupportChatFormPresenter.State> {
            public final long d;

            public static final class a extends Lambda implements Function1<SupportChatFormPresenter.State, SupportChatFormPresenter.State> {
                public final /* synthetic */ long a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(long j) {
                    super(1);
                    this.a = j;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public SupportChatFormPresenter.State invoke(SupportChatFormPresenter.State state) {
                    SupportChatFormPresenter.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    SupportChatFormPresenter.SendingState sendingState = state2.getSendingState();
                    if (Intrinsics.areEqual(sendingState, SupportChatFormPresenter.SendingState.Idle.INSTANCE) || (sendingState instanceof SupportChatFormPresenter.SendingState.InProgress)) {
                        return state2.copy(new SupportChatFormPresenter.SendingState.InProgress(this.a));
                    }
                    if (sendingState instanceof SupportChatFormPresenter.SendingState.Success) {
                        return state2;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public SetInProgressMutator(com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite r3, long r4) {
                /*
                    r2 = this;
                    java.lang.String r0 = "(id = "
                    java.lang.String r1 = ", text = "
                    java.lang.StringBuilder r0 = a2.b.a.a.a.O(r0, r4, r1)
                    java.lang.CharSequence r3 = com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite.access$getText$p(r3)
                    r0.append(r3)
                    r3 = 41
                    r0.append(r3)
                    java.lang.String r3 = r0.toString()
                    com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite$SetInProgressMutator$a r0 = new com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite$SetInProgressMutator$a
                    r0.<init>(r4)
                    java.lang.String r1 = "SendClickedComposite.SetInProgressMutator"
                    r2.<init>(r1, r3, r0)
                    r2.d = r4
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite.SetInProgressMutator.<init>(com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite, long):void");
            }

            public final long getId() {
                return this.d;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$SendClickedComposite$StartSupportChatMutator;", "Lcom/avito/android/messenger/channels/mvi/common/v4/MutatorSingle;", "Lcom/avito/android/messenger/support/SupportChatFormPresenter$State;", "", "d", "J", "getId", "()J", "id", "<init>", "(Lcom/avito/android/messenger/support/SupportChatFormPresenterImpl$SendClickedComposite;J)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public final class StartSupportChatMutator extends MutatorSingle<SupportChatFormPresenter.State> {
            public final long d;

            public static final class a extends Lambda implements Function1<SupportChatFormPresenter.State, Single<SupportChatFormPresenter.State>> {
                public final /* synthetic */ SendClickedComposite a;
                public final /* synthetic */ long b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(SendClickedComposite sendClickedComposite, long j) {
                    super(1);
                    this.a = sendClickedComposite;
                    this.b = j;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Single<SupportChatFormPresenter.State> invoke(SupportChatFormPresenter.State state) {
                    io.reactivex.rxjava3.core.Single<R> single;
                    SupportChatFormPresenter.State state2 = state;
                    Intrinsics.checkNotNullParameter(state2, "oldState");
                    SupportChatFormPresenter.SendingState sendingState = state2.getSendingState();
                    Long l = null;
                    if (!(sendingState instanceof SupportChatFormPresenter.SendingState.InProgress)) {
                        sendingState = null;
                    }
                    SupportChatFormPresenter.SendingState.InProgress inProgress = (SupportChatFormPresenter.SendingState.InProgress) sendingState;
                    if (inProgress != null) {
                        l = Long.valueOf(inProgress.getId());
                    }
                    if (l != null && l.longValue() == this.b) {
                        single = this.a.g.r.startSupportChat(this.a.g.q, this.a.e).map(new b(state2)).onErrorReturn(new c(this, state2));
                    } else {
                        single = Singles.toSingle(state2);
                    }
                    Intrinsics.checkNotNullExpressionValue(single, "if (currentSendingStateI…ingle()\n                }");
                    return InteropKt.toV2(single);
                }
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public StartSupportChatMutator(com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite r3, long r4) {
                /*
                    r2 = this;
                    java.lang.String r0 = "(id = "
                    java.lang.String r1 = ", text = "
                    java.lang.StringBuilder r0 = a2.b.a.a.a.O(r0, r4, r1)
                    java.lang.CharSequence r1 = com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite.access$getText$p(r3)
                    r0.append(r1)
                    r1 = 41
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite$StartSupportChatMutator$a r1 = new com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite$StartSupportChatMutator$a
                    r1.<init>(r3, r4)
                    java.lang.String r3 = "SendClickedComposite.StartSupportChatMutator"
                    r2.<init>(r3, r0, r1)
                    r2.d = r4
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.avito.android.messenger.support.SupportChatFormPresenterImpl.SendClickedComposite.StartSupportChatMutator.<init>(com.avito.android.messenger.support.SupportChatFormPresenterImpl$SendClickedComposite, long):void");
            }

            public final long getId() {
                return this.d;
            }
        }

        public static final class a extends Lambda implements Function0<List<? extends Reducible<SupportChatFormPresenter.State>>> {
            public final /* synthetic */ SendClickedComposite a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(SendClickedComposite sendClickedComposite) {
                super(0);
                this.a = sendClickedComposite;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public List<? extends Reducible<SupportChatFormPresenter.State>> invoke() {
                SendClickedComposite sendClickedComposite = this.a;
                SendClickedComposite sendClickedComposite2 = this.a;
                return CollectionsKt__CollectionsKt.listOf((Object[]) new Reducible[]{new SetInProgressMutator(sendClickedComposite, sendClickedComposite.f), new StartSupportChatMutator(sendClickedComposite2, sendClickedComposite2.f)});
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SendClickedComposite(@NotNull SupportChatFormPresenterImpl supportChatFormPresenterImpl, CharSequence charSequence, long j) {
            super(null, null, null, 7, null);
            Intrinsics.checkNotNullParameter(charSequence, "text");
            this.g = supportChatFormPresenterImpl;
            this.e = charSequence;
            this.f = j;
        }

        @Override // com.avito.android.messenger.channels.mvi.common.v4.CompositeReducible
        @NotNull
        public Function0<List<Reducible<SupportChatFormPresenter.State>>> getBlock() {
            return this.d;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SupportChatFormPresenterImpl(int i, @NotNull SchedulersFactory schedulersFactory, @NotNull SupportChatFormInteractor supportChatFormInteractor, @NotNull Formatter<Throwable> formatter, @NotNull ReducerQueue<SupportChatFormPresenter.State> reducerQueue) {
        super("SupportChatFormPresenter", SupportChatFormPresenter.State.Companion.getDEFAULT(), schedulersFactory, CancelChecker.INSTANCE, reducerQueue, null, null, null, 224, null);
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(supportChatFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(reducerQueue, "reducerQueue");
        this.q = i;
        this.r = supportChatFormInteractor;
        this.s = formatter;
        this.p = new SingleLiveEvent<>();
    }

    @Override // com.avito.android.messenger.support.SupportChatFormPresenter
    public void sendClicked(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        getReducerQueue().plusAssign(new SendClickedComposite(this, charSequence, generateReducibleId("SendClickedComposite")));
    }

    @Override // com.avito.android.messenger.support.SupportChatFormPresenter
    @NotNull
    public SingleLiveEvent<String> getErrorStream() {
        return this.p;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Inject
    public SupportChatFormPresenterImpl(int i, @NotNull SchedulersFactory schedulersFactory, @NotNull SupportChatFormInteractor supportChatFormInteractor, @NotNull Formatter<Throwable> formatter) {
        this(i, schedulersFactory, supportChatFormInteractor, formatter, new SimpleReducerQueue(schedulersFactory.io(), "SupportChatFormPresenter"));
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(supportChatFormInteractor, "interactor");
        Intrinsics.checkNotNullParameter(formatter, "errorFormatter");
    }
}
