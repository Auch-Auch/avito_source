package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public CoroutineScope b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;
    public int h;
    public final /* synthetic */ FlowCollector i;
    public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 j;

    public static final class a extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 a;
        public final /* synthetic */ CompletableJob b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1, CompletableJob completableJob) {
            super(1);
            this.a = combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
            this.b = completableJob;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            if (this.b.isActive()) {
                this.b.cancel((CancellationException) new AbortFlowException(this.a.i));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.i = flowCollector;
        this.j = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.i, continuation, this.j);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.b = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.i, continuation, this.j);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.b = coroutineScope;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a0, code lost:
        if (r1.isClosedForReceive() == false) goto L_0x00b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
        if (r1.isClosedForReceive() != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b2, code lost:
        kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r1, (java.util.concurrent.CancellationException) null, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b7, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bf  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) {
        /*
            r20 = this;
            r8 = r20
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r8.h
            r9 = 1
            r10 = 0
            if (r1 == 0) goto L_0x0032
            if (r1 != r9) goto L_0x002a
            java.lang.Object r0 = r8.f
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            java.lang.Object r0 = r8.e
            kotlinx.coroutines.CompletableJob r0 = (kotlinx.coroutines.CompletableJob) r0
            java.lang.Object r0 = r8.d
            r1 = r0
            kotlinx.coroutines.channels.ReceiveChannel r1 = (kotlinx.coroutines.channels.ReceiveChannel) r1
            java.lang.Object r0 = r8.c
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r21)     // Catch:{ AbortFlowException -> 0x0027 }
            goto L_0x009c
        L_0x0024:
            r0 = move-exception
            goto L_0x00b8
        L_0x0027:
            r0 = move-exception
            goto L_0x00a7
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r21)
            kotlinx.coroutines.CoroutineScope r11 = r8.b
            r3 = 0
            r4 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r5 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r5.<init>(r8, r10)
            r6 = 3
            r7 = 0
            r2 = r11
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.channels.ProduceKt.produce$default(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.CompletableJob r7 = kotlinx.coroutines.JobKt.Job$default(r10, r9, r10)
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            java.util.Objects.requireNonNull(r12, r1)
            r1 = r12
            kotlinx.coroutines.channels.SendChannel r1 = (kotlinx.coroutines.channels.SendChannel) r1
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$a r2 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$a
            r2.<init>(r8, r7)
            r1.invokeOnClose(r2)
            kotlin.coroutines.CoroutineContext r13 = r11.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            java.lang.Object r14 = kotlinx.coroutines.internal.ThreadContextKt.threadContextElements(r13)     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            kotlin.coroutines.CoroutineContext r1 = r11.getCoroutineContext()     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            kotlin.coroutines.CoroutineContext r15 = r1.plus(r7)     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            kotlin.Unit r16 = kotlin.Unit.INSTANCE     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r17 = 0
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3 r18 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$3     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r6 = 0
            r1 = r18
            r2 = r20
            r3 = r13
            r4 = r14
            r5 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r6 = 4
            r19 = 0
            r8.c = r11     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r8.d = r12     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r8.e = r7     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r8.f = r13     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r8.g = r14     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r8.h = r9     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r20
            r7 = r19
            java.lang.Object r1 = kotlinx.coroutines.flow.internal.ChannelFlowKt.withContextUndispatched$default(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ AbortFlowException -> 0x00a5, all -> 0x00a3 }
            if (r1 != r0) goto L_0x009b
            return r0
        L_0x009b:
            r1 = r12
        L_0x009c:
            boolean r0 = r1.isClosedForReceive()
            if (r0 != 0) goto L_0x00b5
            goto L_0x00b2
        L_0x00a3:
            r0 = move-exception
            goto L_0x00b9
        L_0x00a5:
            r0 = move-exception
            r1 = r12
        L_0x00a7:
            kotlinx.coroutines.flow.FlowCollector r2 = r8.i     // Catch:{ all -> 0x0024 }
            kotlinx.coroutines.flow.internal.FlowExceptions_commonKt.checkOwnership(r0, r2)     // Catch:{ all -> 0x0024 }
            boolean r0 = r1.isClosedForReceive()
            if (r0 != 0) goto L_0x00b5
        L_0x00b2:
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r1, r10, r9, r10)
        L_0x00b5:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x00b8:
            r12 = r1
        L_0x00b9:
            boolean r1 = r12.isClosedForReceive()
            if (r1 != 0) goto L_0x00c2
            kotlinx.coroutines.channels.ReceiveChannel.DefaultImpls.cancel$default(r12, r10, r9, r10)
        L_0x00c2:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
