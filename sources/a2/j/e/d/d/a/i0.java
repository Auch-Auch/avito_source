package a2.j.e.d.d.a;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;
public class i0 implements Thread.UncaughtExceptionHandler {
    public final a a;
    public final SettingsDataProvider b;
    public final Thread.UncaughtExceptionHandler c;
    public final AtomicBoolean d = new AtomicBoolean(false);

    public interface a {
    }

    public i0(a aVar, SettingsDataProvider settingsDataProvider, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = aVar;
        this.b = settingsDataProvider;
        this.c = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        this.d.set(true);
        if (thread == null) {
            try {
                Logger.getLogger().e("Could not handle uncaught exception; null thread");
            } catch (Exception e) {
                Logger.getLogger().e("An error occurred in the uncaught exception handler", e);
            } catch (Throwable th2) {
                Logger.getLogger().d("Crashlytics completed exception processing. Invoking default exception handler.");
                this.c.uncaughtException(thread, th);
                this.d.set(false);
                throw th2;
            }
        } else if (th == null) {
            Logger.getLogger().e("Could not handle uncaught exception; null throwable");
        } else {
            ((y) this.a).a(this.b, thread, th);
        }
        Logger.getLogger().d("Crashlytics completed exception processing. Invoking default exception handler.");
        this.c.uncaughtException(thread, th);
        this.d.set(false);
    }
}
