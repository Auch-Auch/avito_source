package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {0, 0, 0}, l = {415}, m = "invokeSuspend", n = {"$this$launch", "state", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope b;
    public Object c;
    public Object d;
    public Object e;
    public int f;
    public final /* synthetic */ Flow g;
    public final /* synthetic */ CompletableDeferred h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(Flow flow, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.g = flow;
        this.h = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.g, this.h, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.b = (CoroutineScope) obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.g, this.h, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.b = coroutineScope;
        return flowKt__ShareKt$launchSharingDeferred$1.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = a.getCOROUTINE_SUSPENDED();
        int i = this.f;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.b;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            Flow flow = this.g;
            FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1 flowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1 = new FlowCollector<T>(this, coroutineScope, objectRef) { // from class: kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1
                public final /* synthetic */ FlowKt__ShareKt$launchSharingDeferred$1 a;
                public final /* synthetic */ CoroutineScope b;
                public final /* synthetic */ Ref.ObjectRef c;

                {
                    this.a = r1;
                    this.b = r2;
                    this.c = r3;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                @Nullable
                public Object emit(Object obj2, @NotNull Continuation continuation) {
                    Unit unit;
                    Ref.ObjectRef objectRef2 = this.c;
                    T t = objectRef2.element;
                    if (t != null) {
                        t.setValue(obj2);
                        unit = Unit.INSTANCE;
                    } else {
                        T t2 = (T) StateFlowKt.MutableStateFlow(obj2);
                        this.a.h.complete(FlowKt.asStateFlow(t2));
                        Unit unit2 = Unit.INSTANCE;
                        objectRef2.element = t2;
                        unit = unit2;
                    }
                    if (unit == a.getCOROUTINE_SUSPENDED()) {
                        return unit;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.c = coroutineScope;
            this.d = objectRef;
            this.e = flow;
            this.f = 1;
            if (flow.collect(flowKt__ShareKt$launchSharingDeferred$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Flow flow2 = (Flow) this.e;
            Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.d;
            CoroutineScope coroutineScope2 = (CoroutineScope) this.c;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.h.completeExceptionally(th);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
