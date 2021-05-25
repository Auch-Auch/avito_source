package u6.a.j0;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a<T> extends c<T> {
    public final Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0, 0}, l = {358}, m = "collectTo", n = {"this", "scope"}, s = {"L$0", "L$1"})
    /* renamed from: u6.a.j0.a$a  reason: collision with other inner class name */
    public static final class C0688a extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ a c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0688a(a aVar, Continuation continuation) {
            super(continuation);
            this.c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.collectTo(null, this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Function2 function2, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, int i2) {
        super(function2, (i2 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : null, (i2 & 4) != 0 ? -2 : i, (i2 & 8) != 0 ? BufferOverflow.SUSPEND : null);
        this.b = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @Override // u6.a.j0.c, kotlinx.coroutines.flow.internal.ChannelFlow
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collectTo(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ProducerScope<? super T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof u6.a.j0.a.C0688a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            u6.a.j0.a$a r0 = (u6.a.j0.a.C0688a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            u6.a.j0.a$a r0 = new u6.a.j0.a$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.e
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r0 = r0.d
            u6.a.j0.a r0 = (u6.a.j0.a) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0054
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.d = r4
            r0.e = r5
            r0.b = r3
            kotlin.jvm.functions.Function2<kotlinx.coroutines.channels.ProducerScope<? super T>, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r6 = r4.a
            java.lang.Object r6 = r6.invoke(r5, r0)
            java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            if (r6 != r0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
        L_0x0051:
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            boolean r5 = r5.isClosedForSend()
            if (r5 == 0) goto L_0x005d
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x005d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.a.collectTo(kotlinx.coroutines.channels.ProducerScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // u6.a.j0.c, kotlinx.coroutines.flow.internal.ChannelFlow
    @NotNull
    public ChannelFlow<T> create(@NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        return new a(this.b, coroutineContext, i, bufferOverflow);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.jvm.functions.Function2<? super kotlinx.coroutines.channels.ProducerScope<? super T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull Function2<? super ProducerScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow) {
        super(function2, coroutineContext, i, bufferOverflow);
        this.b = function2;
    }
}
