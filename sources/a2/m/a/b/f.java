package a2.m.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.engine.CameraEngine;
public class f implements SuccessContinuation<CameraOptions, Void> {
    public final /* synthetic */ CameraEngine a;

    public f(CameraEngine cameraEngine) {
        this.a = cameraEngine;
    }

    /* Return type fixed from 'com.google.android.gms.tasks.Task' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.tasks.SuccessContinuation
    @NonNull
    public Task<Void> then(@Nullable CameraOptions cameraOptions) throws Exception {
        CameraOptions cameraOptions2 = cameraOptions;
        if (cameraOptions2 != null) {
            this.a.c.dispatchOnCameraOpened(cameraOptions2);
            return Tasks.forResult(null);
        }
        throw new RuntimeException("Null options!");
    }
}
