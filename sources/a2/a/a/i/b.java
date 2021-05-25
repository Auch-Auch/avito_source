package a2.a.a.i;

import com.avito.android.analytics.CrashReporterImpl;
import java.lang.Thread;
public final class b implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ CrashReporterImpl a;
    public final /* synthetic */ Thread.UncaughtExceptionHandler b;

    public b(CrashReporterImpl crashReporterImpl, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = crashReporterImpl;
        this.b = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        if (th != null) {
            CrashReporterImpl.access$report(this.a, th);
        }
        this.b.uncaughtException(thread, th);
    }
}
