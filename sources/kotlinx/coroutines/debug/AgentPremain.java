package kotlinx.coroutines.debug;

import android.annotation.SuppressLint;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ProfileTab;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.misc.Signal;
import sun.misc.SignalHandler;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\nJ!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\f¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "", "args", "Ljava/lang/instrument/Instrumentation;", "instrumentation", "", "premain", "(Ljava/lang/String;Ljava/lang/instrument/Instrumentation;)V", AuthSource.SEND_ABUSE, "()V", "", "Z", "isInstalledStatically", "()Z", "setInstalledStatically", "(Z)V", AuthSource.BOOKING_ORDER, "enableCreationStackTraces", "<init>", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@SuppressLint({ProfileTab.ALL})
public final class AgentPremain {
    public static final AgentPremain INSTANCE = new AgentPremain();
    public static boolean a;
    public static final boolean b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJA\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "Ljava/lang/ClassLoader;", "loader", "", "className", "Ljava/lang/Class;", "classBeingRedefined", "Ljava/security/ProtectionDomain;", "protectionDomain", "", "classfileBuffer", "transform", "(Ljava/lang/ClassLoader;Ljava/lang/String;Ljava/lang/Class;Ljava/security/ProtectionDomain;[B)[B", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        public static final DebugProbesTransformer INSTANCE = new DebugProbesTransformer();

        @Nullable
        public byte[] transform(@NotNull ClassLoader classLoader, @NotNull String str, @Nullable Class<?> cls, @NotNull ProtectionDomain protectionDomain, @Nullable byte[] bArr) {
            if (!Intrinsics.areEqual(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            AgentPremain.INSTANCE.setInstalledStatically(true);
            return ByteStreamsKt.readBytes(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    public static final class a implements SignalHandler {
        public static final a a = new a();
    }

    static {
        Object obj;
        Boolean bool = null;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            obj = Result.m242constructorimpl(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m242constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m247isFailureimpl(obj)) {
            bool = obj;
        }
        Boolean bool2 = bool;
        b = bool2 != null ? bool2.booleanValue() : DebugProbesImpl.INSTANCE.getEnableCreationStackTraces();
    }

    @JvmStatic
    public static final void premain(@Nullable String str, @NotNull Instrumentation instrumentation) {
        a = true;
        instrumentation.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.INSTANCE;
        debugProbesImpl.setEnableCreationStackTraces(b);
        debugProbesImpl.install();
        INSTANCE.a();
    }

    public final void a() {
        try {
            Signal.handle(new Signal("TRAP"), a.a);
        } catch (Throwable unused) {
        }
    }

    public final boolean isInstalledStatically() {
        return a;
    }

    public final void setInstalledStatically(boolean z) {
        a = z;
    }
}
