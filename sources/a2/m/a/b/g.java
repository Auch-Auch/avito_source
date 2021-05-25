package a2.m.a.b;

import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.engine.CameraEngine;
import java.util.concurrent.Callable;
public class g implements Callable<Task<CameraOptions>> {
    public final /* synthetic */ CameraEngine a;

    public g(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Task<CameraOptions> call() throws Exception {
        CameraEngine cameraEngine = this.a;
        if (cameraEngine.collectCameraInfo(cameraEngine.getFacing())) {
            return this.a.onStartEngine();
        }
        CameraEngine.LOG.e("onStartEngine:", "No camera available for facing", this.a.getFacing());
        throw new CameraException(6);
    }
}
