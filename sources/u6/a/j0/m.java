package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {316, 318, 319}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
public final class m extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    public ProducerScope b;
    public Object c;
    public int d;
    public final /* synthetic */ long e;
    public final /* synthetic */ long f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.e = j;
        this.f = j2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        m mVar = new m(this.e, this.f, continuation);
        mVar.b = (ProducerScope) obj;
        return mVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProducerScope<? super Unit> producerScope, Continuation<? super Unit> continuation) {
        m mVar = new m(this.e, this.f, continuation);
        mVar.b = producerScope;
        return mVar.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:57)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r7.d
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r4) goto L_0x0011
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
        L_0x0011:
            java.lang.Object r1 = r7.c
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003c
        L_0x0019:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0021:
            java.lang.Object r1 = r7.c
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L_0x004e
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.channels.ProducerScope r1 = r7.b
            long r5 = r7.e
            r7.c = r1
            r7.d = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
            if (r8 != r0) goto L_0x003c
            return r0
        L_0x003c:
            r8 = r7
        L_0x003d:
            kotlinx.coroutines.channels.SendChannel r4 = r1.getChannel()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r8.c = r1
            r8.d = r3
            java.lang.Object r4 = r4.send(r5, r8)
            if (r4 != r0) goto L_0x004e
            return r0
        L_0x004e:
            long r4 = r8.f
            r8.c = r1
            r8.d = r2
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r8)
            if (r4 != r0) goto L_0x003d
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
