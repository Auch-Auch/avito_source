package y6.a.a;

import java.lang.Thread;
import pl.droidsonroids.gif.GifDrawable;
public abstract class h implements Runnable {
    public final GifDrawable a;

    public h(GifDrawable gifDrawable) {
        this.a = gifDrawable;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.a.isRecycled()) {
                a();
            }
        } catch (Throwable th) {
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null) {
                defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
            throw th;
        }
    }
}
