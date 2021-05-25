package a2.m.a.b;

import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraLogger;
import com.otaliastudios.cameraview.engine.CameraEngine;
public class e implements Runnable {
    public final /* synthetic */ Throwable a;
    public final /* synthetic */ CameraEngine b;

    public e(CameraEngine cameraEngine, Throwable th) {
        this.b = cameraEngine;
        this.a = th;
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.a;
        if (th instanceof CameraException) {
            CameraException cameraException = (CameraException) th;
            if (cameraException.isUnrecoverable()) {
                CameraEngine.LOG.e("EXCEPTION:", "Got CameraException. Since it is unrecoverable, executing destroy(false).");
                this.b.destroy(false);
            }
            CameraEngine.LOG.e("EXCEPTION:", "Got CameraException. Dispatching to callback.");
            this.b.c.dispatchError(cameraException);
            return;
        }
        CameraLogger cameraLogger = CameraEngine.LOG;
        cameraLogger.e("EXCEPTION:", "Unexpected error! Executing destroy(true).");
        this.b.destroy(true);
        cameraLogger.e("EXCEPTION:", "Unexpected error! Throwing.");
        Throwable th2 = this.a;
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        }
        throw new RuntimeException(this.a);
    }
}
