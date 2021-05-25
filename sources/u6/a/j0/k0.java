package u6.a.j0;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {0, 1, 2, 3}, l = {206, 210, 211, 217}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class k0 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope b;
    public Object c;
    public int d;
    public final /* synthetic */ SharingStarted e;
    public final /* synthetic */ Flow f;
    public final /* synthetic */ MutableSharedFlow g;
    public final /* synthetic */ Object h;

    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<Integer, Continuation<? super Boolean>, Object> {
        public int b;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            a aVar = new a(continuation);
            Number number = (Number) obj;
            number.intValue();
            aVar.b = number.intValue();
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Integer num, Continuation<? super Boolean> continuation) {
            a aVar = new a(continuation);
            Integer num2 = num;
            num2.intValue();
            aVar.b = num2.intValue();
            Unit unit = Unit.INSTANCE;
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(unit);
            return Boxing.boxBoolean(aVar.b > 0);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.b > 0);
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {0}, l = {219}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class b extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Unit>, Object> {
        public SharingCommand b;
        public Object c;
        public int d;
        public final /* synthetic */ k0 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k0 k0Var, Continuation continuation) {
            super(2, continuation);
            this.e = k0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(this.e, continuation);
            bVar.b = (SharingCommand) obj;
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super Unit> continuation) {
            b bVar = new b(this.e, continuation);
            bVar.b = sharingCommand;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                SharingCommand sharingCommand = this.b;
                int ordinal = sharingCommand.ordinal();
                if (ordinal == 0) {
                    k0 k0Var = this.e;
                    Flow flow = k0Var.f;
                    MutableSharedFlow mutableSharedFlow = k0Var.g;
                    this.c = sharingCommand;
                    this.d = 1;
                    if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (ordinal == 2) {
                    k0 k0Var2 = this.e;
                    Object obj2 = k0Var2.h;
                    if (obj2 == SharedFlowKt.NO_VALUE) {
                        k0Var2.g.resetReplayCache();
                    } else {
                        k0Var2.g.tryEmit(obj2);
                    }
                }
            } else if (i == 1) {
                SharingCommand sharingCommand2 = (SharingCommand) this.c;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k0(SharingStarted sharingStarted, Flow flow, MutableSharedFlow mutableSharedFlow, Object obj, Continuation continuation) {
        super(2, continuation);
        this.e = sharingStarted;
        this.f = flow;
        this.g = mutableSharedFlow;
        this.h = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        k0 k0Var = new k0(this.e, this.f, this.g, this.h, continuation);
        k0Var.b = (CoroutineScope) obj;
        return k0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((k0) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        Object coroutine_suspended = t6.p.a.a.getCOROUTINE_SUSPENDED();
        int i = this.d;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    coroutineScope = (CoroutineScope) this.c;
                    ResultKt.throwOnFailure(obj);
                } else if (!(i == 3 || i == 4)) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) this.c;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        coroutineScope = this.b;
        SharingStarted sharingStarted = this.e;
        SharingStarted.Companion companion = SharingStarted.Companion;
        if (sharingStarted == companion.getEagerly()) {
            Flow flow = this.f;
            MutableSharedFlow mutableSharedFlow = this.g;
            this.c = coroutineScope;
            this.d = 1;
            if (flow.collect(mutableSharedFlow, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (this.e == companion.getLazily()) {
            StateFlow<Integer> subscriptionCount = this.g.getSubscriptionCount();
            a aVar = new a(null);
            this.c = coroutineScope;
            this.d = 2;
            if (FlowKt.first(subscriptionCount, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(this.e.command(this.g.getSubscriptionCount()));
            b bVar = new b(this, null);
            this.c = coroutineScope;
            this.d = 4;
            if (FlowKt.collectLatest(distinctUntilChanged, bVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
        Flow flow2 = this.f;
        MutableSharedFlow mutableSharedFlow2 = this.g;
        this.c = coroutineScope;
        this.d = 3;
        if (flow2.collect(mutableSharedFlow2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
