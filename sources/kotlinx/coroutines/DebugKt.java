package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\"\u001c\u0010\b\u001a\u00020\u00038\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u000b\"\u001c\u0010\u0012\u001a\u00020\r8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u000b\"\u001c\u0010\u0014\u001a\u00020\u00038\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0016\u0010\u0016\u001a\u00020\t8\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u000b\"\u001c\u0010\u0019\u001a\u00020\u00038\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"", "resetCoroutineId", "()V", "", AuthSource.BOOKING_ORDER, "Z", "getRECOVER_STACK_TRACES", "()Z", "RECOVER_STACK_TRACES", "", "DEBUG_PROPERTY_NAME", "Ljava/lang/String;", "DEBUG_PROPERTY_VALUE_ON", "Ljava/util/concurrent/atomic/AtomicLong;", "c", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "COROUTINE_ID", "DEBUG_PROPERTY_VALUE_AUTO", "ASSERTIONS_ENABLED", "getASSERTIONS_ENABLED", "DEBUG_PROPERTY_VALUE_OFF", AuthSource.SEND_ABUSE, "getDEBUG", "DEBUG", "STACKTRACE_RECOVERY_PROPERTY_NAME", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class DebugKt {
    @NotNull
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    @NotNull
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    @NotNull
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";
    public static final boolean a;
    public static final boolean b;
    @NotNull
    public static final AtomicLong c = new AtomicLong(0);

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        if (r0.equals("") != false) goto L_0x0042;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.debug"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            r1 = 1
            if (r0 != 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            int r2 = r0.hashCode()
            if (r2 == 0) goto L_0x003a
            r3 = 3551(0xddf, float:4.976E-42)
            if (r2 == r3) goto L_0x0031
            r3 = 109935(0x1ad6f, float:1.54052E-40)
            if (r2 == r3) goto L_0x0027
            r3 = 3005871(0x2dddaf, float:4.212122E-39)
            if (r2 != r3) goto L_0x005d
            java.lang.String r2 = "auto"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x005d
            goto L_0x002f
        L_0x0027:
            java.lang.String r2 = "off"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x005d
        L_0x002f:
            r0 = 0
            goto L_0x0043
        L_0x0031:
            java.lang.String r2 = "on"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x005d
            goto L_0x0042
        L_0x003a:
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x005d
        L_0x0042:
            r0 = 1
        L_0x0043:
            kotlinx.coroutines.DebugKt.a = r0
            if (r0 == 0) goto L_0x0050
            java.lang.String r0 = "kotlinx.coroutines.stacktrace.recovery"
            boolean r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0, r1)
            if (r0 == 0) goto L_0x0050
            goto L_0x0051
        L_0x0050:
            r1 = 0
        L_0x0051:
            kotlinx.coroutines.DebugKt.b = r1
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r1 = 0
            r0.<init>(r1)
            kotlinx.coroutines.DebugKt.c = r0
            return
        L_0x005d:
            java.lang.String r1 = "System property 'kotlinx.coroutines.debug' has unrecognized value '"
            r2 = 39
            java.lang.String r0 = a2.b.a.a.a.d3(r1, r0, r2)
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DebugKt.<clinit>():void");
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return false;
    }

    @NotNull
    public static final AtomicLong getCOROUTINE_ID() {
        return c;
    }

    public static final boolean getDEBUG() {
        return a;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return b;
    }

    public static final void resetCoroutineId() {
        c.set(0);
    }
}
