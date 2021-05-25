package a2.m.a.b;

import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.engine.CameraEngine;
import java.util.concurrent.Callable;
public class i implements Callable<Task<Void>> {
    public final /* synthetic */ CameraEngine a;

    public i(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Task<Void> call() throws Exception {
        return this.a.onStopEngine();
    }
}
