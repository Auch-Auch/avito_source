package net.gotev.uploadservice.logger;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.Names;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002+,B\t\b\u0002¢\u0006\u0004\b)\u0010*J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014H\u0007¢\u0006\u0004\b\u001a\u0010\u0019J\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u000f8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger;", "", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "delegate", "", "setDelegate", "(Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;)V", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;", FirebaseAnalytics.Param.LEVEL, "setLogLevel", "(Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;)V", "", "devModeOn", "setDevelopmentMode", "(Z)V", "", "component", "uploadId", "", OkListener.KEY_EXCEPTION, "Lkotlin/Function0;", "message", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lkotlin/jvm/functions/Function0;)V", "info", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", Names.DEBUG, "minLevel", AuthSource.SEND_ABUSE, "(Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;)Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "c", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "loggerDelegate", "Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;", "logLevel", "Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate;", AuthSource.BOOKING_ORDER, "Lnet/gotev/uploadservice/logger/DefaultLoggerDelegate;", "defaultLogger", "NA", "Ljava/lang/String;", "<init>", "()V", "Delegate", "LogLevel", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public final class UploadServiceLogger {
    public static final UploadServiceLogger INSTANCE = new UploadServiceLogger();
    @NotNull
    public static final String NA = "N/A";
    public static LogLevel a = LogLevel.Off;
    public static final DefaultLoggerDelegate b;
    public static Delegate c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger$Delegate;", "", "", "component", "uploadId", "message", "", OkListener.KEY_EXCEPTION, "", "error", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", Names.DEBUG, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "info", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public interface Delegate {
        void debug(@NotNull String str, @NotNull String str2, @NotNull String str3);

        void error(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Throwable th);

        void info(@NotNull String str, @NotNull String str2, @NotNull String str3);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lnet/gotev/uploadservice/logger/UploadServiceLogger$LogLevel;", "", "<init>", "(Ljava/lang/String;I)V", "Debug", "Info", "Error", "Off", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
    public enum LogLevel {
        Debug,
        Info,
        Error,
        Off
    }

    static {
        DefaultLoggerDelegate defaultLoggerDelegate = new DefaultLoggerDelegate();
        b = defaultLoggerDelegate;
        c = defaultLoggerDelegate;
    }

    @JvmStatic
    public static final void debug(@NotNull String str, @NotNull String str2, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "component");
        Intrinsics.checkNotNullParameter(str2, "uploadId");
        Intrinsics.checkNotNullParameter(function0, "message");
        Delegate a3 = INSTANCE.a(LogLevel.Debug);
        if (a3 != null) {
            a3.debug(str, str2, function0.invoke());
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str, @NotNull String str2, @Nullable Throwable th, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "component");
        Intrinsics.checkNotNullParameter(str2, "uploadId");
        Intrinsics.checkNotNullParameter(function0, "message");
        Delegate a3 = INSTANCE.a(LogLevel.Error);
        if (a3 != null) {
            a3.error(str, str2, function0.invoke(), th);
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void error(@NotNull String str, @NotNull String str2, @NotNull Function0<String> function0) {
        error$default(str, str2, null, function0, 4, null);
    }

    public static /* synthetic */ void error$default(String str, String str2, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        error(str, str2, th, function0);
    }

    @JvmStatic
    public static final void info(@NotNull String str, @NotNull String str2, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(str, "component");
        Intrinsics.checkNotNullParameter(str2, "uploadId");
        Intrinsics.checkNotNullParameter(function0, "message");
        Delegate a3 = INSTANCE.a(LogLevel.Info);
        if (a3 != null) {
            a3.info(str, str2, function0.invoke());
        }
    }

    @JvmStatic
    public static final synchronized void setDelegate(@Nullable Delegate delegate) {
        synchronized (UploadServiceLogger.class) {
            if (delegate == null) {
                delegate = b;
            }
            c = delegate;
        }
    }

    @JvmStatic
    public static final synchronized void setDevelopmentMode(boolean z) {
        synchronized (UploadServiceLogger.class) {
            a = z ? LogLevel.Debug : LogLevel.Off;
        }
    }

    @JvmStatic
    public static final synchronized void setLogLevel(@NotNull LogLevel logLevel) {
        synchronized (UploadServiceLogger.class) {
            Intrinsics.checkNotNullParameter(logLevel, FirebaseAnalytics.Param.LEVEL);
            a = logLevel;
        }
    }

    public final Delegate a(LogLevel logLevel) {
        if (a.compareTo(logLevel) > 0 || a == LogLevel.Off) {
            return null;
        }
        return c;
    }
}
