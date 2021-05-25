package a2.m.a.b.j;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.otaliastudios.cameraview.engine.action.ActionHolder;
import com.otaliastudios.cameraview.engine.action.ActionWrapper;
import com.otaliastudios.cameraview.engine.action.BaseAction;
@RequiresApi(21)
public class b extends ActionWrapper {
    public long e;
    public long f;
    public BaseAction g;

    public b(long j, @NonNull BaseAction baseAction) {
        this.f = j;
        this.g = baseAction;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper
    @NonNull
    public BaseAction getAction() {
        return this.g;
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction, com.otaliastudios.cameraview.engine.action.Action
    public void onCaptureCompleted(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.onCaptureCompleted(actionHolder, captureRequest, totalCaptureResult);
        if (!isCompleted() && System.currentTimeMillis() > this.e + this.f) {
            this.g.abort(actionHolder);
        }
    }

    @Override // com.otaliastudios.cameraview.engine.action.ActionWrapper, com.otaliastudios.cameraview.engine.action.BaseAction
    public void onStart(@NonNull ActionHolder actionHolder) {
        this.e = System.currentTimeMillis();
        super.onStart(actionHolder);
    }
}
