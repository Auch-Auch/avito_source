package kotlinx.coroutines.sync;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.UrlParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import u6.a.m0.b;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aD\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bHHø\u0001\u0000\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\n\u0010\u000b\"\u001c\u0010\u0011\u001a\u00020\f8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0016\u001a\u00020\u00128\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0010\"\u001c\u0010\u0019\u001a\u00020\u00128\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u0012\u0004\b\u0018\u0010\u0010\"\u001c\u0010\u001c\u001a\u00020\f8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u0012\u0004\b\u001b\u0010\u0010\"\u001c\u0010\u001f\u001a\u00020\f8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u0012\u0004\b\u001e\u0010\u0010\"\u001c\u0010\"\u001a\u00020\f8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u0012\u0004\b!\u0010\u0010\"\u001c\u0010%\u001a\u00020\f8\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b#\u0010\u000e\u0012\u0004\b$\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"", "locked", "Lkotlinx/coroutines/sync/Mutex;", "Mutex", "(Z)Lkotlinx/coroutines/sync/Mutex;", "T", "", UrlParams.OWNER, "Lkotlin/Function0;", "action", "withLock", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", AuthSource.BOOKING_ORDER, "Lkotlinx/coroutines/internal/Symbol;", "getUNLOCK_FAIL$annotations", "()V", "UNLOCK_FAIL", "Lu6/a/m0/b;", g.a, "Lu6/a/m0/b;", "getEMPTY_UNLOCKED$annotations", "EMPTY_UNLOCKED", "f", "getEMPTY_LOCKED$annotations", "EMPTY_LOCKED", AuthSource.SEND_ABUSE, "getLOCK_FAIL$annotations", "LOCK_FAIL", "c", "getSELECT_SUCCESS$annotations", "SELECT_SUCCESS", "e", "getUNLOCKED$annotations", "UNLOCKED", "d", "getLOCKED$annotations", "LOCKED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class MutexKt {
    public static final Symbol a = new Symbol("LOCK_FAIL");
    public static final Symbol b = new Symbol("UNLOCK_FAIL");
    public static final Symbol c = new Symbol("SELECT_SUCCESS");
    public static final Symbol d;
    public static final Symbol e;
    public static final b f;
    public static final b g;

    static {
        Symbol symbol = new Symbol("LOCKED");
        d = symbol;
        Symbol symbol2 = new Symbol("UNLOCKED");
        e = symbol2;
        f = new b(symbol);
        g = new b(symbol2);
    }

    @NotNull
    public static final Mutex Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Mutex(z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object withLock(@org.jetbrains.annotations.NotNull kotlinx.coroutines.sync.Mutex r4, @org.jetbrains.annotations.Nullable java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.sync.MutexKt$withLock$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = (kotlinx.coroutines.sync.MutexKt$withLock$1) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.sync.MutexKt$withLock$1 r0 = new kotlinx.coroutines.sync.MutexKt$withLock$1
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.e
            r6 = r4
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r5 = r0.d
            java.lang.Object r4 = r0.c
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004e
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.c = r4
            r0.d = r5
            r0.e = r6
            r0.b = r3
            java.lang.Object r7 = r4.lock(r5, r0)
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.Object r6 = r6.invoke()     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            return r6
        L_0x005c:
            r6 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r3)
            r4.unlock(r5)
            kotlin.jvm.internal.InlineMarker.finallyEnd(r3)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.MutexKt.withLock(kotlinx.coroutines.sync.Mutex, java.lang.Object, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object withLock$default(Mutex mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        int i2 = 1;
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.mark(0);
        mutex.lock(obj, continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        try {
            return function0.invoke();
        } finally {
            InlineMarker.finallyStart(i2);
            mutex.unlock(obj);
            InlineMarker.finallyEnd(i2);
        }
    }
}
