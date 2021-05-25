package t6;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.SinceKotlin;
import kotlin.internal.HidesMembers;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.ok.android.sdk.OkListener;
public class b {
    @SinceKotlin(version = "1.1")
    @HidesMembers
    public static final void addSuppressed(@NotNull Throwable th, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "$this$addSuppressed");
        Intrinsics.checkNotNullParameter(th2, OkListener.KEY_EXCEPTION);
        if (th != th2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
        }
    }

    @NotNull
    public static final StackTraceElement[] getStackTrace(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$stackTrace");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    @NotNull
    public static final List<Throwable> getSuppressedExceptions(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$suppressedExceptions");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final String stackTraceToString(@NotNull Throwable th) {
        Intrinsics.checkNotNullParameter(th, "$this$stackTraceToString");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "sw.toString()");
        return stringWriter2;
    }
}
