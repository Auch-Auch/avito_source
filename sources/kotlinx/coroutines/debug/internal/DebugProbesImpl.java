package kotlinx.coroutines.debug.internal;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import com.vk.sdk.api.VKApiConst;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0002¢\u0006\u0004\bh\u0010\u0004J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0015\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001e\u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ)\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0000¢\u0006\u0004\b#\u0010$J;\u0010-\u001a\u00020\u0002*\u00020\u00062\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020'0&2\n\u0010+\u001a\u00060)j\u0002`*2\u0006\u0010,\u001a\u00020\bH\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u0010\u0014J%\u00101\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b1\u00102J5\u00106\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u00103\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u0001042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b6\u00107J3\u0010<\u001a\u0002082\u0006\u00109\u001a\u0002082\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160:2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0002¢\u0006\u0004\b<\u0010=J#\u0010>\u001a\u00020\u00022\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u00103\u001a\u00020\bH\u0002¢\u0006\u0004\b>\u0010?J\u0016\u0010A\u001a\u0004\u0018\u00010@*\u00020@H\u0010¢\u0006\u0004\bA\u0010BJ\u001d\u0010D\u001a\b\u0012\u0002\b\u0003\u0018\u00010C*\u0006\u0012\u0002\b\u00030\u001aH\u0002¢\u0006\u0004\bD\u0010ER\u0016\u0010F\u001a\u0002088\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001a\u0004\u0018\u0001048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010KR \u0010P\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030C0M8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\"\u0010T\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020'0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\"\u0010[\u001a\u00020U8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b1\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010^\u001a\u0010\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\u0002\u0018\u00010\\8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010]R\u0016\u0010a\u001a\u00020_8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010`R\u0016\u0010c\u001a\u00020U8@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\bb\u0010XR\"\u0010f\u001a\u00020U8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bA\u0010V\u001a\u0004\bd\u0010X\"\u0004\be\u0010ZR&\u0010g\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030C\u0012\u0004\u0012\u00020U0Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u0010S¨\u0006i"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "", "install", "()V", "uninstall", "Lkotlinx/coroutines/Job;", "job", "", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "Ljava/io/PrintStream;", VKApiConst.OUT, "dumpCoroutines", "(Ljava/io/PrintStream;)V", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "Lkotlin/coroutines/Continuation;", TextureMediaEncoder.FRAME_EVENT, "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "T", "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", AuthSource.SEND_ABUSE, "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "frames", g.a, "(Ljava/io/PrintStream;Ljava/util/List;)V", "state", "Ljava/lang/Thread;", "thread", "c", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "frameIndex", "", "actualTrace", "d", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "i", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "h", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$a;", "f", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$a;", "installations", "I", "Ljava/lang/Thread;", "weakRefCleanerThread", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "", "e", "()Ljava/util/Set;", "capturedCoroutines", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "j", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "", "Z", "getSanitizeStackTraces", "()Z", "setSanitizeStackTraces", "(Z)V", "sanitizeStackTraces", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "dynamicAttach", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "dateFormat", "isInstalled$kotlinx_coroutines_core", "isInstalled", "getEnableCreationStackTraces", "setEnableCreationStackTraces", "enableCreationStackTraces", "capturedCoroutinesMap", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class DebugProbesImpl {
    public static final DebugProbesImpl INSTANCE = new DebugProbesImpl();
    public static final SimpleDateFormat a = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    public static Thread b;
    public static final ConcurrentWeakMap<a<?>, Boolean> c = new ConcurrentWeakMap<>(false, 1, null);
    public static final /* synthetic */ DebugProbesImplSequenceNumberRefVolatile d = new DebugProbesImplSequenceNumberRefVolatile(0);
    public static final /* synthetic */ AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(DebugProbesImplSequenceNumberRefVolatile.class, "sequenceNumber");
    public static final ReentrantReadWriteLock f = new ReentrantReadWriteLock();
    public static boolean g = true;
    public static boolean h = true;
    public static final Function1<Boolean, Unit> i;
    public static volatile int installations;
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> j = new ConcurrentWeakMap<>(true);

    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        @JvmField
        @NotNull
        public final Continuation<T> a;
        @JvmField
        @NotNull
        public final DebugCoroutineInfoImpl b;
        public final CoroutineStackFrame c;

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super T> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Continuation<? super T> continuation, @NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @Nullable CoroutineStackFrame coroutineStackFrame) {
            this.a = continuation;
            this.b = debugCoroutineInfoImpl;
            this.c = coroutineStackFrame;
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object obj) {
            DebugProbesImpl.access$probeCoroutineCompleted(DebugProbesImpl.INSTANCE, this);
            this.a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.a.toString();
        }
    }

    public static final class b extends Lambda implements Function1<a<?>, Boolean> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(a<?> aVar) {
            return Boolean.valueOf(!DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, aVar));
        }
    }

    static {
        Object obj;
        Function1<Boolean, Unit> function1 = null;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m242constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (!Result.m247isFailureimpl(obj)) {
                    function1 = obj;
                }
                i = function1;
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m242constructorimpl(ResultKt.createFailure(th));
        }
    }

    public static final boolean access$isFinished(DebugProbesImpl debugProbesImpl, a aVar) {
        Job job;
        Objects.requireNonNull(debugProbesImpl);
        CoroutineContext context = aVar.b.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        c.remove(aVar);
        return true;
    }

    public static final void access$probeCoroutineCompleted(DebugProbesImpl debugProbesImpl, a aVar) {
        CoroutineStackFrame h2;
        Objects.requireNonNull(debugProbesImpl);
        c.remove(aVar);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = aVar.b.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core != null && (h2 = debugProbesImpl.h(lastObservedFrame$kotlinx_coroutines_core)) != null) {
            j.remove(h2);
        }
    }

    public final void a(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            StackTraceElement stackTraceElement = (StackTraceElement) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) debugCoroutineInfoImpl.lastObservedStackTrace());
            String state = debugCoroutineInfoImpl.getState();
            StringBuilder L = a2.b.a.a.a.L(str);
            a2.b.a.a.a.n1(L, job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString(), ", continuation is ", state, " at line ");
            L.append(stackTraceElement);
            L.append('\n');
            sb.append(L.toString());
            str = str + "\t";
        } else if (!(job instanceof ScopeCoroutine)) {
            StringBuilder L2 = a2.b.a.a.a.L(str);
            L2.append(job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString());
            L2.append('\n');
            sb.append(L2.toString());
            str = str + "\t";
        }
        for (Job job2 : job.getChildren()) {
            a(job2, map, sb, str);
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final void b(java.io.PrintStream r14) {
        /*
        // Method dump skipped, instructions count: 287
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.b(java.io.PrintStream):void");
    }

    /* JADX WARN: Type inference failed for: r9v8, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.StackTraceElement> c(java.lang.String r8, java.lang.Thread r9, java.util.List<java.lang.StackTraceElement> r10) {
        /*
            r7 = this;
            java.lang.String r0 = "RUNNING"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            r0 = 1
            r8 = r8 ^ r0
            if (r8 != 0) goto L_0x00c9
            if (r9 != 0) goto L_0x000e
            goto L_0x00c9
        L_0x000e:
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0019 }
            java.lang.StackTraceElement[] r8 = r9.getStackTrace()     // Catch:{ all -> 0x0019 }
            java.lang.Object r8 = kotlin.Result.m242constructorimpl(r8)     // Catch:{ all -> 0x0019 }
            goto L_0x0024
        L_0x0019:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m242constructorimpl(r8)
        L_0x0024:
            boolean r9 = kotlin.Result.m247isFailureimpl(r8)
            if (r9 == 0) goto L_0x002b
            r8 = 0
        L_0x002b:
            java.lang.StackTraceElement[] r8 = (java.lang.StackTraceElement[]) r8
            if (r8 == 0) goto L_0x00c9
            int r9 = r8.length
            r1 = 0
            r2 = 0
        L_0x0032:
            r3 = -1
            if (r2 >= r9) goto L_0x0064
            r4 = r8[r2]
            java.lang.String r5 = r4.getClassName()
            java.lang.String r6 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x005d
            java.lang.String r5 = r4.getMethodName()
            java.lang.String r6 = "resumeWith"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r6)
            if (r5 == 0) goto L_0x005d
            java.lang.String r4 = r4.getFileName()
            java.lang.String r5 = "ContinuationImpl.kt"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L_0x005d
            r4 = 1
            goto L_0x005e
        L_0x005d:
            r4 = 0
        L_0x005e:
            if (r4 == 0) goto L_0x0061
            goto L_0x0065
        L_0x0061:
            int r2 = r2 + 1
            goto L_0x0032
        L_0x0064:
            r2 = -1
        L_0x0065:
            int r9 = r2 + -1
            int r9 = r7.d(r9, r8, r10)
            if (r9 != r3) goto L_0x007e
            int r9 = r2 + -2
            int r9 = r7.d(r9, r8, r10)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Boolean r4 = java.lang.Boolean.TRUE
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r4)
            goto L_0x0088
        L_0x007e:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r4)
        L_0x0088:
            java.lang.Object r4 = r9.component1()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r9 = r9.component2()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r4 != r3) goto L_0x009f
            return r10
        L_0x009f:
            int r3 = r10.size()
            int r3 = r3 + r2
            int r3 = r3 - r4
            int r3 = r3 - r0
            int r3 = r3 - r9
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r3)
            int r2 = r2 - r9
        L_0x00ad:
            if (r1 >= r2) goto L_0x00b7
            r9 = r8[r1]
            r5.add(r9)
            int r1 = r1 + 1
            goto L_0x00ad
        L_0x00b7:
            int r4 = r4 + r0
            int r8 = r10.size()
        L_0x00bc:
            if (r4 >= r8) goto L_0x00c8
            java.lang.Object r9 = r10.get(r4)
            r5.add(r9)
            int r4 = r4 + 1
            goto L_0x00bc
        L_0x00c8:
            return r5
        L_0x00c9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.c(java.lang.String, java.lang.Thread, java.util.List):java.util.List");
    }

    public final int d(int i2, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.getOrNull(stackTraceElementArr, i2);
        if (stackTraceElement == null) {
            return -1;
        }
        int i3 = 0;
        for (StackTraceElement stackTraceElement2 : list) {
            if (Intrinsics.areEqual(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && Intrinsics.areEqual(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && Intrinsics.areEqual(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public final void dumpCoroutines(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.b(printStream);
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = access$getCoroutineStateLock$p(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            int r2 = r0.getReadHoldCount()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x001e
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0016
        L_0x001e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x0086 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x007a
            java.util.Set r4 = access$getCapturedCoroutines$p(r4)     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$$special$$inlined$sortedBy$2 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$$special$$inlined$sortedBy$2     // Catch:{ all -> 0x0086 }
            r5.<init>()     // Catch:{ all -> 0x0086 }
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0086 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0086 }
            r5.<init>()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0043:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x006e
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.a) r6     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x0086 }
            boolean r7 = access$isFinished(r7, r6)     // Catch:{ all -> 0x0086 }
            r8 = 0
            if (r7 == 0) goto L_0x0059
            goto L_0x0068
        L_0x0059:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.b     // Catch:{ all -> 0x0086 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0068
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r8 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.b     // Catch:{ all -> 0x0086 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0086 }
        L_0x0068:
            if (r8 == 0) goto L_0x0043
            r5.add(r8)     // Catch:{ all -> 0x0086 }
            goto L_0x0043
        L_0x006e:
            if (r3 >= r2) goto L_0x0076
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006e
        L_0x0076:
            r0.unlock()
            return r5
        L_0x007a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L_0x0086:
            r4 = move-exception
        L_0x0087:
            if (r3 >= r2) goto L_0x008f
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0087
        L_0x008f:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo():java.util.List");
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = access$getCoroutineStateLock$p(r9)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0014
            int r2 = r0.getReadHoldCount()
            goto L_0x0015
        L_0x0014:
            r2 = 0
        L_0x0015:
            r4 = 0
        L_0x0016:
            if (r4 >= r2) goto L_0x001e
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0016
        L_0x001e:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x0086 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x007a
            java.util.Set r4 = access$getCapturedCoroutines$p(r4)     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$$special$$inlined$sortedBy$3 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$$special$$inlined$sortedBy$3     // Catch:{ all -> 0x0086 }
            r5.<init>()     // Catch:{ all -> 0x0086 }
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0086 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0086 }
            r5.<init>()     // Catch:{ all -> 0x0086 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0043:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x006e
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r6 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.a) r6     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r7 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x0086 }
            boolean r7 = access$isFinished(r7, r6)     // Catch:{ all -> 0x0086 }
            r8 = 0
            if (r7 == 0) goto L_0x0059
            goto L_0x0068
        L_0x0059:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r7 = r6.b     // Catch:{ all -> 0x0086 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x0086 }
            if (r7 == 0) goto L_0x0068
            kotlinx.coroutines.debug.internal.DebuggerInfo r8 = new kotlinx.coroutines.debug.internal.DebuggerInfo     // Catch:{ all -> 0x0086 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r6.b     // Catch:{ all -> 0x0086 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0086 }
        L_0x0068:
            if (r8 == 0) goto L_0x0043
            r5.add(r8)     // Catch:{ all -> 0x0086 }
            goto L_0x0043
        L_0x006e:
            if (r3 >= r2) goto L_0x0076
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006e
        L_0x0076:
            r0.unlock()
            return r5
        L_0x007a:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L_0x0086:
            r4 = move-exception
        L_0x0087:
            if (r3 >= r2) goto L_0x008f
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0087
        L_0x008f:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo():java.util.List");
    }

    public final Set<a<?>> e() {
        return c.keySet();
    }

    @NotNull
    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(@NotNull DebugCoroutineInfo debugCoroutineInfo, @NotNull List<StackTraceElement> list) {
        return c(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    public final a<?> f(Continuation<?> continuation) {
        if (!(continuation instanceof CoroutineStackFrame)) {
            continuation = null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        if (coroutineStackFrame == null) {
            return null;
        }
        while (!(coroutineStackFrame instanceof a)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (a) coroutineStackFrame;
    }

    public final void g(PrintStream printStream, List<StackTraceElement> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            printStream.print("\n\tat " + ((Object) it.next()));
        }
    }

    public final boolean getEnableCreationStackTraces() {
        return h;
    }

    public final boolean getSanitizeStackTraces() {
        return g;
    }

    public final CoroutineStackFrame h(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String hierarchyToString(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job r10) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x00c1 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x00b5
            java.util.Set r4 = r4.e()     // Catch:{ all -> 0x00c1 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00c1 }
            r5.<init>()     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00c1 }
        L_0x0038:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x005c
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00c1 }
            r7 = r6
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.a) r7     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.Continuation<T> r7 = r7.a     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.Job$Key r8 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)     // Catch:{ all -> 0x00c1 }
            if (r7 == 0) goto L_0x0055
            r7 = 1
            goto L_0x0056
        L_0x0055:
            r7 = 0
        L_0x0056:
            if (r7 == 0) goto L_0x0038
            r5.add(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x0038
        L_0x005c:
            r4 = 10
            int r4 = t6.n.e.collectionSizeOrDefault(r5, r4)     // Catch:{ all -> 0x00c1 }
            int r4 = t6.n.q.mapCapacity(r4)     // Catch:{ all -> 0x00c1 }
            r6 = 16
            int r4 = t6.v.e.coerceAtLeast(r4, r6)     // Catch:{ all -> 0x00c1 }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00c1 }
            r6.<init>(r4)     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r4 = r5.iterator()     // Catch:{ all -> 0x00c1 }
        L_0x0075:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00c1 }
            r7 = r5
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.a) r7     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.Continuation<T> r7 = r7.a     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.getJob(r7)     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$a r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.a) r5     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r5 = r5.b     // Catch:{ all -> 0x00c1 }
            r6.put(r7, r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x0075
        L_0x0094:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r4.<init>()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = ""
            r5.a(r10, r6, r4, r7)     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)     // Catch:{ all -> 0x00c1 }
        L_0x00a9:
            if (r3 >= r2) goto L_0x00b1
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00a9
        L_0x00b1:
            r0.unlock()
            return r10
        L_0x00b5:
            java.lang.String r10 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r10 = r10.toString()
            r4.<init>(r10)
            throw r4
        L_0x00c1:
            r10 = move-exception
        L_0x00c2:
            if (r3 >= r2) goto L_0x00ca
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00c2
        L_0x00ca:
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.hierarchyToString(kotlinx.coroutines.Job):java.lang.String");
    }

    public final void i(Continuation<?> continuation, String str) {
        a aVar;
        if (isInstalled$kotlinx_coroutines_core()) {
            if (!Intrinsics.areEqual(str, DebugCoroutineInfoImplKt.RUNNING) || !KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
                a<?> f2 = f(continuation);
                if (f2 != null) {
                    ReentrantReadWriteLock.ReadLock readLock = f.readLock();
                    readLock.lock();
                    try {
                        if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                            f2.b.updateState$kotlinx_coroutines_core(str, continuation);
                            readLock.unlock();
                        }
                    } finally {
                        readLock.unlock();
                    }
                }
            } else {
                CoroutineStackFrame coroutineStackFrame = null;
                if (!(continuation instanceof CoroutineStackFrame)) {
                    continuation = null;
                }
                CoroutineStackFrame coroutineStackFrame2 = (CoroutineStackFrame) continuation;
                if (coroutineStackFrame2 != null) {
                    ReentrantReadWriteLock.ReadLock readLock2 = f.readLock();
                    readLock2.lock();
                    try {
                        if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                            DebugCoroutineInfoImpl remove = j.remove(coroutineStackFrame2);
                            if (remove == null) {
                                CoroutineStackFrame coroutineStackFrame3 = coroutineStackFrame2;
                                while (true) {
                                    if (!(coroutineStackFrame3 instanceof a)) {
                                        coroutineStackFrame3 = coroutineStackFrame3.getCallerFrame();
                                        if (coroutineStackFrame3 == null) {
                                            aVar = null;
                                            break;
                                        }
                                    } else {
                                        aVar = (a) coroutineStackFrame3;
                                        break;
                                    }
                                }
                                if (aVar == null || (remove = aVar.b) == null) {
                                    readLock2.unlock();
                                    return;
                                }
                                CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                                if (lastObservedFrame$kotlinx_coroutines_core != null) {
                                    coroutineStackFrame = INSTANCE.h(lastObservedFrame$kotlinx_coroutines_core);
                                }
                                if (coroutineStackFrame != null) {
                                    j.remove(coroutineStackFrame);
                                }
                            }
                            remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame2);
                            CoroutineStackFrame h2 = INSTANCE.h(coroutineStackFrame2);
                            if (h2 != null) {
                                j.put(h2, remove);
                                readLock2.unlock();
                                return;
                            }
                            readLock2.unlock();
                        }
                    } finally {
                        readLock2.unlock();
                    }
                }
            }
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final void install() {
        /*
            r13 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            int r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.installations     // Catch:{ all -> 0x007b }
            r5 = 1
            int r4 = r4 + r5
            kotlinx.coroutines.debug.internal.DebugProbesImpl.installations = r4     // Catch:{ all -> 0x007b }
            int r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.installations     // Catch:{ all -> 0x007b }
            if (r4 <= r5) goto L_0x0039
        L_0x002d:
            if (r3 >= r2) goto L_0x0035
            r1.lock()
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0035:
            r0.unlock()
            return
        L_0x0039:
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE
            java.util.Objects.requireNonNull(r4)
            u6.a.i0.a.b r10 = u6.a.i0.a.b.a
            r5 = 0
            r6 = 1
            r7 = 0
            java.lang.String r8 = "Coroutines Debugger Cleaner"
            r9 = 0
            r11 = 21
            r12 = 0
            java.lang.Thread r4 = kotlin.concurrent.ThreadsKt.thread$default(r5, r6, r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.debug.internal.DebugProbesImpl.b = r4
            kotlinx.coroutines.debug.AgentPremain r4 = kotlinx.coroutines.debug.AgentPremain.INSTANCE
            boolean r4 = r4.isInstalledStatically()
            if (r4 == 0) goto L_0x0063
        L_0x0057:
            if (r3 >= r2) goto L_0x005f
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0057
        L_0x005f:
            r0.unlock()
            return
        L_0x0063:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.i
            if (r4 == 0) goto L_0x006f
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.Object r4 = r4.invoke(r5)
            kotlin.Unit r4 = (kotlin.Unit) r4
        L_0x006f:
            if (r3 >= r2) goto L_0x0077
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006f
        L_0x0077:
            r0.unlock()
            return
        L_0x007b:
            r4 = move-exception
        L_0x007c:
            if (r3 >= r2) goto L_0x0084
            r1.lock()
            int r3 = r3 + 1
            goto L_0x007c
        L_0x0084:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.install():void");
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: kotlin.coroutines.Continuation<? super T> */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.concurrent.atomic.AtomicLongFieldUpdater */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(@NotNull Continuation<? super T> continuation) {
        ArrayList arrayList;
        if (!(isInstalled$kotlinx_coroutines_core() && f(continuation) == null)) {
            return continuation;
        }
        StackTraceFrame stackTraceFrame = null;
        if (h) {
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            int length = stackTrace.length;
            int i2 = -1;
            int length2 = stackTrace.length - 1;
            while (true) {
                if (length2 < 0) {
                    break;
                } else if (Intrinsics.areEqual(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i2 = length2;
                    break;
                } else {
                    length2--;
                }
            }
            int i3 = 0;
            if (!g) {
                int i4 = length - i2;
                arrayList = new ArrayList(i4);
                while (i3 < i4) {
                    arrayList.add(i3 == 0 ? StackTraceRecoveryKt.artificialFrame("Coroutine creation stacktrace") : stackTrace[i3 + i2]);
                    i3++;
                }
            } else {
                arrayList = new ArrayList((length - i2) + 1);
                arrayList.add(StackTraceRecoveryKt.artificialFrame("Coroutine creation stacktrace"));
                int i5 = length - 1;
                boolean z = true;
                for (int i6 = i2 + 1; i6 < i5; i6++) {
                    StackTraceElement stackTraceElement = stackTrace[i6];
                    if (!m.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, null)) {
                        arrayList.add(stackTraceElement);
                    } else {
                        if (z) {
                            arrayList.add(stackTraceElement);
                            z = false;
                        } else if (!m.startsWith$default(stackTrace[i6 + 1].getClassName(), "kotlinx.coroutines", false, 2, null)) {
                            arrayList.add(stackTraceElement);
                        }
                    }
                    z = true;
                }
                arrayList.add(stackTrace[i5]);
            }
            if (!arrayList.isEmpty()) {
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (listIterator.hasPrevious()) {
                    stackTraceFrame = new StackTraceFrame(stackTraceFrame, (StackTraceElement) listIterator.previous());
                }
            }
        }
        if (!isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        a<?> aVar = new a<>(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, e.incrementAndGet(d)), stackTraceFrame);
        ConcurrentWeakMap<a<?>, Boolean> concurrentWeakMap = c;
        concurrentWeakMap.put(aVar, Boolean.TRUE);
        if (!isInstalled$kotlinx_coroutines_core()) {
            concurrentWeakMap.clear();
        }
        return aVar;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(@NotNull Continuation<?> continuation) {
        i(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(@NotNull Continuation<?> continuation) {
        i(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final void setEnableCreationStackTraces(boolean z) {
        h = z;
    }

    public final void setSanitizeStackTraces(boolean z) {
        g = z;
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:403)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    public final void uninstall() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = kotlinx.coroutines.debug.internal.DebugProbesImpl.f
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.INSTANCE     // Catch:{ all -> 0x004c }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x004c }
            if (r5 == 0) goto L_0x0087
            int r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl.installations     // Catch:{ all -> 0x004c }
            int r5 = r5 + -1
            kotlinx.coroutines.debug.internal.DebugProbesImpl.installations = r5     // Catch:{ all -> 0x004c }
            int r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl.installations     // Catch:{ all -> 0x004c }
            if (r5 == 0) goto L_0x0041
        L_0x0035:
            if (r3 >= r2) goto L_0x003d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0035
        L_0x003d:
            r0.unlock()
            return
        L_0x0041:
            java.util.Objects.requireNonNull(r4)
            java.lang.Thread r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.b
            if (r4 == 0) goto L_0x004e
            r4.interrupt()
            goto L_0x004e
        L_0x004c:
            r4 = move-exception
            goto L_0x0093
        L_0x004e:
            r4 = 0
            kotlinx.coroutines.debug.internal.DebugProbesImpl.b = r4
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl$a<?>, java.lang.Boolean> r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.c
            r4.clear()
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.j
            r4.clear()
            kotlinx.coroutines.debug.AgentPremain r4 = kotlinx.coroutines.debug.AgentPremain.INSTANCE
            boolean r4 = r4.isInstalledStatically()
            if (r4 == 0) goto L_0x006f
        L_0x0063:
            if (r3 >= r2) goto L_0x006b
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0063
        L_0x006b:
            r0.unlock()
            return
        L_0x006f:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = kotlinx.coroutines.debug.internal.DebugProbesImpl.i
            if (r4 == 0) goto L_0x007b
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            java.lang.Object r4 = r4.invoke(r5)
            kotlin.Unit r4 = (kotlin.Unit) r4
        L_0x007b:
            if (r3 >= r2) goto L_0x0083
            r1.lock()
            int r3 = r3 + 1
            goto L_0x007b
        L_0x0083:
            r0.unlock()
            return
        L_0x0087:
            java.lang.String r4 = "Agent was not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r4 = r4.toString()
            r5.<init>(r4)
            throw r5
        L_0x0093:
            if (r3 >= r2) goto L_0x009b
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009b:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.uninstall():void");
    }
}
