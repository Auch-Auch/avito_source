package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.flow.FlowCollector;
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {0, 0, 0}, l = {124}, m = "invokeSuspend", n = {"$this$retryWhen", "cause", "attempt"}, s = {"L$0", "L$1", "J$0"})
public final class t extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    public FlowCollector b;
    public Throwable c;
    public long d;
    public Object e;
    public Object f;
    public long g;
    public int h;
    public final /* synthetic */ long i;
    public final /* synthetic */ Function2 j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(long j2, Function2 function2, Continuation continuation) {
        super(4, continuation);
        this.i = j2;
        this.j = function2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        long longValue = l.longValue();
        t tVar = new t(this.i, this.j, continuation);
        tVar.b = (FlowCollector) obj;
        tVar.c = th;
        tVar.d = longValue;
        return tVar.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0045, code lost:
        if (((java.lang.Boolean) r9).booleanValue() != false) goto L_0x0049;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r1 = r8.h
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r8.f
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = r8.e
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x003f
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r8.b
            java.lang.Throwable r1 = r8.c
            long r3 = r8.d
            long r5 = r8.i
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0048
            kotlin.jvm.functions.Function2 r5 = r8.j
            r8.e = r9
            r8.f = r1
            r8.g = r3
            r8.h = r2
            java.lang.Object r9 = r5.invoke(r1, r8)
            if (r9 != r0) goto L_0x003f
            return r0
        L_0x003f:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0048
            goto L_0x0049
        L_0x0048:
            r2 = 0
        L_0x0049:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.t.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
