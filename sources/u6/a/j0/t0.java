package u6.a.j0;

import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
public final class t0 implements SharingStarted {
    public final long a;
    public final long b;

    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {181, 183, 185, 186, 188}, m = "invokeSuspend", n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    public static final class a extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
        public FlowCollector b;
        public int c;
        public Object d;
        public int e;
        public int f;
        public final /* synthetic */ t0 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(t0 t0Var, Continuation continuation) {
            super(3, continuation);
            this.g = t0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
            int intValue = num.intValue();
            a aVar = new a(this.g, continuation);
            aVar.b = flowCollector;
            aVar.c = intValue;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x009b A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00ac A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = t6.p.a.a.getCOROUTINE_SUSPENDED()
                int r1 = r10.f
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x0047
                if (r1 == r6) goto L_0x003f
                if (r1 == r5) goto L_0x0035
                if (r1 == r4) goto L_0x002b
                if (r1 == r3) goto L_0x0020
                if (r1 != r2) goto L_0x0018
                goto L_0x003f
            L_0x0018:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0020:
                int r1 = r10.e
                java.lang.Object r3 = r10.d
                kotlinx.coroutines.flow.FlowCollector r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x009d
            L_0x002b:
                int r1 = r10.e
                java.lang.Object r4 = r10.d
                kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x008b
            L_0x0035:
                int r1 = r10.e
                java.lang.Object r5 = r10.d
                kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x0071
            L_0x003f:
                java.lang.Object r0 = r10.d
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                kotlin.ResultKt.throwOnFailure(r11)
                goto L_0x00ad
            L_0x0047:
                kotlin.ResultKt.throwOnFailure(r11)
                kotlinx.coroutines.flow.FlowCollector r11 = r10.b
                int r1 = r10.c
                if (r1 <= 0) goto L_0x005f
                kotlinx.coroutines.flow.SharingCommand r2 = kotlinx.coroutines.flow.SharingCommand.START
                r10.d = r11
                r10.e = r1
                r10.f = r6
                java.lang.Object r11 = r11.emit(r2, r10)
                if (r11 != r0) goto L_0x00ad
                return r0
            L_0x005f:
                u6.a.j0.t0 r6 = r10.g
                long r6 = r6.a
                r10.d = r11
                r10.e = r1
                r10.f = r5
                java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r6, r10)
                if (r5 != r0) goto L_0x0070
                return r0
            L_0x0070:
                r5 = r11
            L_0x0071:
                u6.a.j0.t0 r11 = r10.g
                long r6 = r11.b
                r8 = 0
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 <= 0) goto L_0x009e
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
                r10.d = r5
                r10.e = r1
                r10.f = r4
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto L_0x008a
                return r0
            L_0x008a:
                r4 = r5
            L_0x008b:
                u6.a.j0.t0 r11 = r10.g
                long r5 = r11.b
                r10.d = r4
                r10.e = r1
                r10.f = r3
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r5, r10)
                if (r11 != r0) goto L_0x009c
                return r0
            L_0x009c:
                r3 = r4
            L_0x009d:
                r5 = r3
            L_0x009e:
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
                r10.d = r5
                r10.e = r1
                r10.f = r2
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto L_0x00ad
                return r0
            L_0x00ad:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: u6.a.j0.t0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<SharingCommand, Continuation<? super Boolean>, Object> {
        public SharingCommand b;

        public b(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.b = (SharingCommand) obj;
            return bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SharingCommand sharingCommand, Continuation<? super Boolean> continuation) {
            b bVar = new b(continuation);
            bVar.b = sharingCommand;
            return bVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            t6.p.a.a.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.b != SharingCommand.START);
        }
    }

    public t0(long j, long j2) {
        this.a = j;
        this.b = j2;
        boolean z = true;
        if (j >= 0) {
            if (!(j2 < 0 ? false : z)) {
                throw new IllegalArgumentException(a2.b.a.a.a.V2("replayExpiration(", j2, " ms) cannot be negative").toString());
            }
            return;
        }
        throw new IllegalArgumentException(a2.b.a.a.a.V2("stopTimeout(", j, " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    @NotNull
    public Flow<SharingCommand> command(@NotNull StateFlow<Integer> stateFlow) {
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest(stateFlow, new a(this, null)), new b(null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof t0) {
            t0 t0Var = (t0) obj;
            if (this.a == t0Var.a && this.b == t0Var.b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Long.valueOf(this.b).hashCode() + (Long.valueOf(this.a).hashCode() * 31);
    }

    @NotNull
    public String toString() {
        List createListBuilder = d.createListBuilder(2);
        if (this.a > 0) {
            StringBuilder L = a2.b.a.a.a.L("stopTimeout=");
            L.append(this.a);
            L.append("ms");
            createListBuilder.add(L.toString());
        }
        if (this.b < Long.MAX_VALUE) {
            StringBuilder L2 = a2.b.a.a.a.L("replayExpiration=");
            L2.append(this.b);
            L2.append("ms");
            createListBuilder.add(L2.toString());
        }
        return a2.b.a.a.a.s(a2.b.a.a.a.L("SharingStarted.WhileSubscribed("), CollectionsKt___CollectionsKt.joinToString$default(d.build(createListBuilder), null, null, null, 0, null, null, 63, null), ')');
    }
}
