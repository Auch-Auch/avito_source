package kotlinx.coroutines.debug.internal;

import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010/\u001a\u0004\u0018\u00010*\u0012\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b5\u00106J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\n\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00030\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007HPø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0011\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0005R(\u0010\u001f\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00078@@@X\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0013\u0010\r\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u0013R\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0000@\u0000X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0000@\u0001X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001b\u0010/\u001a\u0004\u0018\u00010*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0014008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u00101R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00101\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "", "", "Ljava/lang/StackTraceElement;", "lastObservedStackTrace", "()Ljava/util/List;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", TextureMediaEncoder.FRAME_EVENT, "", AuthSource.SEND_ABUSE, "(Lkotlin/sequences/SequenceScope;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "state", "Lkotlin/coroutines/Continuation;", "updateState$kotlinx_coroutines_core", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)V", "updateState", "toString", "()Ljava/lang/String;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCreationStackTrace", "creationStackTrace", "value", "getLastObservedFrame$kotlinx_coroutines_core", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "setLastObservedFrame$kotlinx_coroutines_core", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "lastObservedFrame", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "_state", "getState", "Ljava/lang/Thread;", "lastObservedThread", "Ljava/lang/Thread;", "", "sequenceNumber", "J", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "d", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getCreationStackBottom", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "creationStackBottom", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "_context", "c", "_lastObservedFrame", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/debug/internal/StackTraceFrame;J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class DebugCoroutineInfoImpl {
    public final WeakReference<CoroutineContext> a;
    public String b = DebugCoroutineInfoImplKt.CREATED;
    public WeakReference<CoroutineStackFrame> c;
    @Nullable
    public final StackTraceFrame d;
    @JvmField
    @Nullable
    public Thread lastObservedThread;
    @JvmField
    public final long sequenceNumber;

    @DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0, 0}, l = {80}, m = "yieldFrames", n = {"this", "$this$yieldFrames", TextureMediaEncoder.FRAME_EVENT, "it"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class a extends RestrictedContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ DebugCoroutineInfoImpl c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DebugCoroutineInfoImpl debugCoroutineInfoImpl, Continuation continuation) {
            super(continuation);
            this.c = debugCoroutineInfoImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.a(null, null, this);
        }
    }

    public DebugCoroutineInfoImpl(@Nullable CoroutineContext coroutineContext, @Nullable StackTraceFrame stackTraceFrame, long j) {
        this.d = stackTraceFrame;
        this.sequenceNumber = j;
        this.a = new WeakReference<>(coroutineContext);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super java.lang.StackTraceElement> r6, @org.jetbrains.annotations.Nullable kotlin.coroutines.jvm.internal.CoroutineStackFrame r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$a r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.a) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$a r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$a
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r6 = r0.g
            java.lang.StackTraceElement r6 = (java.lang.StackTraceElement) r6
            java.lang.Object r6 = r0.f
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6
            java.lang.Object r7 = r0.e
            kotlin.sequences.SequenceScope r7 = (kotlin.sequences.SequenceScope) r7
            java.lang.Object r2 = r0.d
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r2 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0064
        L_0x0039:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            r2 = r5
        L_0x0045:
            if (r7 != 0) goto L_0x004a
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x004a:
            java.lang.StackTraceElement r8 = r7.getStackTraceElement()
            if (r8 == 0) goto L_0x0067
            r0.d = r2
            r0.e = r6
            r0.f = r7
            r0.g = r8
            r0.b = r3
            java.lang.Object r8 = r6.yield(r8, r0)
            if (r8 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0064:
            r4 = r7
            r7 = r6
            r6 = r4
        L_0x0067:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r7.getCallerFrame()
            if (r7 == 0) goto L_0x006e
            goto L_0x0045
        L_0x006e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.a(kotlin.sequences.SequenceScope, kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final CoroutineContext getContext() {
        return this.a.get();
    }

    @Nullable
    public final StackTraceFrame getCreationStackBottom() {
        return this.d;
    }

    @NotNull
    public final List<StackTraceElement> getCreationStackTrace() {
        StackTraceFrame stackTraceFrame = this.d;
        if (stackTraceFrame != null) {
            return SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new u6.a.i0.a.a(this, stackTraceFrame, null)));
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @Nullable
    public final CoroutineStackFrame getLastObservedFrame$kotlinx_coroutines_core() {
        WeakReference<CoroutineStackFrame> weakReference = this.c;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @NotNull
    public final String getState() {
        return this.b;
    }

    @NotNull
    public final List<StackTraceElement> lastObservedStackTrace() {
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (lastObservedFrame$kotlinx_coroutines_core != null) {
            StackTraceElement stackTraceElement = lastObservedFrame$kotlinx_coroutines_core.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            lastObservedFrame$kotlinx_coroutines_core = lastObservedFrame$kotlinx_coroutines_core.getCallerFrame();
        }
        return arrayList;
    }

    public final void setLastObservedFrame$kotlinx_coroutines_core(@Nullable CoroutineStackFrame coroutineStackFrame) {
        this.c = coroutineStackFrame != null ? new WeakReference<>(coroutineStackFrame) : null;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DebugCoroutineInfo(state=");
        L.append(getState());
        L.append(",context=");
        L.append(getContext());
        L.append(')');
        return L.toString();
    }

    public final void updateState$kotlinx_coroutines_core(@NotNull String str, @NotNull Continuation<?> continuation) {
        if (!Intrinsics.areEqual(this.b, str) || !Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.SUSPENDED) || getLastObservedFrame$kotlinx_coroutines_core() == null) {
            this.b = str;
            Thread thread = null;
            if (!(continuation instanceof CoroutineStackFrame)) {
                continuation = null;
            }
            setLastObservedFrame$kotlinx_coroutines_core((CoroutineStackFrame) continuation);
            if (Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.RUNNING)) {
                thread = Thread.currentThread();
            }
            this.lastObservedThread = thread;
        }
    }
}
